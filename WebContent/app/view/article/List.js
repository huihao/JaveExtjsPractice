Ext.define('AM.view.article.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.articlelist',

    title : 'All Artices',
    store: 'Articles',

    columns: [
        {header: 'Title',  dataIndex: 'title',  flex: 1},
        {header: 'Content', dataIndex: 'content', flex: 1}
    ]
});
