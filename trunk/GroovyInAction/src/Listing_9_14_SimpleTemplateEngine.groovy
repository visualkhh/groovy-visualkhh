                                                 //#1
mailReminder = '''
Dear ${salutation?salutation+' ':''}$lastname,
another month has passed and again it's time for these
<%=tasks.size()%> tasks:
<% tasks.each { %>- $it 
<% } %> 
your collaboration is very much appreciated
'''

def engine   = new groovy.text.SimpleTemplateEngine()       
def template = engine.createTemplate(mailReminder)          
def binding  = [                                            
    salutation: 'Mrs.',                                     //|#2
    lastname  : 'Davis',                                    //|#2
    tasks     : ['visit the Groovy in Action (GinA) page',  //|#2
                 'chat with GinA readers']                  //|#2
]

                                                 //|#3
assert template.make(binding).toString() == '''
Dear Mrs. Davis,
another month has passed and again it's time for these
2 tasks:
- visit the Groovy in Action (GinA) page 
- chat with GinA readers 
 
your collaboration is very much appreciated
'''
