Ext.define("AM.model.Article",{
	extend:'Ext.data.Model',
	
	requires: [
	           'Ext.data.reader.Json'
	       ],
	       
	fields: ['id', 'title', 'content']
})