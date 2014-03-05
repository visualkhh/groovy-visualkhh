package projecttracker

class Project {
   String name
    String description
    Date dueDate
    static belongsTo = [owner : EndUser]
    static hasMany = [tasks : Task]
 
    static constraints = {
    }
}
