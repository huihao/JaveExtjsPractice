Ext.define('AM.view.user.List',{
	extend:'Ext.grid.Panel',
	alias:'widget.userlist',
	
	initComponent: function() {
        Ext.apply(this, {
        	 store:'User',
        	 closable:'true',
        	 columns: [
        	           { header: 'Name',  dataIndex: 'name' },
        	           { header: 'Email', dataIndex: 'email', flex: 1 },
        	           { header: 'Phone', dataIndex: 'phone' }
        	       ]
        });
        this.callParent(arguments);
        }
	
})