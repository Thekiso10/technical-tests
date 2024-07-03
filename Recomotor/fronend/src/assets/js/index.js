import { getLogin, cookieExiste } from './login.js';
import { showAlert } from './utils.js';

window.addEventListener("load", function(event) {
    submitEmployerButtonEvent();
    submitEmployerFormEvent();
    validateCookie();
});

function validateCookie() {
    if (cookieExiste('numEmployer')) {
        window.location.replace("/cars");
    }
}

function submitEmployerFormEvent() {
    const form = document.getElementById("form-login");
    form.addEventListener("submit", () => {
        validateLogin();
    });
}

function submitEmployerButtonEvent() {
    const button = document.getElementById("submit-employer");
    button.addEventListener("click", () => {
        validateLogin();
    });
}

function validateLogin() {
    const numEmployer = document.getElementById("input-num-employer").value;
    if (validateInputNumEmployer(numEmployer)) {
        getLogin(numEmployer).then((response) => {
            if (response) {
                window.location.replace("/cars");
            } else { 
                showAlert("alert-loguin", `No se ha encontrado el empleado con numero: ${numEmployer}`);
            }
        });
    } else {
        showAlert("alert-loguin", "El campo 'numero de empleado' esta vacío");
    }
}

function validateInputNumEmployer(numEmployer) {
    return numEmployer ? true : false;
}

