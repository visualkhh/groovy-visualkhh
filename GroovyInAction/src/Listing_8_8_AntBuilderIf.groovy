ant = new AntBuilder()
if ( ! System.properties.'java.version'.contains('1.4')) {
    ant.fail 'This build script requires JDK 1.4.x'
} 
// further action