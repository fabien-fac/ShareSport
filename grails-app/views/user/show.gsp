
<%@ page import="sharesport.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                <li><g:link class="edit" action="edit" resource="${userInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status"><script type="text/javascript">$.fancybox("<strong>${flash.message}</strong>");</script></div>
			</g:if>
			<ol class="property-list user">
			
				<g:if test="${userInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="user.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${userInstance}" field="email"/></span>
					
				</li>
				</g:if>

				<g:if test="${userInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="user.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInstance}" field="password"/></span>
					
				</li>
				</g:if>

				<g:if test="${userInstance?.login}">
				<li class="fieldcontain">
					<span id="login-label" class="property-label"><g:message code="user.login.label" default="Login" /></span>
					
						<span class="property-value" aria-labelledby="login-label"><g:fieldValue bean="${userInstance}" field="login"/></span>
					
				</li>
				</g:if>

				<g:if test="${userInstance?.score}">
				<li class="fieldcontain">
					<span id="score-label" class="property-label"><g:message code="user.score.label" default="Score" /></span>
					
						<span class="property-value" aria-labelledby="score-label"><g:fieldValue bean="${userInstance}" field="score"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.isActive}">
				<li class="fieldcontain">
					<span id="isActive-label" class="property-label"><g:message code="user.isActive.label" default="Is Active" /></span>
					
						<span class="property-value" aria-labelledby="isActive-label"><g:formatBoolean boolean="${userInstance?.isActive}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.isAdmin}">
				<li >
					<span id="isAdmin-label" class="property-label"><g:message code="user.isAdmin.label" default="Is Admin" /></span>
					
						<span class="property-value" aria-labelledby="isAdmin-label"><g:formatBoolean boolean="${userInstance?.isAdmin}" /></span>
					
				</li>
				</g:if>
                <hr>
                <li class="fieldcontain">
                    <span class="property-value">
                        <g:form url="[resource:userInstance, action:'delete']" method="DELETE">
                            <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </span>
                </li>
			</ol>

		</div>
	</body>
</html>
