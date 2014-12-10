
<%@ page import="sharesport.Event" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
        <div id="id-event" style="display: none">${eventInstance?.id}</div>
		<div id="show-event" class="content scaffold-show" role="main">
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

						<span class="property-value" aria-labelledby="auteur-label">${eventInstance?.auteur?.username.encodeAsHTML()}</span>

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

						<span class="property-value" aria-labelledby="sport-label">${eventInstance?.sport?.name.encodeAsHTML()}</span>

				</li>
				</g:if>

			</ol>

            <div id="tchat-event-container">
                <div id="box-messages">

                </div>
                <br>
                <div id="form-tchat">
                    <input type="text" id="input-tchat" placeholder="Votre message..."/>
                </div>

            </div>

		</div>
	</body>
</html>
