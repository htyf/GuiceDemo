<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>dwr - test (www.imxylz.cn)</title>
<script type='text/javascript'
	src='/guice-dwr/dwr/interface/helloworld.js'></script>
<script type='text/javascript' src='/guice-dwr/dwr/engine.js'></script>
<script type='text/javascript' src='/guice-dwr/dwr/util.js'></script>
<script type='text/javascript'>
	var showHello = function(data) {
		dwr.util.setValue('result', dwr.util.toDescriptiveString(data, 1));
	}
	var getSystemDate = function(data) {
		dwr.util.setValue('systime', dwr.util.toDescriptiveString(data, 2));
	}
</script>
<style type='text/css'>
input.button {
	border: 1px outset;
	margin: 0px;
	padding: 0px;
}

span {
	background: #ffffdd;
	white-space: pre;
	padding-left: 20px;
}
</style>
</head>
<body onload='dwr.util.useLoadingMessage()'>
	<p>
	<h2>Guice and DWR</h2>
	<input class='button' type='button'
		value="Call HelloWorld 'sayHello' service"
		onclick="helloworld.sayHello(showHello)" />
	<span id='result'></span>
	</p>
	<p>
		<input class='button' type='button'
			value="Call HelloWorld 'getSystemDate' service"
			onclick="helloworld.getSystemDate(getSystemDate)" /> <span
			id='systime'></span>
	</P>
</body>
</html>
