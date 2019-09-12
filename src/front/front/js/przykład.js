function loadMap() {
	
	var jObj;
	var request = new XMLHttpRequest();
	url = "localhost:8080/login" ;
	request.open("POST", url);

	request.setRequestHeader('Content-type', 'application/json'); to moze sie przydac
	request.send('login=imie&password=TajneHaslo1');
	console.log(this.status);
	request.onload = function() {
		if (this.readyState === 4 && this.status === 200) {
			jObj = JSON.parse(request.responseText);
				for (var i = 0; i < jObj.length; i++) {
					var info = {
						ID : jObj[i].id,
						Imie: jObj[i].name
					}
					alert(info);
									
				}
		} else if (this.status === 400) {
			alert("blad serwera/url");
		} else {
			alert(this.status);
		}
		
	}
}

