def text = '''
Scramble the inner characters of words
leaving the text still readable for people but
not for computers.
'''
println text.replaceAll(/\B\w+\B/) { inner ->
    def list = inner.toList()
    Collections.shuffle(list)
    list.join ''
}