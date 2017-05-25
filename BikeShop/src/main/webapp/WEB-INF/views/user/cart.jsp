<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row text-center">
	<h2>Загальна сума корзини: ${tprice} грн</h2>
</div>
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8 col-xs-12">
		<c:forEach items="${comm}" var="commodity">
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
							<div><form:form style="display:inline-block;margin-top:8px;"
								action="/cart/delete/${commodity.id}" method="POST">
								<button type="submit" class="btn btn-danger">Видалити</button>
							</form:form></div>
				      	</div>
				    </div>
				 </div>
		</c:forEach>
	</div>
</div>
