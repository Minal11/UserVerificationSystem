var invalid = 0;
function validateForm() {
    var number = /[0-9]/;
    var lowercase = /[a-z]/;
    var uppercase = /[A-Z]/;
    var symbol = /\W/;

    //password Check
    if (($("#pass").val().length > 6) && (number.test($("#pass").val())) && (lowercase.test($("#pass").val()))
        && (uppercase.test($("#pass").val())) && (symbol.test($("#pass").val())))
        {
        invalid = 0;
    }
    else
    {
        invalid = 1;
    }

    if (invalid == 1)
    {
        $('#pass').popover({
            html: true,
            trigger: 'manual',
            placement: 'right',
            //template:'<div class="popover"><div class="arrow"></div><h3 class="popover-title"></h3><div class="popover-content1"></div></div>', 
            content: function() {

                return $('#popover-content1').html();
            }
        });
        $('#pass').popover("show");
        return false;
    }
    else
    {
        $('#pass').popover("destroy");
        return true;
    }
}

$('document').ready(function() {

    $('#commentBtn1').click(function() {
        var divi = $('<div>').html('<div><img src = "http://placehold.it/16x16"/><a sty le="padding-left:5%"href = "#">   UserName  </a>Nice Picture!!!</div>');
        $("#comment").append(divi);
    });
   

    $('form').on('submit', function() {
        if ($('#pass').val() != $('#cpass').val()) {

            $('#cpass').popover({
                html: true,
                trigger: 'manual',
                placement: 'right',
                //template:'<div class="popover"><div class="arrow"></div><h3 class="popover-title"></h3><div class="popover-content"></div></div>', 
                content: function() {

                    return $('#popover-content').html();
                }
            });
            $('#cpass').popover("show");
            return false;
        }
        $('#cpass').popover("destroy");
        return true;
    });

    $('#datepicker').datepicker({
        showOn: "button",
        buttonImage: "./bootstrap/img/calendar_icon.gif",
        buttonImageOnly: true            
    });
});







			