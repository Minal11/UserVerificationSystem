package net.codejava.email;



import java.security.SecureRandom;

import net.codejava.email.Hashing;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Hashing
{
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    // The following constants may be changed without breaking existing hashes.
    public static final int SALT_BYTE_SIZE = 24;
    public static final int HASH_BYTE_SIZE = 24;
    public static final int PBKDF2_ITERATIONS = 1000;

    public static final int ITERATION_INDEX = 0;
    public static final int SALT_INDEX = 1;
    public static final int PBKDF2_INDEX = 2;

    /**
     * Returns a salted PBKDF2 hash of the password.
     */
    public static String createHash(String password)
        throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        return createHash(password.toCharArray());
    }

    /**
     * Returns a salted PBKDF2 hash of the password.
     */
    public static String createHash(char[] password)
        throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        // Generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_BYTE_SIZE];
        random.nextBytes(salt);

        // Hash the password
        byte[] hash = pbkdf2(password, salt, PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
        // format iterations:salt:hash
        return PBKDF2_ITERATIONS + ":" + toHex(salt) + ":" +  toHex(hash);
    }

    /**
     * \Validates a password using a hash.
       */
    public static boolean validatePassword(String password, String correctHash)
        throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        return validatePassword(password.toCharArray(), correctHash);
    }

    /**
     * Validates a password using a hash.
     */
    public static boolean validatePassword(char[] password, String correctHash)
        throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        // Decode the hash into its parameters
        String[] params = correctHash.split(":");
        int iterations = Integer.parseInt(params[ITERATION_INDEX]);
        byte[] salt = fromHex(params[SALT_INDEX]);
        byte[] hash = fromHex(params[PBKDF2_INDEX]);
        // Compute the hash of the provided password, using the same salt, 
        // iteration count, and hash length
        byte[] testHash = pbkdf2(password, salt, iterations, hash.length);
        // Compare the hashes in constant time. The password is correct if
        // both hashes match.
        return slowEquals(hash, testHash);
    }

    /**
     * Compares password hashes that cannot be extracted  from online system 
     *  using a timing attack and then attacked off-line.
     */
    private static boolean slowEquals(byte[] a, byte[] b)
    {
        int diff = a.length ^ b.length;
        for(int i = 0; i < a.length && i < b.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }

    /**
     *  Computes the PBKDF2 hash of a password.
     */
    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes)
        throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        return skf.generateSecret(spec).getEncoded();
    }

    /**
     * Converts a string of hexadecimal characters into a byte array.
     */
    private static byte[] fromHex(String hex)
    {
        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
    }

    /**
     * Converts a byte array into a hexadecimal string.
     */
    private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
  }

}