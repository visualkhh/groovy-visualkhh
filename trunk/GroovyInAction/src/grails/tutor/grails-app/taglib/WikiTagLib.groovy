import org.springframework.validation.Errors;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.servlet.support.RequestContextUtils as RCU;
import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU;

class WikiTagLib extends ApplicationTagLib {

    def replacements = [
        [ "\n"                , "<br>\n"],          // newlines to breaks
        [ "<br>\n\\s*<br>\n"  , "<p/>\n"],          // double breaks to paragraphs
        [ /\*(\b[^\*]*?\b)\*/ , '<b>$1</b>' ],      // *bold*
        [ /\~(\b[^\*]*?\b)\~/ , '<i>$1</i>' ],      // ~italic~
        [ /\b\_([^\*]*?)\_\b/ , '<div style="text-decoration:underline">$1</div>' ], // _underline_
    ]
    /**
     * Emit given text as Wiki Markup
     *
     * eg. <h1>Wiki Text:</h1> <g:wikify text="${tutorialEntry.text}"/>
     */
    def wikify = { attributes ->
        def text = attributes.text
        for (pair in replacements) {
            text = text.replaceAll(pair[0], pair[1])
        }
         out << text
    }
}