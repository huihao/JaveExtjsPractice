Ext.define('AM.view.Viewport', {
    extend: 'Ext.container.Viewport',

    layout: 'border',
    items: [{
	    	region: 'center',
	        xtype: 'articlelist' ,
	        title: 'ArticleList'

        	},
          {
        	 region: 'west',
        	 xtype:'mytreepanel',
        	 title: 'Navigation',
        	 store:Ext.create('AM.store.tree'),
        	 width:200
        }
        ]  
});