import groovy.mock.interceptor.MockFor

class SortableFarm extends Farm {
    void sort() {
        /* here the Farm would sort it's machines by load */
    }
}

def relay(request) {
    def farm = new SortableFarm()
    farm.sort()
    farm.getMachines()[0].send(request)
}

def farmMock = new MockFor(SortableFarm)                    //#1

farmMock.demand.sort(){}                                    //#|2
farmMock.demand.getMachines { [new Expando(send: {} )] }    //#|2

farmMock.use {
    relay(null)
}