homedir = new File('/java/groovy')
dirs = []
homedir.eachDir{dirs << it.name }             //#1
assert ['bin','conf','docs','embeddable','lib'] == dirs

cvsdir = new File('/cygwin/home/dierk/groovy')
files = []
cvsdir.eachFile{files << it.name}             //#2
assert files.contains('.cvsignore')
assert files.contains('CVS')

files = []
cvsdir.eachFileMatch(~/groovy.*/){files << it.name}  //#3
assert ['groovy-core', 'groovy-native'] == files

docsdir = new File('/java/groovy/docs')
count = 0
docsdir.eachFileRecurse{if (it.directory) count++}   //#4
assert 104 == count
