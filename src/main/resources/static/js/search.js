var BASE_URL = "http://localhost:8080/search/";

function search(){
	var searchKeywords = document.getElementById("searchContent").value;
	var finalUrl  = BASE_URL + searchKeywords;
	$.ajax({
        url: finalUrl,
        cache: false,
        success: function (searchResult) {
            if(searchResult === undefined || searchResult == null || searchResult.length == 0){
            	$('#emptyMessage').innerHTML = "No results matched your search.";
            } else {
            	$('h3').html("Search Result:");
            	$('#searchResults').html("");
	            $.each(searchResult, function(index, data){
	                $('#searchResults').append("<ul>\""+data.content+"\" by " + data.user.userName + "</ul>");
	            });
            }
        },
        error: function() {
            alert("Cannot search for empty string!");
            return false;
        }
    });
}