twister = 'she sells sea shells at the sea shore of seychelles'

// twister s�� �����ϰ� a�� ������ �ܾ ���� �ִ�. �˻�������
assert twister =~ /s.a/                                        //#1

finder = (twister =~ /s.a/)                                    //|#2
assert finder instanceof java.util.regex.Matcher               //|#2


// twister �� �ܾ�� ���̿��� ������ ��ĭ���� �ִ�.  ��ġ������
assert twister ==~ /(\w+ \w+)*/                                //#3

WORD = /\w+/
matches = (twister ==~ /($WORD $WORD)*/)                       //|#4
assert matches instanceof java.lang.Boolean                    //|#4

assert (twister ==~ /s.e/) == false                            //#5

wordsByX = twister.replaceAll(WORD, 'x')
assert wordsByX == 'x x x x x x x x x x'

words = twister.split(/ /)                                     //#6
assert words.size() == 10
assert words[0] == 'she'
