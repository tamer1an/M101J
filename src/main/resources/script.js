
//Object factory
var Factory = function(){
    this.objType = {};
    this.createNewObj = function (obj) {
        obj = (typeof(window[obj])=='object') ? window[obj] : { error: 'no such class name in global space' };

        this.setObjType(obj);

        var func = this.getObjConstructor();
        for (var prop in obj){
            func.prototype[prop] = obj[prop];
        }

        return new func();
    };
    this.getObjType = function(){
        return this.objType;
    };
    this.setObjType = function(obj){
        this.objType = obj
    };
    this.getObjConstructor = function(obj){
        return this.getObjType().constructor;
    }
};

//Add event to list
function addEventHandler(oNode, evt, oFunc,bCaptures){
    if (oNode.length>0) {
        for (var idx in oNode){
            if (typeof(oNode[idx]) == "object")
                oNode[idx].addEventListener(evt, oFunc, bCaptures);
        }
        return;
    }
   oNode.addEventListener(evt, oFunc, bCaptures);
}

//Elem Has Attribute
function elemHasAttribute(elementName,attribute){
	var element = document.createElement(elementName);
	return attribute in element;
};	


//Include js files function
function include(file,scriptStack) {
	var script = document.createElement('script');
	script.src = file;
	script.type = 'text/javascript';
	
	if(scriptStack == 'async' && elemHasAttribute('script','async'))
		script.async = true;
	else if(scriptStack == 'defer')
		script.defer = true;
		
	document.getElementsByTagName('head')[0].appendChild(script);
	debuggStack({'msg':'script.js(47): include '+file});
};	

//Include js file with callback function
function includeWithCallBack(file, callback) {
	var script = document.createElement('script');
	script.src = file;
	script.type = 'text/javascript';
	document.getElementsByTagName('head')[0].appendChild(script);
		
	script.onreadystatechange = function() {
		if(script.readyState == "complete" || script.readyState=="loaded") {
			script.onreadystatechange = false;
			callback;
		} else {
			script.onload = function() {
			callback;
			};
		}
	};
};