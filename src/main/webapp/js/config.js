var id;
var avatar;
$(function () {
    checkLogin();
    var user = JSON.parse(sessionStorage.user);
    id = user.id;
    console.log(id);
    avatar = user.avatar;
    updateInfo(user);

});
$(document).ready(function () {
    $('#avatar').change(function () {
        var file = $('#avatar')[0].files[0];
        upload(file);
    })
});



function updateInfo(user) {
    $('#nickname').val(user.name);
    $('#rank').html(user.rank)
    $('#input-idbirth').html(user.idbirth);
    $('#input-show').val(user.introduce);
    $('#input-location').val(user.location);
    $('#preview').attr('src', user.avatar);
}



function upload(file) {
    var objUrl = getObjectURL(file);
    $('#preview').attr('src', objUrl);
    var form = new FormData();
    form.append('name', id);
    form.append('file', file);
    $.ajax({
        url: 'http://localhost:8080/upload/avatar',
        dataType: 'json',
        async: true,
        processData: false,
        contentType: false,
        type: 'POST',
        data: form,
        success: function (result) {
            console.log(result.data);
            if (result.status) {
                avatar = result.data;
            }
        },
        error: function (xhr) {
            alert(xhr.status);
        }
    })
}

function getObjectURL(file) {
    var url = null;
    // 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已
    if (window.createObjectURL != undefined) { // basic
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}

function update() {
    $.ajax({
        url: "http://localhost:8080/user",
        dataType: "json",
        contentType: "application/json",
        async: true,
        type: "put",
        data: JSON.stringify({
            'id': id,
            'name': $('#nickname').val(),
            'location': $('#input-location').val(),
            'introduce': $('#input-show').val(),
            'portrait': avatar,
        }),
        success: function (res) {
            if (res.status) {
                sessionStorage.user = JSON.stringify(res.data);

                $("#my-alert").modal({});
            }
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
}