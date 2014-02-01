
<html>
    <head>
         <title>Create User</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="list">User List</g:link></span>
        </div>
        <div class="body">
           <h1>Create User</h1>
           <g:if test="${flash['message']}">
                 <div class="message">${flash['message']}</div>
           </g:if>
           <g:hasErrors bean="${user}">
                <div class="errors">
                    <g:renderErrors bean="${user}" as="list" />
                </div>
           </g:hasErrors>
           <g:form action="save" method="post">
               <div class="dialog">
                <table>

                       
                       
                                  <tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='name'>Name:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:user,field:'name','errors')}'><input type='text' name='name' value='${user?.name}' /></td></tr>
                       
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
            