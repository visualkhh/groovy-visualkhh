package _B5

def TARGET_DIR ='target'
def CHAPTERS_DIR='chapters'
def ant = new AntBuilder();
ant.delete(dir:TARGET_DIR);
ant.copy(todir:TARGET_DIR){
	fileset(dir:CHAPTERS_DIR,includes:'*.doc',excludes:'~*')
};
/*ant
<project name="prepareBookDirs" default="copy">

  <property name="target.dir"   value="target"/>  
  <property name="chapters.dir" value="chapters"/>
  
  <target name="copy">
    <delete dir="${target.dir}" />
    <copy todir="${target.dir}">
      <fileset dir="${chapters.dir}" 
        includes="*.doc" 
        excludes="~*"   />
    </copy>
  </target>
</project>
*/