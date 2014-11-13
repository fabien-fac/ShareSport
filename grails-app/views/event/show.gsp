
<%@ page import="sharesport.Event" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-event" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-event" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list event">
			
				<g:if test="${eventInstance?.titre}">
				<li class="fieldcontain">
					<span id="titre-label" class="property-label"><g:message code="event.titre.label" default="Titre" /></span>
					
						<span class="property-value" aria-labelledby="titre-label"><g:fieldValue bean="${eventInstance}" field="titre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.auteur}">
				<li class="fieldcontain">
					<span id="auteur-label" class="property-label"><g:message code="event.auteur.label" default="Auteur" /></span>
					
						<span class="property-value" aria-labelledby="auteur-label"><g:link controller="user" action="show" id="${eventInstance?.auteur?.id}">${eventInstance?.auteur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.begin_date}">
				<li class="fieldcontain">
					<span id="begin_date-label" class="property-label"><g:message code="event.begin_date.label" default="Begindate" /></span>
					
						<span class="property-value" aria-labelledby="begin_date-label"><g:formatDate date="${eventInstance?.begin_date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.hashtags}">
				<li class="fieldcontain">
					<span id="hashtags-label" class="property-label"><g:message code="event.hashtags.label" default="Hashtags" /></span>
					
						<g:each in="${eventInstance.hashtags}" var="h">
						<span class="property-value" aria-labelledby="hashtags-label"><g:link controller="hashtag" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.sport}">
				<li class="fieldcontain">
					<span id="sport-label" class="property-label"><g:message code="event.sport.label" default="Sport" /></span>
					
						<span class="property-value" aria-labelledby="sport-label"><g:link controller="sport" action="show" id="${eventInstance?.sport?.id}">${eventInstance?.sport?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventInstance?.timeline}">
				<li class="fieldcontain">
					<span id="timeline-label" class="property-label"><g:message code="event.timeline.label" default="Timeline" /></span>
					
						<span class="property-value" aria-labelledby="timeline-label"><g:link controller="timeline" action="show" id="${eventInstance?.timeline?.id}">${eventInstance?.timeline?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:eventInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${eventInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>