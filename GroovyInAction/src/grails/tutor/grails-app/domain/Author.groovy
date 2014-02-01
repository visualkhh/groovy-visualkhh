class Author { 
	Long id; 
	Long version;
	 
	String name

	def constraints = {
          name(length:5..15, blank:false, unique:true)
    }
	
	String toString() { name }
}	