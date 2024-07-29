$(document).ready(function() {
	
	getOrderCompleteList();
});

//주문 조회
var resultOrderCompleteList;
function getOrderCompleteList(start_num){
	
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
	
	resultAjaxAccess("getOrderCompleteList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnTotalCnt = results.returnTotalCnt;
				resultOrderCompleteList = results.returnList;
				
				var total_cnt = returnTotalCnt[0].total_cnt;
				
				//목록 초기화
				if(startNum == 0){
					$("#orderCompleteUl").empty();	
				}else{
					$("#listMoreLi").remove();	
				}
				
				var html = "";
				if(resultOrderCompleteList.length > 0){
					
					//건수
					$("#orderCompleteListCntSp").text(addComma(String(total_cnt)) + " 건");
					
					$.each(resultOrderCompleteList, function(key, value){
					
						var songjang_no;
						var cancelBtn;
						
						var message = (value.message!=undefined)?value.message:"";
						var status_time = (value.status_time!=undefined)?value.status_time:value.create_dt;
						var status_loc = (value.status_loc!=undefined)?value.status_loc:"";
						
						if(value.songjang_no != null && value.songjang_no != undefined){
							songjang_no = value.songjang_no;
							cancelBtn = '<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">' +
										'	반품' +
										'</button>';
						}else{
							songjang_no = "";
							cancelBtn = '<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">' +
										'	취소' +
										'</button>';
						}
						
						html += '<li class="item" style="height: 110px; font-size: 12px;">' +
									'<div class="product-img">' +
										'<a class="rounded-2 border border-translucent d-inline-block" href="./assets/img/product/maesil.jpg" style="background: white;">' +
											'<img src="./assets/img/product/maesil.jpg" alt="" style="width: 100px; height: 90px; background: white;">' +
										'</a>' +
									'</div>' +
									'<div class="row">' +
										'<div class="col-sm-2">' +
											'<div class="form-group" style="margin-bottom: 0px;">' +
												'<span class="font-weight-bold" style="margin-top: 0px;">주문번호 : ' + value.order_no + '</span>' +
											'</div>' +
											'<p class="d-flex flex-column text-left" style="margin-bottom: 2px;">' +
												'<span class="font-weight-bold">상품번호 : ' + value.product_no + '</span>' +
												'<div class="form-group" style="margin-bottom: 0px;">' +
													'<div class="input-group input-group-sm float-left" style="width: 180px; margin-top: 1px;">' +
														'<span class="font-weight-bold product-description" style="font-size: 13px; color: chartreuse;">' + value.songjang_no + '</span>' +
													'</div>' +
												'</div>' +
											'</p>' +
										'</div>' +
										'<div class="col-sm-2">' +
											'<span class="font-weight-bold">' +
												'품목명 : ' + value.product_title + ' ('+ value.option_no + '번)</span>' +
											'<span class="product-description">수량 : ' + value.box_cnt + ' BOX</span>' +
											'<span class="product-description">택배사 : CJ 대한통운</span>' +
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
											'<span class="product-description">발송일 : ' + value.create_dt + '</span>' +
											'<span></span>' +
										'</div>' +
										'<div class="col-sm-2" style="width: 100px;">' +
											'<div class="row">' +
												'<div class="col-sm-12">' + cancelBtn +
													'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onClick="javascript:orderDelete(\'' + value.order_no + '\')">' +
													'	교환' +
													'</button>' +
												'</div>' +
												'<div class="col-sm-12" style="margin-top: 10px;">' +	
													'<span class="product-description" style="color: chartreuse;">' + status_time + '</span>' +
													'<span class="product-description" style="color: chartreuse;">' + value.status + ' (' + status_loc + ')</span>' +
												'</div>' +
											'</div>' +	
										'</div>' +			
									'</div>' +
								'</li>';
					});
					
					if(resultOrderCompleteList.length == 10){
						html += '<li id="listMoreLi" class="item" style="text-align:center;">' +
									'<button type="button" class="btn btn-default btn-xs" style="width: 100%; margin-right: 5px;" onClick="javascript:getOrderCompleteList(\'' + (startNum + 10) + '\')">더보기</button>' +
								'</li>';	
					}
					
				}else{
					if(start_num == undefined || start_num == 0){
						html = '<li class="item" style="text-align:center;"><span>조회된 데이터가 없습니다. </span></li>';
					}
				}
				
				$("#orderCompleteUl").append(html);
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//주문 이메일 전송 다이얼로그(체크된 값 가져오기)
var orderChkArr = [];
var orderChkListArr = [];
function orderSendEmail(){
	let checkedBox = $("input:checkbox:checked");
	orderChkArr = [];
	
	if(checkedBox.length == 0){		
		infoShow("선택된 주문이 없습니다.");
		return;
	}else{
		sendEmailShow();
	
		$.each(checkedBox, function (index, item){
			if(item.name != ""){
				orderChkArr.push(item.name);	
			}
		});
		
		getOrderCompleteEmailInfo();
		getCompanyNoList();
		getOrderCompleteChkList();	
	}
}

//주문 이메일 정보
function getOrderCompleteEmailInfo(){
	
	resultAjaxAccess("getOrderCompleteEmailInfo.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
						
						$("#emailTitleDialogIp").val(value.email_title);
						$("#emailContentDialogTa").val(value.email_content);
					});
				}else{
					infoShow("메일 전송 컨텐츠를 입력하십시오.");
					retuern;
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//업체 목록
function getCompanyNoList(){
	
	resultAjaxAccess("getCompanyNoList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
						
				//목록 초기화
				$("#companyNmDialogSel").empty();
					
				if(returnList.length > 0){
					$.each(returnList, function(key, value){
						$("#companyNmDialogSel").append('<option value="' + value.company_no + '">' + value.company_nm + '</option>')
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

//주문 목록
function getOrderCompleteChkList(){
	
	$("#orderDialogTb").empty();
	
	var html = "";
	
	orderChkListArr = [];
	if(resultOrderList.length > 0){
					
	  	for(var i = 0; i < orderChkArr.length; i++){
	  		for(var j = 0; j < resultOrderList.length; j++){
				if(orderChkArr[i] == resultOrderList[j].order_no){
					orderChkListArr.push({order_no:resultOrderList[j].order_no, product_title:resultOrderList[j].product_title});
				}
			}
		}
		
		$("#orderDialogChkCnt").text(orderChkListArr.length + " 건");
		
	  	for(var i = 0; i < orderChkListArr.length; i++){
			  
			  html += '<tr>' +
					'<td style="width: 300px;">' + orderChkListArr[i].order_no + ' / ' + orderChkListArr[i].product_title + '</td>' +
					'<td>' +
						'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onClick="javascript:orderChkListArrDelete(\'' + orderChkListArr[i].order_no + '\')">' +
							'삭제' +
						'</button>' +
					'</td>' +
			'</tr>';
		}
		
		$("#orderDialogTb").append(html);
	}else{
		infoShow("체크된 주문번호가 없습니다");
		return;
	}
}