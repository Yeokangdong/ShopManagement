$(document).ready( function () {
	getCommon();
});

//천단위 콤마 펑션
function addComma(value){
	value = value.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	return value; 
}