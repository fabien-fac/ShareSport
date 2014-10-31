<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Sharesport - Paris sportifs</title>
		<!--<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>-->
	</head>
	<body>
		<div id="page-body" role="main">
            <div class="body-content">
                <h1>Welcome to ShareSport</h1>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pellentesque consectetur quam, eleifend ultricies magna iaculis id. Nullam tristique a mi ut aliquet. Donec tempus vel dolor ut pharetra. Pellentesque mollis neque pretium ligula pulvinar, ut auctor purus iaculis. Vivamus ipsum nulla, suscipit quis fermentum non, congue et mi. Ut auctor dapibus erat, sit amet pulvinar ante condimentum vel. Suspendisse molestie lectus ut arcu sodales sollicitudin. Ut mollis, nisi id vehicula vestibulum, ipsum eros eleifend ipsum, et venenatis nunc velit sit amet sapien. Proin auctor aliquet volutpat.
                </p>
                <div id="tagul">
                    <script src="js/tagul.js"></script>
                </div>
                <h2>Titre 2</h2>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pellentesque consectetur quam, eleifend ultricies magna iaculis id. Nullam tristique a mi ut aliquet. Donec tempus vel dolor ut pharetra. Pellentesque mollis neque pretium ligula pulvinar, ut auctor purus iaculis. Vivamus ipsum nulla, suscipit quis fermentum non, congue et mi. Ut auctor dapibus erat, sit amet pulvinar ante condimentum vel. Suspendisse molestie lectus ut arcu sodales sollicitudin. Ut mollis, nisi id vehicula vestibulum, ipsum eros eleifend ipsum, et venenatis nunc velit sit amet sapien. Proin auctor aliquet volutpat.
                </p>
            </div>
            <div class="body-sidebar">
            <sec:ifNotLoggedIn>
                <h1>Formulaire d'inscription</h1>
                <g:form>
                    <table>
                        <tr>
                            <td><g:textField name="email" id="email-signin" placeholder="Adresse email"/></td>
                        </tr>
                        <tr>
                            <td><span class="error-form" id="msg-email-signin"></span></td>
                        </tr>
                        <tr>
                            <td><g:textField name="login" id="login-signin" placeholder="Nom d'utilisateur"/></td>
                        </tr>
                        <tr>
                            <td><span class="error-form" id="msg-login-signin"></span></td>
                        </tr>
                        <tr>
                            <td><g:passwordField name="password" id="password-signin" placeholder="Mot de passe"/></td>
                        </tr>
                        <tr>
                            <td><span class="error-form" id="msg-password-signin"></span></td>
                        </tr>
                        <tr>
                            <td><input type="button" class="button-form" id="button-signin" value="Inscription"/></td>
                        </tr>
                    </table>
                </g:form>
            </sec:ifNotLoggedIn>
            </div>
		</div>
	</body>
</html>
