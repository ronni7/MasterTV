
function ZapiszF(id){
localStorage.setItem('idfilmu',id);
}

function ZapiszK(id){
    localStorage.setItem('idkanalu',id);
}



function UstawGodzine(){

    var Film = localStorage.getItem('idfilmu');
    var Kanal = localStorage.getItem('idkanalu');
    var Godzina = document.forms["hour"]["g"];

    var jObj0;
    var request0 = new XMLHttpRequest();
    url0 = "http://localhost:8080/server/updateMovie";
    request0.open("POST", url0);
    request0.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    request0.setRequestHeader('MediaType', 'application/json');
    request0.setRequestHeader('charset', 'utf-8');

    request0.onload = function () {
        if (this.readyState === 4 && this.status === 200) {

            jObj0 = JSON.parse(request0.responseText);

            var info0 = {
                ID: jObj0.id,
                Tytul: jObj0.title,
                Godzina: jObj0.startAtTime
            }

            alert("Kanał i godznia ustawione!")

        }else if (this.status === 400) {
            alert("blad serwera/url");
        } else {
            alert(this.status);
        }

    }
    request0.send('channelID=' + Kanal + '&movieID=' + Film + '&startingTime='+ Godzina.value);
}

function WyswietlFilmy(){

    var jObj;
    var request = new XMLHttpRequest();
    url = "http://localhost:8080/server/allMovies";
    request.open("GET", url);
    request.setRequestHeader('Content-type', 'application/json');

    request.onload = function () {
        if (this.readyState === 4 && this.status === 200) {

            let html = '';
            html += '<div><br><center>' ;

            html += '<table border="1">\n' +
                '<tr>\n' +

                '\t<th>Tytuł</th>' +
                '\t<th>Wybierz</th>\n' +
                '</tr>\n';

            jObj = JSON.parse(request.responseText);
            for (var i = 0; i < jObj.length; i++) {


                    var info = {
                        ID: jObj[i].id,
                        Tytul: jObj[i].title,
                        Godzina : jObj[i].startAtTime
                    }

                    html +=
                        '<tr>\t<td>' + info.Tytul + '</td>' +
                        '\t<td><a href="assign2.html" onclick="ZapiszF('+info.ID+')">Wybierz</a></td>\n' +
                        '</tr>';


            }
            html += '</table></center></div>';
            document.querySelector('.newclass').innerHTML = html;



        } else if (this.status === 400) {
            alert("blad serwera/url");
        } else {
            alert(this.status);
        }

    }
    request.send();
}

function WyswietlKanaly() {
    var jObj2;
    var request2 = new XMLHttpRequest();
    url2 = "http://localhost:8080/server/allChannels";
    request2.open("GET", url2);
    request2.setRequestHeader('Content-type', 'application/json');

    request2.onload = function () {
        if (this.readyState === 4 && this.status === 200) {

            let html = '';
            html += '<div><br><center>';
            html += '<table border="1">\n' + '<tr>\n' + '<th>Nazwa kanału </th> \t\t <th>Wybierz</th></tr>';
            jObj2 = JSON.parse(request2.responseText);
            for (var i = 0; i < jObj2.length; i++) {
                var info2 = {
                    ID: jObj2[i].channelID,
                    Link: jObj2[i].hyperlink,
                    Nazwa: jObj2[i].name
                }

                html += '<tr>\t<td>' + info2.Nazwa + '</td>\t\t<td>' + '<a href="assign3.html" onclick="ZapiszK(' + info2.ID + ')">Wybierz</a></td></tr>';
            }
            html += '</table></center></div>';
            document.querySelector('.showit').innerHTML = html;
            document.close();
        } else if (this.status === 400) {
            alert("blad serwera/url");
        } else {
            alert(this.status);
        }

    }
    request2.send();
}
