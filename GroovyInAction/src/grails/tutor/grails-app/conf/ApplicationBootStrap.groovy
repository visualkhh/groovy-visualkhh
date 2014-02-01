class ApplicationBootStrap {

     Closure init = { servletContext ->
        def guillaume = new Author(name: 'Guillaume')
        guillaume.save()
        
        def dierk = new User(name: 'Dierk')
        dierk.save()
        
        def root = new TutorialEntry(
            title: '1 Sample Tutorial',
            text:  '*Root* holder for _all_ ~entries~',
            author: guillaume            
        )
        root.save()

        def previous = root
        for (i in 1..5) {
            def entry = new TutorialEntry(
                title:      "1.$i Some Title",
                text:       'a very long text ' * i,
                author:      guillaume,
                predecessor: previous,
                parentEntry: root
            )
            entry.save()
            previous = entry
        }
     }

     Closure destroy = {
     }
} 