twister = 'she sells sea shells at the sea shore of seychelles'

// twister s로 시작하고 a로 끝나는 단어가 세개 있다. 검색연산자
assert twister =~ /s.a/                                        //#1

finder = (twister =~ /s.a/)                                    //|#2
assert finder instanceof java.util.regex.Matcher               //|#2


// twister 의 단어들 사이에는 공백이 한칸씩만 있다.  일치연산자
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
