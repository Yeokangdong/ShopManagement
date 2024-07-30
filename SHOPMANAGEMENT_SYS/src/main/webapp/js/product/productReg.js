//시작함수
$(document).ready(function() {
	
	getLastProductList();
	getCategoryList();
	getMakeCompanyList();
});

//최근 등록한 상품 목록
function getLastProductList(){
	
	resultAjaxAccess("getLastProductList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				let resultList = results.returnList;
				
				$("#productTitleSel").empty();	
				
				if(resultList.length > 0){
					
					$("#productTitleSel").append('<option value="0"> -- 복사 등록하려면 선택 -- </option>');
					$.each(resultList, function(key, value){
						
						$("#productTitleSel").append('<option value="' + value.product_no + '">' + value.product_title + '</option>');
					});
				}
				
				getProductInfo();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//카테고리 목록
function getCategoryList(){
	
	resultAjaxAccess("getCategoryList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				let resultList = results.returnList;
				
				$("#categorySel").empty();	
				
				if(resultList.length > 0){
					
					$.each(resultList, function(key, value){
						
						$("#categorySel").append('<option value="' + value.category_no + '">' + value.category_nm + '</option>');
					});
					
					getItemList();
				}
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//품목 목록
function getItemList(){

	var paramData = {
						category_no: $("#categorySel").val()
					}
	
	resultAjaxAccess("getItemList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				let resultList = results.returnList;
				
				$("#itemSel").empty();	
				
				if(resultList.length > 0){
					
					$.each(resultList, function(key, value){
						
						$("#itemSel").append('<option value="' + value.item_no + '">' + value.item_nm + '</option>');
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

//업체 목록
function getMakeCompanyList(){
	
	resultAjaxAccess("getMakeCompanyList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				let resultList = results.returnList;
				
				$("#companySel").empty();	
				
				if(resultList.length > 0){
					
					$.each(resultList, function(key, value){
						
						$("#companySel").append('<option value="' + value.company_no + '">' + value.company_nm + '</option>');
					});
					
					getItemList();
				}
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//상품 등록
function setProductReg(){
	
	let tax;
	if($("#tax1Chk").is(":checked")){
		tax = "1";
	}else if($("#tax2Chk").is(":checked")){
		tax = "2";
	}else{
		tax = "3";
	}

	var paramData = {
						category_no: $("#categorySel option:selected").val(),
						item_no: $("#itemSel option:selected").val(),
						company_no: $("#companySel option:selected").val(),
						tax: tax,
						product_title: $("#productTitleIp").val(),
						inventory: $("#inventoryIp").val().replace(",",""),
						origin: $("#originSel").val(),
						origin_title: $("#originTitleIp").val()
					}
	
	resultAjaxAccess("setProductReg.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				let product_no = results.productNo;
				$("#productNoIp").val(product_no);
				
				getLastProductList();
				
				infoShow("상품이 등록되었습니다.");
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//상품 정보
function getProductInfo(){

	var paramData = {
						product_no: $("#productTitleSel option:selected").val()
					}
	
	resultAjaxAccess("getProductInfo.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				let resultList = results.returnList;
				
				if(resultList.length > 0){
					
					$.each(resultList, function(key, value){
						
						$("#productNoIp").val(value.product_no);
						$("#categorySel").val(value.category_no);
						$("#itemSel").val(value.item_no);
						$("#companySel").val(value.company_no);
						
						$("#input[id='tax1Chk']").prop('checked', false);
						$("#input[id='tax2Chk']").prop('checked', false);
						$("#input[id='tax3Chk']").prop('checked', false);
						if(value.tax == "1"){
							$("#tax1Chk").prop('checked','checked');
						}else if(value.tax == "2"){
							$("#tax2Chk").prop('checked','checked');
						}else{
							$("#tax3Chk").prop('checked','checked');
						}
						
						$("#productTitleIp").val(value.product_title);
						$("#inventoryIp").val(value.inventory);
						$("#originSel").val(value.origin);
						$("#originTitleIp").val(value.origin_title);
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