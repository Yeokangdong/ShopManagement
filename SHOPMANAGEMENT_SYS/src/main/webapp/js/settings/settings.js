//시작함수
$(document).ready(function() {
	
	getUserInfo();
	getSystemInfo();
	getBusinessInfo();
	
	getStatisticsList();
	
	getCategoryList();
	getSellStoreList();
	getCourierCompanyList();
});

//계정 수정
function setUserModify(){
	
	var userId = $("#userIdIp").val();
	var userPassword = $("#userPasswordIp").val();
	var userPasswordConfirm = $("#userPasswordConfirmIp").val();
	
	if(userId == "" && userId == undefined){
		infoShow("아이디를 확인하십시오.");
		return;
	}
	
	if(userId == ""){
		infoShow("아이디를 입력하십시오.");
		return;
	}else{
		if(userPassword != userPasswordConfirm){
			infoShow("비밀번호를 확인하십시오.");
			return;
		}
	} 
	
	var paramData = {
						user_id: userId,
						user_password: userPassword
						}
	
	resultAjaxAccess("setUserModify.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("수정 되었습니다.");
				
				getUserInfo();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//계정 정보
function getUserInfo(){
	
	resultAjaxAccess("getUserInfo.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var systemInfo = results.userInfo;
				
				if(systemInfo.length > 0){
					
					$.each(systemInfo, function(key, value){
						
						$("#userIdIp").val(value.user_id);
						$("#userPasswordIp").val(value.user_password);
						$("#userPasswordConfirmIp").val(value.user_password);
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

//로고 통계 정보
function getStatisticsList(){
	
	resultAjaxAccess("getStatisticsList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
						
						var company_cnt1 = (value.company_cnt1!=undefined)?addComma(value.company_cnt1):"0";
						var company_cnt2 = (value.company_cnt2!=undefined)?addComma(value.company_cnt2):"0";
						var customer_cnt = (value.customer_cnt!=undefined)?addComma(value.customer_cnt):"0";
						
						$("#company1Sp").text(company_cnt1);
						$("#company2Sp").text(company_cnt2);
						$("#customerSp").text(customer_cnt);
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

//로고 변경
function logoFile(evt){
	
	var files = evt.files[0];
	
	var formData = new FormData();
  	formData.append("files", files);
  	
  	resultAjaxFileAccess("setLogoFilesReg.do", formData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("로고가 변경되었습니다.");
				
				getSystemInfo();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//시스템 수정
function setSystemModify(){
	
	var system_nm = $("#systemNmIp").val();
	var system_s_nm = $("#systemSNmIp").val();
	
	if(system_nm == ""){
		infoShow("시스템명을 입력하십시오.");
		return;
	}
	
	var paramData = {
						logo_img_change: $("#logoImg1Chk").is(":checked")?"Y":"N",
						system_nm: system_nm,
						system_s_nm: system_s_nm
						}
	
	resultAjaxAccess("setSystemModify.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("수정 되었습니다.");
				
				getSystemInfo();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//시스템 정보
function getSystemInfo(){
	
	resultAjaxAccess("getSystemInfo.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var systemInfo = results.systemInfo;
				
				if(systemInfo.length > 0){
					
					$.each(systemInfo, function(key, value){
						
						$("#logoImg1Chk").prop('checked', false); 
						$("#logoImg1Chk").prop('checked', false); 
						if(value.logo_img_change != undefined && value.logo_img_change != null){
							if(value.logo_img_change == "Y"){
								$("#logoImg1Chk").prop('checked', true); 
						
								//설정 로고
								$("#logoImg").attr("src", "http://" + ip + ":" + port + "/계정/" + value.logo);
								
								//메뉴 로고
								$("#topLogoImg").attr("src", "http://" + ip + ":" + port + "/계정/" + value.logo);
							}else{
								$("#logoImg2Chk").prop('checked', true); 
							}
						}
						
						$("#systemNmSp").text(value.system_nm);
						$("#systemSNmSp").text(value.system_s_nm);
						
						//하단 시스템 에름
						$("#systemTitle").text(value.system_nm);
						$("#footerSystemTitle").text(value.system_nm + " 판매 관리 시스템");
						$("#copyTitle").text(value.system_nm);
						
						$("#systemNmIp").val(value.system_nm);
						$("#systemSNmIp").val(value.system_s_nm);
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

//사업자 수정
function setBusinessModify(){
	
	var paramData = {
						business_no: $("#businessNoIp").val()?$("#businessNoIp").val():"",
						tele_sell: $("#teleSellIp").val()?$("#teleSellIp").val():"",
						address: $("#addressIp").val()?$("#addressIp").val():"",
						customer_center: $("#customerCenterIp").val()?$("#customerCenterIp").val():""
						}
	
	resultAjaxAccess("setBusinessModify.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("수정 되었습니다.");
				
				getBusinessInfo();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}


//사업자 조회
function getBusinessInfo(){
	
	resultAjaxAccess("getBusinessInfo.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var businessInfo = results.businessInfo;
				
				if(businessInfo.length > 0){
					
					$.each(businessInfo, function(key, value){
						
						$("#businessNoP").text(value.business_no);
						$("#teleSellP").text(value.tele_sell);
						$("#addressP").text(value.address);
						$("#customerCenterP").text(value.customer_center);
						
						$("#businessNoIp").val(value.business_no);
						$("#teleSellIp").val(value.tele_sell);
						$("#addressIp").val(value.address);
						$("#customerCenterIp").val(value.customer_center);
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


//카테고리 등록
function setCategoryReg(){
	var paramData = {
						category_nm: $("#categoryNmIp").val()?$("#categoryNmIp").val():""
						}
	
	resultAjaxAccess("setCategoryReg.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("저장되었습니다.");
				
				getCategoryList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//카테고리 삭제
function setCategoryDelete(category_no){
	//확인
	if(confirm("정말 삭제하시겠습니까?") == true){    
		var paramData = {
							category_no: category_no
							}
		
		resultAjaxAccess("setCategoryDelete.do", paramData).done(function (results){
			if(results != null){
				if(results.message == "success"){
					
					infoShow("삭제 되었습니다.");
					
					getCategoryList();
				}else{
					errorShow(results.error);
				}
			}else{
				errorShow(results.error);
			}
		});
	}else{
		return false;
	}
}

//카테고리 조회
function getCategoryList(){
	
	resultAjaxAccess("getCategoryList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				//목록 초기화
				$("#categoryTb").empty();
				$("#itemCategorySel").empty();
					
				//건수
				$("#categoryListCnt").text(returnList.length + " 건");
				
				var html = "";
				var itemHtml = "";
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
						
						html += '<tr>' +
									'<td style="width: 180px;">' + value.category_nm + '</td>' +
									'<td style="width: 100px;">' + value.category_no + '</td>' +
									'<td>' +
										'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onclick="javascript:setCategoryDelete(\'' + value.category_no + '\');">' +
										'	삭제' +
										'</button>' +
									'</td>'	 +
								'</tr>';
								
						itemHtml += '<option value="' + value.category_no + '">' + value.category_nm + '</option>';		
					});
				}else{
					html += '<tr>' +  
								'<td colspan="4" style="width: 300px; text-align:center;">조회된 데이터가 없습니다.</td>' +
							'</tr>';
				}
				
				$("#categoryTb").append(html);
				$("#itemCategorySel").append(itemHtml);
				
				$("itemCategorySel").val("1").prop("selected", true);
				getItemList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//품목 등록
function setItemReg(){
	var paramData = {
						category_no: $("#itemCategorySel option:selected").val(),
						item_nm: $("#itemNmIp").val()?$("#itemNmIp").val():""
						}
	
	resultAjaxAccess("setItemReg.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("저장되었습니다.");
				
				getCategoryList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//품목 삭제
function setItemDelete(category_no){
	//확인
	if(confirm("정말 삭제하시겠습니까?") == true){    
		var paramData = {
							item_no: item_no
							}
		
		resultAjaxAccess("setItemDelete.do", paramData).done(function (results){
			if(results != null){
				if(results.message == "success"){
					
					infoShow("삭제 되었습니다.");
					
					getCategoryList();
				}else{
					errorShow(results.error);
				}
			}else{
				errorShow(results.error);
			}
		});
	}else{
		return false;
	}
}

//품목 조회
function getItemList(){
	
	var paramData = {
						category_no: $("#itemCategorySel option:selected").val()
						}
						
	resultAjaxAccess("getItemList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
					
				//건수
				$("#itemListCnt").text(returnList.length + " 건");
				
				//목록 초기화
				$("#itemTb").empty();
				
				var html = "";
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
						
						html += '<tr>' +
									'<td style="width: 180px;">' + value.item_nm + '</td>' +
									'<td style="width: 100px;">' + value.item_no + '</td>' +
									'<td>' +
										'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onclick="javascript:setItemDelete(\'' + value.item_no + '\');">' +
										'	삭제' +
										'</button>' +
									'</td>'	 +
								'</tr>';
					});
				}else{
					html += '<tr>' +  
								'<td colspan="4" style="width: 300px; text-align:center;">조회된 데이터가 없습니다.</td>' +
							'</tr>';
				}
				
				$("#itemTb").append(html);
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//판매 스토어 등록
function setSellStoreReg(){
	
	var paramData = {
						store_nm: $("#sellStoreIp").val()
						}
	
	resultAjaxAccess("setSellStoreReg.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("저장되었습니다.");
				
				getSellStoreList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//판매 스토어 삭제
function setSellStoreDelete(store_no){
	//확인
	if(confirm("정말 삭제하시겠습니까?") == true){    
		var paramData = {
							store_no: store_no
							}
		
		resultAjaxAccess("setSellStoreDelete.do", paramData).done(function (results){
			if(results != null){
				if(results.message == "success"){
					
					infoShow("수정 되었습니다.");
					
					getSellStoreList();
				}else{
					errorShow(results.error);
				}
			}else{
				errorShow(results.error);
			}
		});
	}else{
		return false;
	}
}

//판매 스토어 수수율 수정
function setSellStoreChargeModify(){ 
		
	var paramData = {
						store_no: $("#sellStoreSel option:selected").val(),
						charge: $("#sellStoreChargeIp").val()
						}
	
	resultAjaxAccess("setSellStoreChargeModify.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("수정 되었습니다.");
				
				getSellStoreList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//판매 스토어 조회
function getSellStoreList(){
	
	var paramData = {
						category_no: $("#sellStoreSel option:selected").val(),
						}
						
	resultAjaxAccess("getSellStoreList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
					
				//건수
				$("#sellStoreListCnt").text(returnList.length + " 건");
				
				//목록 초기화
				$("#sellStoreTb").empty();
				$("#sellStoreSel").empty();
				
				var html = "";
				var storeHtml = "";
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
				
						var charge;
						if(value.charge != undefined && value.charge != null){
							charge = value.charge;
						}else{
							charge = "0";
						}
						
						html += '<tr>' +
									'<td style="width: 180px;">' + value.store_nm + '</td>' +
									'<td style="width: 100px;">' + charge + ' %</td>' +
									'<td>' +
										'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onclick="javascript:setSellStoreDelete(\'' + value.store_no + '\');">' +
										'	삭제' +
										'</button>' +
									'</td>'	 +
								'</tr>';
								
						storeHtml += '<option value="' + value.store_no + '">' + value.store_nm + '</option>';				
					});
				}else{
					html += '<tr>' +  
								'<td colspan="4" style="width: 300px; text-align:center;">조회된 데이터가 없습니다.</td>' +
							'</tr>';
				}
				
				$("#sellStoreTb").append(html);
				$("#sellStoreSel").append(storeHtml);
				
				$("sellStoreSel").val("1").prop("selected", true);
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//택배사 운임 수정
function setCourierCompanyModify(){ 
		
	var paramData = {
						courier_no: $("#courierCompanySel option:selected").val(),
						charge: $("#courierCompanyChargeIp").val()
						}
	
	resultAjaxAccess("setCourierCompanyModify.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("수정 되었습니다.");
				
				getCourierCompanyList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//택배사 조회
var returnList;
function getCourierCompanyList(){
						
	resultAjaxAccess("getCourierCompanyList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				courierCompanyList = results.returnList;
					
				//목록 초기화
				$("#courierCompanySel").empty();
				
				var html = "";
				if(courierCompanyList.length > 0){
					
					$.each(courierCompanyList, function(key, value){
						
						html += '<option value="' + value.courier_no + '">' + value.courier_nm + '</option>';
					});
					
					$("#courierCompanySel").append(html);
				}
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}