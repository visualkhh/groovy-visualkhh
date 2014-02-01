def cli = new CliBuilder( usage: 'groovy Mailman -sft[mh] "text"' )

cli.h(longOpt: 'help', 'usage information')
cli.s(argName:'host',    longOpt:'smtp',   args: 1, required: true,
    'smtp host name')
cli.f(argName:'address', longOpt:'from',   args: 1, required: true,
    'from mail address (like me@home.com)')
cli.t(argName:'address', longOpt:'to',     args: 1, required: true,
    'to address (like you@home.com)')
cli.m(argName:'matter', longOpt:'subject', args: 1,
    'subject matter (default: no subject)')

def opt = cli.parse(args)
if (!opt)  return                           //#1
if (opt.h) cli.usage()

def ant = new AntBuilder()
def subj = (opt.matter) ? opt.matter : 'no subject'
ant.mail(mailhost: opt.host, subject: subj) {
    from(address: opt.f)
    to  (address: opt.t)
    message( opt.arguments().join(' '))
}