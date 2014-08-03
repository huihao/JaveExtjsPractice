Ext.define('AM.view.article.Edit',{
	extend:'Ext.window.Window',
	alias:'widget.articleedit',
	
	require:['Ext.form.Panel'],
	title:'Edit Article',
	layout:'fit',
	autoShow:true,
	width:280,
	
	initComponent:function (){
		this.items = [
        {
		 xtype: 'form',
         padding: '5 5 0 5',
         border: false,
         style: 'background-color: #fff;',

         items: [
                 {
                     xtype: 'textfield',
                     name : 'id',
                     fieldLabel: 'id',
                     disabled:'true'
                 },
             {
                 xtype: 'textfield',
                 name : 'title',
                 fieldLabel: 'title'
             },
             {
                 xtype: 'textfield',
                 name : 'content',
                 fieldLabel: 'content'
             }
         ] 
	  }
        ];

        this.buttons = [
            {
                text: 'Save',
                action: 'save'
            },
            {
                text: 'Cancel',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
	}
})