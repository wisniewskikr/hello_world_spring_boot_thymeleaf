$(function() {
	$( document ).tooltip();
});

function onLanguageChange(selectedObject) {
	var oldAction = selectedObject.form.action;
	var newAction = oldAction.replace("handle-button-ok", "handle-language-change");
	selectedObject.form.action = newAction;
	selectedObject.form.submit();
}