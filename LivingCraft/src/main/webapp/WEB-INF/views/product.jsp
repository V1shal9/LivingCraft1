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
<p>Search Product: {{searchProduct}}</p>
<input type="text" placeholder="search the product" ng-model="searchProduct">
</div>
<form:form method="post" modelAttribute="product" action="addProduct" enctype="multipart/form-data">
 <table> 
 <tr> 
 <th colspan="2">Add Product</th> 
 </tr> 
 <tr> 
 <form:hidden path="productId" /> 
  <td><form:label path="productId">Product Id:</form:label></td> 
 <td><form:input path="productId" type="hidden"></form:input></td> 
 </tr>
 <tr>
 <td><form:label path="productName">Product Name:</form:label></td> 
 <td><form:input path="productName"></form:input></td> 
 </tr> 
 <tr> 
 <td><form:label path="productDescription">Product Description:</form:label></td>
  <td><form:input path="productDescription"></form:input></td>
</tr>
  <tr>
        <td><form:label path="productQuantity">product Quantity</form:label></td>
        <td><form:input path="productQuantity" /></td>
    </tr>
    
    <tr>
        <td><form:label path="productPrice">Product Price</form:label></td>
        <td><form:input path="productPrice" /></td>
    </tr>
    
     <tr>
        <td><form:label path="productDiscount">Product Discount</form:label></td>
        <td><form:input path="productDiscount" /></td>
    </tr>
     <tr>
        <td><form:label path="productImage">Product Image</form:label></td>
        <td><form:input path="productImage" type="file" name="file" /></td>
     </tr>
<tr>
<td><form:select path="category.categoryName" items="${categoryList}" itemValue="categoryName" itemLabel="categoryName">
</form:select>

 <td><form:select path="subCategory.subCategoryName" items="${subCategoryList}" itemValue="subCategoryName" itemLabel="subCategoryName"></form:select>
 </td>
 <td><form:select path="supplier.supplierName" items="${supplierList}" itemValue="supplierName" itemLabel="supplierName"></form:select>
 </td>


</tr>
<tr>
<td colspan="2"><input type="submit" value="addProduct"class="blue-button" /></td> 
</tr> 
</table> 
</form:form><br>
<h3>Product List</h3> 
<table class="tg" border="solid gray 2px"> 
<tr> 
<th width="80">Product Id</th> 
<th width="120">Product Name</th> 
<th width="120">Product description</th> 
<th width="120">product quantity</th>  
<th width="120">product price</th>  
<th width="120">product discount</th> 
<th width="60">Edit</th> 
<th width="60">Delete</th> 
</tr>
<%-- <c:forEach items="${productList}" var="plist">  --%>
<tr ng-repeat="plist in jsonData | orderBy:sortType:sortReverse | filter:searchProduct">
<td>{{plist.productId}}</td> 
<td>{{plist.productName}}</td> 
<td>{{plist.productDescription}}</td> 
<td>{{plist.productQuantity}}</td> 
<td>{{plist.productPrice}}</td> 
<td>{{plist.productDiscount}}</td> 

<td><a href="editProduct-{{plist.productId}}" >Edit</a></td> 
<td><a href="deleteProduct-{{plist.productId}}">Delete</a></td> 
</tr> 

</table> 
<script type="text/javascript">
  var app=angular.module('app',[])
  app.controller("myController",function($scope)
  {
 	 $scope.sortType='subProduct';
 	 $scope.sortReverse =false;
 	 $scope.jsonData= ${productList};
	 
  });
</script>

</div>

<%@ include file="footer.jsp"%>