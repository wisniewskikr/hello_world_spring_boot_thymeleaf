$(function() {
	$( document ).tooltip();
});

$(document).on('submit','#inputForm',function(e){
	$("body").addClass("loading"); 
});