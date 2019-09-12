function addChannel(){

    var link = document.forms["addchannel"]["hyperlink"];
    var name = document.forms["addchannel"]["name"];

    var channel = {
        hyperlink: link.value.toString(),
        name: name.value.toString()
    }

    var request = new XMLHttpRequest();
    url = "http://localhost:8080/server/saveChannel";
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
    request.send(JSON.stringify(channel));

}



