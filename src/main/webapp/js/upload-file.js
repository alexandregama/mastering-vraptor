$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
        done: function (e, data) {
        	alert("Its working!");
            $.each(data.result.files, function (index, file) {
                $('<p/>').text(file.name).appendTo(document.body);
            });
        },
	    success: function (e, data) {
	    	alert("Its working!");
	    	$.each(data.result.files, function (index, file) {
	    		$('<p/>').text(file.name).appendTo(document.body);
	    	});
	    },
	    error: function (e, data) {
	    	alert("An error occured after response");
	    	console.log(e);
	    	console.log(data);
	    }
    });
});