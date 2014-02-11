package _B9
import groovy.util.BuilderSupport;

class MyBuilder extends BuilderSupport{
	protected def createNode( name) {
		println "createNode-> name : ${name}";
	}
	
	protected def createNode( name, Map attributes) {
		println "createNode-> name : ${name},  attributes : ${attributes}";
	}
	
	protected def createNode( name, Map attributes,  value) {
		println "createNode-> name : ${name},  attributes : ${attributes},  value : ${value}";
	}
	
	protected def createNode( name,  value) {
		println "createNode-> name : ${name},  value : ${value}";
	}
	protected void setParent( name,  child) {
		println "setParent-> name : ${name},  value : ${child}";
	}
	protected void nodeCompleted( parent,  node) {
		println "nodeCompleted-> name : ${parent},  value : ${node}";
	}
}

def builder = new MyBuilder();
builder.foo(){	//builder.createNode('foo') 호출	 ,  최상위이므로 setParent()는 없다
	
	
	bar(a:1); 
	//bar = bulder.createNode('bar',[a:1]);
	//builder.setParent(foo,bar);
	//bar는 처리할 클로저가 없다.
	//builder.nodeCompleted(foo,bar);
	//bulder.nodeCOmpleted(null,foo);
}

/* 결과
createNode-> name : foo
createNode-> name : bar,  attributes : [a:1]
nodeCompleted-> name : null,  value : null
nodeCompleted-> name : null,  value : null

*/