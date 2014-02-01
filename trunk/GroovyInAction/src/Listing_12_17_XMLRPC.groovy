// requires groovy-xmlrpc-0.3.jar in classpath
import groovy.net.xmlrpc.XMLRPCServerProxy as Proxy
import groovy.net.xmlrpc.XMLRPCServer as Server
import java.net.ServerSocket

def server = new Server()
server.echo = { return it }

def socket = new ServerSocket(8080)
server.startServer(socket)

remote = new Proxy("http://localhost:8080/")         //|#1
assert 'Hello world!' == remote.echo('Hello world!') //|#1

server.stopServer()