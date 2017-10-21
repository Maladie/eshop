document.addEventListener("DOMContentLoaded", function () {
    "use strict";
    var form = document.getElementById("productForm");
    if (form !== null) {
        form.addEventListener("submit", function (event) {
            var inputs = this.getElementsByTagName("input");

            debugger;
            var isValid = true;
            for (var i = 0; i < inputs.length; i++) {
                console.log("id: " + inputs[i].id + ", val: " + inputs[i].value);
                if (inputs[i].value === "" && !(inputs[i].classList.contains("custom-file-input")) && inputs[i].type !== 'hidden') {
                    isValid = false;
                    console.log("isValid: " + isValid);
                    break;
                }
            }
            debugger;
            if (!isValid) {
                event.preventDefault();
                event.stopPropagation();
            }
            this.classList.add("was-validated");
        });
    }
});