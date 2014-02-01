class Weekday implements Comparable {
    static final DAYS = [
        'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'
    ]
	def day=null;
    private int index = 0    
    Weekday(String day){                                //#1
		this.day = day;
        index = DAYS.indexOf(day)
    }    
    Weekday next(){
		println(this.day+"  next (${DAYS[(index)]})   next (${DAYS[(index+1)]})");
        return new Weekday(DAYS[(index+1) % DAYS.size()])
    }    
    Weekday previous(){
    	println(this.day+" previous (${DAYS[(index-1)]})");
        return new Weekday(DAYS[index-1])               //#2
    }
    int compareTo(Object other){
    	println(this.day+" compareTo ${DAYS[(index)]}   ${this.index}, ${other.index} ${this.index <=> other.index} ");
        return this.index <=> other.index
    }
    String toString(){
    	println(this.day+" toString");
        return DAYS[index]
    }
}

def mon = new Weekday('Mon')
def fri = new Weekday('Fri')

def worklog = ''
//for (day in fri..mon){                                  //#3
for (day in mon..fri){                                  //#3
	println("-------in------")
    worklog += day.toString() + ' '
}
println worklog;
assert worklog == 'Mon Tue Wed Thu Fri '