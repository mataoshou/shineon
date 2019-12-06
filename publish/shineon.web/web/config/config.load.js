
try{
	if(rootPath==null||rootPath==undefined)
	{
		 rootPath ="";
	}
}catch(e){
	var rootPath ="";
}

document.write('<script src="'+rootPath+'/config/config.sys.js"></script>');


