def store = ''
10.times{                       //#1  �ݺ� 10��
    store += 'x'
}
assert store == 'xxxxxxxxxx'

store = ''
1.upto(5) { number ->           //#2  1���� 5���� 1���� ����
	print (number+' ');
    store += number
}
assert store == '12345'
println '';
println (store);

store = ''
2.downto(-2) { number ->        //#3 2���� -2 ���� 1���� ����
print (number+' ');
    store += number + ' '
}
assert store == '2 1 0 -1 -2 '
println '';
println (store);

store = ''
0.step(0.5, 0.1 ){ number ->    //#4  0���� 
print (number+' ');
    store += number + ' '
}
assert store == '0 0.1 0.2 0.3 0.4 '
println '';
println (store);