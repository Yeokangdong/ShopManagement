//시작함수
$(document).ready(function() {
	
	getCompanyNoList();
	
});

//초기화
function initTxt(){
	companyNo = "";
	$("#employeeNmIp").val("");
	$("#employeeChargeIp").val("");
	$("#employeeTeleponeIp").val("");
	$("#employeeEmailIp").val("");
}

//업체 목록
function getCompanyNoList(){
	
	resultAjaxAccess("getCompanyNoList.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
						
				//목록 초기화
				$("#companyNmSel").empty();
					
				if(returnList.length > 0){
					$.each(returnList, function(key, value){
						$("#companyNmSel").append('<option value="' + value.company_no + '">' + value.company_nm + '</option>')
					});
					
					getEmployeeList();
				}
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//직원 등록
function setEmployeeReg(){
	
	var paramData = {
						company_no: $("#companyNmSel option:selected").val(),
						employee_nm: $("#employeeNmIp").val()?$("#employeeNmIp").val():"", 
						charge: $("#employeeChargeIp").val()?$("#employeeChargeIp").val():"",
						telephone: $("#employeeTeleponeIp").val()?$("#employeeTeleponeIp").val():"", 
						email: $("#employeeEmailIp").val()?$("#employeeEmailIp").val():""
						}
	
	resultAjaxAccess("setEmployeeReg.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("저장되었습니다.");
				
				initTxt();
				getEmployeeList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//업체 수정
function setEmployeeModify(){
	
	var employee_no = $("#employeeNoSp").text();
	
	if(employee_no == undefined || employee_no == ""){
		infoShow("직원을 선택하십시오.");
		
		return;
	}
	
	var paramData = {
						employee_no: employee_no,
						company_no: $("#companyNmSel option:selected").val(),
						employee_nm: $("#employeeNmIp").val()?$("#employeeNmIp").val():"", 
						charge: $("#employeeChargeIp").val()?$("#employeeChargeIp").val():"",
						telephone: $("#employeeTeleponeIp").val()?$("#employeeTeleponeIp").val():"", 
						email: $("#employeeEmailIp").val()?$("#employeeEmailIp").val():""
						}
	
	resultAjaxAccess("setEmployeeModify.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				
				infoShow("저장되었습니다.");
				
				getEmployeeList();
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//직원 삭제
function setEmployeeDelete(employee_no){
	
	//확인
	if(confirm("정말 삭제하시겠습니까?") == true){   
		if(employee_no == undefined || employee_no == ""){
			infoShow("직원을 선택하십시오.");
			
			return;
		}
		
		var paramData = {
							employee_no: employee_no
							}
		
		resultAjaxAccess("setEmployeeDelete.do", paramData).done(function (results){
			if(results != null){
				if(results.message == "success"){
					
					infoShow("삭제 되었습니다.");
					
					getEmployeeList();
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

//직원 조회
function getEmployeeList(){
	
	var paramData = {
						company_no: $("#companyNmSel option:selected").val()
						}
	
	resultAjaxAccess("getEmployeeList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				//목록 초기화
				$("#employeeTb").empty();
					
				//건수
				$("#employeeListCnt").text(addComma(String(returnList.length)) + " 건");
				
				var html = "";
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
						
						html += '<tr>' +
										'<td><span class="bs-stepper-circle">' + (key + 1) +'</span></td>' +
										'<td>' + $("#companyNmSel option:selected").text() + '</td>' +
										'<td>' + value.employee_nm + '</td>' +
										'<td>' + value.charge + '</td>' +
										'<td>' + value.telephone + '</td>' +
										'<td>' + value.email + '</td>' +
										'<td>' +
											'<button type="button" class="btn btn-info btn-xs float-left" style="width: 50px; margin-right: 5px;" onclick="javascript:getEmployeeInfo(\'' + value.employee_no + '\');">' +
											'	정보' +
											'</button>' +
											'<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;" onclick="javascript:setEmployeeDelete(\'' + value.employee_no + '\');">' +
											'	삭제' +
											'</button>' +
										'</td>'	 +
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

//직원 정보
function getEmployeeInfo(employee_no){
	
	var paramData = {
						employee_no: employee_no
						}
	
	resultAjaxAccess("getEmployeeInfo.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var employeeInfo = results.employeeInfo;
					
				if(employeeInfo.length > 0){
					$.each(employeeInfo, function(key, value){
						
						$("#companyNoSp").text(value.company_no);
						$("#employeeNoSp").text(value.employee_no);
						
						$("#employeeNmIp").val(value.employee_nm);
						$("#employeeChargeIp").val(value.charge);
						$("#employeeTeleponeIp").val(value.telephone);
						$("#employeeEmailIp").val(value.email);
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