class TutorialEntry {
	Long id; 
	Long version;
		
    String        title
    TutorialEntry parentEntry  // = null issue
    TutorialEntry predecessor  // = null issue
    String        text
    Author        author       = new Author()

    def constraints = {
        title( blank:false, unique:true) // matches: /\d(\.\d+)*\s+.*/
    }

    String toString() { title }

    boolean visitedBy (User user) {
        if (!user) return false
        return null != Visit.findByEntryAndUser(this, user)
    }

}	