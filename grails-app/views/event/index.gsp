
<%@ page import="sharesport.Event" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
        <div class="page-body">
            <div class="body-content">
                <h1>Les événements</h1>
                <g:form controller="event" action="index">
                    <g:textField name="titre" placeholder="Titre"/>
                    <g:textField name="sport" placeholder="Sport"/>
                    <g:textField name="hashtag" placeholder="Hashtag"/>
                    <g:textField name="auteur" placeholder="Auteur"/>
                    <g:submitButton name="Chercher"/>
                </g:form>
                <div id="list-event" class="content scaffold-list" role="main">
                <g:each in="${eventInstanceList}" status="i" var="eventInstance">
                    <div class="event">
                        <img src="${resource(dir: 'images', file: 'sharesport_logo.png')}" alt="ShareSport" height="80px"/>
                        <p><g:link action="show" id="${eventInstance.id}">${fieldValue(bean: eventInstance, field: "titre")}</g:link></p>
                        <p>${fieldValue(bean: eventInstance, field: "sport.name")}</p>
                        <p> <g:formatDate date="${eventInstance.begin_date}" /></p>
                    </div>

                </g:each>
                    <table>
                        <thead>
                        <tr>

                            <g:sortableColumn property="titre" title="${message(code: 'event.titre.label', default: 'Titre')}" />

                            <th><g:message code="event.auteur.label" default="Auteur" /></th>

                            <g:sortableColumn property="begin_date" title="${message(code: 'event.begin_date.label', default: 'Begindate')}" />

                            <th><g:message code="event.sport.label" default="Sport" /></th>

                        </tr>
                        </thead>
                    </table>
                    <div class="pagination">
                        <g:paginate total="${eventInstanceCount ?: 0}" />
                    </div>
                </div>
            </div>
            <div class="body-sidebar">
                <div class="user-data">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tristique elit est, ac sodales odio fringilla a. Nullam tincidunt consectetur dui, a tempus ligula tincidunt id. Maecenas lobortis pretium odio, a varius lacus posuere vel. Aliquam pulvinar, lacus vel euismod aliquet, turpis dui fermentum lacus, a suscipit purus elit et augue. Sed interdum, sem ut consectetur hendrerit, sapien erat blandit velit, eu suscipit erat lacus id felis. Mauris gravida rutrum tellus ac mollis. Donec in tincidunt massa, vel tincidunt turpis. Vestibulum nec lectus tellus. Quisque lectus sem, semper nec egestas nec, bibendum non leo.
                </div>
                <div class="most-popular">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tristique elit est, ac sodales odio fringilla a. Nullam tincidunt consectetur dui, a tempus ligula tincidunt id. Maecenas lobortis pretium odio, a varius lacus posuere vel. Aliquam pulvinar, lacus vel euismod aliquet, turpis dui fermentum lacus, a suscipit purus elit et augue. Sed interdum, sem ut consectetur hendrerit, sapien erat blandit velit, eu suscipit erat lacus id felis. Mauris gravida rutrum tellus ac mollis. Donec in tincidunt massa, vel tincidunt turpis. Vestibulum nec lectus tellus. Quisque lectus sem, semper nec egestas nec, bibendum non leo.
                </div>
            </div>
        </div>
	</body>
</html>
