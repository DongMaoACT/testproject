$(function () {

    $("#email, #pass").focus(restore);
    $("#email").blur(checkEmail);
    $("#pass").blur(checkPass);
    $("#submit").click(checkAll);
});

function checkEmail() {
    let flag;
    let email = $("#email").val();

    if(email === ""){
        setError("请输入邮箱！");
        flag = false;
    } else if (!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
        setError("请输入合法邮箱！");
        flag = false;
    } else {
        flag = true;
    }
    return flag;
}

//check whether pass is empty
function checkPass() {

    let flag = true;

    if($("#pass").val() === ""){
        flag = false;
        setError("请输入密码！");
    }
    return flag;
}

function checkAll() {

    if(!(checkEmail() && checkPass())){
        return false;
    } else {
        //ajax submit
        let email = $("#email").val();
        let pass = $("#pass").val();

        $.ajax({
            url: "http://localhost:8080/user/login",
            dataType: "json",
            contentType: "application/json",
            async: true,
            type: "POST",
            data:JSON.stringify({
                "email": email,
                "password": pass
            }) ,
            success: function (result) {

                if(result.status){
                    sessionStorage.user = JSON.stringify(result.user);
                    //动态跳转输出
                    window.location.href = "../index.html";
                } else {
                    setError(result.message);
                }
            }
        });
    }
}
//clear error info
function restore() {
    $(".err").text("");
}

//set error info
function setError(info) {
    $(".err").text(info);
}
