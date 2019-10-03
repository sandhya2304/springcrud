<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<spring:url value="/customer/save" var="saveURL" />

<form:form action="${saveURL }" method="POST" modelAttribute="customerForm">
  <form:hidden path="id"/>
  <table>
   <tr>
    <td>Firstname</td>
    <td><form:input path="firstname"/></td>
   </tr>
   <tr>
    <td>Lastname</td>
    <td><form:input path="lastname"/></td>
   </tr>  
   <tr>
    <td>Gender: </td>
    <td>
     <form:radiobutton path="gender" value="Male" /> Male
     <form:radiobutton path="gender" value="Female" /> Female
    </td>
   </tr> 
   <tr>
    <td>Address</td>
    <td><form:textarea path="address" rows="3" /></td>
   </tr>
   <tr>
    <td></td>
    <td><button type="submit">Save</button></td>
   </tr>
  </table>
 </form:form>
</body>
</html>