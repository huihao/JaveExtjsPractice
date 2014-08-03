Ext.define('AM.view.TabPanel',{
    extend: 'Ext.tab.Panel',
    alias:'widget.tabPanel',
    initComponent : function(){
        Ext.apply(this,{
            defaults: {
               autoScroll:true
            },
            activeTab: 0,
            border: false,
           //plain: true,
            items: [{
              id: 'HomePage',
              title: 'Home',
              layout: 'fit',
              xtype: 'articlelist'
            }]
        });
        this.callParent(arguments);
    }
})