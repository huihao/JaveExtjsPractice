Ext.define('AM.view.article.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.articlelist',
    
    requires: [ 'Ext.toolbar.Toolbar'],
    border: false,
    title : 'All Artices',
    initComponent: function() {
        Ext.apply(this, {
            store: 'Articles',

            columns: [
                      {header: 'Title',  dataIndex: 'title',  flex: 1},
                      {header: 'Content', dataIndex: 'content', flex: 1},
                      {header: 'Id', dataIndex: 'id', flex: 1}
                  ],
            dockedItems:[{
                xtype: 'toolbar',
                dock: 'top',
                items: [{
                    text: 'Add',
                    action: 'add'
                }]
            }],
            tbar :[  
                   {xtype:'button',text:'add',id:'add'},  
                   {xtype:'button',id:'delete',text:'delete'},  
                   {xtype:'button',text:'edit'},  
            ]
        });

        this.callParent(arguments);
    },
    
});
