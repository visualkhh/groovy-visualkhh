import groovy.swing.SwingBuilder

data = [
    [nick:'MrG',       full:'Guillaume Laforge'  ], 
    [nick:'jez',       full:'Jeremy Rayner'      ], 
    [nick:'fraz',      full:'Franck Rasolo'      ], 
    [nick:'sormuras',  full:'Christian Stein'    ], 
    [nick:'blackdrag', full:'Jochen Theodorou'   ], 
    [nick:'Mittie',    full:'Dierk Koenig'       ]
]

swing = new SwingBuilder()
frame = swing.frame(title:'Table Demo') {
  scrollPane {
    table() {
      tableModel(list:data) {
        propertyColumn(header:'Nickname', propertyName:'nick')
        propertyColumn(header:'Full Name',propertyName:'full')
      }
    }
  }    
}
frame.pack()                               
frame.show()