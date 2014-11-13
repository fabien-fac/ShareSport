<%@ page import="sharesport.Event" %>



<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'titre', 'error')} required">
	<label for="titre">
		<g:message code="event.titre.label" default="Titre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titre" required="" value="${eventInstance?.titre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'auteur', 'error')} required">
	<label for="auteur">
		<g:message code="event.auteur.label" default="Auteur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="auteur" name="auteur.id" from="${sharesport.User.list()}" optionKey="id" required="" value="${eventInstance?.auteur?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'begin_date', 'error')} required">
	<label for="begin_date">
		<g:message code="event.begin_date.label" default="Begindate" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="begin_date" precision="day"  value="${eventInstance?.begin_date}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'hashtags', 'error')} ">
	<label for="hashtags">
		<g:message code="event.hashtags.label" default="Hashtags" />
		
	</label>
	<g:select name="hashtags" from="${sharesport.Hashtag.list()}" multiple="multiple" optionKey="id" size="5" value="${eventInstance?.hashtags*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'sport', 'error')} required">
	<label for="sport">
		<g:message code="event.sport.label" default="Sport" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="sport" name="sport.id" from="${sharesport.Sport.list()}" optionKey="id" required="" value="${eventInstance?.sport?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'timeline', 'error')} required">
	<label for="timeline">
		<g:message code="event.timeline.label" default="Timeline" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="timeline" name="timeline.id" from="${sharesport.Timeline.list()}" optionKey="id" required="" value="${eventInstance?.timeline?.id}" class="many-to-one"/>

</div>

