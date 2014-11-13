
<%@ page import="sharesport.Event" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
        <div>
            <g:form controller="event" action="index">
                <g:textField name="titre" placeholder="Titre"/>
                <g:textField name="sport" placeholder="Sport"/>
                <g:textField name="hashtag" placeholder="Hashtag"/>
                <g:textField name="auteur" placeholder="Auteur"/>
                <g:submitButton name="Chercher"/>
            </g:form>
        </div>
		<div id="list-event" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="titre" title="${message(code: 'event.titre.label', default: 'Titre')}" />
					
						<th><g:message code="event.auteur.label" default="Auteur" /></th>
					
						<g:sortableColumn property="begin_date" title="${message(code: 'event.begin_date.label', default: 'Begindate')}" />
					
						<th><g:message code="event.sport.label" default="Sport" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${eventInstanceList}" status="i" var="eventInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${eventInstance.id}">${fieldValue(bean: eventInstance, field: "titre")}</g:link></td>
					
						<td>${fieldValue(bean: eventInstance, field: "auteur")}</td>
					
						<td><g:formatDate date="${eventInstance.begin_date}" /></td>
					
						<td>${fieldValue(bean: eventInstance, field: "sport")}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${eventInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
