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
        url : "/user/login",
        type : "POST",
        data : $("#login_form").serialize(),
        dataType : "json",
        success : function(data) {
            if (data.status) {
                var val = $("#returnUrl").val();
                location.href = !val?'/':val;
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