$(function() {
    
    var pieChartCanvas = $('#customerDBRankChart').get(0).getContext('2d')
    var pieData = {
        labels: ['VVIP', 'VIP', 'Family', '첫주문'],
        datasets: [{
            data: [700, 500, 400, 600],
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
    
    var pieChartCanvas = $('#customerDBOrderChart').get(0).getContext('2d')
    var pieData = {
        labels: ['VVIP', 'VIP', 'Family', '첫주문'],
        datasets: [{
            data: [700, 500, 400, 600],
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
    
    /* ChartJS
     * -------
     * Here we will create a few charts using ChartJS
     */

    //--------------
    //- AREA CHART -
    //--------------

    // Get context with jQuery - using jQuery's .get() method.


    var chartData = {
      labels  : ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
      datasets: [
        {
          label               : '고객 주문수',
          backgroundColor     : '#28a745',
          borderColor         : '#28a745',
          pointRadius         : false,
          type				  : 'bar',
          order				  : 1,
          borderColor		  : '#28a745',
    	  backgroundColor     : '#28a745',
    	  barThickness 		  : 50,
          data                : [90, 100, 150, 90, 225, 130, 170]
        },
      ]
    }

    //-------------
    //- BAR CHART -
    //--------------
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
    })
})
