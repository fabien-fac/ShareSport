<%@ page import="sharesport.Message" %>



<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="message.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="content" required="" value="${messageInstance?.content}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="message.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${messageInstance?.date}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'editor', 'error')} required">
	<label for="editor">
		<g:message code="message.editor.label" default="Editor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="editor" name="editor.id" from="${sharesport.User.list()}" optionKey="id" required="" value="${messageInstance?.editor?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'timeline', 'error')} required">
	<label for="timeline">
		<g:message code="message.timeline.label" default="Timeline" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="timeline" name="timeline.id" from="${sharesport.Timeline.list()}" optionKey="id" required="" value="${messageInstance?.timeline?.id}" class="many-to-one"/>

</div>

