/**
 * 
 */

window.addEventListener('load', function() {
	var queryString = null;
	queryString = location.search;
	console.log(queryString);

	if (queryString == '?faild') {
		document.getElementById('miss').classList.remove('none');

	}
});