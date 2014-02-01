import groovy.swing.SwingBuilder
import javax.swing.*

key     = 'YOUR-KEY-HERE'
counter = 1

def updateButton(button) {
    counter++
    def apiUrl = "http://www.flickr.com/services/rest/?" +
       "method=flickr.interestingness.getList&per_page=1&" +
       "page=$counter&api_key=$key"
    def rsp      = new XmlParser().parse(apiUrl)
    def photo    = rsp.photos.photo[0]
    def imageUrl = "http://static.flickr.com/" + 
       "${photo.'@server'}/${photo.'@id'}_${photo.'@secret'}_m.jpg"
    button.icon = new ImageIcon(imageUrl.toURL())
    button.text = photo.'@title'
    return button
}

def frame = new SwingBuilder().frame(
        title: 'Groovy Flickr Viewer',
        defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {
    updateButton( button (
        horizontalTextPosition: SwingConstants.CENTER,
        verticalTextPosition:   SwingConstants.BOTTOM,
        actionPerformed:      { updateButton(it.source) }
    ))
}
frame.pack()                               
frame.show()