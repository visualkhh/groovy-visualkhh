
<html>
    <head>
         <title>Author List</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="create">New Author</g:link></span>
        </div>
        <div class="body">
           <h1>Author List</h1>
            <g:if test="flash['message']">
                 <div class="message">
                       ${flash['message']}
                 </div>
            </g:if>
           <table>
               <tr>
                   
                                      
                        <th>Id</th>
                                      
                        <th>Name</th>
                   
                   <th></th>
               </tr>
               <g:each in="${authorList}">
                    <tr>
                       
                            <td>${it.id}</td>
                       
                            <td>${it.name}</td>
                       
                       <td class="actionButtons">
                            <span class="actionButton"><g:link action="show" id="${it.id}">Show</g:link></span>
                       </td>
                    </tr>
               </g:each>
           </table>
        </div>
    </body>
</body>
            