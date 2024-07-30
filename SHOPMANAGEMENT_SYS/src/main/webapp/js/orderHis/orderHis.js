$(document).ready(function() {
	
	getOrderHisList();
});

//주문 파일 다이얼로그
var files;
function orderHisReg(){
	document.getElementById("orderHisFileIp").click();
	$("#orderHisFileIp").on("change", function (evt) {
		files = evt.target.files[0];
		
		var file_name = files.name;
		var extension = file_name.substr(file_name.length - 4);
		
		if(extension != "xlsx"){
			infoShow("엑셀파일(xlsx)을 입력하십시오.");
			return;
		}else{
			setOrderHisReg();	
		}
	});
}

//주문 등록
function setOrderHisReg(){
	
	loadingDataShow();
	
	var formData = new FormData();
  	formData.append("files", files);
  	
  	resultAjaxFileAccess("setOrderHisReg.do", formData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				getOrderHisList();
				
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

//주문 삭제
function setOrderHisDelete(order_no){
	
	if(confirm("정말 삭제하시겠습니까?") == true){    //확인
		
		var paramData = {
							order_no: order_no
						}
						
		resultAjaxAccess("setOrderHisDelete.do", paramData).done(function (results){
			if(results != null){
				if(results.message == "success"){
					
					getOrderHisList();
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

//주문 목록
var resultOrderHisList;
function getOrderHisList(start_num){
	
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
	
	resultAjaxAccess("getOrderHisList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnTotalCnt = results.returnTotalCnt;
				resultOrderHisList = results.returnList;
				
				var total_cnt = returnTotalCnt[0].total_cnt;
				
				//목록 초기화
				if(startNum == 0){
					$("#orderHisUl").empty();	
				}else{
					$("#listMoreLi").remove();	
				}
				
				var html = "";
				if(resultOrderHisList.length > 0){
					
					//건수
					$("#orderHisListCntSp").text(addComma(String(total_cnt)) + " 건");
					
					$.each(resultOrderHisList, function(key, value){
					
						var songjang_no;
						var cancelBtn;
						
						var message = (value.message!=undefined)?value.message:"";
						var status_time = (value.status_time!=undefined)?value.status_time:value.create_dt;
						var status_loc = (value.status_loc!=undefined)?"(" + value.status_loc + ")":"";
						
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
														'<input id="songjangNoIp" type="text" name="' + value.order_no + '" class="form-control float-left" style="width: 130px; height: 25px; color: chartreuse;" placeholder="운송장번호"' +
														' value="' + songjang_no + '" onkeydown="if(window.event.keyCode==13){javascript:setOrderSongjanoNoModify(\'' + value.order_no + '\');}">' +
														'<div class="input-group-append">' +
															'<button type="submit" class="btn btn-default" style="width: 40px; height: 25px; padding-top: 1px; color: chartreuse;" onclick="javascript:setOrderSongjanoNoModify(\'' + value.order_no + '\');">' +
															'	<i class="fa fa-registered"></i>' +
															'</button>' +
														'</div>' +
														'<select id="sellStoreSel' + key + '" style="width: 100%; height: 25px; color: chartreuse;"></select>' +
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
												'<div class="col-sm-12">' +
													'<button type="button" class="btn btn-info btn-xs float-left" style="width: 100px; margin-right: 5px;" onClick="javascript:pageDeliveryTracking(\'' + songjang_no + '\')">' +
													'	상품추적' +
													'</button>' + cancelBtn +
													'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onClick="javascript:setOrderHisDelete(\'' + value.order_no + '\')">' +
													'	삭제' +
													'</button>' +
												'</div>' +
												'<div class="col-sm-12" style="margin-top: 10px;">' +	
													'<span class="product-description" style="color: chartreuse;">' + status_time + '</span>' +
													'<span class="product-description" style="color: chartreuse;">' + value.status + ' ' + status_loc + '</span>' +
												'</div>' +
											'</div>' +	
										'</div>' +			
									'</div>' +
								'</li>';
					});
					
					if(resultOrderHisList.length == 10){
						html += '<li id="listMoreLi" class="item" style="text-align:center;">' +
									'<button type="button" class="btn btn-default btn-xs" style="width: 100%; margin-right: 5px;" onClick="javascript:getOrderHisList(\'' + (startNum + 10) + '\')">더보기</button>' +
								'</li>';	
					}
					
				}else{
					if(start_num == undefined || start_num == 0){
						html = '<li class="item" style="text-align:center;"><span>조회된 데이터가 없습니다. </span></li>';
					}
				}
				
				$("#orderHisUl").append(html);
				
				getSellStoreList();
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//스토어
function getSellStoreList(){
	
	resultAjaxAccess("getSellStoreList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				var returnList = results.returnList;
						
				//목록 초기화
				$("#sellStoreSel").empty();
					
				if(returnList.length > 0){
							
					$.each(resultOrderHisList, function(key1, value){
						
						$("#sellStoreSel" + key1).append('<option value="000">외주 판매</option>');
						$.each(returnList, function(key2, value){
						
							$("#sellStoreSel" + key1).append('<option value="' + value.store_no + '">' + value.store_nm + '</option>');
						});
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

//송장번호 입력
function setOrderSongjanoNoModify(order_no){
	
	let songjang_no = $("input[name='" + order_no + "']").val();
	
	if(songjang_no == ""){
		infoShow("송장번호를 입력하십시오.");
		return;
	}
	
	var paramData = {
						order_no: order_no,
						songjang_no: songjang_no
						}
						
	resultAjaxAccess("setOrderSongjanoNoModify.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("송장번호가 등록되었습니다.");
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}