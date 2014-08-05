Ext.define('AM.view.user.List',{
	extend:'Ext.grid.Panel',
	alias:'widget.userlist',
	require:[
	             'Ext.selection.CellModel'
	         ],
	
	initComponent: function() {
        Ext.apply(this, {
        	 store:'User',
        	 columnLines: true,
        	 selModel: Ext.create('Ext.selection.CheckboxModel'),
        	 columns: [
        	           { header: 'Name',  dataIndex: 'name',
        	        	   editor: {
        	                   xtype: 'textfield',
        	                   allowBlank: false
        	               }
        	           },
        	           { header: 'Email', dataIndex: 'email', flex: 1 , 
        	        	    editor: {
        	                xtype: 'textfield',
        	                allowBlank: false
        	            }
        	           },
        	           { header: 'Phone', dataIndex: 'phone',
        	        	   editor: {
        	                   xtype: 'textfield',
        	                   allowBlank: false
        	               }
        	           }
        	       ],
        	  selType: 'cellmodel',
        	  plugins: [
        	            Ext.create('Ext.grid.plugin.RowEditing', {
        	                clicksToEdit: 1
        	            })
        	        ]
        });
        this.callParent(arguments);
        }
	
})