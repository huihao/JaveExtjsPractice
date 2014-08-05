Ext.define('AM.controller.User', {
    extend: 'Ext.app.Controller',
    	
	stores: [
	         'User@AM.store'
	     ],
	     
     views: [
             'List@AM.view.user'
         ],
     refs: [
            {
                ref: 'userList',
                selector: 'userlist'
            }
      ],
     init:function (){
     	this.control({
     		
     	})}
})