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
            }else {
                console.log("login + password = invalid");
                event.preventDefault();
                event.stopPropagation();
            }
        });
        form.change( function (event) {
            var button= $("#loginButton");
            debugger;
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
        password.focus();
    }
});