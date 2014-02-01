class PersonDAO {
    String findAll() {
        'SELECT * FROM Person'
    }
    String findByLastname(name) {
        findAll() + " WHERE p.lastname = '$name'"
    }
    String findByMaximum(attribute) {
        findAll() + " WHERE $attribute = " +
        "SELECT maximum($attribute) FROM Person"
    }
}
dao = new PersonDAO()

action = 'findAll'  // some external input
params = [] as Object[]
assert dao.invokeMethod(action, params) == 'SELECT * FROM Person'