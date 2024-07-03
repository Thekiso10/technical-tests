export function showAlert(idLocation, text) {
    if (!document.getElementById(idLocation).hasChildNodes()) {
        let fragmentoHTML = document.createElement("div");
        fragmentoHTML.appendChild(document.createTextNode(text));
    
        fragmentoHTML.classList.add("alert", "alert-danger", "text-center", "mt-3");
    
        document.getElementById(idLocation).appendChild(fragmentoHTML);
    
        setTimeout(function() {
            document.getElementById(idLocation).removeChild(fragmentoHTML);
        }, 3500); // 3,5 segundos en milisegundos (1000ms * 3,5)
    }
}