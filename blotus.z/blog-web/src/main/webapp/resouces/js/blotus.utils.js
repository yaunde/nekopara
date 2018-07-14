/**
 * javascript工具类
 * 
 */
var BlotusUtils = (function (window,$) {
	return {
		/**
		 * 获取url的参数
		 */
		getParameter : function (name) {
		    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
		},
		
		/**
		 * 判断字符串是否为空
		 */
	    isEmpty : function (string) {

			if (null !== string && string !== undefined && string !== '') {
				// 判断输入的是否全是空格
				var regex = "^[ ]+$";
				var re = new RegExp(regex);
				return re.test(string)
			} 
			return true;
	    }
			
	}
})(window,jQuery);