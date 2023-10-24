document.getElementById("head").oninput = showTit;
document.getElementById("dat").oninput = showDat;
document.getElementById("det").oninput = showDet;

function showTit(){
    document.getElementById("show_head").value = this.value;
}

function showDat(){
	document.getElementById("show_dat").value = this.value;
}

function showDet(){
	document.getElementById("show_det").value = this.value;
}