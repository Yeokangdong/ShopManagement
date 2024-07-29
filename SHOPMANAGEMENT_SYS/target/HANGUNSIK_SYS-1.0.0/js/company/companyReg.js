//시작함수
$(document).ready(function() {
	getCompanyList();
});

//초기화
function initTxt(){
	$("#companyNmIp").value("");
	$("#ceoNmIp").value("");
	$("#businessNoIp").value("");
	$("#telephoneIp").value("");
	$("#emailIp").value("");
	$("#addressIp").value("");
	$("#bankNmIp").value("");
	$("#bankNoIp").value("");
	$("#bankAccountHolderIp").value("");
	$("#bankDepositIp").value("");
}

//업체 등록
function companyReg(){
	
	var paramData = {
						company_type:$("#companyTypeSel option:selected").val(),
						company_nm:$("#companyNmIp").val(), 
						ceo_nm:$("#ceoNmIp").val(), 
						business_tax:$("#businessTaxSel option:selected").val(),
						business_no:$("#businessNoIp").val(),
						telephone:$("#telephoneIp").val(),
						email:$("#emailIp").val(),
						address:$("#addressIp").val(),
						bank_nm:$("#bankNmIp").val(),
						bank_no:$("#bankNoIp").val(),
						bank_account_holder:$("#bankAccountHolderIp").val(),
						bank_deposit:$("#bankDepositIp").val()
						}
	
	resultAjaxAccess("setCompanyReg.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				alert("저장되었습니다.", "저장");
				
				getCompanyList();
			}else{
				alert(results.error);
			}
		}
	});
}

function getCompanyList(){
	var paramData = {
						search_type:$("#companyTypeSel option:selected").val(),
						search_txt:$("#searchTxtIp").val(),
						company_type:$("#companyTypeSel option:selected").val()
						}
	
	resultAjaxAccess("getCompanyList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var companyList = results.companyList;
				
				//목록 초기화
				$("#companyTb").empty();
				
				var html = "";
				if(companyList.length > 0){
					
					//건수
					$("#companyListCnt").text(companyList.length + " 건");
					
					$.each(companyList, function(key, value){
						
						var company_type, company_color;
						if(value.company_type == "1"){
							company_type = "제조";
							company_color = "badge-info";
						}else{
							company_type = "외주";
							company_color = "badge-danger";
						}
						
						html += '<tr>' +
										'<td><span class="bs-stepper-circle">' + (key + 1) +'</span></td>' +
										'<td>' + value.company_nm + '</td>' +
										'<td>' + value.company_no + '</td>' +
										'<td>' + value.ceo_nm + '</td>' +
										'<td>' + value.telephone + '</td>' +
										'<td>' + value.business_no + '</td>' +
										'<td><span class="badge ' + company_color + '" style="width: 50px; height: 25px; padding-top: 7px;">' + company_type + '</span></td>' +
										'<td>' + addComma(value.bank_deposit) + ' 원</td>' +
										'<td>' +
											'<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;" onclick="javascript:setCompanyReg(' + value.company_no + ');">' +
											'	수정' +
											'</button>' +
											'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px; onclick="javascript:setCompanyDelete(' + value.company_no + ');">' +
											'	삭제' +
											'</button>' +
										'</td>'	 +
									'</tr>';
					});
				}else{
					html += '<tr>' +  
								'<td colspan="9" style="text-align:center;">조회된 데이터가 없습니다.</td>' +
							'</tr>';
				}
				
				$("#companyTb").append(html);
			}else{
				alert(results.error);
			}
		}
	});
}