import java.lang.reflect.Modifier
import org.codehaus.groovy.runtime.DefaultGroovyMethods

def methods = DefaultGroovyMethods.declaredMethods

methods = methods.grep {Modifier.isPublic(it.modifiers)}
methods = methods.grep {it.parameterTypes.size() > 0}
def map = new TreeMap()
for (m in methods) { 
    def key = m.parameterTypes[0].name
    map[key] = map.get(key,[]) << m 
}

map.each { objName, methodDefs ->
    println objName.center(40,'-')
    methodDefs.sort{it.name}.each{method ->
        def params = method.parameterTypes.toList()
        params.remove(0)
        println "${method.name}\t$params\t:\t${method.returnType}"
    }
}