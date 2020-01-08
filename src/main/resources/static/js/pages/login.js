/**
 * Created by chendatao on 2019/4/19.
 */

$(function () {
    $("#login").click(function(e){
        login();
        return false;
    });
});
function login() {
    $.ajax({
        url : "/boss/login",
        type : "POST",
        data : $("#login_form").serialize(),
        dataType : "json",
        success : function(data) {
            if (data.success) {
                var val = $("#returnUrl").val();
                location.href = !val?'/boss/':val;
                return;
            }
            $("#content").html(data.msg);
            $("#errMsg").removeClass('hide');

        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
        },
        complete : function(XMLHttpRequest, textStatus) {
        }
    });

}