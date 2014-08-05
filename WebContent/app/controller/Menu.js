Ext.define('AM.controller.Menu', {
    extend: 'Ext.app.Controller',
    refs: [
           {
        	   ref:'articlelist',
        	   selector:'articlelist'
           },
           {
        	   ref:'tabPanel',
        	   selector:'tabPanel'
           }
       ],
       views: [
               'List@AM.view.article',
               'TreePanel@AM.view',
               'TabPanel@AM.view'
           ],
       init:function (){
       	this.control({
               'mytreepanel':{
               	beforeload:this.treeExpend,
               	cellclick:this.treeClick
               }
       	});
       },
       treeExpend:function(store,operation){
       	store.proxy.extraParams.id=operation.node.data.id;
       },
       treeClick:function (view, record, item, index){
       	var tp=this.getTabPanel();
       	if(index.data.leaf==1){
       		var newtp=this.getArticlelist();
       		if(newtp==null)
   			{
   	    	    newtp=tp.add({
   	    		title:"articles",
   	    		xtype:'articlelist'
   	    	    });
   	    	}
   	    	newtp.show();
   	    }   
       }
})