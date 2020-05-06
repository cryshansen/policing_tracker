<?xml version="1.0" ?>
<jsp:root  
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> ]]>
	</jsp:text>
	<f:view>
		<html xmlns="http://www.w3.org/1999/xhtml"
			xmlns:jsp="http://java.sun.com/JSP/Page"
			xmlns:f="http://java.sun.com/jsf/core"
			xmlns:h="http://java.sun.com/jsf/html"
			xmlns:t="http://myfaces.apache.org/tomahawk">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
			<title>Tomahawk Date control</title>
		</head>
		<body>
		
			<h:form>
				<t:inputDate id="date1" value="#{date1}" popupCalendar="true"></t:inputDate>
			</h:form>
			
		</body>
		</html>
	</f:view>
</jsp:root>