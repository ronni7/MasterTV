function deletemovie(){
    var jObj;
    var request = new XMLHttpRequest();
    url = "http://localhost:8080/server/allMovies";
    request.open("GET", url);
    request.setRequestHeader('Content-type', 'application/json');

    request.onload = function () {
        if (this.readyState === 4 && this.status === 200) {

                let html = '';
                html += '<div><center><br>' ;

                html += '<table border="5">\n' +
                    '<tr>\n' +
                    '\t<th>Tytul</th>\t<th>Kanał</th>\t<th>Akcja</th>\n' +
                    '</tr>\n';

                jObj = JSON.parse(request.responseText);
                for (var i = 0; i < jObj.length; i++) {
                    if (jObj[i].channelID != null) {
                        var info3 = {
                            ID: jObj[i].id,
                            Tytul: jObj[i].title,
                            Kanal: jObj[i].channelID.name
                        }

                        html +=
                            '<tr>\t<td>' + info3.Tytul + '</td>\t\t<td>' + info3.Kanal + '</td>\t\t<td><a href="#" onclick="UsuwanieFilmu(' + info3.ID + ')">Usuń</a></td>\n'
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

function UsuwanieFilmu(id){

    var ID = id;

    var jObj;
    var request = new XMLHttpRequest();
    url = "http://localhost:8080/server/deleteMovie";
    request.open("POST", url);
    request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    request.setRequestHeader('MediaType', 'application/json');
    request.setRequestHeader('charset', 'utf-8');

    request.onload = function () {

        if (this.readyState === 4 && this.status === 200) {

            }

        else if (this.status === 400) {
            alert("blad serwera/url");
        } else {
            alert(this.status);
        }

    }
    request.send('movieID=' + ID);
    location.reload();

}

function deletechannel(){
    var jObj;
    var request = new XMLHttpRequest();
    url = "http://localhost:8080/server/allChannels";
    request.open("GET", url);
    request.setRequestHeader('Content-type', 'application/json');

    request.onload = function () {
        if (this.readyState === 4 && this.status === 200) {
                let html = '';
                html += '<div><br><center>' ;
                html += '<table border="5">\n' + '<tr>\n' + '<th>Nazwa kanału </th>'+'\t<th>Akcja</th></tr>';
            jObj = JSON.parse(request.responseText);
            for (var i = 0; i < jObj.length; i++) {
                var info2 = {
                    ID: jObj[i].channelID,
                    Nazwa: jObj[i].name
                }

                html+='<tr>\t<td>' + info2.Nazwa + '</td><td><a href="#" onclick="UsuwanieKanalu('+info2.ID+')">Usuń</a></td></tr>';
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

function UsuwanieKanalu(id){

    var ID = id;

    var jObj;
    var request = new XMLHttpRequest();
    url = "http://localhost:8080/server/deleteChannel";
    request.open("POST", url);
    request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    request.setRequestHeader('MediaType', 'application/json');
    request.setRequestHeader('charset', 'utf-8');

    request.onload = function () {
        if (this.readyState === 4 && this.status === 200) {
        }

        else if (this.status === 400) {
            alert("blad serwera/url");
        } else {
            alert(this.status);
        }

    }
    request.send('channelID=' + ID);
    location.reload();

}