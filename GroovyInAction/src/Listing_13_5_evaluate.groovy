def prefs = evaluate(new File('Preferences.groovy'))

assert prefs.'@name' == 'Dierk'
assert prefs.workingHour*.value().contains(16)