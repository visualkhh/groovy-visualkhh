class AthleteApplication {
    def helper     = new DbHelper()
    def athleteDAO = new AthleteDAO(db: helper.db)
    def sortBy     = 'athleteId'

    def init() {
        helper.executeDdl(athleteDAO)
    }
    def exit() { System.exit(0) }
    def sort(field) {
        sortBy = field.join(',')
        list()
    }
    def create(List args) {
        athleteDAO.create(args)
        list()
    }
    def list() {
        def athletes = athleteDAO.all(sortBy)
        println athletes.size() + ' Athlete(s) in DB: '
        println 'id firstname  lastname     dateOfBirth'
        athletes.each { athlete ->
            println athlete.athleteId +': ' +
                athlete.firstname.padRight(10) + ' ' +
                athlete.lastname.padRight(12)  + ' ' +
                athlete.dateOfBirth
        }
    }
    def update(id, field, newValue){
        def count = athleteDAO.update(field, newValue, id)
        println count +' row(s) updated'
        list()
    }
    def delete(id) {
        def count = athleteDAO.delete(*id)
        println count +' row(s) deleted'
        list()
    }
    def mainLoop() {
        while(true) {
            println 'commands: create list update delete sort exit'
            def input = System.in.readLine().tokenize()
            def method = input.remove(0)
            invokeMethod(method, input)
        }
    }
}
app = new AthleteApplication()
app.init()
app.mainLoop()