

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ page isELIgnored="false" %>
    <%@ include file="header.jsp" %>
    
<div ng-app="app" ng-controller="myController">

<div class="alert alert-info">
<p>Search Supplier: {{searchSupplier}}</p>
<input type="text" placeholder="search the Supplier" ng-model="searchSupplier">
</div>
<form:form method="post" modelAttribute="supplier" action="addSupplier">
 <table> 
 <tr> 
 <th colspan="2">Add Supplier</th> 
 </tr> 
 <tr> 
 <form:hidden path="supplierId" /> 
  <td><form:label path="supplierId">Supplier Id:</form:label></td> 
 <td><form:input path="supplierId" type="hidden"></form:input></td> 
 </tr>
 <tr>
 <td><form:label path="supplierName">Supplier Name:</form:label></td> 
 <td><form:input path="supplierName"></form:input><br>
  <form:errors path="supplierName" cssClass="error"></form:errors></td>
 </tr> 
 <tr>
 <td><form:label path="supplierAddress">Supplier Address</form:label></td>
 <td><form:input path="supplierAddress" /><br>
  <form:errors path="supplierAddress" cssClass="error"></form:errors></td>
 </tr>
 <tr>
 <td><form:label path="supplierContact">Supplier Contact</form:label></td>
 <td><form:input path="supplierContact" /></td>
<%--   <form:errors path="supplierContact" cssClass="error"></form:errors></td> --%>
 </tr>
<tr>
<td colspan="2"><input type="submit" value="addSupplier"class="blue-button" /></td> 
</tr> 
</table> 
</form:form><br>
<h3>Supplier List</h3> 
<table class="tg" border="solid gray 2px" padding="3px"> 
<tr> 
<th width="80">Supplier Id</th> 
<th width="120">Supplier Name</th> 
<th width="120">Supplier Address</th> 
<th width="120">Supplier Contact</th>
<th width="60">Edit</th> 
<th width="60">Delete</th> 
</tr>
<%-- <c:forEach items="${supplierList}" var="slist">  --%>
<tr ng-repeat="slist in jsonData | orderBy:sortType:sortReverse | filter:searchSupplier"> 
<td>{{slist.supplierId}}</td> 
<td>{{slist.supplierName}}</td> 
<td>{{slist.supplierAddress}}</td> 
<td>{{slist.supplierContact}}</td> 
<td><a href="editSupplier-{{slist.supplierId}}" >Edit</a></td> 
<td><a href="deleteSupplier-{{slist.supplierId}}">Delete</a></td> 
</tr> 

</table> 
 <script type="text/javascript">
 var app=angular.module('app',[])
 app.controller("myController",function($scope)
 {
	 $scope.sortType='supplierName';
	 $scope.sortReverse =false;
	 $scope.jsonData= ${supplierList};
	 
 });
 
 </script>
 </div>

<%@include file="footer.jsp" %>
   