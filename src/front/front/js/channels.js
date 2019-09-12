function getmovies(){
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
                    '\t<th>Tytuł</th>\t\t<th>Opis</th>\t\t<th>Czas trwania</th>\t\t<th>Minimalny wiek</th>' +
                    '\t<th>Godzina</th>' +
                    '\t<th>Link</th>\n' +
                    '</tr>\n';

                jObj = JSON.parse(request.responseText);
                for (var i = 0; i < jObj.length; i++) {
                    if (jObj[i].channelID != null) {
                        var info = {
                            ID: jObj[i].id,
                            Tytul: jObj[i].title,
                            Opis: jObj[i].description,
                            Czas: jObj[i].lengthInMinutes,
                            Wiek: jObj[i].minimumAge,
                            Godzina: jObj[i].startAtTime,
                            Link: jObj[i].channelID.hyperlink
                        }
                        console.log(info.Link);

                        html +=
                            '<tr>\t<td>' + info.Tytul + '</td>' +
                            '\t\t<td>' + info.Opis + '</td>' +
                            '\t\t<td>' + info.Czas + '</td>' +
                            '\t\t<td>' + info.Wiek + '</td>' +
                            '\t\t<td>' + info.Godzina + '</td>' +
                            '\t<td><a href="' + info.Link + '">Oglądaj</a></td>\n' +
                            '</tr>';

                    }

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

function getchannel(){
    var jObj;
    var request = new XMLHttpRequest();
    url = "http://localhost:8080/server/allChannels";
    request.open("GET", url);
    request.setRequestHeader('Content-type', 'application/json');

    request.onload = function () {
        if (this.readyState === 4 && this.status === 200) {

                let html = '';
                html += '<div><br><center>' ;
                html += '<table border="1">\n' + '<tr>\n' + '<th>Nazwa kanału </th> \t\t <th>Link do kanału</th></tr>';
            jObj = JSON.parse(request.responseText);
            for (var i = 0; i < jObj.length; i++) {
                var info = {
                    ID: jObj[i].channelid,
                    Link: jObj[i].hyperlink,
                    Nazwa: jObj[i].name
                }

                html+='<tr>\t<td>' + info.Nazwa + '</td>\t\t<td>' + '<a href="'+info.Link+'">'+'Oglądaj!'+'</a></td></tr>';
            } html += '</table></center></div>';
            document.querySelector('.showit').innerHTML = html;
            document.close();
        } else if (this.status === 400) {
            alert("blad serwera/url");
        } else {
            alert(this.status);
        }

    }
    request.send();

}