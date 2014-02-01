
<html>
    <head>
         <title>TutorialEntry List</title>
         <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link action="index">Home</g:link></span>
            <span class="menuButton"><g:link action="create">New TutorialEntry</g:link></span>
            <span class="menuButton"><g:link controller="user" action="list"><%= (session ?.user) ? "${session.user.name}": 'Log in' %></g:link></span>
            <g:if test="${session?.user}">
                <span class="menuButton"><g:link action="listVisited">List visited</g:link></span>
                <span class="menuButton"><g:link action="listUnVisited">List unvisited</g:link></span>
            </g:if>
        </div>
        <div class="body">
           <h1>TutorialEntry List</h1>
            <g:if test="flash['message']">
                 <div class="message">
                       ${flash['message']}
                 </div>
            </g:if>
           <table>
               <tr>
                   <th>Title</th>
                   <th>Id</th>
                   <th>Author</th>
                   <th>Text</th>
               </tr>
               <g:each var="page" in="${tutorialEntryList}">
                    <tr>
                       <%
                           depth = 0
                           def runner = page
                           // while (runner.parentEntry != runner){ runner = runner.parentEntry; depth++}
                           while (runner.parentEntry){ runner = runner.parentEntry; depth++}
                       %>
                            <td style="text-align:left; padding-left: ${ 5 + depth*20 }px ">
                                <g:link action="show" id="${page.id}">${page.title}</g:link>

                            </td>
                            <td style="text-align:right;">${page.id}</td>
                            <td style="text-align:center;">${page.author}</td>
                            <td style="text-align:left;">

                               ${page.text}
                                <!-- page.text.size() > 40 ? page.text[0..37]+'...' : -->
                            </td>
                    </tr>
               </g:each>
           </table>
        </div>
    </body>
</html>
            