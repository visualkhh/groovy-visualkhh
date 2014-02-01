
<html>
    <head>
         <title>Edit Visit</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="list">Visit List</g:link></span>
            <span class="menuButton"><g:link action="create">New Visit</g:link></span>
        </div>
        <div class="body">
           <h1>Edit Visit</h1>
           <g:if test="${flash['message']}">
                 <div class="message">${flash['message']}</div>
           </g:if>
           <g:hasErrors bean="${visit}">
                <div class="errors">
                    <g:renderErrors bean="${visit}" as="list" />
                </div>
           </g:hasErrors>
           <div class="prop">
	      <span class="name">Id:</span>
	      <span class="value">${visit?.id}</span>
	      <input type="hidden" name="visit.id" value="${visit?.id}" />
           </div>           
           <g:form controller="visit" method="post">
               <input type="hidden" name="id" value="${visit?.id}" />
               <div class="dialog">
                <table>

                       
                       
				<tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='entry'>Entry:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:visit,field:'entry','errors')}'><g:select optionKey="id" from="${TutorialEntry.list()}" name='entry.id' value='${visit?.entry?.id}'></g:select></td></tr>
                       
				<tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='user'>User:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:visit,field:'user','errors')}'><g:select optionKey="id" from="${User.list()}" name='user.id' value='${visit?.user?.id}'></g:select></td></tr>
                       
                </table>
               </div>

               <div class="buttons">
                     <span class="button"><g:actionSubmit value="Update" /></span>
                     <span class="button"><g:actionSubmit value="Delete" /></span>
               </div>
            </g:form>
        </div>
    </body>
</body>
            