def cli = new CliBuilder(usage:'groovy Echo [option]*')
cli.h(longOpt: 'help', 'usage information')
cli.f(required:true, args: 1, optionalArg:false,
    longOpt: 'file', 'file')

def cmd = cli.cmd(args)
if (cmd.h) cli.help()

println new File(cmd.file).text
