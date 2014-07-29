Ext.define('AM.store.Articles', {
    extend: 'Ext.data.Store',
    model: 'AM.model.Article',
    autoLoad: true,
    autoSync:true,
    proxy: {
        type: 'ajax',
        api: {
            read: 'article?action=jsonlist',
            update: 'article?action=jsonedit',
            create:'article?action=jsonadd',
            destroy:'article?action=jsondelete'
        },
        reader: {
            type: 'json',
            successProperty: 'success'
        },
        writer:{
        	 type: 'json'
        }
    }
});