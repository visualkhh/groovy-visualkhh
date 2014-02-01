
<html>
    <head>
         <title>Create Visit</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="list">Visit List</g:link></span>
        </div>
        <div class="body">
           <h1>Create Visit</h1>
           <g:if test="${flash['message']}">
                 <div class="message">${flash['message']}</div>
           </g:if>
           <g:hasErrors bean="${visit}">
                <div class="errors">
                    <g:renderErrors bean="${visit}" as="list" />
                </div>
           </g:hasErrors>
           <g:form action="save" method="post">
               <div class="dialog">
                <table>

                       
                       
                                  <tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='entry'>Entry:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:visit,field:'entry','errors')}'><g:select optionKey="id" from="${TutorialEntry.list()}" name='entry.id' value='${visit?.entry?.id}'></g:select></td></tr>
                       
                                  <tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='user'>User:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:visit,field:'user','errors')}'><g:select optionKey="id" from="${User.list()}" name='user.id' value='${visit?.user?.id}'></g:select></td></tr>
                       
               </table>
               </div>
               <div class="buttons">
                     <span class="formButton">
                        <input type="submit" value="Create"></input>
                     </span>
               </div>
            </g:form>
        </div>
    </body>
</body>
            