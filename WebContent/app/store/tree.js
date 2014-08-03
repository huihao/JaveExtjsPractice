Ext.define('AM.store.tree',{
     extend:'Ext.data.TreeStore',
     autoLoad: true,
     autoSync: true,
     root: {
 	    text: 'Ext JS',
 	    //id: '00',
 	    expanded: true
 	 },
     proxy: {
         type: 'ajax',
         url:'menu',
         reader: {
             type: 'json'
         },
        extraParams: {  
        id : encodeURI('')
    }  
     }
})