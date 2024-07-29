$(document).ready( function () {
	
});

//천단위 콤마 펑션
function addComma(value){
	value = value.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	return value; 
}

//이미지 크게보기
function imgBigSizeShow(value){
	$("#imageBigSizeDiv").addClass("show");
	$("#imageBigSizeDiv").css('display','block');
	$("#modalImgBigSize").attr("src", value.src);
}

//확인 팝업
function confirmModal(value){
	$("#confirmModal").addClass("show");
	$("#confirmModal").css('display','block');
	$("#confirmModalContentP").html(value);
}

//정보 팝업
function infoShow(value){
	$("#infoModal").addClass("show");
	$("#infoModal").css('display','block');
	$("#infoModalContentP").html(value);
}

//이메일 팝업
function sendEmailShow(){
	$("#email-modal-lg").addClass("show");
	$("#email-modal-lg").css('display','block');
}

//에러
function errorShow(value){
	$("#errorModal").addClass("show");
	$("#errorModal").css('display','block');
	$("#errorModalContentP").html(value);
}

//데이터 처리 로딩 보이기
function loadingDataShow(){
	$("#dataLoadingbar").css('display','block');
}

//메일 로딩 보이기
function loadingEmailShow(){
	$("#emailLoadingbar").css('display','block');
}

//데이터 처리 로딩 감추기
function LoadingDataHide(){
	$("#dataLoadingbar").css('display','none');
}

//메일 로딩 감추기
function loadingEmailHide(){
	$("#emailLoadingbar").css('display','none');
}