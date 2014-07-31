Ext.define('AM.store.tree',{
     extend:'Ext.data.TreeStore',
     remoteSort: true,
     autoLoad: true,
     autoSync: true,
     root: {
        expanded: true,
        children: [
            { text: "detention", leaf: true },
            { text: "homework", expanded: true, children: [
                { text: "book report", leaf: true },
                { text: "alegrbra", leaf: true}
            ] },
            { text: "buy lottery tickets", leaf: true }
        ]
    }
})