command     = 'cmd /c dir /T:C Listing* | find ":" | sort /+10'
line        = command.execute().in.readLine()

//assert line =~ /00:06 .* Listing_7_3_MarkupBuilderLogic/
// xxx whatever this will finally be...
println 'earliest file so far: '
println line