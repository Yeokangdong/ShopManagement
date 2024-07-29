$(document).ready(function() {
	
	const searchParams = new URLSearchParams(location.search);
    for (const param of searchParams) {
    	if(param[1] != undefined && param[1] != "undefined"){
    		
		}else{
			history.replaceState({}, null, location.pathname);
		}
	}
	
	getCompanyList();
});

//업체 조회
function getCompanyList(start_num){
	
	let startNum = 0;
	if(start_num != undefined){
		startNum = Number(start_num);	
	}else{
		startNum = 0;
	}
	
	var paramData = {
						search_type: $("#searchTypeSel option:selected").val(),
						search_txt: $("#searchTxtIp").val(),
						company_type: $("#companyTypeSel option:selected").val(),
						start_num: startNum
						}
	
	resultAjaxAccess("getCompanyList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnTotalCnt = results.returnTotalCnt;
				var returnList = results.returnList;
				
				var total_cnt = returnTotalCnt[0].total_cnt;
				
				//목록 초기화
				if(startNum == 0){
					$("#companyTb").empty();	
				}else{
					$("#listMoreTd").remove();	
				}
				
				var html = "";
				if(returnList.length > 0){
					
					//건수
					$("#companyListCnt").text(addComma(String(total_cnt)) + " 건");
					
					$.each(returnList, function(key, value){
						
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
											'<button type="button" class="btn btn-info btn-xs float-left" style="width: 50px; margin-right: 5px;" onclick="javascript:getCompanyInfo(\'' + value.company_no + '\');">' +
											'	정보' +
											'</button>' +
										'</td>'	 +
									'</tr>';
					});
					
					if(returnList.length == 10){
						html += '<td id="listMoreTd" colspan="9">' +
									'<button type="button" class="btn btn-default btn-xs" style="width: 100%; margin-right: 5px;" onClick="javascript:getCompanyList(\'' + (startNum + 10) + '\')">더보기</button>' +
								'</td>';	
					}
				}else{
					if(start_num == undefined || start_num != 0){
						html += '<tr>' +  
									'<td colspan="9" style="text-align:center;">조회된 데이터가 없습니다.</td>' +
								'</tr>';
					}
				}
				
				$("#companyTb").append(html);
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//업체 정보
function getCompanyInfo(company_no){
	
	var paramData = {
						company_no: company_no
						}
	
	resultAjaxAccess("getCompanyInfo.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var companyInfo = results.companyInfo;
					
				var company_nm = companyInfo[0].company_nm;	
				if(companyInfo.length > 0){
					$.each(companyInfo, function(key, value){
						
						var company_type = value.company_type;
						if(company_type == "1"){
							company_type = "제조";
						}else{
							company_type = "외주";
						}
						
						var tax = value.business_tax;
						if(tax == "1"){
							tax = "일반과세자";
						}else if(tax == "2"){
							tax = "간이과세자";
						}else if(tax == "3"){
							tax = "면세과세자";
						}
						
						$("#companyNoSp").text(value.company_no);
						
						$("#companyTypeRegSel").val(value.company_type);
						$("#companyNoIp").val(value.company_no);
						$("#companyNmIp").val(value.company_nm);
						$("#ceoNmIp").val(value.ceo_nm);
						$("#businessNoIp").val("( " + tax + " )" + value.business_no);
						$("#telephoneIp").val(value.telephone);
						$("#emailIp").val(value.email);
						$("#typeIp").val(company_type);
						$("#addressIp").val(value.address);
						$("#bankNmIp").val(value.bank_nm);
						$("#bankNoIp").val(value.bank_no);
						$("#bankAccountHolderIp").val(value.bank_account_holder);
						$("#bankDepositIp").val(addComma(value.bank_deposit));
						$("#createDtIp").val(value.create_dt);
					});
					
					getEmployeeList(company_no, company_nm);
					getCompanyFileList(company_no);
				}
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//직원 조회
function getEmployeeList(company_no, company_nm){
	
	var paramData = {
						company_no: company_no
						}
	
	resultAjaxAccess("getEmployeeList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				//목록 초기화
				$("#employeeTb").empty();
				
				var html = "";
				if(returnList.length > 0){
					
					//건수
					$("#employeeListCnt").text(returnList.length + " 건");
					
					$.each(returnList, function(key, value){
						
						html += '<tr>' +
										'<td><span class="bs-stepper-circle">' + (key + 1) +'</span></td>' +
										'<td>' + company_nm + '</td>' +
										'<td>' + value.employee_nm + '</td>' +
										'<td>' + value.charge + '</td>' +
										'<td>' + value.telephone + '</td>' +
										'<td>' + value.email + '</td>' +
									'</tr>';
					});
				}else{
					html += '<tr>' +  
								'<td colspan="7" style="text-align:center;">조회된 데이터가 없습니다.</td>' +
							'</tr>';
				}
				
				$("#employeeTb").append(html);
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//문서 조회
function getCompanyFileList(company_no){
	
	var paramData = {
						company_no: company_no
						}
	
	resultAjaxAccess("getCompanyFileList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				var file_path = "http://" + ip + ":" + port + "/업체/" + company_no + "/";
				
				$("#businessFileImg").attr("src", "assets/img/sample/nodoc.png");
				$("#bankFileImg").attr("src", "assets/img/sample/nodoc.png");
				$("#dealFileImg").attr("src", "assets/img/sample/nodoc.png");
				
				var html = "";
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
						
						if(value.file_type == "1"){
							$("#businessFileImg").attr("src", file_path + value.file_nm);
						}else if(value.file_type == "2"){
							$("#bankFileImg").attr("src", file_path + value.file_nm);
						}else if(value.file_type == "3"){
							$("#dealFileImg").attr("src", file_path + value.file_nm);
						} 
					});
				}else{
					
				}
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//업체 파일 다운로드
function getCompanyFileDownload(){
	
	resultAjaxAccess("getCompanyFileDownload.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				window.open("http://" + ip + ":" + port + "/" + results.url);
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}