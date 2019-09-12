function addMovie(){

    var title = document.forms["addfilm"]["name"];
    var description = document.forms["addfilm"]["desc"];
    var lengthInMinutes = document.forms["addfilm"]["length"];
    var minimumAge = document.forms["addfilm"]["age"];
    var startAtTime = document.forms["addfilm"]["start"];
    var fileName = document.forms["addfilm"]["nameoffile"];


    var movie = {
        movieID: null,
        title: title.value.toString(),
        description: description.value.toString(),
        lengthInMinutes: lengthInMinutes.value,
        minimumAge: minimumAge.value,
        startAtTime: startAtTime.value.toString(),
        fileName: fileName.value.toString()
    }

    var request = new XMLHttpRequest();
    url = "http://localhost:8080/server/saveMovie";
    request.open("POST", url);
    request.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');

    request.onload = function () {
        if (this.readyState === 4 && this.status === 200) {

        } else if (this.status === 400) {
            alert("blad serwera/url");

        } else {
            alert(this.status);
        }
    }
    request.send(JSON.stringify(movie));

}