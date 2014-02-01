class PersonDAO {
    public findAll = {
        'SELECT * FROM Person'
    }
    // more finder methods as Closure fields ...
}
dao = new PersonDAO()

action = 'findAll'  // some external input
params = []
assert dao[action](*params) == 'SELECT * FROM Person'