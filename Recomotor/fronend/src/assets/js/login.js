import { getEmployer } from './../../api/employer.js';

export function getLogin(numEmployer) {
    return getEmployer(numEmployer).then((employer) => {
        let validate = true;
        
        if (employer != false) {
            createCookie(employer);
        } else {
            validate = false;
        }

        return validate;
    });
}

export function getCookier(nameCookie) {
    const cookieValue = getValueCookie(nameCookie);
    if (cookieValue !== null) {
        try {
            const jsonObject = JSON.parse(cookieValue);
            return jsonObject;
        } catch (error) {
            console.error('Error al parsear la cookie JSON:', error);
            return null;
        }
    } else {
        console.log('La cookie no se encontró o está vacía.');
        return null;
    }
}

export function deleteCookier(nameCookie) {
    if (cookieExiste(nameCookie)) {
        document.cookie = `${nameCookie}=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;
    }
}

export function updateFavourModelCookier(nameCookie, idModel) {
    let actualCookie = getCookier(nameCookie);
    if (actualCookie.favourModel != null) {
        actualCookie.favourModel.id = idModel;
    } else {
        actualCookie.favourModel = {'id': idModel};
    }

    createCookie(actualCookie);
}

export function cookieExiste(nameCookie) {
    const cookies = document.cookie.split("; ");
    for (const cookie of cookies) {
        const parts = cookie.split("=");
        const actualNema = parts[0];
        if (actualNema === nameCookie) {
            return true; 
        }
    }

  return false; // La cookie no existe
}

function getValueCookie(nameCookie) {
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
        const cookie = cookies[i].trim();
        if (cookie.startsWith(nameCookie + '=')) {
            return cookie.substring(nameCookie.length + 1); // +1 para evitar el signo igual (=)
        }
    }
    // Si no se encuentra la cookie, devuelve null
    return null;
}

function createCookie(employer) {
    let date = new Date();
    date.setTime(date.getTime() + (24 * 60 * 60 * 1000));
    
    document.cookie = `numEmployer=${JSON.stringify(employer)}; expires=${date.toUTCString()}; path=/`;
}
