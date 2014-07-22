Ext.define('AM.store.Articles', {
    extend: 'Ext.data.Store',
    model: 'AM.model.Article',
    autoLoad: true,
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'article?action=jsonlist',
            update: 'article?action=jsonedit'
        },
        reader: {
            type: 'json',
            successProperty: 'success'
        }
    }
});