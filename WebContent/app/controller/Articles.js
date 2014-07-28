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
           ,{
        	   ref:'articlelist',
        	   selector:'articlelist'
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
            },
            'articlelist button[id=add]':{
            	click:this.addArticle
            },
            'articlelist button[id=delete]':{
            	click:this.deleteArticle
            }
    	});
    },
    addArticle:function(){
    	var add=Ext.create('AM.view.article.Edit').show();
    	var record=Ext.create('AM.model.Article');
    	add.down('form').loadRecord(record);
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
        
        console.log(values);
        record.set(values);
        win.close();
        this.getArticlesStore().insert(0,record);
    },
    deleteArticle:function(){

    	var record = this.getArticlelist().getSelectionModel().getLastSelected();
    	console.log(record.data.id);
    }
});
