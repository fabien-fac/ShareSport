<%@ page import="sharesport.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${userInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="password" maxlength="50" required="" value="${userInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'login', 'error')} required">
	<label for="pseudo">
		<g:message code="user.pseudo.label" default="Pseudo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="pseudo" maxlength="20" required="" value="${userInstance?.pseudo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'score', 'error')} required">
	<label for="score">
		<g:message code="user.score.label" default="Score" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="score" type="number" min="0" value="${userInstance.score}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'isActive', 'error')} ">
	<label for="isActive">
		<g:message code="user.isActive.label" default="Is Active" />
		
	</label>
	<g:checkBox name="isActive" value="${userInstance?.isActive}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'isAdmin', 'error')} ">
	<label for="isAdmin">
		<g:message code="user.isAdmin.label" default="Is Admin" />
		
	</label>
	<g:checkBox name="isAdmin" value="${userInstance?.isAdmin}" />

</div>

