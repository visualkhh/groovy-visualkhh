def count = 0
def data  = []

def counter = { it << count }.asWritable()

def stanza = "content $counter is $data"    //#1

assert 'content 0 is []'  == stanza

count++
data << 1

assert 'content 1 is [1]' == stanza