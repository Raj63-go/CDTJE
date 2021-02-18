var $table=$('#productListTables');

if($table.length){
	
	var jsonUrl='';
	
	if(window.categoryId==''){
		jsonUrl=window.contextRoot + '/json/data/all/products';
	}
	else{
		jsonUrl=window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
	}
	
	$table.DataTable({
		lengthMenu:[[2,5,10,-1]['2 records','5 records','10 records','All']],
	    pagelength:5,
	    
	    ajax:{
	    	url:jsonUrl,
	    	dataSrc:''
	    },
	    
	    columns:[
	    	{
	    		data:'name'
	    	},
	    	{
	    		data:'brand'
	    	},
	    	{
	    		data:'unitprice'
	    	}
	    ]
	})
}