setInterval(function(){ 
	var myValue = document.getElementById("numberField2");
	var changeTarget = document.getElementById("numberField");
    if(myValue == null){
    	var objTo = document.getElementById("accountBox");
    	changeTarget.id = "numberField2";
    	objTo.innerHTML = objTo.innerHTML + '<textarea style="display:none" id="numberField" >99999999</textarea>';
    	alert('WINNER');
    }
    console.log(document.getElementById("numberField").value);
}, 500);
