$(function() {
    
})

//배송 추적
function deliveryTracking(){
	$("#delivery").attr('src', "https://trace.cjlogistics.com/web/info.jsp?slipno=" + $("#songjangTxt").val());
}
