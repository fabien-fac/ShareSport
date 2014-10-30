<%@ page import="sharesport.Hashtag" %>



<div class="fieldcontain ${hasErrors(bean: hashtagInstance, field: 'label', 'error')} required">
	<label for="label">
		<g:message code="hashtag.label.label" default="Label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="label" required="" value="${hashtagInstance?.label}"/>

</div>

