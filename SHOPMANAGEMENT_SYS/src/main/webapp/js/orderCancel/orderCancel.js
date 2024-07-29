$(document).ready(function() {
	
	getOrderCancelList();
});

//주문 취소 삭제
function setOrderCancelDelete(order_no){
	
	if(confirm("정말 삭제하시겠습니까?") == true){    //확인
		
		var paramData = {
							order_no: order_no
						}
						
		resultAjaxAccess("setOrderCancelDelete.do", paramData).done(function (results){
			if(results != null){
				if(results.message == "success"){
					
					getOrderCancelList();
				}else{
					errorShow(results.error);
				}
			}else{
				errorShow(results.error);
			}
		});
 	}else{   //취소
     	return false;

 	}
}

//주문 조회
function getOrderCancelList(start_num){
	
	let startNum = 0;
	if(start_num != undefined){
		startNum = Number(start_num);	
	}else{
		startNum = 0;
	}
	
	var date_chk = "N";
	var first_dt;
	var end_dt;
	if($("#orderDateChk").is(":checked")){
		date_chk = "Y";
		
		let date = $("#reservation").val();
		first_dt = date.substring(0, 10);
		end_dt = date.substring(13);
	}
	
	var paramData = {
						search_type: $("#searchTypeSel option:selected").val(),
						search_txt: $("#searchTxtIp").val(),
						date_chk: date_chk,
						first_dt: first_dt,
						end_dt: end_dt,
						start_num: startNum
						}
	
	resultAjaxAccess("getOrderCancelList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnTotalCnt = results.returnTotalCnt;
				var resulList = results.returnList;
				
				var total_cnt = returnTotalCnt[0].total_cnt;
				
				//목록 초기화
				if(startNum == 0){
					$("#orderCancelUl").empty();	
				}else{
					$("#listMoreLi").remove();	
				}
				
				if(total_cnt > 0){
					
					//건수
					$("#orderCancelListCntSp").text(addComma(String(total_cnt)) + " 건");
				}
				
				var html = "";
				if(resulList.length > 0){
					
					$.each(resulList, function(key, value){
					
						var message = (value.message!=undefined)?value.message:"";
						
						html += '<li class="item" style="height: 110px; font-size: 12px;">' +
									'<div class="product-img">' +
										'<a class="rounded-2 border border-translucent d-inline-block" href="./assets/img/product/maesil.jpg" style="background: white;">' +
											'<img src="./assets/img/product/maesil.jpg" alt="" style="width: 80px; height: 80px; background: white;">' +
										'</a>' +
									'</div>' +
									'<div class="row">' +
										'<div class="col-sm-2">' +
											'<div class="form-group" style="margin-bottom: 0px;">' +
												'<input id="orderChk" name="' + value.order_no + '" type="checkbox" class="check-group" style="width: 15px; height: 15px;" checked="checked">' +
												'<span class="font-weight-bold" style="margin-top: 0px;">주문번호 : ' + value.order_no + '</span>' +
											'</div>' +
											'<p class="d-flex flex-column text-left">' +
												'<span class="font-weight-bold">상품번호 : ' + value.product_no + '</span>' +
												'<span class="product-description">판매스토어 : 쿠팡</span>' +
											'</p>' +
										'</div>' +
										'<div class="col-sm-2">' +
											'<span class="font-weight-bold">' +
												'품목명 : ' + value.product_title + ' ('+ value.option_no +'번)</span>' +
											'<span class="product-description">수량 : ' + value.box_cnt + ' BOX</span>' +
											'<span class="product-description">박스타입 : 특대</span>' +
										'</div>	' +
										'<div class="col-sm-3">' +
											'<span class="font-weight-bold">' +
												'받는분 성명 : ' + value.receive_nm + 
											'</span>' +
											'<span class="product-description">받는분 전화번호: ' + value.receive_tel + '</span>' +
											'<span class="product-description">받는분 주소: ' + value.receive_address + '</span>' +
											'<span></span>' +
											'<span class="product-description">배송메세지 : ' + message + '</span>' +
										'</div>' +
										'<div class="col-sm-3">' +
											'<span class="font-weight-bold">' +
												'보내는분 성명 : ' + value.send_nm + '</span>' +
											'<span class="product-description">보내는분 전화번호: ' + value.send_tel + '</span>' +
											'<span class="product-description">보내는분 주소: ' + value.send_address + '</span>' +
											'<span class="product-description">주문일 : ' + value.create_dt + '</span>' +
											'<span></span>' +
										'</div>' +
										'<div class="col-sm-2" style="width: 100px;">' +
											'<div class="row">' +
												'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onClick="javascript:setOrderCancelDelete(\'' + value.order_no + '\')">' +
												'	삭제' +
												'</button>' +
											'</div>' +	
										'</div>' +			
									'</div>' +
								'</li>';
					});
					
					if(resulList.length == 10){
						html += '<li id="listMoreLi" class="item" style="text-align:center;">' +
									'<button type="button" class="btn btn-default btn-xs" style="width: 100%; margin-right: 5px;" onClick="javascript:getOrderCancelList(\'' + (startNum + 10) + '\')">더보기</button>' +
								'</li>';	
					}
					
				}else{
					if(start_num == undefined || start_num == 0 ){
						html = '<li class="item" style="text-align:center;"><span>조회된 데이터가 없습니다. </span></li>';
					}
				}
				
				$("#orderCancelUl").append(html);
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}