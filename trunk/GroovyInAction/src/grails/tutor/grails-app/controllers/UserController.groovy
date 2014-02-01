
class UserController {
    def index = { redirect(action:list,params:params) }

    def select = {
        def user = User.get( params['id'] )
        if(user) {
            session.user = user
            redirect(controller:'tutorialEntry', action:"list")
        } else {
            flash['message'] = "Sorry user ${params['id']} cannot be selected."
            redirect(action:show)
        }
    }

    def list = {
        if(!params['max']) params['max'] = 10
        [ userList: User.list( params ) ]
    }

    def show = {
        [ user : User.get( params['id'] ) ]
    }

    def delete = {
        def user = User.get( params['id'] )
        if(user) {
            user.delete()
            flash['message'] = "User ${params['id']} deleted."
            redirect(action:list)
        }
        else {
            flash['message'] = "User not found with id ${params['id']}"
            redirect(action:list)
        }
    }

    def edit = {
        def user = User.get( params['id'] )

        if(!user) {
                flash['message'] = "User not found with id ${params['id']}"
                redirect(action:list)
        }
        else {
            return [ user : user ]
        }
    }

    def update = {
        def user = User.get( params['id'] )
        if(user) {
             user.properties = params
            if(user.save()) {
                redirect(action:show,id:user.id)
            }
            else {
                render(view:'edit',model:[user:user])
            }
        }
        else {
            flash['message'] = "User not found with id ${params['id']}"
            redirect(action:edit,id:params['id'])
        }
    }

    def create = {
        def user = new User()
        user.properties = params
        return ['user':user]
    }

    def save = {
        def user = new User()
        user.properties = params
        if(user.save()) {
            redirect(action:show,id:user.id)
        }
        else {
            render(view:'create',model:[user:user])
        }
    }

}