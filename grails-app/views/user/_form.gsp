<%@ page import="sharesport.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
        <span class="property-label">
            <g:message code="user.email.label" default="Email" />
            <span class="required-indicator">*</span>
        </span>
	</label>
    <span class="property-value">
	    <g:field type="email" name="email" required="" value="${userInstance?.email}"/>
    </span>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
        <span class="property-label">
            <g:message code="user.password.label" default="Password" />
            <span class="required-indicator">*</span>
        </span>
	</label>
    <span class="property-value">
    	<g:field type="password" name="password" maxlength="50" required="" value="${userInstance?.password}"/>
    </span>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'login', 'error')} required">
	<label for="login">
        <span class="property-label">
            <g:message code="user.login.label" default="Login" />
            <span class="required-indicator">*</span>
        </span>
	</label>
    <span class="property-value">
    	<g:textField name="login" maxlength="20" required="" value="${userInstance?.login}"/>
    </span>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'score', 'error')} required">
	<label for="score">
        <span class="property-label">
            <g:message code="user.score.label" default="Score" />
            <span class="required-indicator">*</span>
        </span>
	</label>
    <span class="property-value">
    	<g:field name="score" type="number" min="0" value="${userInstance.score}" required=""/>
    </span>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'isActive', 'error')} ">
	<label for="isActive">
        <span class="property-label">
    		<g:message code="user.isActive.label" default="Is Active" />
        </span>
	</label>
    <span class="property-value">
    	<g:checkBox name="isActive" value="${userInstance?.isActive}" />
    </span>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'isAdmin', 'error')} ">
	<label for="isAdmin">
        <span class="property-label">
		    <g:message code="user.isAdmin.label" default="Is Admin" />
		</span>
	</label>
    <span class="property-value">
	    <g:checkBox name="isAdmin" value="${userInstance?.isAdmin}" />
    </span>

</div>

