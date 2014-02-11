package _B7

import groovy.swing.SwingBuilder

swing = new SwingBuilder()
frame = swing.frame(title:'Demo',size:[600,20]) {
	menuBar {
        menu('File') {
            menuItem 'New' 
            menuItem 'Open'
        }
    }
    panel {
        label 'Label 1'
        slider()
        comboBox(items:['one','two','three'])
    }    
}
frame.pack()                               
frame.show()
