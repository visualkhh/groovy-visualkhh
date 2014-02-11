package _B3
def writer  = new StringWriter()
def builder = new groovy.xml.MarkupBuilder(writer);

def web = builder.'web-app'{
	'display-name'('groopvyWeb1');
	builder.'display-name'('groopvyWeb2');
	builder.'display-name'(gogo:5,'-value1-');
	builder.'display-name'('go-go':'5-5','-value2-');
	displayname ('--------') 
}

println writer.toString().replaceAll ("\r","");
/*°á°ú
<web-app>
  <display-name>groopvyWeb1</display-name>
  <display-name>groopvyWeb2</display-name>
  <display-name gogo='5'>-value1-</display-name>
  <display-name go-go='5-5'>-value2-</display-name>
  <displayname>--------</displayname>
</web-app>
*/