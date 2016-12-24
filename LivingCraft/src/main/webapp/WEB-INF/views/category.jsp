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
<p>Search Category: {{searchCategory}}</p>
<input type="text" placeholder="search the category" ng-model="searchCategory">
</div>
<form:form method="post" modelAttribute="category" action="addCategory">
 <table> 
 <tr> 
 <th colspan="2">Add Category</th> 
 </tr> 
 <tr> 
 <form:hidden path="categoryId" /> 
  <td><form:label path="categoryId">Category Id:</form:label></td> 
 <td><form:input path="categoryId" type="hidden"></form:input></td> 
 </tr>
 <tr>
 <td><form:label path="categoryName">Category Name:</form:label></td> 
 <td><form:input path="categoryName"></form:input><br>
 <form:errors path="categoryName" cssClass="error"></form:errors></td>
 </tr> 
 <tr> 
 <td><form:label path="categoryDescription">category Description:</form:label></td>
  <td><form:input path="categoryDescription" size="30" maxlength="30"></form:input><br>
  <form:errors path="categoryDescription" cssClass="error"></form:errors></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="addCategory"class="blue-button" /></td> 
</tr> 
</table> 
</form:form><br>
<h3>Category List</h3> 
 
<table class="tg" border="solid gray 2px"> 
<tr> 
<th width="80">Category Id</th> 
<th width="120">Category Name</th> 
<th width="120">Category description</th> 
<th width="60">Edit</th> 
<th width="60">Delete</th> 
</tr>
<tr ng-repeat="clist in jsonData | orderBy:sortType:sortReverse | filter:searchCategory"> 
<td>{{clist.categoryId}}</td> 
<td>{{clist.categoryName}}</td> 
<td>{{clist.categoryDescription}}</td> 
<td><a href="editCategory-{{clist.categoryId}}" >Edit</a></td> 
<td><a href="deleteCategory-{{clist.categoryId}}">Delete</a></td> 
</tr> 
 </table> 

 <script type="text/javascript">
 var app=angular.module('app',[])
 app.controller("myController",function($scope)
 {
	 $scope.sortType='categoryName';
	 $scope.sortReverse =false;
	 $scope.jsonData= ${categoryList};
	 
 });
 
 </script>
 </div>
<%@include file="footer.jsp" %>
