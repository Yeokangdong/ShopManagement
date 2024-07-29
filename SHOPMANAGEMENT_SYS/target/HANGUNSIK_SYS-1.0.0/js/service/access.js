//ajax return
function resultAjaxAccess(method, param){
	return $.ajax({
        type: "POST",
        dataType: "json",
        url: method,
        data: param,
        success: function (data, textStatus, jqXHR) {
        	//console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
        	//console.log(textStatus);
        }
    });
}

//ajax return
function resultFormAccess(method, param){
	return $.ajax({
        type: "POST",
        dataType: "multipart/form-data",
        url: method,
        data: param,
        success: function (data, textStatus, jqXHR) {
        	//console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
        	//console.log(textStatus);
        }
    });
}

//ajax Array return
function resultAjaxArrAccess(method, param){
	return $.ajax({
        type: "POST",
        dataType: "json",
        url: method,
        data: param,
        contentType: "application/json",
        success: function (data, textStatus, jqXHR) {
        	//console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
        	//console.log(textStatus);
        }
    });
}

//ajax file return
function resultAjaxFileAccess(method, param){
	return $.ajax({                          
        type: "POST",
        dataType: "json",
        url: method,
        data: param,
        acync: true,
		processData: false,
		contentType: false,
		xhr: function(){
			var xhr = $.ajaxSettings.xhr();
			xhr.upload.onprogress = function(e){
				var per = (e.loaded * 100 / e.total).toFixed(1);
				$("#loadingPerTxt").text(per + "%");
			};
			return xhr;
		},
		success: function (data, textStatus, jqXHR) {
        	//console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
        	//console.log(textStatus);
        }
    });
}