<html>
<head>
    <title>Show TutorialEntry</title>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}"></link>
</head>

<body>
<div class="nav">
    <span class="menuButton"><g:link action="index">Home</g:link></span>
    <span class="menuButton"><g:link action="previous" id="${tutorialEntry?.id}">Previous</g:link></span>
    <span class="menuButton"><g:link action="next" id="${tutorialEntry?.id}">Next</g:link></span>
</div>

<div class="body">
    <h1>Tutorial ${tutorialEntry.title}</h1>
    <g:if test="${flash['message']}">
        <div class="message">${flash['message']}</div>
    </g:if>

    <div class="dialog">
        <table>

            <tr class="prop">
                <td valign="top" style="text-align:left;" width="20%" class="name">Author:</td>
                <td valign="top" style="text-align:left;" class="value">
                    <g:link controller="author" action="show"
                        id="${tutorialEntry?.author?.id}">${tutorialEntry?.author}</g:link>
                </td>
            </tr>

            <tr class="prop">
                <td valign="top" style="text-align:left;" width="20%" class="name">Parent Entry:</td>
                <td valign="top" style="text-align:left;" class="value">
                    <g:link controller="tutorialEntry" action="show"
                        id="${tutorialEntry?.parentEntry?.id}">${tutorialEntry?.parentEntry}</g:link>
                </td>
            </tr>

            <tr class="prop">
                <td valign="top" style="text-align:left;" width="20%" class="name">Text:</td>
                <td valign="top" style="text-align:left;" class="value"><g:wikify text="${tutorialEntry?.text}"/></td>
            </tr>
        </table>
    </div>

    <div class="buttons">
        <g:form controller="tutorialEntry">
            <input type="hidden" name="id" value="${tutorialEntry?.id}"/>
            <g:if test="${session?.user && ! tutorialEntry.visitedBy(session.user)}">
                 <span class="button"><g:actionSubmit value="Visited"/></span>
            </g:if>
            <span class="button"><g:actionSubmit value="Edit" /></span>
        </g:form>
    </div>
</div>
</body>
</html>