class Book {
    String title             //#1
}

def groovyBook = new Book()

groovyBook.setTitle('Groovy conquers the world')            //#2
assert groovyBook.getTitle() == 'Groovy conquers the world' //#2

groovyBook.title = 'Groovy in Action'                       //#3
assert groovyBook.title == 'Groovy in Action'               //#3
