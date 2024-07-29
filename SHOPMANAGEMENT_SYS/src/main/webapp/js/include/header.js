$(document).ready(function() {

	$('#reservation').daterangepicker()
	//Date range picker with time picker
	$('#reservationtime').daterangepicker({
  		timePicker: true,
  		timePickerIncrement: 30,
  		locale: {
    		format: "YYYY/MM/DD hh:mm A"
  		}
	})
	
	//Date range as a button
	$('#daterange-btn').daterangepicker(
  	{
    	ranges   : {
	      'Today'       : [moment(), moment()],
	      'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
	      'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
	      'Last 30 Days': [moment().subtract(29, 'days'), moment()],
	      'This Month'  : [moment().startOf('month'), moment().endOf('month')],
	      'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
    	},
    	startDate: moment().subtract(29, 'days'),
    	endDate  : moment()
  	},
  	
  	function (start, end) {
    	/*$('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))*/
    	$('#reportrange span').html(start.format('YYYY, MMMM D') + ' - ' + end.format('YYYY, MMMM D'))
  	}
	)
});

$(document).ready(function() {
	const searchParams = new URLSearchParams(location.search);
    for (const param of searchParams) {
    	if(param[1] != undefined && param[1] != "undefined"){
			
    		switch(param[1]){
				case "settings":
					$("#pageSettings").addClass("active");
					$("#vert-tabs-home-tab").addClass("active");
					break;
				case "product":
					$("#pageProductTop").addClass("active");
					$("#pageProduct").addClass("active");
					break;
				case "productReg":
					$("#pageProductTop").addClass("active");
					$("#pageProductReg").addClass("active");
					break;
				case "company":
					$("#pageCompanyTop").addClass("active");
					$("#pageCompany").addClass("active");
					break;
				case "companyReg":
					$("#pageCompanyTop").addClass("active");
					$("#pageCompanyReg").addClass("active");
					break;
				case "employeeReg":
					$("#pageCompanyTop").addClass("active");
					$("#pageEmployeeReg").addClass("active");
					break;
				case "order1Reg":
					$("#pageOrderTop").addClass("active");
					$("#pageOrder1Reg").addClass("active");
					break;
				case "order2Reg":
					$("#pageOrderTop").addClass("active");
					$("#pageOrder2Reg").addClass("active");
					break;
				case "orderHis":
					$("#pageOrderHisTop").addClass("active");
					$("#pageOrderHis").addClass("active");
					break;
				case "orderComplete":
					$("#pageOrderHisTop").addClass("active");
					$("#pageOrderComplete").addClass("active");
					break;
				case "orderCancel":
					$("#pageOrderHisTop").addClass("active");
					$("#pageOrderCancel").addClass("active");
					break;	
				case "deliveryTracking":
					$("#pageDeliveryTracking").addClass("active");
					break;	;	
				case "customerDB":
					$("#pageCustomerDB").addClass("active");
					break;		
			}
		}
	}
});

//시작함수
$(document).ready(function() {
	resultAjaxAccess("getSystemInfo.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var systemInfo = results.systemInfo;
				
				if(systemInfo.length > 0){
					
					$.each(systemInfo, function(key, value){
						
						//설정 로고
						$("#logoImg").attr("src", "http://" + ip + ":" + port + "/계정/" + value.logo);
						
						//메뉴 로고
						$("#topLogoImg").attr("src", "http://" + ip + ":" + port + "/계정/" + value.logo);
						
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
});

//사이드바 무빙
function sidebarSize(){
	if($("body").hasClass("sidebar-collapse") == true){
		$("body").removeClass("sidebar-collapse");	
	}else{
		$("body").addClass("sidebar-collapse");	
	}
}

//카달로그 페이지로 이동
function pageCadalog(){
	window.open("pageCadalog.do");
}

//홈텍스로 이동
function moveHomtex(){
	window.open("https://www.hometax.go.kr/websquare/websquare.html?w2xPath=/ui/pp/index_pp.xml");
}

//종합정보 페이지로 이동
function pageDashboard(){
	window.location.replace("pageDashboard.do");
}

//로그아웃
function logout() {
	$.ajax({
			type: "POST",
	        /* java loginCheck 클래스로 로그인 시도 */
			url: "logout.do",
			beforeSend : function(xhr){
				xhr.setRequestHeader("AJAX", "true"); 
				xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			},
			
			success: function(msg, textStatus, xhr) {
				
			},
			error:function(request, status, error){
				alert("code:" + request.status + "\n" + "error:" + error);
			}
		});
		return false;
}