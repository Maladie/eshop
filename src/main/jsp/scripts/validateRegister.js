document.addEventListener("DOMContentLoaded", function () {
    "use strict";
    var form = document.getElementById("registerForm");
    // form.classList.add("was-validated");
    var userName = form.elements["userName"];
    var password = form.elements["password"];
    var name = form.elements["name"];
    var surname = form.elements["surname"];
    var submitButton = document.getElementById('submitbtn');
    if (form !== null) {
        form.addEventListener("submit", function (event) {
            // var submittedForm = event.target;
            // var userName = submittedForm.elements["userName"];
            // var password = submittedForm.elements["password"];
            // var name = submittedForm.elements["name"];
            // var surname = submittedForm.elements["surname"];
            var validName = isNameValid(name.value);
            var validSurname = isSurnameValid(surname.value);
            var validUserName = (isLoginValid(userName.value) && !isUserNameAlreadyUsed(userName.value));
            var validPassword = isPasswordValid(password.value);
            debugger;
            if (validName && validSurname && validUserName && validPassword) {
                this.classList.add("was-validated");
            } else {
                event.preventDefault();
                event.stopPropagation();
            }
        });
    }
    userName.addEventListener('change', function (event) {
        console.log("userName change event");
        var username = event.target;
        var usedLoginFeedback = document.getElementById("userName-used-feedback");
        var feedback = document.getElementById("userName-feedback");
        if (!isLoginValid(username.value)) {
            usedLoginFeedback.style.display = "none";
            feedback.style.display = "inline";
            setValidityState(username, false);
        } else {
            feedback.style.display = "none";
            setValidityState(username, true);
            checkUserName(username.value);
        }
    });
    password.addEventListener('change', function (event) {
        var passwordInput = event.target;
        var feedback = document.getElementById("pass-feedback");
        if (!isPasswordValid(passwordInput.value)) {
            feedback.style.display = "block";
            setValidityState(passwordInput,false);
        } else {
            feedback.style.display = "none";
            setValidityState(passwordInput, true);
        }
    });
    name.addEventListener('change', function (event) {
        var nameInput = event.target;
        var feedback = document.getElementById("name-feedback");
        if (!isNameValid(nameInput.value)) {
            feedback.style.display = "inline";
            setValidityState(nameInput, false);
        } else {
            feedback.style.display = "none";
            setValidityState(nameInput, true);
        }
    });
    surname.addEventListener('change', function (event) {
        var surnameInput = event.target;
        var feedback = document.getElementById("surname-feedback");
        if (!isSurnameValid(surnameInput.value)) {
            feedback.style.display = "inline";
            setValidityState(surnameInput, false);
        } else {
            feedback.style.display = "none";
           setValidityState(surnameInput, true);
        }
    });
    var isLoginValid = function (login) {
        return login.length >= 3;
    };
    var isNameValid = function (name) {
        debugger;
        return name.length > 0;
    };
    var isSurnameValid = function (surname) {
        return isNameValid(surname);
    };
    var isPasswordValid = function (password) {
        return password.length >= 8;
    };
    var checkUserName = function (username) {
        $.ajax({
            type: 'POST',
            url: 'register',
            data: {
                validateUserName: username
            },
            success: function (response) {
                return isUserNameAlreadyUsed(response);
            },
            dataType: 'text'
        });
    };
    form.addEventListener('change', function (event) {
        console.log("form changed");
        var inputs = $('input').filter(':not(#searchBar)');
        var isValid = inputsValid(inputs);
        if (submitButton !== null) {
            submitButton.disabled = !isValid;
        }
    });

    /**
     *
     * @param input {input}
     * @param isValid {boolean}
     */
    var setValidityState = function (input, isValid) {
        if (isValid) {
            input.classList.remove("is-invalid");
            input.classList.remove("invalid");
            input.classList.add("is-valid");
            input.classList.add("valid");
        } else {
            input.classList.remove("is-valid");
            input.classList.remove("valid");
            input.classList.add("is-invalid");
            input.classList.add("invalid");
        }
        //console.log("setValid " + isValid +" "+input.name)
    };

    /**
     *
     * @param inputs
     * @returns {boolean}
     */
    var inputsValid = function(inputs){
        var valid = true;
        for (var i=0; i<inputs.length; i++) {
            if(inputs[i].classList.contains('is-invalid') && valid === true){
                valid = false;
            }
        }
        return valid;
    };
    var isUserNameAlreadyUsed = function (response) {
        console.log("login check");
        var username = document.getElementById("userName");
        var usedLoginFeedback = document.getElementById("userName-used-feedback");
        if (response === 'unavailable') {
            usedLoginFeedback.style.display = "block";
            setValidityState(username, false);
        } else {
            usedLoginFeedback.style.display = "none";
            setValidityState(username, true);
        }
        console.log("login checked");
        $('#registerForm').trigger("change");
        console.log("login check - triggered form change");
    };
    $('#name').trigger("change");
    $('#surname').trigger("change");
});
