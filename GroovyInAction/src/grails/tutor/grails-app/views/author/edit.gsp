
<html>
    <head>
         <title>Edit Author</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="list">Author List</g:link></span>
            <span class="menuButton"><g:link action="create">New Author</g:link></span>
        </div>
        <div class="body">
           <h1>Edit Author</h1>
           <g:if test="${flash['message']}">
                 <div class="message">${flash['message']}</div>
           </g:if>
           <g:hasErrors bean="${author}">
                <div class="errors">
                    <g:renderErrors bean="${author}" as="list" />
                </div>
           </g:hasErrors>
           <div class="prop">
	      <span class="name">Id:</span>
	      <span class="value">${author?.id}</span>
	      <input type="hidden" name="author.id" value="${author?.id}" />
           </div>           
           <g:form controller="author" method="post">
               <input type="hidden" name="id" value="${author?.id}" />
               <div class="dialog">
                <table>

                       
                       
				<tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='name'>Name:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:author,field:'name','errors')}'><input type='text' name='name' value='${author?.name}' /></td></tr>
                       
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
            