package projecttracker

class Task {
	String name
	String description
	Date dueDate
	static belongsTo = [assignee : EndUser, project : Project]
 
	static constraints = {
    }
}
