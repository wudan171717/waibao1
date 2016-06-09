function addEvent(obj,type,fn){
	if(obj.addEventListener){
		obj.addEventListener(type,fn,false);
	}else if (obj.attachEvent) {
		obj.attachEvent("on"+type,fn);
	}
}
addEvent(window,'load',function () {
	function getStyle(src, name) {
		if(window.getComputedStyle) {
			return window.getComputedStyle(src)[name];
		}
		return src.currentStyle[name];
	}
	var content = document.getElementById('content');
	var image = content.getElementsByClassName('image');
	var child = content.getElementsByClassName('child');
	for (var i = 0; i < image.length; i++) {
		(function(index) {
			addEvent(image[index],'click',function(e){
				if (getStyle(child[index], 'display')=='none') {
					child[index].style.display= 'block';
					image[index].src='../images/list-open.gif';
				}else{
					child[index].style.display='none';
					image[index].src='../images/list-close.gif';
				}
				
			});
		})(i);
	}
});