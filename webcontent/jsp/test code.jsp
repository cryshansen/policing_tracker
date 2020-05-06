<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h:outputText value="Sales Rep: "></h:outputText>
			
			
dropdown list
 			<h:selectOneMenu value="#{customerQueryBean.employeeNumber}">
				<f:selectItem itemLabel="Select Sales Rep, if any" itemValue=" "/>
				<t:selectItems value="#{customerQueryBean.employeeList}" var="employee" itemLabel="#{employee.lastName}, #{employee.firstName}" itemValue="#{employee.employeeNumber}"></t:selectItems>
			</h:selectOneMenu>
			<h:outputText></h:outputText>
			
			
			
			
			<h:column>
				<f:facet name="header">
					<h:outputText value="First Name"></h:outputText>
				</f:facet>
				<h:outputText value="#{offender.firstName}"></h:outputText>					
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Last Name"></h:outputText>
				</f:facet>
				<h:outputText value="#{offender.lastName} "></h:outputText>
			</h:column>
			<h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Address" ></h:outputText>
				</f:facet>
				<h:outputText value="#{offender.address}" ></h:outputText>
			</h:column>
			
			
			<f:facet name="header">
							<h:outputText value="City" ></h:outputText>
						</f:facet>
						<h:outputText value="#{offender.city}"></h:outputText>
</body>
</html>