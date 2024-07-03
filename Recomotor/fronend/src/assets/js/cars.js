import { deleteCookier, getCookier, updateFavourModelCookier } from './login.js';
import { updateFavourModel } from './../../api/employer.js'

window.addEventListener("load", function(event) {
    deleteSession();
    selectFavourModel();
});

export function addFavourModel(idButton) {
    const idModel = idButton.split('-')[1];
    const employer = getCookier('numEmployer');

    if (employer != null) {
        updateFavourModel(employer.id, idModel).then((employer) => {
            if (employer == 200) {
                updateFavourModelCookier('numEmployer', idModel);
                regenedateStartIcon(idButton);
            }
        });
    }
}

function deleteSession() {
    const button = document.getElementById("button-nav-0");
    button.addEventListener("click", () => {
        deleteCookier('numEmployer');
    });
}

function selectFavourModel() {
    const employer = getCookier('numEmployer');
    if (employer.favourModel != null) {
        regenedateStartIcon(`buttonModel-${employer.favourModel.id}`);
    }
}

function regenedateStartIcon(idButton) {
    const listTagClass = document.getElementsByClassName('favour');
    if (listTagClass && listTagClass.length > 0) {
        for (let tag of listTagClass) {
            tag.classList.remove('favour');
        }
    }

    document.getElementById(idButton).classList.add('favour');
}