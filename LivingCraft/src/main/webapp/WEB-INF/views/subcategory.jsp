<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>

<div ng-app="app" ng-controller="myController">
<div class="alert alert-info">
<p>Search SubCategory: {{searchSubCategory}}</p>
<input type="text" placeholder="search the subCategory" ng-model="searchSubCategory">
</div>
<form:form method="post" modelAttribute="subCategory" action="addSubCategory">
 <table> 
 <tr> 
 <th colspan="2">Add SubCategory</th> 
 </tr> 
 <tr> 
 <form:hidden path="subCategoryId" /> 
  <td><form:label path="subCategoryId">SubCategory Id:</form:label></td> 
 <td><form:input path="subCategoryId" type="hidden"></form:input></td> 
 </tr>
 <tr>
 <td><form:label path="subCategoryName">SubCategory Name:</form:label></td> 
 <td><form:input path="subCategoryName"></form:input><br>
 <form:errors path="subCategoryName" cssClass="error"></form:errors></td>
 </tr> 
 <tr> 
 <td><form:label path="subCategoryDescription">subCategory Description:</form:label></td>
  <td><form:input path="subCategoryDescription" size="30" maxlength="30"></form:input><br>
   <form:errors path="subCategoryDescription" cssClass="error"></form:errors></td>
</tr>
<tr>
<td>
<form:select path="category.categoryName" items="${categoryList}" itemValue="categoryName" itemLabel="categoryName"/>
</td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="addSubCategory"class="blue-button" /></td> 
</tr> 
</table> 
</form:form><br>
<h3>SubCategory List</h3>  
<table class="tg" border="solid gray 2px"> 
<tr> 
<th width="80">SubCategory Id</th> 
<th width="120">SubCategory Name</th> 
<th width="120">SubCategory description</th> 
<th width="60">Edit</th> 
<th width="60">Delete</th> 
</tr>
<tr ng-repeat="clist in jsonData | orderBy:sortType:sortReverse | filter:searchSubCategory">
<%-- <c:forEach items="${subCategoryList}" var="clist">  (//normal method)--%>
 
<td>{{clist.subCategoryId}}</td> 
<td>{{clist.subCategoryName}}</td> 
<td>{{clist.subCategoryDescription}}</td> 
<td><a href="editSubCategory-{{clist.subCategoryId}}" >Edit</a></td> 
<td><a href="deleteSubCategory-{{clist.subCategoryId}}">Delete</a></td> 
</tr> 
</table> 
<script type="text/javascript">
  var app=angular.module('app',[])
  app.controller("myController",function($scope)
  {
 	 $scope.sortType='subCategoryName';
 	 $scope.sortReverse =false;
 	 $scope.jsonData= ${subCategoryList};
	 
  });
</script>

</div>

<%@ include file="footer.jsp"%>