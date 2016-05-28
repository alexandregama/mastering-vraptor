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
});