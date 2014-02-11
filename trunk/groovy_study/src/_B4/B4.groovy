package _B4

//def writer = new FileWriter('markup.html')
def writer = new StringWriter();
def html   = new groovy.xml.MarkupBuilder(writer)                                   
html.html {
  head {
    title 'Constructed by MarkupBuilder'
  }
  body {
    h1 'What can I do with MarkupBuilder?'
    form (action:'whatever') {
	      for (line in ['Produce HTML','Produce XML','Have some fun']){
	        input(type:'checkbox',checked:'checked', id:line, '')
	        label(for:line, line)
	        br('')
		  }
	   }
	 } 
  }

println writer.toString().replaceAll ("\r","");
/*°á°ú
<html>
  <head>
    <title>Constructed by MarkupBuilder</title>
  </head>
  <body>
    <h1>What can I do with MarkupBuilder?</h1>
    <form action='whatever'>
      <input type='checkbox' checked='checked' id='Produce HTML'></input>
      <label for='Produce HTML'>Produce HTML</label>
      <br></br>
      <input type='checkbox' checked='checked' id='Produce XML'></input>
      <label for='Produce XML'>Produce XML</label>
      <br></br>
      <input type='checkbox' checked='checked' id='Have some fun'></input>
      <label for='Have some fun'>Have some fun</label>
      <br></br>
    </form>
  </body>
</html>
*/