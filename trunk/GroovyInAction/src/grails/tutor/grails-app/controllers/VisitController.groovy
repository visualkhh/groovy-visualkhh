
class VisitController {
    def index = { redirect(action:list,params:params) }

    def list = {
        if(!params['max']) params['max'] = 10
        [ visitList: Visit.list( params ) ]
    }

    def show = {
        [ visit : Visit.get( params['id'] ) ]
    }

    def delete = {
        def visit = Visit.get( params['id'] )
        if(visit) {
            visit.delete()
            flash['message'] = "Visit ${params['id']} deleted."
            redirect(action:list)
        }
        else {
            flash['message'] = "Visit not found with id ${params['id']}"
            redirect(action:list)
        }
    }

    def edit = {
        def visit = Visit.get( params['id'] )

        if(!visit) {
                flash['message'] = "Visit not found with id ${params['id']}"
                redirect(action:list)
        }
        else {
            return [ visit : visit ]
        }
    }

    def update = {
        def visit = Visit.get( params['id'] )
        if(visit) {
             visit.properties = params
            if(visit.save()) {
                redirect(action:show,id:visit.id)
            }
            else {
                render(view:'edit',model:[visit:visit])
            }
        }
        else {
            flash['message'] = "Visit not found with id ${params['id']}"
            redirect(action:edit,id:params['id'])
        }
    }

    def create = {
        def visit = new Visit()
        visit.properties = params
        return ['visit':visit]
    }

    def save = {
        def visit = new Visit()
        visit.properties = params
        if(visit.save()) {
            redirect(action:show,id:visit.id)
        }
        else {
            render(view:'create',model:[visit:visit])
        }
    }

}