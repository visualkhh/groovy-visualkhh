import groovy.mock.interceptor.StubFor

def relay(request) {
    new Farm().getMachines().sort { it.load }[0].send(request)
}

def fakeOne = new Expando(load:10, send: { false } )
def fakeTwo = new Expando(load:5,  send: { true }  )

def farmStub = new StubFor(Farm)                        //#1
farmStub.demand.getMachines { [fakeOne, fakeTwo ] }     //#2

farmStub.use {                                          //#|3
    assert relay(null)                                  //#|3
}                                                       //#|3
