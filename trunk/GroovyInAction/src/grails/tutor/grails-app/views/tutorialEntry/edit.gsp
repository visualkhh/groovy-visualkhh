
<html>
    <head>
         <title>Edit TutorialEntry</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="list">TutorialEntry List</g:link></span>
            <span class="menuButton"><g:link action="create">New TutorialEntry</g:link></span>
        </div>
        <div class="body">
           <h1>Edit TutorialEntry</h1>
           <g:if test="${flash['message']}">
                 <div class="message">${flash['message']}</div>
           </g:if>
           <g:hasErrors bean="${tutorialEntry}">
                <div class="errors">
                    <g:renderErrors bean="${tutorialEntry}" as="list" />
                </div>
           </g:hasErrors>
           <div class="prop">
	      <span class="name">Id:</span>
	      <span class="value">${tutorialEntry?.id}</span>
	      <input type="hidden" name="tutorialEntry.id" value="${tutorialEntry?.id}" />
           </div>           
           <g:form controller="tutorialEntry" method="post">
               <input type="hidden" name="id" value="${tutorialEntry?.id}" />
               <div class="dialog">
                <table>

                    <tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='title'>Title:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:tutorialEntry,field:'title','errors')}'><input type='text' name='title' value='${tutorialEntry?.title}' /></td></tr>

                    <tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='author'>Author:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:tutorialEntry,field:'author','errors')}'><g:select optionKey="id" from="${Author.list()}" name='author.id' value='${tutorialEntry?.author?.id}'></g:select></td></tr>

                    <tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='parentEntry'>Parent Entry:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:tutorialEntry,field:'parentEntry','errors')}'><g:select optionKey="id" from="${TutorialEntry.list()}" name='parentEntry.id' value='${tutorialEntry?.parentEntry?.id}'></g:select></td></tr>

                    <tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='text'>Text:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:tutorialEntry,field:'text','errors')}'>
                    <textarea name="text" style="width:85%" rows=20 cols=80 wrap="virtual">${tutorialEntry?.text}</textarea>

                    </td></tr>


                </table>
               </div>

               <div class="buttons">
                     <span class="button"><g:actionSubmit value="Update" /></span>
                     <span class="button"><g:actionSubmit value="Delete" /></span>
               </div>
            </g:form>
        </div>
    </body>
</html>
            