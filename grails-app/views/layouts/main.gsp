<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'shareSport.css')}" type="text/css">
        <g:javascript src="jquery-2.1.1.min.js"/>
        <g:javascript src="inscription.js"/>
		<g:layoutHead/>
		<g:javascript library="application"/>
		<r:layoutResources />
	</head>
	<body>
		<div id="grailsLogo" role="banner">
            <a href="/ShareSport/"><img src="${resource(dir: 'images', file: 'sharesport_logo.png')}" alt="ShareSport" height="100px"/></a>
            <div id="menu-banner">
                <ul>
                    <li>
                        <a href="">Item 1</a>
                    </li>
                    <li>
                        <a href="">Item 1</a>
                    </li>
                    <li>
                        <a href="">Item 1</a>
                    </li>
                </ul>
            </div>
            <div class="connect">
                <g:if test="${session.userId == null}">
                    <g:form>
                        <table class=" connect">
                            <tr>
                                <td><g:textField name="email" id="email-connect" placeholder="Adresse email"/></td>
                                <td><span id="msg-email-connect"></span></td>
                            </tr>
                            <tr>
                                <td><g:passwordField name="password" id="password-connect" placeholder="Mot de passe"/></td>
                                <td><span id="msg-password-connect"></span></td>
                            </tr>
                            <tr>
                                <td><input type="button" class="button-form" id="button-connect" value="Connexion"/></td>
                            </tr>
                        </table>
                    </g:form>
                </g:if>
                <g:else>
                    <g:link controller="user" action="disconnect"><span class="button">Deconnexion</span></g:link>
                </g:else>
            </div>
        </div>
		<g:layoutBody/>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<r:layoutResources />
	</body>
</html>
