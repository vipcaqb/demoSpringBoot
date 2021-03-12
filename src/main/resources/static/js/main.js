$(document).ready(function() {
	$("#createForm").submit(function(event) {

		//stop submit the form, we will post it manually.
		event.preventDefault();
		
		$("#name").attr("value","");
		$("#createSubmit").prop("disabled", true);
		fire_ajax_submit();

	});
});
function fire_ajax_submit() {
	var book = {};
	book["name"] = $("#name").val();
	var author = {};
	author["id"] = $("#authorId").val()
	book["author"] = author; 
	//var params = {}
	//params["name"] = $("#name").val();
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/book/create",
		data: JSON.stringify(book),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			var json = JSON.stringify(data, null, 4);
			var dataObject = JSON.parse(json);
			var name = dataObject[0]["name"];
			var id = dataObject[0]["id"];
			var authorName = dataObject[0]["author"]["name"];
			$('#bookList')
			.append("<li>"+id+"</li><li><form action='book/update/"+id+"' method='POST'><input type='text' name='name' value='"+name+"'> <input type='submit' value='Update'></form></li> <li>"+authorName+"</li> <li><a href='/book/delete/"+id+"'>Delete</a></li><hr/>");
			$("#createSubmit").prop("disabled", false);
		},
		error: function(e) {
			
			var json =  e.responseText;
			var msg = JSON.parse(json);
            $('#nameErr').html(msg['msg']);
			console.log("ERROR zzzz: " + e.responseText);

		}
	});

}