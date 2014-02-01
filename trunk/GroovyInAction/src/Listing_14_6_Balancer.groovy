import junit.framework.Assert;

def relay(request, farm) {                              //#|1
    farm.machines.sort { it.load }[0].send(request)     //#|1
}                                                       //#|1

class FakeMachine {                                     //#2
    def load
    def send(request) { return this }
}

final LOW_LOAD = 5, HIGH_LOAD = 10
def farm = [machines: [                                 //#|3
    new FakeMachine(load:HIGH_LOAD),                    //#|3
    new FakeMachine(load:LOW_LOAD)]]                    //#|3

Assert.assertSame(LOW_LOAD, relay(null, farm).load)
