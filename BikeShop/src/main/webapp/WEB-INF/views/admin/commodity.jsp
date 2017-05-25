<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
	.filter .control-label{
		text-align: left;
	}
</style>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/brand">Brand</a></li>
					<li><a href="/admin/material">Material</a></li>
					<li><a href="/admin/color">Color</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li class="active"><a href="/admin/commodity<custom:allParams/>">Commodity</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-2 col-xs-12">
		<form:form class="form-horizontal filter" action="/admin/commodity" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="min, max, brandId, materialId, colorId, categoryId, _brandId, _materialId, _colorId, _categoryId"/>
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="min" class="form-control" placeholder="Min"/>
				</div>
				<div class="col-sm-6">
					<form:input path="max" class="form-control" placeholder="Max"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Brands</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${brands}" itemValue="id" itemLabel="brand" path="brandId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Material</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${materials}" itemValue="id" itemLabel="material" path="materialId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Color</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${colors}" itemValue="id" itemLabel="color" path="colorId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Category</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${categories}" itemValue="id" itemLabel="category" path="categoryId"/>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	</div>
	<div class="col-md-8 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/commodity" method="POST" modelAttribute="commodity" enctype="multipart/form-data">
					<custom:hiddenInputs excludeParams="brand, material, color, category, price"/>
					<div class="form-group">
						<label style="color:red;text-align:left;" for="brand" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="brand"/></label>
					</div>
					<div class="form-group">
    					<label for="brand" class="col-sm-2 control-label">Brand</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="brand" id="brand" items="${brands}" itemValue="id" itemLabel="brand"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="material" class="col-sm-2 control-label">Material</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="material" id="material" items="${materials}" itemLabel="material" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="color" class="col-sm-2 control-label">Color</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="color" id="color" items="${colors}" itemValue="id" itemLabel="color"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="category" class="col-sm-2 control-label">Category</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="category" id="category" items="${categories}" itemValue="id" itemLabel="category"/>
    					</div>
  					</div>
  					<div class="form-group">
						<label style="color:red;text-align:left;" for="name" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="price"/></label>
					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Price</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="price" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-10">
      						<input name="file" type="file" id="name">
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-primary">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-xs-3"><h3>Image</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Brand</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Material</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Color</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Category</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Price</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Options</h3></div>
		</div>
			<c:forEach items="${page.content}" var="commodity">
				<div class="row">
					<div class="col-md-3 col-xs-3"><img src="/images/commodities/${commodity.id}.jpg?version=${commodity.version}" width="200" height="200"></div>
					<div class="col-md-1 col-xs-1">${commodity.brand.brand}</div>
					<div class="col-md-2 col-xs-2">${commodity.material.material}</div>
					<div class="col-md-2 col-xs-2">${commodity.color.color}</div>
					<div class="col-md-2 col-xs-2">${commodity.category.category}</div>
					<div class="col-md-1 col-xs-1">${commodity.price}</div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning" href="/admin/commodity/update/${commodity.id}<custom:allParams/>">update</a>
					<a class="btn btn-danger" href="/admin/commodity/delete/${commodity.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Price asc" paramValue="price" />
								<custom:sort innerHtml="Price desc" paramValue="price,desc" />
								<custom:sort innerHtml="Brand name asc" paramValue="brand.brand" />
								<custom:sort innerHtml="Brand name desc" paramValue="brand.brand,desc" />
								<custom:sort innerHtml="Color name asc" paramValue="color.color" />
								<custom:sort innerHtml="Color name desc" paramValue="color.color,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
				</div>
	</div>
	<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
</div>