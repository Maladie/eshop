document.addEventListener("DOMContentLoaded", function() {
    "use strict";
    var form = $("#loginForm");
    if(form!== null) {
        debugger;
        var login = $('#userName');
        var password = $('#password');
        form.submit(function (event) {
            if(isLoginValid(login.val()) && isValidPassword(password.val())){
                console.log("login + password = valid");
                postLogin();
                event.preventDefault();
                event.stopPropagation();
            }else {
                console.log("login + password = invalid");
                event.preventDefault();
                event.stopPropagation();
                $('alert-danger').show();
            }
        });
        form.change( function (event) {
            $('.alert').hide();
            var button= $("#loginButton");
            console.log(login.value);
            console.log(login.val());
            if(isLoginValid(login.val()) && isValidPassword(password.val())){
                button.prop('disabled', false);
            }else {
                button.prop('disabled', true);
            }
        });
        login.change( function (event) {
            var login = event.target;
            var feedback = document.getElementById("login-feedback");
            if(!isLoginValid(this.value)){
                feedback.style.display = "block";
                login.classList.remove("is-valid");
                login.classList.add("is-invalid");
            } else {
                feedback.style.display = "none";
                login.classList.remove("is-invalid");
                login.classList.add("is-valid");
            }
        });
        password.change( function (event) {
            var pass = event.target;
            var feedback = document.getElementById("pass-feedback");
            if(!isValidPassword(this.value)){
                feedback.style.display = "block";
                pass.classList.remove("is-valid");
                pass.classList.add("is-invalid");
            } else {
                feedback.style.display = "none";
                pass.classList.remove("is-invalid");
                pass.classList.add("is-valid");
            }
        });

        /**
         *
         * @param login {input}
         * @returns {boolean}
         */
        var isLoginValid = function (login) {
            if(login !== undefined)
            return login.length >= 3;
        };
        /**
         *
         * @param password {input}
         * @returns {boolean}
         */
        var isValidPassword = function (password) {
            if (password !== undefined)
            return password.length >= 1;
        };
        password.change();
        login.change();
        $('#loginButton').focus();
        var postLogin = function () {
            $.ajax({
                type: 'POST',
                url: 'login',
                data: {
                    userName: login.val(),
                    password: password.val()
                },
                success: function (response) {
                    return loginResponse(response);
                },

                dataType: 'text'
            });
        };
        var loginResponse = function (response) {
            if(response ==='ALL_OK'){
                showRedirect();
            } else {
                showInfoInvalidLoginPassword();
            }
        }
    }
});
var showRedirect = function () {
$('.alert-success').show();
var fiveSeconds = new Date().getTime() + 5000;
    $('#clock').countdown(fiveSeconds, {elapse: true})
        .on('update.countdown', function(event) {
            var $this = $(this);
            if (event.elapsed) {
                window.location.href = '/home'
            } else {
                $this.html(event.strftime('<a class="alert-link" href="/home">Redirecting in: <span>%S</span><br> Click to skip waiting.</a>'));
            }
        });
};
var showInfoInvalidLoginPassword = function () {
$('.alert-danger').show();
};
