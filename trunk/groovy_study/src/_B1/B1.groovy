package _B1

import groovy.xml.*;
def builder = new MarkupBuilder();	//마크업빌더
builder.numbers{
	description 'sss';
	for(i in 10..15){
		number (value : i,square:i*i){
			for(j in 2..<i){
				if(i%j==0){
					factor(value:j);
				}
			}
		}
	}
}

println builder;
/*결과
<numbers>
  <description>sss</description>
  <number value='10' square='100'>
    <factor value='2' />
    <factor value='5' />
  </number>
  <number value='11' square='121' />
  <number value='12' square='144'>
    <factor value='2' />
    <factor value='3' />
    <factor value='4' />
    <factor value='6' />
  </number>
  <number value='13' square='169' />
  <number value='14' square='196'>
    <factor value='2' />
    <factor value='7' />
  </number>
  <number value='15' square='225'>
    <factor value='3' />
    <factor value='5' />
  </number>
</numbers>groovy.xml.MarkupBuilder@11bed71
*/