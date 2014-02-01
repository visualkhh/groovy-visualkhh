
<html>
    <head>
         <title>Show User</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="list">User List</g:link></span>
            <span class="menuButton"><g:link action="create">New User</g:link></span>
        </div>
        <div class="body">
           <h1>Show User</h1>
           <g:if test="${flash['message']}">
                 <div class="message">${flash['message']}</div>
           </g:if>
           <div class="dialog">
                 <table>
                   
                   
                        <tr class="prop">
                              <td valign="top" style="text-align:left;" width="20%" class="name">Id:</td>
                              
                                    <td valign="top" style="text-align:left;" class="value">${user.id}</td>
                              
                        </tr>
                   
                        <tr class="prop">
                              <td valign="top" style="text-align:left;" width="20%" class="name">Name:</td>
                              
                                    <td valign="top" style="text-align:left;" class="value">${user.name}</td>
                              
                        </tr>
                   
                 </table>
           </div>
           <div class="buttons">
               <g:form controller="user">
                 <input type="hidden" name="id" value="${user?.id}" />
                 <span class="button"><g:actionSubmit value="Edit" /></span>
                 <span class="button"><g:actionSubmit value="Delete" /></span>
               </g:form>
           </div>
        </div>
    </body>
</body>
            