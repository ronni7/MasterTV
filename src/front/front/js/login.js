function logowanie() {
    var login = document.forms['login']['login'];
    var pass = document.forms['login']['password'];

    var jObj;
    var request = new XMLHttpRequest();
    url = "http://localhost:8080/login";
    request.open("POST", url);
    request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    request.setRequestHeader('MediaType', 'application/json');
    request.setRequestHeader('charset', 'utf-8');

    request.onload = function () {

        if (this.readyState === 4 && this.status === 200) {
            if (request.responseText == 0) {
                alert('Podany login lub hasło jest błędne!')
            } else {

            jObj = JSON.parse(request.responseText);

            var info = {
                imie: jObj.name,
                email: jObj.email,
                plec: jObj.sex,
                rola: jObj.role
            }

            if (info.rola == 'USER' || info.rola == 'SUPERUSER') {
                setTimeout("location.href='./main.html';", 100);
            } else if (info.rola == 'ADMIN') {
                setTimeout("location.href='./admin.html';", 100);
            }

            document.cookie=info.rola;

        }
        }
         else if (this.status === 400) {
            alert("blad serwera/url");

        } else {
            alert(this.status);

        }

    }
    request.send('login=' + login.value + '&password=' + pass.value);
}