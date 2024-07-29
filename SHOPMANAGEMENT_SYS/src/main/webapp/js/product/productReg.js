//시작함수
$(document).ready(function() {
	
	getLastProductList();
	getCategoryList();
});

//최근 등록한 상품 목록
function getLastProductList(){
	
	resultAjaxAccess("getLastProductList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				let resultList = results.returnList;
				
				$("#brandTitleSel").empty();	
				
				if(resultList.length > 0){
					
					$("#brandTitleSel").append('<option value="0"> -- 복사 등록하려면 선택 -- </option>');
					$.each(resultList, function(key, value){
						
						$("#brandTitleSel").append('<option value="' + value.item_no + '">' + value.brand_title + '</option>');
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

//기본 상품 등록
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
						category_no: $("#categorySel").val(),
						item_no: $("#itemSel").val(),
						tax: tax,
						brand_title: $("#brandTitleIp").val()
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
						category_no: $("#categorySel").val()
					}
	
	resultAjaxAccess("getProductInfo.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("상품이 등록되었습니다.");
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}