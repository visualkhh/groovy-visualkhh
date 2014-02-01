def loader = this.class.classLoader.rootLoader

def dir = new File('lib')
dir.eachFileMatch(~/.*\.jar$/) {
    loader.addURL(it.toURL())
}
evaluate(new File('StarWars.groovy'))