loader = this.getClass().getClassLoader()

while (loader && !(loader instanceof org.codehaus.groovy.tools.RootLoader)) {
    println loader.class.name
    loader = loader.getParent()
}

// groovy -e "println this.class.classLoader.rootLoader.URLs.inspect()"