var BASE_URL = "http://localhost:8080/search/";

function search(){
	var searchKeywords = document.getElementById("searchContent").value;
	if(searchKeywords === undefined || searchKeywords == null || searchKeywords.length == 0){
		$('h3').html("");
		$('#searchResults').html("");
		$('#emptyMessage').html("");
        alert("Cannot search for empty string!");
        return false;
	}
	var finalUrl  = BASE_URL + searchKeywords;
	$.ajax({
        url: finalUrl,
        cache: false,
        success: function (searchResult) {
        	$('h3').html("Search Result:");
            if(searchResult === undefined || searchResult == null || searchResult.length == 0){
            	$('#emptyMessage').html("No results matched your search.");
            } else {
            	$('#emptyMessage').html("");
            	$('#searchResults').html("");
	            $.each(searchResult, function(index, data){
	                $('#searchResults').append("<ul>\""+data.content+"\" by " + data.user.userName + "</ul>");
	            });
            }
        },
        error: function() {
        	$('h3').html("");
    		$('#searchResults').html("");
    		$('#emptyMessage').html("");
            alert("Internal error! Check that your search string is not empty!");
            return false;
        }
    });
}