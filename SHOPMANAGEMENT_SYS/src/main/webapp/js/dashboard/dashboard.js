$(document).ready( function () {
	
	getNewOrderCnt();
	getReadyDeliveryCnt();
	getDeliveryCnt();
	getDeliveryCompleteCnt();
	getOrderCancelCnt();
	getCustomerDBCnt();
	getMakeCompanyCnt();
	getOutsourcingCompanyCnt();
});

//신규 주문
function getNewOrderCnt(){
	
	resultAjaxAccess("getNewOrderCnt.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
					
						//건수
						$("#newOrderSp").text(addComma(value.new_order_cnt) + " 건");
					});
				}else{
					$("#newOrderSp").text("0 건");
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//배송준비
function getReadyDeliveryCnt(){
	
	resultAjaxAccess("getReadyDeliveryCnt.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
					
						//건수
						$("#readyDeliverySp").text(addComma(value.ready_delivery_cnt) + " 건");
					});
				}else{
				
					$("#readyDeliverySp").text("0 건");
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//배송중
function getDeliveryCnt(){
	
	resultAjaxAccess("getDeliveryCnt.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
					
						//건수
						$("#deliverySp").text(addComma(value.delivery_cnt) + " 건");
					});
				}else{
				
					$("#deliverySp").text("0 건");
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//배송완료
function getDeliveryCompleteCnt(){
	
	resultAjaxAccess("getDeliveryCompleteCnt.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
					
						//건수
						$("#deliveryCompleteSp").text(addComma(value.delivery_complete_cnt) + " 건");
					});
				}else{
				
					$("#deliveryCompleteSp").text("0 건");
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//취소
function getOrderCancelCnt(){
	
	resultAjaxAccess("getOrderCancelCnt.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
					
						//건수
						$("#orderCancelSp").text(addComma(value.order_cancel_cnt) + " 건");
					});
				}else{
				
					$("#orderCancelSp").text("0 건");
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//제조
function getMakeCompanyCnt(){
	
	resultAjaxAccess("getMakeCompanyCnt.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
					
						//건수
						$("#makeCompanyCntSp").text(addComma(value.make_company_cnt) + " 건");
					});
				}else{
				
					$("#makeCompanyCntSp").text("0 건");
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//외주
function getOutsourcingCompanyCnt(){
	
	resultAjaxAccess("getOutsourcingCompanyCnt.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
					
						//건수
						$("#outsourcingCompanySp").text(addComma(value.outsourcing_company_cnt) + " 건");
					});
				}else{
				
					$("#outsourcingCompanySp").text("0 건");
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

//고객
function getCustomerDBCnt(){
	
	resultAjaxAccess("getCustomerDBCnt.do").done(function (results){
		if(results != null){
			if(results.message == "success"){
				var returnList = results.returnList;
				
				if(returnList.length > 0){
					
					$.each(returnList, function(key, value){
					
						//건수
						$("#customerDBSp").text(addComma(value.order_customerdb_cnt) + " 건");
					});
				}else{
				
					$("#customerDBSp").text("0 건");
				}
				
			}else{
				errorShow(results.error);
			}
		}else{
			errorShow(results.error);
		}
	});
}

$(function () {
    /* ChartJS
     * -------
     * Here we will create a few charts using ChartJS
     */

    //--------------
    //- AREA CHART -
    //--------------

    // Get context with jQuery - using jQuery's .get() method.


    var salesLineChartData = {
      labels  : ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
      datasets: [
        {
          label               : '총 매출',
          backgroundColor     : '#ff0000',
          borderColor         : '#ff0000',
          pointRadius         : false,
          type				  : 'line',
          order				  : 0,
          pointColor          : '#3b8bba',
          pointStrokeColor    : '#ff0000',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: '#ff0000',
          data                : [500, 800, 100, 1560, 1800, 2000, 2200]
        },
        {
          label               : '총 순익',
          backgroundColor     : '#ffffff',
          borderColor         : '#ffffff',
          pointRadius         : false,
          type				  : 'line',
          order				  : 0,
          pointColor          : '#ffffff',
          pointStrokeColor    : '#c1c7d1',
          pointHighlightFill  : '#ffffff',
          pointHighlightStroke: '#ffffff',
          data                : [200, 220, 300, 800, 1000, 1500, 1700]
        },
      ]
    }
    
    var orderBarChartData = {
      labels  : ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
      datasets: [
        {
          label               : '주문(월)',
          backgroundColor     : '#28a745',
          borderColor         : '#28a745',
          pointRadius         : false,
          type				  : 'bar',
          order				  : 1,
          borderColor		  : '#28a745',
    	  backgroundColor     : '#28a745',
    	  barThickness 		  : 25,
          data                : [120, 330, 220, 330, 500, 600, 380]
        },
      ]
    }
    
    var salesBarChartData = {
      labels  : ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
      datasets: [
        {
          label               : '매출(월)',
          backgroundColor     : '#ffc107',
          borderColor         : '#ffc107',
          pointRadius         : false,
          type				  : 'bar',
          order				  : 1,
          borderColor		  : '#ffc107',
    	  backgroundColor     : '#ffc107',
    	  barThickness 		  : 25,
          data                : [120, 330, 220, 330, 500, 600, 380]
        },
      ]
    }
    
    var profitBarChartData = {
      labels  : ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
      datasets: [
        {
          label               : '순익(월)',
          backgroundColor     : '#17a2b8',
          borderColor         : '#17a2b8',
          pointRadius         : false,
          type				  : 'bar',
          order				  : 1,
          borderColor		  : '#17a2b8',
    	  backgroundColor     : '#17a2b8',
    	  barThickness 		  : 25,
          data                : [120, 330, 220, 330, 500, 600, 380]
        },
      ]
    }

    //-------------
    //- LINE CHART -
    //--------------
    var salesLineChart = $('#salesLineChart').get(0).getContext('2d')
    var salesLineChart = $.extend(true, {}, salesLineChart)
    salesLineChartData.datasets[0].fill = false;
    salesLineChartData.datasets[1].fill = false;

    var salesLineChart = new Chart(salesLineChart, {
      type: 'line',
      data: salesLineChartData,
      options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
    })
        
    //-------------
    //- BAR CHART -
    //--------------
    var orderBarChart = $('#orderBarChart').get(0).getContext('2d')
    var orderBarChart = $.extend(true, {}, orderBarChart)
    orderBarChartData.datasets[0].fill = false;

    var orderBarChart = new Chart(orderBarChart, {
      type: 'bar',
      data: orderBarChartData,
      options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
    })
    
        
    //-------------
    //- BAR CHART -
    //--------------
    var salesBarChart = $('#salesBarChart').get(0).getContext('2d')
    var salesBarChart = $.extend(true, {}, salesBarChart)
    salesBarChartData.datasets[0].fill = false;

    var salesBarChart = new Chart(salesBarChart, {
      type: 'bar',
      data: salesBarChartData,
      options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
    })
    
        
    //-------------
    //- BAR CHART -
    //--------------
    var profitBarChart = $('#profitBarChart').get(0).getContext('2d')
    var profitBarChart = $.extend(true, {}, profitBarChart)
    profitBarChartData.datasets[0].fill = false;

    var profitBarChart = new Chart(profitBarChart, {
      type: 'bar',
      data: profitBarChartData,
      options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
    })
})