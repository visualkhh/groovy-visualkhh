import groovy.xml.Namespace

def url = 'http://rollerweblogger.org/atom/roller?catname=/Java'

def atom   = new Namespace('http://www.w3.org/2005/Atom')
def titles = new XmlParser().parse(url)[atom.entry][atom.title]

println titles*.text().join("\n")