assert (~/..../).isCase('bear')

switch('bear'){
    case ~/..../ : assert true; break
    default      : assert false
}

beasts = ['bear','wolf','tiger','regex']

assert beasts.grep(~/..../) == ['bear','wolf']
