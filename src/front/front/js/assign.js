function przypisz(){

    var Film = document.forms["assign"]["nameF"];
    var Kanal = document.forms["assign"]["nameK"];

    var FilmID;
    var FilmGodzina;
    var KanalID;

    var jObj;
    var request = new XMLHttpRequest();
    url = "http://localhost:8080/server/allMovies";
    request.open("GET", url);
    request.setRequestHeader('Content-type', 'application/json');

    request.onload = function () {
        if (this.readyState === 4 && this.status === 200) {

            jObj = JSON.parse(request.responseText);
            for (var i = 0; i < jObj.length; i++) {

                var info3 = {
                    ID: jObj[i].id,
                    Tytul: jObj[i].title,
                    Godzina: jObj[i].startAtTime
                }
                if (Film.value == info3.Tytul) {
                    FilmID = info3.ID;
                    FilmGodzina = info3.Godzina;
                    alert(FilmID);
                }

            }

        }else if (this.status === 400) {
            alert("blad serwera/url");
        } else {
            alert(this.status);
        }

    }
    request.send();

    var jObj2;
    var request2 = new XMLHttpRequest();
    url2 = "http://localhost:8080/server/allChannels";
    request2.open("GET", url2);
    request2.setRequestHeader('Content-type', 'application/json');

    request2.onload = function () {
        if (this.readyState === 4 && this.status === 200) {

            jObj2 = JSON.parse(request2.responseText);
            for (var i = 0; i < jObj2.length; i++) {

                var info4 = {
                    ID: jObj2[i].channelid,
                    name: jObj2[i].name,

                }
                if (Kanal.value == info4.name) {
                    KanalID = info4.ID;

                }
            }

        }else if (this.status === 400) {
            alert("blad serwera/url");
        } else {
            alert(this.status);
        }

    }
    request2.send();

    var jObj0;
    var request0 = new XMLHttpRequest();
    url0 = "http://localhost:8080/server/updateMovie";
    request0.open("POST", url0);
    request0.setRequestHeader('Content-type', 'application/json;charset=UTF-8');

    alert(KanalID);

    request0.onload = function () {
        if (this.readyState === 4 && this.status === 200) {

            alert(assign.channelID)
            jObj0 = JSON.parse(request0.responseText);

                var info0 = {
                    ID: jObj[i].id,
                    Tytul: jObj[i].title,
                    Godzina: jObj[i].startAtTime
                }



        }else if (this.status === 400) {
            alert("blad serwera/url");
        } else {
            alert(this.status);
        }

    }
    var assign = {
        channelID : KanalID,
        movieID : FilmID,
        startingTime : FilmGodzina
    }
    request0.send(assign);

}