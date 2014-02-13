package _C5

homedir = new File('src');
println homedir;
println homedir.name;
println homedir.absolutePath;
println homedir.canonicalPath;
println homedir.directory;



//homedir = new File('/java/groovy')
dirs = []
homedir.eachDir{dirs << it.name }             //#1	//디렉터리이름 기록 클로저
println dirs

cvsdir = new File('./img')
files = []
cvsdir.eachFile{files << it.name}             //#2	//파일이름 기록 클로져
println files;

files = []
cvsdir.eachFileMatch(~/swing.*/){files << it.name}  //#3	//패턴과 일치하는 파일 이름 기록 클로저
println files;

docsdir = new File('src');
count = 0
files = []
docsdir.eachFileRecurse{if (it.directory){files<<it; count++}}   //#4 재귀적으로 디렉터리를 세는 클로저
println files;

/*결과
src
src
W:\code.google\groovy-visualkhh\groovy_study\src
W:\code.google\groovy-visualkhh\groovy_study\src
true
[.svn, _1, _10, _14, _16, _17, _18, _19, _2, _20, _21, _22, _23, _24, _25, _26, _27, _3, _4, _5, _6, _7, _8, _9, _B1, _B10, _B2, _B3, _B4, _B5, _B6, _B7, _B8, _B9, _C1, _C2, _C3, _C4, _C5]
[GroovyHelper.jpg, GroovyInterceptable.jpg, GroovyObject.jpg, GroovyObject_UML.jpg, invokeMethod.jpg, metaDia.jpg, nodebuilder_d.jpg, swing_b_layout.jpg, swing_b_pwd.jpg, swing_b_s.jpg]
[swing_b_layout.jpg, swing_b_pwd.jpg, swing_b_s.jpg]
[src\.svn, src\.svn\prop-base, src\.svn\props, src\.svn\text-base, src\.svn\tmp, src\.svn\tmp\prop-base, src\.svn\tmp\props, src\.svn\tmp\text-base, src\_1, src\_1\.svn, src\_1\.svn\prop-base, src\_1\.svn\props, src\_1\.svn\text-base, src\_1\.svn\tmp, src\_1\.svn\tmp\prop-base, src\_1\.svn\tmp\props, src\_1\.svn\tmp\text-base, src\_10, src\_10\.svn, src\_10\.svn\prop-base, src\_10\.svn\props, src\_10\.svn\text-base, src\_10\.svn\tmp, src\_10\.svn\tmp\prop-base, src\_10\.svn\tmp\props, src\_10\.svn\tmp\text-base, src\_14, src\_14\.svn, src\_14\.svn\prop-base, src\_14\.svn\props, src\_14\.svn\text-base, src\_14\.svn\tmp, src\_14\.svn\tmp\prop-base, src\_14\.svn\tmp\props, src\_14\.svn\tmp\text-base, src\_14\oldpack, src\_14\oldpack\.svn, src\_14\oldpack\.svn\prop-base, src\_14\oldpack\.svn\props, src\_14\oldpack\.svn\text-base, src\_14\oldpack\.svn\tmp, src\_14\oldpack\.svn\tmp\prop-base, src\_14\oldpack\.svn\tmp\props, src\_14\oldpack\.svn\tmp\text-base, src\_16, src\_16\.svn, src\_16\.svn\prop-base, src\_16\.svn\props, src\_16\.svn\text-base, src\_16\.svn\tmp, src\_16\.svn\tmp\prop-base, src\_16\.svn\tmp\props, src\_16\.svn\tmp\text-base, src\_17, src\_17\.svn, src\_17\.svn\prop-base, src\_17\.svn\props, src\_17\.svn\text-base, src\_17\.svn\tmp, src\_17\.svn\tmp\prop-base, src\_17\.svn\tmp\props, src\_17\.svn\tmp\text-base, src\_18, src\_18\.svn, src\_18\.svn\prop-base, src\_18\.svn\props, src\_18\.svn\text-base, src\_18\.svn\tmp, src\_18\.svn\tmp\prop-base, src\_18\.svn\tmp\props, src\_18\.svn\tmp\text-base, src\_19, src\_19\.svn, src\_19\.svn\prop-base, src\_19\.svn\props, src\_19\.svn\text-base, src\_19\.svn\tmp, src\_19\.svn\tmp\prop-base, src\_19\.svn\tmp\props, src\_19\.svn\tmp\text-base, src\_2, src\_2\.svn, src\_2\.svn\prop-base, src\_2\.svn\props, src\_2\.svn\text-base, src\_2\.svn\tmp, src\_2\.svn\tmp\prop-base, src\_2\.svn\tmp\props, src\_2\.svn\tmp\text-base, src\_2\sub, src\_2\sub\.svn, src\_2\sub\.svn\prop-base, src\_2\sub\.svn\props, src\_2\sub\.svn\text-base, src\_2\sub\.svn\tmp, src\_2\sub\.svn\tmp\prop-base, src\_2\sub\.svn\tmp\props, src\_2\sub\.svn\tmp\text-base, src\_20, src\_20\.svn, src\_20\.svn\prop-base, src\_20\.svn\props, src\_20\.svn\text-base, src\_20\.svn\tmp, src\_20\.svn\tmp\prop-base, src\_20\.svn\tmp\props, src\_20\.svn\tmp\text-base, src\_21, src\_21\.svn, src\_21\.svn\prop-base, src\_21\.svn\props, src\_21\.svn\text-base, src\_21\.svn\tmp, src\_21\.svn\tmp\prop-base, src\_21\.svn\tmp\props, src\_21\.svn\tmp\text-base, src\_22, src\_22\.svn, src\_22\.svn\prop-base, src\_22\.svn\props, src\_22\.svn\text-base, src\_22\.svn\tmp, src\_22\.svn\tmp\prop-base, src\_22\.svn\tmp\props, src\_22\.svn\tmp\text-base, src\_23, src\_23\.svn, src\_23\.svn\prop-base, src\_23\.svn\props, src\_23\.svn\text-base, src\_23\.svn\tmp, src\_23\.svn\tmp\prop-base, src\_23\.svn\tmp\props, src\_23\.svn\tmp\text-base, src\_24, src\_24\.svn, src\_24\.svn\prop-base, src\_24\.svn\props, src\_24\.svn\text-base, src\_24\.svn\tmp, src\_24\.svn\tmp\prop-base, src\_24\.svn\tmp\props, src\_24\.svn\tmp\text-base, src\_25, src\_25\.svn, src\_25\.svn\prop-base, src\_25\.svn\props, src\_25\.svn\text-base, src\_25\.svn\tmp, src\_25\.svn\tmp\prop-base, src\_25\.svn\tmp\props, src\_25\.svn\tmp\text-base, src\_26, src\_26\.svn, src\_26\.svn\prop-base, src\_26\.svn\props, src\_26\.svn\text-base, src\_26\.svn\tmp, src\_26\.svn\tmp\prop-base, src\_26\.svn\tmp\props, src\_26\.svn\tmp\text-base, src\_27, src\_27\.svn, src\_27\.svn\prop-base, src\_27\.svn\props, src\_27\.svn\text-base, src\_27\.svn\tmp, src\_27\.svn\tmp\prop-base, src\_27\.svn\tmp\props, src\_27\.svn\tmp\text-base, src\_3, src\_3\.svn, src\_3\.svn\prop-base, src\_3\.svn\props, src\_3\.svn\text-base, src\_3\.svn\tmp, src\_3\.svn\tmp\prop-base, src\_3\.svn\tmp\props, src\_3\.svn\tmp\text-base, src\_4, src\_4\.svn, src\_4\.svn\prop-base, src\_4\.svn\props, src\_4\.svn\text-base, src\_4\.svn\tmp, src\_4\.svn\tmp\prop-base, src\_4\.svn\tmp\props, src\_4\.svn\tmp\text-base, src\_5, src\_5\.svn, src\_5\.svn\prop-base, src\_5\.svn\props, src\_5\.svn\text-base, src\_5\.svn\tmp, src\_5\.svn\tmp\prop-base, src\_5\.svn\tmp\props, src\_5\.svn\tmp\text-base, src\_6, src\_6\.svn, src\_6\.svn\prop-base, src\_6\.svn\props, src\_6\.svn\text-base, src\_6\.svn\tmp, src\_6\.svn\tmp\prop-base, src\_6\.svn\tmp\props, src\_6\.svn\tmp\text-base, src\_7, src\_7\.svn, src\_7\.svn\prop-base, src\_7\.svn\props, src\_7\.svn\text-base, src\_7\.svn\tmp, src\_7\.svn\tmp\prop-base, src\_7\.svn\tmp\props, src\_7\.svn\tmp\text-base, src\_8, src\_8\.svn, src\_8\.svn\prop-base, src\_8\.svn\props, src\_8\.svn\text-base, src\_8\.svn\tmp, src\_8\.svn\tmp\prop-base, src\_8\.svn\tmp\props, src\_8\.svn\tmp\text-base, src\_9, src\_9\.svn, src\_9\.svn\prop-base, src\_9\.svn\props, src\_9\.svn\text-base, src\_9\.svn\tmp, src\_9\.svn\tmp\prop-base, src\_9\.svn\tmp\props, src\_9\.svn\tmp\text-base, src\_B1, src\_B1\.svn, src\_B1\.svn\prop-base, src\_B1\.svn\props, src\_B1\.svn\text-base, src\_B1\.svn\tmp, src\_B1\.svn\tmp\prop-base, src\_B1\.svn\tmp\props, src\_B1\.svn\tmp\text-base, src\_B10, src\_B10\.svn, src\_B10\.svn\prop-base, src\_B10\.svn\props, src\_B10\.svn\text-base, src\_B10\.svn\tmp, src\_B10\.svn\tmp\prop-base, src\_B10\.svn\tmp\props, src\_B10\.svn\tmp\text-base, src\_B2, src\_B2\.svn, src\_B2\.svn\prop-base, src\_B2\.svn\props, src\_B2\.svn\text-base, src\_B2\.svn\tmp, src\_B2\.svn\tmp\prop-base, src\_B2\.svn\tmp\props, src\_B2\.svn\tmp\text-base, src\_B3, src\_B3\.svn, src\_B3\.svn\prop-base, src\_B3\.svn\props, src\_B3\.svn\text-base, src\_B3\.svn\tmp, src\_B3\.svn\tmp\prop-base, src\_B3\.svn\tmp\props, src\_B3\.svn\tmp\text-base, src\_B4, src\_B4\.svn, src\_B4\.svn\prop-base, src\_B4\.svn\props, src\_B4\.svn\text-base, src\_B4\.svn\tmp, src\_B4\.svn\tmp\prop-base, src\_B4\.svn\tmp\props, src\_B4\.svn\tmp\text-base, src\_B5, src\_B5\.svn, src\_B5\.svn\prop-base, src\_B5\.svn\props, src\_B5\.svn\text-base, src\_B5\.svn\tmp, src\_B5\.svn\tmp\prop-base, src\_B5\.svn\tmp\props, src\_B5\.svn\tmp\text-base, src\_B6, src\_B6\.svn, src\_B6\.svn\prop-base, src\_B6\.svn\props, src\_B6\.svn\text-base, src\_B6\.svn\tmp, src\_B6\.svn\tmp\prop-base, src\_B6\.svn\tmp\props, src\_B6\.svn\tmp\text-base, src\_B7, src\_B7\.svn, src\_B7\.svn\prop-base, src\_B7\.svn\props, src\_B7\.svn\text-base, src\_B7\.svn\tmp, src\_B7\.svn\tmp\prop-base, src\_B7\.svn\tmp\props, src\_B7\.svn\tmp\text-base, src\_B8, src\_B8\.svn, src\_B8\.svn\prop-base, src\_B8\.svn\props, src\_B8\.svn\text-base, src\_B8\.svn\tmp, src\_B8\.svn\tmp\prop-base, src\_B8\.svn\tmp\props, src\_B8\.svn\tmp\text-base, src\_B9, src\_B9\.svn, src\_B9\.svn\prop-base, src\_B9\.svn\props, src\_B9\.svn\text-base, src\_B9\.svn\tmp, src\_B9\.svn\tmp\prop-base, src\_B9\.svn\tmp\props, src\_B9\.svn\tmp\text-base, src\_C1, src\_C2, src\_C3, src\_C4, src\_C5]

*/