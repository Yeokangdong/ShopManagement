/**
 * 계정 
 * 
 */


//시작함수
$(document).ready(function() {
	
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