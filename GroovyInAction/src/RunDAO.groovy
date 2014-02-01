class RunDAO extends DataAccessObject {

    def create(distance, time, venue, when, fkAthlete) {
        dataSet().add(
            distance:    distance,
            time:        time,
            venue:       venue,
            when:        when,
            fkAthlete:   fkAthlete
        )
    }
}