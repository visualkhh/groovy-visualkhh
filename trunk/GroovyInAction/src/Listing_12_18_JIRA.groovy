import groovy.net.xmlrpc.XMLRPCServerProxy as Proxy

/*
remote = new Proxy('http://jira.codehaus.org/rpc/xmlrpc')

loginToken = remote.jira1.login('codevise','mittie')
projects   = remote.jira1.getProjects(loginToken)
projects.each { println it.name }
*/

class JiraProxy extends Proxy {
    JiraProxy (url) { super ( url ) }
    Object invokeMethod(String methodname, args) {
        super.invokeMethod('jira1.'+methodname, args)
    }
}

def jira = new JiraProxy('http://jira.codehaus.org/rpc/xmlrpc')

jira.login('codevise','mittie') { loginToken ->
   def projects = getProjects(loginToken)
   def groovy = projects.find { it.name == 'groovy' }
   println groovy.key
   println groovy.description
   println groovy.lead
}
