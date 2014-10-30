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
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'sharesport_logo_transparent.png')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'shareSport.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'images', file: 'skin/fancybox/jquery.fancybox.css')}" type="text/css">

		<g:layoutHead/>
		<g:javascript library="application"/>
		<r:layoutResources />
	</head>
	<body>
		<div id="header" role="banner">
            <div class="nav-header">
                <div class="logo-header">
                    <a href="/ShareSport/"><img src="${resource(dir: 'images', file: 'sharesport_logo.png')}" alt="ShareSport" height="80px"/></a>
                </div>
                <ul>
                    <li class="btn-header">
                        <a href="">Item 1</a>
                    </li>
                    <li class="btn-header">
                        <a href="">Item 2</a>
                    </li>
                    <li class="btn-header">
                        <a href="">Item 3</a>
                    </li>
                </ul>
            </div>
            <div class="connect">
                <g:if test="${session.userId == null}">
                    <g:form>
                        <ul>
                            <li>
                                <g:textField name="email" id="email-connect" placeholder="Adresse email"/>
                            </li>
                            <li>
                                <g:passwordField name="password" id="password-connect" placeholder="Mot de passe"/>
                            </li>
                            <li>
                                <input type="button" class="button-form" id="button-connect" value="Connexion"/>
                            </li>
                        </ul>
                    </g:form>
                </g:if>
                <g:else>
                    <g:form controller="user" action="logout">
                        <ul>
                            <li>
                                <g:submitButton name="logout" value="Deconnexion"/>
                            </li>
                        </ul>
                    </g:form>
                </g:else>
            </div>
        </div>
		<g:layoutBody/>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<r:layoutResources />
	</body>
</html>
