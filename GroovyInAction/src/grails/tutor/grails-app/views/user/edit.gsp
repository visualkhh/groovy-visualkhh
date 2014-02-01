
<html>
    <head>
         <title>Edit User</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="list">User List</g:link></span>
            <span class="menuButton"><g:link action="create">New User</g:link></span>
        </div>
        <div class="body">
           <h1>Edit User</h1>
           <g:if test="${flash['message']}">
                 <div class="message">${flash['message']}</div>
           </g:if>
           <g:hasErrors bean="${user}">
                <div class="errors">
                    <g:renderErrors bean="${user}" as="list" />
                </div>
           </g:hasErrors>
           <div class="prop">
	      <span class="name">Id:</span>
	      <span class="value">${user?.id}</span>
	      <input type="hidden" name="user.id" value="${user?.id}" />
           </div>           
           <g:form controller="user" method="post">
               <input type="hidden" name="id" value="${user?.id}" />
               <div class="dialog">
                <table>

                       
                       
				<tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='name'>Name:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:user,field:'name','errors')}'><input type='text' name='name' value='${user?.name}' /></td></tr>
                       
				<tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='visits'>Visits:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:user,field:'visits','errors')}'><ul>
    <g:each var='v' in='${user.visits}'>
        <li><g:link controller='visit' action='show' id='${v.id}'>${v}</g:link></li>
    </g:each>
</ul>
<g:link controller='visit' params='["user.id":user?.id]' action='create'>Add Visit</g:link>
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
</body>
            