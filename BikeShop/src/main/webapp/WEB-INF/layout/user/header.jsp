<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">B I K E S H O P</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="isAuthenticated()">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="/admin">Адміністратор</a></li>
					</sec:authorize>
					<form:form action="/logout" method="POST" class="navbar-form navbar-left">
						<button type="submit" class="btn btn-danger">Вийти</button>
					</form:form>
					<li><a href="/cart"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
						<span>Корзина</span>
				</a></li>
				</sec:authorize>
				<sec:authorize access="!isAuthenticated()">
					<li><a href="/login"><span class="glyphicon glyphicon-user"
							aria-hidden="true"></span> <span>Увійти</span>
					</a></li>
					<li><a href="/registration"><span class="glyphicon glyphicon-list-alt"
							aria-hidden="true"></span> <span>Реєстрація</span>
					</a></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>