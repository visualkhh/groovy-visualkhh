log = ''
(1..10).each({ log += it })
assert log == '12345678910'