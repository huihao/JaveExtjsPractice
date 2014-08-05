Ext.define('AM.store.User',{
	extend:'Ext.data.Store',
	model: 'AM.model.User',
    proxy: {
        type: 'ajax',
        api: {
            read: 'user?action=jsonlist',
        },
        reader: {
            type: 'json'
        }
    }
})