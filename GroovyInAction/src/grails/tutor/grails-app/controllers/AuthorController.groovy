
class AuthorController {
    def index = { redirect(action:list,params:params) }

    def list = {
        if(!params['max']) params['max'] = 10
        [ authorList: Author.list( params ) ]
    }

    def show = {
        [ author : Author.get( params['id'] ) ]
    }

    def delete = {
        def author = Author.get( params['id'] )
        if(author) {
            author.delete()
            flash['message'] = "Author ${params['id']} deleted."
            redirect(action:list)
        }
        else {
            flash['message'] = "Author not found with id ${params['id']}"
            redirect(action:list)
        }
    }

    def edit = {
        def author = Author.get( params['id'] )

        if(!author) {
                flash['message'] = "Author not found with id ${params['id']}"
                redirect(action:list)
        }
        else {
            return [ author : author ]
        }
    }

    def update = {
        def author = Author.get( params['id'] )
        if(author) {
             author.properties = params
            if(author.save()) {
                redirect(action:show,id:author.id)
            }
            else {
                render(view:'edit',model:[author:author])
            }
        }
        else {
            flash['message'] = "Author not found with id ${params['id']}"
            redirect(action:edit,id:params['id'])
        }
    }

    def create = {
        def author = new Author()
        author.properties = params
        return ['author':author]
    }

    def save = {
        def author = new Author()
        author.properties = params
        if(author.save()) {
            redirect(action:show,id:author.id)
        }
        else {
            render(view:'create',model:[author:author])
        }
    }

}