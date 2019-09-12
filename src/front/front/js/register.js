function rejestracja(){
    var login = document.forms["register"]["l"];
    var pass1 = document.forms["register"]["p1"];
    var pass2 = document.forms["register"]["p2"];
    var name= document.forms["register"]["i"];
    var surname = document.forms["register"]["n"];
    var email = document.forms["register"]["m"];
    var nick = document.forms["register"]["u"];
    var sex = document.forms["register"]["p"];

    if(pass1.value!=pass2.value){
        alert("Podane hasła do siebie nie pasują!")
    }
    else {
        if (sex.value == "Kobieta") {
            sex = 1;
        } else sex = 0;
        var user = {
            userid: null,
            name: name.value.toString(),
            surname: surname.value.toString(),
            login: login.value.toString(),
            nickname: nick.value.toString(),
            password: pass1.value.toString(),
            email: email.value.toString(),
            sex: sex,
            role: 0
        }

        var request = new XMLHttpRequest();
        url = "http://localhost:8080/register";
        request.open("POST", url);
        request.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');

        request.onload = function () {
            if (this.readyState === 4 && this.status === 200) {

                if(jObj.userID == -1) alert("Login jest zajęty!");

            } else if (this.status === 400) {
                alert("blad serwera/url");

            } else {

                alert(this.status);

            }

        }
    }
    request.send(JSON.stringify(user));


}


