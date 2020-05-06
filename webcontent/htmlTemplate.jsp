<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path+"/";
%>

<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<f:view>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<base href="<%=basePath%>" />  
	<title>JSP with html markup</title>
</head>
<body>
	
	<h:form>
		<t:inputDate id="date1" value="#{date1}" popupCalendar="true"></t:inputDate>
	</h:form>
	
</body>
</html>
</f:view>
