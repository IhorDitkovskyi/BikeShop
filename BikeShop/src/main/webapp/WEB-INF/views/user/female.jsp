<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
	.filter .control-label{
		text-align: left;
	}
	.control-label{
		padding-bottom: 9px;
	}
</style>
<div class="row">
	<div class="col-md-2 col-xs-12">
		<form:form class="form-horizontal filter" action="/female" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="min, max, brandId, colorId, materialId, _brandId, _colorId, _materialId"/>
			<div class="form-group">
				<label class="control-label col-md-12">Ціновий діапазон</label>
				<div class="col-sm-6">
					<form:input path="min" class="form-control" placeholder="Min"/>
				</div>
				<div class="col-sm-6">
					<form:input path="max" class="form-control" placeholder="Max"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-12">Бренд</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${brands}" itemValue="id" itemLabel="brand" path="brandId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Колір</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${colors}" itemValue="id" itemLabel="color" path="colorId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Матеріал</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${materials}" itemValue="id" itemLabel="material" path="materialId"/>
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-success">Ok</button>
				<a class="btn btn-warning" href="/female">Cancel</a>
			</div>
		</form:form>
	</div>
	<div class="col-md-8 col-xs-12">
		<c:forEach items="${page.content}" var="commodity">
				 <div class="col-sm-6 col-md-4">
				    <div class="thumbnail">
				      	<img src="/images/commodities/${commodity.id}.jpg?version=${commodity.version}">
				      	<div class="caption">
				        	<h4>Опис товару</h4>
				        	<div>${commodity.brand.brand}</div>
							<div>${commodity.category.category}</div>
							<div>${commodity.color.color}</div>
							<div>${commodity.material.material}</div>
							<div>Ціна: ${commodity.price}</div>
							<sec:authorize access="isAuthenticated()">
					 		<div><form:form style="display:inline-block;margin-top:8px;"
								action="/female/addtocart/${commodity.id}" method="POST">
								<custom:hiddenInputs excludeParams=""/>
								<button type="submit" class="btn btn-success">В корзину</button>
							</form:form></div>
							</sec:authorize>
				      	</div>
				    </div>
				 </div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Сортування<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="По ціні (від дешевого)" paramValue="price" />
								<custom:sort innerHtml="По ціні (від дорогого)" paramValue="price,desc" />
								<custom:sort innerHtml="По бренду" paramValue="brand.brand" />
								<custom:sort innerHtml="По кольору" paramValue="color.color" />
								<custom:sort innerHtml="По матеріалу" paramValue="material.material" />
							</ul>
						</div>
					</div>
 <!--				<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="3,6,9" size="${page.size}" />
					</div> -->
				</div>
			<div class="row" style="margin-top: 30px;">
				<div class="col-md-12 col-xs-12 text-center">
					<a href=><img src="/images/forIndex/rek123.jpg" class="img-thumbnail"></a>
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