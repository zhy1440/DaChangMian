Ext.define('app.store.Personnel', {
    extend: 'Ext.data.Store',

    alias: 'store.personnel',

    fields: [
        'name', 'email', 'phone'
    ],

    proxy: {
        type: 'ajax',
        url: './contact',
        reader: {
            type: 'json',
            rootProperty: 'users'
        }
    },
    autoLoad: true
});
