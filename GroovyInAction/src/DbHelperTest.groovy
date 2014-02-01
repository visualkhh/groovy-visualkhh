helper = new DbHelper()
athleteDAO = new AthleteDAO(db: helper.db)
runDAO     = new RunDAO(db: helper.db)

def init() {
    helper.executeDdl(
        'Athlete',
        [firstname:   'VARCHAR(64)',
         lastname:    'VARCHAR(64)',
         dateOfBirth: 'DATE']
    )
    helper.executeDdl(
        'Run',
        [distance:   'INTEGER',    // in meters
         time:       'INTEGER',    // in seconds
         venue:      'VARCHAR(64)',
         when:       'TIMESTAMP'],
        'Athlete'
    )
    athleteDAO.create('Paul',   'Tergat',     '1969-06-17')
    athleteDAO.create('Khalid', 'Khannouchi', '1971-12-22')
}
def exit() { System.exit(0) }
def createAthlete(firstname, lastname, birth='1900-01-01') {
    athleteDAO.create(firstname, lastname, birth)
    readAthlete()
}
def readAthlete() {
    println 'Athletes: '
    println 'id firstname  lastname     dateOfBirth'
    athleteDAO.listAll().each { athlete ->
        println athlete.athleteId +': ' +
            athlete.firstname.padRight(10) + ' ' +
            athlete.lastname.padRight(12)  + ' ' +
            athlete.dateOfBirth
    }
}
def updateAthlete(id, field, newValue){
    def count = athleteDAO.update(field, newValue, id)
    println count +' row(s) updated'
    readAthlete()
}
def deleteAthlete(id) {
    athleteDAO.delete(*id)
    readAthlete()
}
def mainLoop() {
    while(true) {
        println '(create|read|update|delete)(Athlete|Run) or exit'
        def input = System.in.readLine().tokenize()
        def method = input.remove(0)
        invokeMethod(method, input)
    }
}

init()
readAthlete()
mainLoop()






/*
    athleteDAO.create('Ronaldo', 'da Costa', '1970-06-07')
    insertRun(2,4,55, 'Berlin',  '2003-09-28', 'Tergat')
    insertRun(2,5,38, 'London',  '2002-04-14', 'Khannouchi')
    insertRun(2,5,42, 'Chicago', '1999-10-24', 'Khannouchi')
    insertRun(2,6,05, 'Berlin',  '1998-09-20', 'da Costa')

*/