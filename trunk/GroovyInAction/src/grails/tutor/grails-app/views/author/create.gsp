
<html>
    <head>
         <title>Create Author</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="list">Author List</g:link></span>
        </div>
        <div class="body">
           <h1>Create Author</h1>
           <g:if test="${flash['message']}">
                 <div class="message">${flash['message']}</div>
           </g:if>
           <g:hasErrors bean="${author}">
                <div class="errors">
                    <g:renderErrors bean="${author}" as="list" />
                </div>
           </g:hasErrors>
           <g:form action="save" method="post">
               <div class="dialog">
                <table>

                       
                       
                                  <tr class='prop'><td valign='top' style='text-align:left;' width='20%'><label for='name'>Name:</label></td><td valign='top' style='text-align:left;' width='80%' class='${hasErrors(bean:author,field:'name','errors')}'><input type='text' name='name' value='${author?.name}' /></td></tr>
                       
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
</html>
