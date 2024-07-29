$(document).ready( function () {
	
	getCustomerDBList();
});

//고객 조회
function getCustomerDBList(start_num){
	
	let startNum = 0;
	if(start_num != undefined){
		startNum = Number(start_num);	
	}else{
		startNum = 0;
	}
	
	var paramData = {
						search_type: $("#searchTypeSel option:selected").val(),
						search_txt: $("#searchTxtIp").val(),
						rank_type: $("#rankTypeSel option:selected").val(),
						start_num: startNum
						}
	
	var returnList;

	resultAjaxAccess("getCustomerDBList.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnTotalCnt = results.returnTotalCnt;
				returnList = results.returnList;
				
				var total_cnt = returnTotalCnt[0].total_cnt;
				
				//목록 초기화
				if(startNum == 0){
					$("#customerDBTb").empty();	
				}else{
					$("#listMoreTd").remove();	
				}
					
				//건수
				$("#customDBListCnt").text(addComma(String(total_cnt)) + " 건");
				
				var html = "";
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
					
						var rank = "";
						if(value.order_cnt == 1){
							rank = "첫주문";
						}else if(value.order_cnt > 1 && value.order_cnt <= 5){
							rank = "Family";
						}else if(value.order_cnt > 5 && value.order_cnt <= 10){
							rank = "VIP";
						}else if(value.order_cnt > 10){
							rank = "VVIP";
						}
						
						html += '<tr>' +
									'<td style="width: 30px;"><input id="orderChk" name="' + value.customer_no + '" type="checkbox" class="check-group" style="width: 15px; height: 15px;" checked="checked"></td>' +
									'<td>' + value.customer_nm + '</td>' +
									'<td>' + value.telephone + '</td>' +
									'<td>매실</td>' +
									'<td>' + value.order_cnt + '</td>' +
									'<td>0</td>' +
									'<td>' + value.last_order_dt + '</td>' +
									'<td>' + rank + '</td>' +
									'<td>' +
										'<button type="button" class="btn btn-info btn-xs float-left" style="width: 50px; margin-right: 5px;" onClick="javascript:getCustomerDBInfo(\'' + value.customer_nm + '\');">' +
										'	정보' +
										'</button>' +
									'</td>' +	
								'</tr>';
					});
					
					if(returnList.length == 10){
						html += '<td id="listMoreTd" colspan="9">' +
									'<button type="button" class="btn btn-default btn-xs" style="width: 100%; margin-right: 5px;" onClick="javascript:getCustomerDBList(\'' + (startNum + 10) + '\')">더보기</button>' +
								'</td>';	
					}
				}else{
					if(start_num == undefined || start_num != 0){
						html += '<tr>' +  
									'<td colspan="9" style="text-align:center;">조회된 데이터가 없습니다.</td>' +
								'</tr>';
					}
				}
				
				$("#customerDBTb").append(html);
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
		
		getCustomerDBProductChart();
		getCustomerDBRankChart();
		getCustomerDBCntChart();
	});
}

//고객 정보
function getCustomerDBInfo(customer_nm){
	
	var paramData = {
						customer_nm: customer_nm
						}
	
	resultAjaxAccess("getCustomerDBInfo.do", paramData).done(function (results){
		if(results != null){
			if(results.message == "success"){
				var customerDBInfo = results.customerDBInfo;
				
				if(customerDBInfo.length > 0){
					$.each(customerDBInfo, function(key, value){
						
						//등급
						var rank = "";
						if(value.order_cnt == 1){
							$("#rankSp").text("첫주문");
						}else if(value.order_cnt > 1 && value.order_cnt <= 5){
							$("#rankSp").text("Family");
						}else if(value.order_cnt > 5 && value.order_cnt <= 10){
							$("#rankSp").text("VIP");
						}else if(value.order_cnt > 10){
							$("#rankSp").text("VVIP");
						}
						
						$("#customerNmIp").val(value.customer_nm);
						$("#telephoneIp").val(value.telephone);
						$("#totalOrderAmountIp").val("");
						$("#orderProductIp").val("");
						$("#telephoneIp").val(value.telephone);
						$("#LastOrderDtIp").val(value.last_order_dt);
						$("#orderCntIp").val(value.order_cnt);
						$("#returnProductIp").val("");
						$("#changeProductIp").val("");
						$("#cancelProductIp").val("");
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

//품목 차트
function getCustomerDBProductChart(){
	
	resultAjaxAccess("getCustomerDBProductChart.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
					
				if(returnList.length > 0){
					$.each(returnList, function(key, value){
						
						
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

//등급 차트
function getCustomerDBRankChart(){
	
	resultAjaxAccess("getCustomerDBRankChart.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
					
				if(returnList.length > 0){
						
					var rankFirst = 0;
					var rankFamily = 0;
					var rankVIP = 0;
					var rankVVIP = 0;
					
					$.each(returnList, function(key, value){
					  		
						rankFirst += parseInt(value.rankFirst);
						rankFamily += parseInt(value.rankFamily);
						rankVIP += parseInt(value.rankVIP);
						rankVVIP += parseInt(value.rankVVIP);
					});
					
					var pieChartCanvas = $('#customerDBRankChart').get(0).getContext('2d')
				    var pieData = {
				        labels: ['첫주문', 'Family', 'VIP', 'VVIP'],
				        datasets: [{
				            data: [rankFirst, rankFamily, rankVIP, rankVVIP],
				            backgroundColor: ['#f56954', '#00a65a', '#f39c12', '#00c0ef']
				        }]
				    }
				    var pieOptions = {
				        legend: {
				            display: false
				        }
				    }
				    var pieChart = new Chart(pieChartCanvas,{
				        type: 'doughnut',
				        data: pieData,
				        options: pieOptions
				    })
				}
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//전체 고객수 차트
function getCustomerDBCntChart(){
	
	resultAjaxAccess("getCustomerDBCntChart.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;	
					
				if(returnList.length > 0){
						
					var dateArr = [];
					var cntArr = [];
					
					$.each(returnList, function(key, value){
						dateArr.push(value.date);
						cntArr.push(value.cnt);
					});
					  		
				 	var chartData = {
						labels  : dateArr,
						datasets: [{
							          label               : '고객 주문수',
							          backgroundColor     : '#28a745',
							          borderColor         : '#28a745',
							          pointRadius         : false,
							          type				  : 'bar',
							          order				  : 1,
							          borderColor		  : '#28a745',
							    	  backgroundColor     : '#28a745',
							    	  barThickness 		  : 50,
							          data                : cntArr
								},
						]}
							    
						var sellChart = $('#sellChart').get(0).getContext('2d')
						var sellChartData = $.extend(true, {}, chartData)
						sellChartData.datasets[0].fill = false;

						var sellChart = new Chart(sellChart, {
  							type: 'bar',
  							data: sellChartData,
  							options: {
  									scales: {
						    				y: {
						      					beginAtZero: true
						    					}
  											}
									}
						});
			}
		}
	}});
}

//목록 전체 선택/해제
function orderChkList(){
	
	if($("#customerChk").is(":checked")){
		$("input:checkbox").prop("checked", true);
		$("#customerChk").prop("checked", true);	
	}else{
		$("input:checkbox").prop("checked", false);
		$("#customerChk").prop("checked", false);	
	}	
}
