def workDays    = Calendar.MONDAY..Calendar.FRIDAY
def officeHours = 8..18

while(true) {
    def now = new Date()
    if (
        workDays.contains(now.day)      &&
        officeHours.contains(now.hours) &&
        0 == now.minutes % 10
    ) {
        println "execution called at ${now.toGMTString()}"
        // call execution here
        sleep 31 * 1000
    }
    sleep 31 * 1000
}