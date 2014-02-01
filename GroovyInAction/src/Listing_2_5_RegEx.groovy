assert '12345' =~ /\d+/

assert 'xxxxx' == '12345'.replaceAll(/\d/, 'x')