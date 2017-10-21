document.addEventListener("DOMContentLoaded", function () {
    "use strict";
    var $form = $('#registerForm');
    var $userNameInput = $('#userName');
    var $passwordInput = $('#password');
    var $nameInput = $('#name');
    var $surnameInput = $('#surname');
    var $submitButton = $('#submitbtn');

    var validName = false;
    var validSurname = false;
    var validUserName = false;
    var validPassword = false;

    if ($form !== undefined && $form !== null) {
        debugger;
        $form.submit(function (event) {
            debugger;
            if (validName && validSurname && validUserName && validPassword) {
                this.addClass("was-validated");
            } else {
                //break form submitting
                event.preventDefault();
                event.stopPropagation();
            }
        });
        $form.change(function (event) {
            //skip searchBar input
            debugger;
            var inputs = $('input').filter(':not(#searchBar)');
            var isValid = inputsValid(inputs);
                $submitButton.attr('disabled', !isValid);
        });
    }
    $userNameInput.change(function (event) {
        var usedLoginFeedback = $("#userName-used-feedback");
        var feedback = $("#userName-feedback");
        if (!isLoginValid($userNameInput.val())) {
            usedLoginFeedback.hide();
            feedback.show();
            setValidityState($userNameInput, false);
        } else {
            feedback.hide();
            setValidityState($userNameInput, true);
            checkUserName($userNameInput.val());
        }
    });
    $passwordInput.change(function (event) {
        var feedback = $("#pass-feedback");
        if (!isPasswordValid($passwordInput.val())) {
            feedback.show();
            setValidityState($passwordInput,false);
        } else {
            feedback.hide();
            setValidityState($passwordInput, true);
        }
    });
    $nameInput.change(function (event) {
        var feedback = $("#name-feedback");
        if (!isNameValid($nameInput.val())) {
            feedback.show();
            setValidityState($nameInput, false);
        } else {
            feedback.hide();
            setValidityState($nameInput, true);
        }
    });
    $surnameInput.change(function (event) {
        var feedback = $("#surname-feedback");
        if (!isSurnameValid($surnameInput.val())) {
            feedback.show();
            setValidityState($surnameInput, false);
        } else {
            feedback.hide();
           setValidityState($surnameInput, true);
        }
    });
    var isLoginValid = function (login) {
        if(login !== undefined) {
            return login.length >= 3;
        }
        return false;
    };
    var isPasswordValid = function (password) {
        if(password !== undefined) {
            return password.length >= 8;
        }
        return false;
    };
    var isNameValid = function (name) {
        if (name !== undefined) {
            return name.length > 0;
        }
        return false;
    };
    var isSurnameValid = function (surname) {
        return isNameValid(surname);
    };
    var checkUserName = function (username) {
        if(username !== undefined && username.length >=3) {
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
        } else {
            console.log('UserName too short. Skipped checking');
        }
    };

    /**
     *
     * @param input {Object}
     * @param isValid {boolean}
     */
    var setValidityState = function (input, isValid) {
        if (isValid) {
            input.removeClass("is-invalid invalid");
            input.addClass("is-valid valid");
        } else {
            input.removeClass("is-valid valid");
            input.addClass("is-invalid invalid");
        }
    };

    /**
     *
     * @param inputs
     * @returns {boolean}
     */
    var inputsValid = function(inputs){
        var valid = true;
        for (var i=0; i<inputs.length; i++) {
            if(hasClassInvalid(inputs[i]) && valid === true){
                valid = false;
            }
        }
        return valid;
    };

    var hasClassInvalid = function(input){
        var classList = input.classList;
        return classList.contains('is-invalid') || classList.contains('invalid');

    };
    var isUserNameAlreadyUsed = function (responseMessage) {
        var loginUnavailableFeedback = $('#userName-used-feedback');
        if (responseMessage === 'unavailable') {
            loginUnavailableFeedback.show();
            setValidityState($userNameInput, false);
        } else {
            loginUnavailableFeedback.hide();
            setValidityState($userNameInput, true);
        }
        // invoke form change event
        $form.change();
    };
});
