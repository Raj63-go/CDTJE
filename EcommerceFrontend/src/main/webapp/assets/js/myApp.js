$(function(){
	switch(menu){
	
	case "About us":
		$('#about').addClass('active');
		break;
	
	case "Products":
		$('#product').addClass('active');
		break;
	
	case "Product Management":
		$('#manageproduct').addClass('active');
		break;
		
	case "Register":
		$('#register').addClass('active');
		break;	
	
	case "Contact":
		$('#contact').addClass('active');
		break;
		
	default:
		$('#home').addClass('active');
	}
})

var $table =$('#productListTables');


if($table.length)
	
	{
	
	var jsonUrl='';
	
	if(window.categoryId =='')
		
	{
		jsonUrl=window.contextRoot+'/json/data/all/products';
	}	
	
	else
		{
		
		jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		}
	
	
	$table.DataTable({
		
		lengthMenu:[[2,5,10,-1],['2 records','5 records','10 records','All']],
		pageLength:5,
		
		ajax:{
			url:jsonUrl,
			dataSrc:''
		},
		
		columns:[
			   {
		        	  data: 'code',
		        	  mRender: function(data, type, row){
		 
		        			return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
		        		 }
		       },
			
			{
				
				data:'name'
			},
			{
				data:'brand'
			},
			{
				data:'unitPrice',
				mRender:function(data ,type, row)
				{
					return '&#8377;' +data
				}
					
			},
			{
				data:'quantity',
				mRender:function(data, type, show){
					if(data <1){
						return '<span style="color:red">Out of stock</span>';
					}
					return data;
				}
			},
			{
				data:'id',
				mRender:function(data,type,row)
				{
					var str ='';
					str +='<a class="btn btn-primary" href ="'+window.contextRoot+'/show/'+data+'/products">View Product</a> &#160;';
					
					str += '<a class="btn btn-success" href="#">Add To Cart</a>';
					
					return str;
				}
			}]
	});
		
	}

var $alert =$('.alert');
if($alert.length){
	setTimeout(function(){
		$alert.fadeOut('slow');
	}
	,4000
	)
}
		

//For Admin Functionality

var $productsTable =$('#productsTable');

if($productsTable.length)
	{
	var jsonUrl=window.contextRoot+'/json/data/admin/all/products';
	console.log(jsonUrl);
	$productsTable.DataTable({
		
		lengthMenu:[[10,30,50,-1],['10 records','30 records','50 records','All']],
		pageLength:30,
		
		ajax:{
			url:jsonUrl,
			dataSrc:''
		},
		columns:[
			
			{
				data:'id'
			},
			
			{
				data:'code',
				bSortable:false,
				mRender:function(data,type,row){
					return '<img src="'+window.contextRoot+'/resources/img/'+data+'.jpg" class="dataTableImg"/>';
				}
			},
			{
				data:'name'
			},
			
			{
				data:'brand'
			},
			
			{
				data:'quantity',
				mRender:function(data,type,row){
					if(data<1)
						{
						return '<span style="color:red">Out Of Stock</span>';
						}
					return data;
				}
			},
			
			{
				data:'unitPrice',
				mRender:function(data,type,row){
					return '&#8377;' +data
				}
				
			},
			
			{
				data:'active',
				bSortable:false,
				mRender:function(data,type,row){
					var str='';
					
					if(data){
						str += '<label class="switch"><input type="checkbox" checked value="'+row.id+'"><div class="slider round"></div></label>';
					}
					else
					{
						str += '<label class="switch"><input type="checkbox" value="'+row.id+'"><div class="slider round"></div></label>';
					}
					return str;
					
				}
			},
			{
				data:'id',
				bSortable:false,
				mRender:function(data,type,row){
					
					var str="";
					str +='<a href="'+window.contextRoot+'/manage/'+data+'/products" class="btn btn-primary">Edit</a>';
					return str;
				}
				
			}			
			
		],
		
		
		

		
			 initComplete: function(){
	        	 
	        	 var api =this.api();
	        	 
	        	 api.$('.switch input[type="checkbox"]').on('change', function(){
	        			
	        			var checkbox=$(this);
	        			var checked=checkbox.prop('checked');
	        			var dMsg=(checked)?'Do You want to activate product???':
	        								'Do You want to deactivate product???';
	        			var value=checkbox.prop('value');
	        			
	        			bootbox.confirm({
	        				size:'medium',
	        				title:'Product activate or deactivate',
	        				message:dMsg,
	        				callback: function(confirmed){
	        					if(confirmed){
	        						console.log(value);
	        						var activationUrl = window.contextRoot + '/manage/products/' +value+ '/activation';
	        						$.post(activationUrl,function(data){
	        							bootbox.alert({
		        							size:'medium',
		        							title:'information',
		        							message:data
		        						});
	        						});
	        						
	        						
	        					}
	        					else{
	        						checkbox.prop('checked',!checked);
	        					}
	        				}
	        			});
	        		});
	         }			   

	     });

	  }

