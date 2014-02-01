class Visit { 
	Long id; 
	Long version; 
	
	User          user  = new User()
	TutorialEntry entry = new TutorialEntry()
	
	String toString() { user.toString() + ' : ' + entry.toString() }
}	
