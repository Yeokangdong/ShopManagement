/**
 * 계정 
 * 
 */


//시작함수
$(document).ready(function() {
	
});

//설정 페이지 이동
function pageSettings(){
	window.location.replace("pageSettings.do?page=settings");
}

//상품 조회 페이지 이동
function pageProduct(){
	window.location.replace("pageProduct.do?page=product");
}

//상품 상세 페이지 이동
function pageProductDetail(){
	window.location.replace("pageProductDetail.do");
}

//상품 등록/수정 페이지 이동
function pageProductReg(){
	window.location.replace("pageProductReg.do?page=productReg");
}

//업체조회 페이지 이동
function pageCompany(){
	window.location.replace("pageCompany.do?page=company");
}

//업체 등록 페이지 이동
function pageCompanyReg(){
	window.location.replace("pageCompanyReg.do?page=companyReg");
}

//직원 등록 페이지 이동
function pageEmployeeReg(){
	window.location.replace("pageEmployeeReg.do?page=employeeReg");
}

//다중 주문 페이지 이동
function pageOrder1Reg(){
	window.location.replace("pageOrder1Reg.do?page=order1Reg");
}

//건별 주문 페이지 이동
function pageOrder2Reg(){
	window.location.replace("pageOrder2Reg.do?page=order2Reg");
}

//주문 내역 페이지 이동
function pageOrderHis(){
	window.location.replace("pageOrderHis.do?page=orderHis");
}

//배송 완료 페이지 이동
function pageOrderComplete(){
	window.location.replace("pageOrderComplete.do?page=orderComplete");
}

//취소 내역 페이지 이동
function pageOrderCancel(){
	window.location.replace("pageOrderCancel.do?page=orderCancel");
}

//상품 추적 페이지 이동
function pageDeliveryTracking(param){
	window.location.replace("pageDeliveryTracking.do?page=deliveryTracking&songjang_no=" + param);
}

//고객DB 페이지 이동
function pageCustomerDB(menu){
	window.location.replace("pageCustomerDB.do?page=customerDB");
}

//고객DB 페이지 이동
function pageExactCalculation(){
	window.location.replace("pageExactCalculation.do");
}