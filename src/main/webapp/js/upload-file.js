$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
	    success: function (e, data) {
	    	var obj = JSON.parse(e);
	    	console.log(obj["filePath"]);
	    	$("#image-uploaded").attr("src", obj["filePath"]);
	    },
	    error: function (e, data) {
	    	console.log(e);
	    	console.log(data);
	    }
    });
    
    $('#fileupload-ajax-s3').fileupload({
    	dataType: 'json',
    	success: function (e, data) {
    		var obj = JSON.parse(e);
    		console.log(obj["filePath"]);
    		$("#image-uploaded-to-s3").attr("src", obj["filePath"]);
    	},
    	error: function (e, data) {
    		console.log(e);
    		console.log(data);
    	}
    });
});