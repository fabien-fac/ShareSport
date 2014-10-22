<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
		<g:form>
            <table>
                <tr>
                    <td><g:textField name="email" id="email-signin" placeholder="adresse email"/></td>
                    <td><span id="msg-email-signin"></span></td>
                </tr>
                <tr>
                    <td><g:textField name="login" id="login-signin" placeholder="login"/></td>
                    <td><span id="msg-login-signin"></span></td>
                </tr>
                <tr>
                    <td><g:passwordField name="password" id="password-signin" placeholder="password"/></td>
                    <td><span id="msg-password-signin"></span></td>
                </tr>
                <tr>
                    <td><input type="button" id="button-signin" value="Inscription"/></td>
                </tr>
            </table>

		</g:form>
	</body>
</html>
