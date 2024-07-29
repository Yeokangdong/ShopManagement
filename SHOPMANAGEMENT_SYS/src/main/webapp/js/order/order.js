$(document).ready(function() {
	
	getOrderTotalList();
	getOrderList();
});

//달력 조회시
function getDateSearch(){
	
	getOrderList();
}

//주문 파일 다이얼로그
var files;
function orderReg(){
	
	document.getElementById("orderFileIp").click();
	$("#orderFileIp").on("change", function (evt) {
		files = evt.target.files[0];
		
		var file_name = files.name;
		var extension = file_name.substr(file_name.length - 4);
		
		if(extension != "xlsx"){
			infoShow("엑셀파일(xlsx)을 입력하십시오.");
			return;
		}else{
			setOrderReg();	
		}	
	});
}

//전체(1개) 삭제
function setOrderCancel(order_no){
	
	if(confirm("정말 취소하시겠습니까?") == true){    //확인
		
		var paramData = {
							order_no: order_no
						}
						
		resultAjaxAccess("setOrderCancel.do", paramData).done(function (results){
			if(results != null){
				if(results.message == "success"){
					
					getOrderList();
				}else{
					errorShow(results.error);
				}
			}else{
				LoadingDataHide();
				errorShow(results.error);
			}
		});
 	}else{   //취소
     	return false;

 	}
}

//전체(1개) 삭제
function setOrderDelete(order_no){
	
	if(confirm("정말 삭제하시겠습니까?") == true){    //확인
		
		var paramData = {
							order_no: order_no
						}
						
		resultAjaxAccess("setOrderDelete.do", paramData).done(function (results){
			if(results != null){
				if(results.message == "success"){
					
					getOrderList();
				}else{
					errorShow(results.error);
				}
			}else{
				LoadingDataHide();
				errorShow(results.error);
			}
		});
 	}else{   //취소
     	return false;

 	}
}

//주문 폼 양식 다운로드
function orderFormDownload(){
	window.open("http://" + ip + ":" + port + "/엑셀 양식/주문.xlsx");
}

//주문 등록
function setOrderReg(){
	
	loadingDataShow();
	
	var formData = new FormData();
  	formData.append("files", files);
  	
  	resultAjaxFileAccess("setOrderReg.do", formData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				getOrderTotalList();
				getOrderList();
				
				LoadingDataHide();
				infoShow("주문이 등록되었습니다.");
			}else{
				LoadingDataHide();
				errorShow(results.error);
			}
		}else{
			LoadingDataHide();
			errorShow(results.error);
		}
	});
}

//주문 전체 목록
var returnTotalList;
function getOrderTotalList(){
	
  	resultAjaxAccess("getOrderTotalList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				returnTotalList = returnList;
				var total_cnt = returnList.length;
				
				if(total_cnt > 0){
					
					//건수
					$("#orderListCntSp").text(addComma(String(total_cnt)) + " 건");
				}
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//주문 조회
function getOrderList(start_num){
	
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
						start_num: startNum,
						}
	
	resultAjaxAccess("getOrderList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var resultOrderList = results.returnList;
				
				
				//목록 초기화
				if(startNum == 0){
					$("#orderUl").empty();	
				}else{
					$("#listMoreLi").remove();	
				}
				
				var html = "";
				if(resultOrderList.length > 0){
					
					$.each(resultOrderList, function(key, value){
					
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
												'<button type="button" class="btn btn-info btn-xs float-left" style="width: 100px; margin-right: 5px;">' +
												'	주문내역 이동' +
												'</button>' +
												'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onClick="javascript:setOrderCancel(\'' + value.order_no + '\')">' +
												'	취소' +
												'</button>' +
												'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onClick="javascript:setOrderDelete(\'' + value.order_no + '\')">' +
												'	삭제' +
												'</button>' +
											'</div>' +	
										'</div>' +			
									'</div>' +
								'</li>';
					});
					
					if(resultOrderList.length == 10){
						html += '<li id="listMoreLi" class="item" style="text-align:center;">' +
									'<button type="button" class="btn btn-default btn-xs" style="width: 100%; margin-right: 5px;" onClick="javascript:getOrderList(\'' + (startNum + 10) + '\')">더보기</button>' +
								'</li>';	
					}
					
				}else{
					if(start_num == undefined || start_num == 0 ){
						html = '<li class="item" style="text-align:center;"><span>조회된 데이터가 없습니다. </span></li>';
					}
				}
				
				$("#orderUl").append(html);
				
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
		
		getOrderEmailInfo();
		getCompanyNoList();
		getOrderChkList();	
	}
}

//주문 이메일 정보
function getOrderEmailInfo(){
	
	resultAjaxAccess("getOrderEmailInfo.do").done(function (results){
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
				loadingEmailHide();
				errorShow(results.error);
			}
		}else{
			loadingEmailHide();
			errorShow(results.error);
		}
	});
}

//주문 목록
function getOrderChkList(){
	
	$("#orderDialogTb").empty();
	
	var html = "";
	
	orderChkListArr = [];
	if(returnTotalList.length > 0){
					
	  	for(var i = 0; i < orderChkArr.length; i++){
	  		for(var j = 0; j < returnTotalList.length; j++){
				if(orderChkArr[i] == returnTotalList[j].order_no){
					orderChkListArr.push({order_no:returnTotalList[j].order_no, receive_nm:returnTotalList[j].receive_nm, product_title:returnTotalList[j].product_title});
				}
			}
		}
		
		$("#orderDialogChkCnt").text(orderChkListArr.length + " 건");
		
	  	for(var i = 0; i < orderChkListArr.length; i++){
			  
			  html += '<tr>' +
					'<td style="width: 500px;">' + orderChkListArr[i].order_no + ' / ' + orderChkListArr[i].receive_nm + ' / ' + orderChkListArr[i].product_title + '</td>' +
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

//목록 전체 선택/해제
function orderChkList(){
	
	if($("#orderChk").is(":checked")){
		$("input:checkbox").prop("checked", true);
		$("#orderChk").prop("checked", true);	
	}else{
		$("input:checkbox").prop("checked", false);
		$("#orderChk").prop("checked", false);	
	}
	
}

//주문 값 삭제 목록
function orderChkListArrDelete(param){
	
	for(let i = 0; i < orderChkListArr.length; i++) {
	    if (orderChkListArr[i].order_no === param) {
	        orderChkArr.splice(i, 1);
	    }
	}
    
	getOrderChkList();
}

//이메일 전송
function sendEmail(){
	
  	loadingEmailShow();
	
	var paramData = {
						email_title: $("#emailTitleDialogIp").val(),
						email_content: $("#emailContentDialogTa").val(),
						company_no: $("#companyNmDialogSel option:selected").val(),
						orderChkArr: JSON.stringify(orderChkArr),
						}
	
	resultAjaxAccess("sendEmail.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				
				loadingEmailHide();
				infoShow("메일 전송이 완료되었습니다.");
			}else{
				loadingEmailHide();
				errorShow(results.error);
			}
		}else{
			loadingEmailHide();
			errorShow(results.error);
		}
	});
}