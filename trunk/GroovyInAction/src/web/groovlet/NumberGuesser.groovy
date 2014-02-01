def session = request.session
def guess   = params.guess
guess = guess ? guess.toInteger() : null 
if (params.restart) guess = null

if (!session.goal || params.restart) {
    session.goal = (Math.random()*100).toInteger()
}
def goal = session.goal

html.html{ head { title 'Think of a Number'  }
    body {
        h1 'Think of a Number'
        if (goal && guess) {
            div "Your guess $guess is "
            switch (guess) {
                case goal        : div 'correct!'; break
                case {it < goal} : div 'too low' ; break
                case {it > goal} : div 'too high'; break
            }
        }        
        p "What's your guess (0..100)?"
        form(action:'NumberGuesser.groovy'){
            input(type:'text', name:'guess', '')
            button(type:'submit', 'Guess')
            button(type:'submit', name:'restart', value:'true',
                   'New Game')
}   }   }