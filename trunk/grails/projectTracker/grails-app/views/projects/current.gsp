<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Current Projects</title>
</head>
<body>
    <table border="1">
        <g:each in="${allProjects}" status="i" var="thisProject">
            <tr>
                <td>${i} : ${thisProject.name}</td>
                <td>${i} : ${thisProject.description}</td>
                <td>${i} : ${thisProject.dueDate}</td>
            </tr>
        </g:each>
    </table>
</body>
</html>