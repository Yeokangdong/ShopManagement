$(function() {
    const searchParams = new URLSearchParams(location.search);
    for (const param of searchParams) {
    	if(param[0] != undefined && param[1] != "undefined" && param[0] == "songjang_no"){
    		
    		let songjang_no = param[1];
    		$("#songjangTxt").val(songjang_no);
    		
    		getOrderHisInfo(songjang_no);
    		
    		songjang_no = songjang_no.replaceAll("-","");
    		
    		deliveryTracking(songjang_no);	
		}
	}
})

//배송 추적
function deliveryTracking(songjang_no){
	$("#deliveryIf").attr('src', "https://trace.cjlogistics.com/web/info.jsp?slipno=" + songjang_no);
}

//상품 추적 정보
function getOrderHisInfo(songjang_no){
		
	var paramData = {
						songjang_no: songjang_no
					}
	
	resultAjaxAccess("getOrderHisInfo.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var orderHisInfo = results.orderHisInfo;
				
				if(orderHisInfo.length > 0){
					
					$.each(orderHisInfo, function(key, value){
					
						$("#order_no").val(value.order_no);
						$("#product_no").val(value.order_no);
						$("#product_title").val(value.product_title + " (" + value.option_no + "번)");
						$("#box_cnt").val(value.box_cnt);
						$("#message").val(value.message);
						$("#create_dt").val(value.create_dt);
						$("#status").val(value.status);
						$("#status_loc").val(value.status_loc);
						$("#status_time").val(value.status_time);
						
						$("#receive_nm").val(value.receive_nm);
						$("#receive_tel").val(value.receive_tel);
						$("#receive_tel_etc").val(value.receive_tel_etc);
						$("#receive_address").val(value.receive_address);
						$("#send_nm").val(value.send_nm);
						$("#send_tel").val(value.send_tel);
						$("#send_tel_etc").val(value.send_tel_etc);
						$("#send_address").val(value.send_address);
					});
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}
