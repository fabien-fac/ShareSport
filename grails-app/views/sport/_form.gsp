<%@ page import="sharesport.Sport" %>



<div class="fieldcontain ${hasErrors(bean: sportInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="sport.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${sportInstance?.name}"/>

</div>

