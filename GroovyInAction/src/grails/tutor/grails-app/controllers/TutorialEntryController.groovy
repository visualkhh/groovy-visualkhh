
class TutorialEntryController {
    def index = { redirect(action:list, params:params) }

    def previous = {
        def entry = TutorialEntry.get( params.id )
        // if (entry != entry.predecessor) {
        if (entry.predecessor) {
            entry = entry.predecessor
        }  else {
            flash.message = "Top of tutorials reached."
        }
        redirect(action: show, id: entry.id)
    }

    def next = {
        def entry = TutorialEntry.get( params.id )
        def nextEntry = TutorialEntry.findByPredecessor(entry)
        // if (entry != nextEntry) {
        if (nextEntry) {
            entry = nextEntry
        } else {
            flash.message = "End of tutorials reached."
        }
        redirect(action: show, id: entry.id)
    }

    def visited = {
        def entry = TutorialEntry.get( params.id )
        if (entry && session.user) {
            new Visit(entry: entry, user: session.user).save()
            // some logging here ?
        }
        redirect(action: next, id: entry.id)
    }

    def listVisited = {
        def visited = Visit.findAllByUser(session.user).entry
        render(view:'list', model:[ tutorialEntryList: visited ])
    }

    def listUnVisited = {
        def unvisited = TutorialEntry.list() - Visit.findAllByUser(session.user).entry
        render(view:'list', model:[ tutorialEntryList: unvisited ])
    }

    def list = {
        if(!params['max']) params['max'] = 10
        [ tutorialEntryList: TutorialEntry.list( params ) ]
    }

    def show = {
        [ tutorialEntry : TutorialEntry.get( params['id'] ) ]
    }

    def delete = {
        def tutorialEntry = TutorialEntry.get( params['id'] )
        if(tutorialEntry) {
            tutorialEntry.delete()
            flash['message'] = "TutorialEntry ${params['id']} deleted."
            redirect(action:list)
        }
        else {
            flash['message'] = "TutorialEntry not found with id ${params['id']}"
            redirect(action:list)
        }
    }

    def edit = {
        def tutorialEntry = TutorialEntry.get( params['id'] )

        if(!tutorialEntry) {
                flash['message'] = "TutorialEntry not found with id ${params['id']}"
                redirect(action:list)
        }
        else {
            return [ tutorialEntry : tutorialEntry ]
        }
    }

    def update = {
        def tutorialEntry = TutorialEntry.get( params['id'] )
        if(tutorialEntry) {
             tutorialEntry.properties = params
            if(tutorialEntry.save()) {
                redirect(action:show,id:tutorialEntry.id)
            }
            else {
                render(view:'edit',model:[tutorialEntry:tutorialEntry])
            }
        }
        else {
            flash['message'] = "TutorialEntry not found with id ${params['id']}"
            redirect(action:edit,id:params['id'])
        }
    }

    def create = {
        def tutorialEntry = new TutorialEntry()
        tutorialEntry.properties = params
        return ['tutorialEntry':tutorialEntry]
    }

    def save = {
        def tutorialEntry = new TutorialEntry()
        tutorialEntry.properties = params
        if(tutorialEntry.save()) {
            redirect(action:show,id:tutorialEntry.id)
        }
        else {
            render(view:'create',model:[tutorialEntry:tutorialEntry])
        }
    }

}