export async function getEmployer(numEmployer) {
    return await fetch(`http://localhost:8080/api/employers/${numEmployer}`)
        .then((response) => {
            return response.json();
        }).catch((error) => {
            return false;
        });
}

export async function updateFavourModel(id, idModel) {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title: 'Fetch PUT Request Example' })
    };


    return await fetch(`http://localhost:8080/api/employers/update/favour-model/${id}?idModel=${idModel}`, requestOptions)
        .then((response) => {
            return response.status;
        }).catch((error) => {
            return false;
        });
}