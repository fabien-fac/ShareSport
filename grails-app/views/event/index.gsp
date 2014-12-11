
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
                <div class="sub-body">
                    <div class="title-sub-body">
                        <h2>Trouver un événement</h2>
                    </div>
                    <g:form controller="event" action="index">
                        <table class="search-event">
                            <tr>
                                <td>
                                    <g:textField name="titre" placeholder="Titre..."/>
                                </td>
                                <td>
                                    <g:textField name="auteur" placeholder="Auteur..."/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <g:textField name="hashtag" placeholder="Hashtag..."/>
                                </td>
                                <td>
                                    <g:select name="sport" from="${sportList}" noSelection="${["":'Choisir un sport...']}" optionKey="name" optionValue="name"></g:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <g:submitButton name="Chercher"/>
                                </td>
                            </tr>
                        </table>
                    </g:form>
                </div>
                <br/>
                <div class="sub-body">
                    <div class="title-sub-body">
                        <h2>Liste des événements</h2>
                    </div>
                    <div id="list-event" class="content scaffold-list" role="main">
                        <g:each in="${eventInstanceList}" status="i" var="eventInstance">
                            <g:link action="show" id="${eventInstance.id}">
                            <div class="event">
                                <img src="${resource(dir: 'images', file: 'sharesport_logo.png')}" alt="ShareSport" height="80px"/>
                                <p>${fieldValue(bean: eventInstance, field: "titre")}</p>
                                <p>${fieldValue(bean: eventInstance, field: "sport.name")}</p>
                                <p> <g:formatDate date="${eventInstance.begin_date}" /></p>
                            </div>
                            </g:link>
                        </g:each>

                        <div class="pagination">
                            <g:paginate total="${eventInstanceCount ?: 0}" />
                        </div>
                    </div>
                </div>
                <table>
                    <thead>
                    <tr>

                        <g:sortableColumn property="titre" title="${message(code: 'event.titre.label', default: 'Titre')}" />

                        <g:sortableColumn property="begin_date" title="${message(code: 'event.begin_date.label', default: 'Begindate')}" />

                    </tr>
                    </thead>
                </table>


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
