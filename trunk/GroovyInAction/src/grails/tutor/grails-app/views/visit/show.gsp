
<html>
    <head>
         <title>Show Visit</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="list">Visit List</g:link></span>
            <span class="menuButton"><g:link action="create">New Visit</g:link></span>
        </div>
        <div class="body">
           <h1>Show Visit</h1>
           <g:if test="${flash['message']}">
                 <div class="message">${flash['message']}</div>
           </g:if>
           <div class="dialog">
                 <table>
                   
                   
                        <tr class="prop">
                              <td valign="top" style="text-align:left;" width="20%" class="name">Id:</td>
                              
                                    <td valign="top" style="text-align:left;" class="value">${visit.id}</td>
                              
                        </tr>
                   
                        <tr class="prop">
                              <td valign="top" style="text-align:left;" width="20%" class="name">Entry:</td>
                              
                                    <td valign="top" style="text-align:left;" class="value"><g:link controller="tutorialEntry" action="show" id="${visit?.entry?.id}">${visit?.entry}</g:link></td>
                              
                        </tr>
                   
                        <tr class="prop">
                              <td valign="top" style="text-align:left;" width="20%" class="name">User:</td>
                              
                                    <td valign="top" style="text-align:left;" class="value"><g:link controller="user" action="show" id="${visit?.user?.id}">${visit?.user}</g:link></td>
                              
                        </tr>
                   
                 </table>
           </div>
           <div class="buttons">
               <g:form controller="visit">
                 <input type="hidden" name="id" value="${visit?.id}" />
                 <span class="button"><g:actionSubmit value="Edit" /></span>
                 <span class="button"><g:actionSubmit value="Delete" /></span>
               </g:form>
           </div>
        </div>
    </body>
</body>
            