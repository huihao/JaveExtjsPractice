Ext.define('AM.controller.Articles', {
    extend: 'Ext.app.Controller',

    stores: [
        'Articles@AM.store'
    ],

    models: [
        'Article@AM.model'
    ],
    refs: [
           {
               ref: 'articlesPanel',
               selector: 'panel'
           }
       ],

    views: [
        'List@AM.view.article',
        'Edit@AM.view.article'
    ],
    init:function (){
    	this.control({
    		'viewport > articlelist':{
    			itemdblclick:this.editArticle
    		},
    		'articleedit button[action=save]': {
                click: this.updateArticle
            }
    	});
    },
    editArticle: function(grid, record) {
        var edit = Ext.create('AM.view.article.Edit').show();

        edit.down('form').loadRecord(record);
    },
    updateArticle: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        record.set(values);
        win.close();
        this.getArticlesStore().sync();
    }
});
