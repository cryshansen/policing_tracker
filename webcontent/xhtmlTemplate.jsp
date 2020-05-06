<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<f:view>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:t="http://myfaces.apache.org/tomahawk">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<base href="${pageContext.request.contextPath}/" />   
	<title>JSP with xhtml markup</title>
</head>
<body>

	<h:form>

		<t:inputDate id="date1" value="#{date1}" popupCalendar="true"></t:inputDate>

	</h:form>
	
</body>
</html>
</f:view>
