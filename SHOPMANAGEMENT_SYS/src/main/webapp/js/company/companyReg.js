//시작함수
$(document).ready(function() {
	getCompanyList();
});

//초기화
function initTxt(){
	companyNo = "";
	
	$("#companyNoSp").text("");
	$("#companyNmIp").val("");
	$("#ceoNmIp").val("");
	$("#businessNoIp").val("");
	$("#telephoneIp").val("");
	$("#emailIp").val("");
	$("#addressIp").val("");
	$("#bankNmIp").val("");
	$("#bankNoIp").val("");
	$("#bankAccountHolderIp").val("");
	$("#bankDepositIp").val("");
	
	$("#uploadFileDiv").empty();
}

//업체 등록
function setCompanyReg(){
	
	var paramData = {
						company_type: $("#companyTypeRegSel option:selected").val(),
						company_nm: $("#companyNmIp").val()?$("#companyNmIp").val():"", 
						ceo_nm: $("#ceoNmIp").val()?$("#ceoNmIp").val():"", 
						business_tax: $("#businessTaxSel option:selected").val(),
						business_no: $("#businessNoIp").val()?$("#businessNoIp").val():"",
						telephone: $("#telephoneIp").val()?$("#telephoneIp").val():"",
						email: $("#emailIp").val()?$("#emailIp").val():"",
						address: $("#addressIp").val()?$("#addressIp").val():"",
						bank_nm: $("#bankNmIp").val()?$("#bankNmIp").val():"",
						bank_no: $("#bankNoIp").val()?$("#bankNoIp").val():"",
						bank_account_holder: $("#bankAccountHolderIp")?$("#bankAccountHolderIp").val():"",
						bank_deposit: $("#bankDepositIp").val()?$("#bankDepositIp").val().replace(",", ""):0
						}
	
	resultAjaxAccess("setCompanyReg.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("저장되었습니다.");
				
				initTxt();
				getCompanyList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//업체 수정
function setCompanyModify(){
	
	var company_no = $("#companyNoSp").text();
	
	if(company_no == undefined || company_no == ""){
		infoShow("업체를 선택하십시오.");
		
		return;
	}
	
	var paramData = {
						company_no: company_no,
						company_type: $("#companyTypeRegSel option:selected").val(),
						company_nm: $("#companyNmIp").val()?$("#companyNmIp").val():"", 
						ceo_nm: $("#ceoNmIp").val()?$("#ceoNmIp").val():"", 
						business_tax: $("#businessTaxSel option:selected").val(),
						business_no: $("#businessNoIp").val()?$("#businessNoIp").val():"",
						telephone: $("#telephoneIp").val()?$("#telephoneIp").val():"",
						email: $("#emailIp").val()?$("#emailIp").val():"",
						address: $("#addressIp").val()?$("#addressIp").val():"",
						bank_nm: $("#bankNmIp").val()?$("#bankNmIp").val():"",
						bank_no: $("#bankNoIp").val()?$("#bankNoIp").val():"",
						bank_account_holder: $("#bankAccountHolderIp")?$("#bankAccountHolderIp").val():"",
						bank_deposit: $("#bankDepositIp").val()?$("#bankDepositIp").val().replace(",", ""):0
						}
	
	resultAjaxAccess("setCompanyModify.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("저장되었습니다.");
				
				getCompanyList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//업체 삭제
function setCompanyDelete(company_no){
	
	//확인
	if(confirm("정말 삭제하시겠습니까?") == true){   
		if(company_no == undefined || company_no == ""){
			infoShow("업체를 선택하십시오.");
			
			return;
		}
		
		var paramData = {
							company_no: company_no
							}
		
		resultAjaxAccess("setCompanyDelete.do", paramData).done(function (results){
			if(results != null){
				if(results.message == "success"){
					getCompanyList();
					
					infoShow("삭제 되었습니다.");
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
				
				//건수
				$("#companyListCnt").text(addComma(String(total_cnt)) + " 건");
				
				var html = "";
				if(returnList.length > 0){
					
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
											'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onclick="javascript:setCompanyDelete(\'' + value.company_no + '\');">' +
											'	삭제' +
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
					
				if(companyInfo.length > 0){
					$.each(companyInfo, function(key, value){
						
						$("#companyNoSp").text(value.company_no);
						
						$("#companyTypeRegSel").val(value.company_type);
						$("#companyNmIp").val(value.company_nm);
						$("#ceoNmIp").val(value.ceo_nm);
						$("#businessTaxSel").val(value.business_tax);
						$("#businessNoIp").val(value.business_no);
						$("#telephoneIp").val(value.telephone);
						$("#emailIp").val(value.email);
						$("#addressIp").val(value.address);
						$("#bankNmIp").val(value.bank_nm);
						$("#bankNoIp").val(value.bank_no);
						$("#bankAccountHolderIp").val(value.bank_account_holder);
						$("#bankDepositIp").val(addComma(value.bank_deposit));
					});
					
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
				
				$("#businessDocSp").removeClass("btn-success");
				$("#bankDocSp").removeClass("btn-success");
				$("#dealDocSp").removeClass("btn-success");
				$("#businessDocSp").addClass("btn-danger");
				$("#bankDocSp").addClass("btn-danger");
				$("#dealDocSp").addClass("btn-danger");
				
				var html = "";
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
						
						if(value.file_type == "1"){
							$("#businessDocSp").removeClass("btn-danger");
							$("#businessDocSp").addClass("btn-success");
						}else if(value.file_type == "2"){
							$("#bankDocSp").removeClass("btn-danger");
							$("#bankDocSp").addClass("btn-success");
						}else if(value.file_type == "3"){
							$("#dealDocSp").removeClass("btn-danger");
							$("#dealDocSp").addClass("btn-success");
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

//업체 파일 다이얼로그
var files;
function companyFile(param, evt){
	
	files = evt.files[0];	
	
	if(param == "1"){
		$("#businessFileLb").remove();
		$("#businessFileDiv").append('<label id="businessFileLb" class="custom-file-label" for="customFile">' + files.name + '</label>');	
	}else if(param == "2"){
		$("#bankFileLb").remove();
		$("#bankFileDiv").append('<label id="bankFileLb" class="custom-file-label" for="customFile">' + files.name + '</label>');	
	}else if(param == "3"){
		$("#dealFileLb").remove();
		$("#dealFileDiv").append('<label id="dealFileLb" class="custom-file-label" for="customFile">' + files.name + '</label>');	
	}else if(param == "4"){
		$("#etcFileLb").remove();
		$("#etcFileDiv").append('<label id="etcFileLb" class="custom-file-label" for="customFile">' + files.name + '</label>');	
	}
	
}

//업체 파일 업로드
function setCompanyFileUpload(param){
	
	var company_no = $("#companyNoSp").text();
	
	if(company_no == undefined || company_no == ""){
		infoShow("업체를 선택하십시오.");
		
		return;
	}
	
	if(files == undefined || files == ""){
		infoShow("파일을 선택하십시오.");
		
		return;
	}
	
	if(files.length > 1){
		infoShow("선택한 파일이 많습니다.");
		
		return;
	}
	
	var formData = new FormData();
  	formData.append("files", files);
  	formData.append("company_no", company_no);
  	formData.append("file_type", param);
  	
  	resultAjaxFileAccess("setCompanyFilesReg.do", formData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				infoShow("파일이 등록되었습니다.");
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