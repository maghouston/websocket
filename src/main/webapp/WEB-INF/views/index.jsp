<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BORAJI.COM</title>

	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
	
<script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.js"
	th:src="@{/webjars/jquery/2.1.4/jquery.min.js}" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<link
	href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.5/css/bootstrap.min.css"
	th:href="@{/webjars/bootstrap/3.3.5/css/bootstrap.min.css}"
	rel="stylesheet" media="screen" />
<link
	href="http://cdn.jsdelivr.net/webjars/jquery-file-upload/9.10.1/jquery.fileupload.css"
	rel="stylesheet" media="screen" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>

<script type="text/javascript">
	var stompClient;

	var socket = new SockJS('/spring-mvc/live-temperature');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		stompClient.subscribe('/topic/temperature', function(temperature) {
			var serverMsg = document.getElementById('serverMsg');
			serverMsg.value = temperature.body;
		});
	});


</script>
</head>
<body>
	<h1>Spring MVC 5 + WebSocket + Hello World example</h1>
	<hr />
	<label>Message</label>
	<br>
	<textarea rows="8" cols="50" id="clientMsg"></textarea>
	<br>
	<button onclick="send()">Send</button>
	<br>
	<label>Response from Server</label>
	<br>
	<textarea rows="8" cols="50" id="serverMsg" readonly="readonly"></textarea>
</body>
</html>