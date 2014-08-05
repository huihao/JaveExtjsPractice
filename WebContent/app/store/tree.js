Ext.define('AM.store.tree',{
     extend:'Ext.data.TreeStore',
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