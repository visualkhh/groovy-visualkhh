package _C14

                                                 //#1
//mailReminder = '''
//Dear ${salutation?salutation+' ':''}$lastname,
//another month has passed and again it's time for these
//<%=tasks.size()%> tasks:
//<% tasks.each { %>- $it 
//<% } %> 
//your collaboration is very much appreciated
//'''
//앞에서 나온 out변수는 Writer클래스의 객체이며 디폴트로 바인딩된다.
mailReminder = '''
Dear ${salutation?salutation+' ':''}$lastname,
another month has passed and again it's time for these
<%=tasks.size()%> tasks:
<% tasks.each { out.println('-'+it)} %> 
your collaboration is very much appreciated
'''

//def engine   = new groovy.text.SimpleTemplateEngine()       
def engine   = new groovy.text.SimpleTemplateEngine(true)       //true를 하면  내부동작 정보 출력할수있다.
def template = engine.createTemplate(mailReminder)          
def binding  = [                                            
    salutation: 'Mrs.',                                     //|#2
    lastname  : 'Davis',                                    //|#2
    tasks     : ['visit the Groovy in Action (GinA) page',  //|#2
                 'chat with GinA readers']                  //|#2
]

                                                 //|#3
println template.make(binding).toString();

/*
결과

Dear Mrs. Davis,
another month has passed and again it's time for these
2 tasks:
- visit the Groovy in Action (GinA) page 
- chat with GinA readers 
 
your collaboration is very much appreciated
*/