/**
 * 
 * JB-Park JQuery Utils
 * 2016. 07. 15
 */

$.extend( {
	
	sqiAjaxPostJson : function(url, jsonParam, callback, errCallback) {
		// @RequestBody
		var ajaxConfig = {
				url : url,
				type : 'POST',
				data : JSON.stringify(jsonParam),
				dataType : 'json'
				
		};
		
		$.ajaxSetup(ajaxConfig);
		$.ajax({
			contentType : 'application/json',
			success : function(result) {
				callback(result);
			},
			error : function(err) {
				errCallback(err);
			}
		});
	},

	sqiAjaxGetJson : function(url, jsonParam, callback, errCallback) {
		// @ModelAttribute
		var ajaxConfig = {
				url : url,
				type : 'GET',
				data : jsonParam,
				dataType : 'json'
				
		};
		
		$.ajaxSetup(ajaxConfig);
		$.ajax({
			success : function(result) {
				callback(result);
			},
			error : function(err) {
				errCallback(err);
			}
		});
	},
	
	sqiSetResponseBody : function(formSerializeArray) {
		var obj = {};
		$.each(formSerializeArray, function(idx, data){
			obj[data.name] = data.value;
		});
		
		return obj;
	},
	
	sqiSetEliga : function(formSerializeArray) {
		var obj = {};
		var weeks = "";
		var exceptDay = "";
		var deviceIds = new Array();
		var eventIds = new Array();
		var startTime = new Array();
		var endTime = new Array();
		var eventGroupIds = new Array();
		$.each(formSerializeArray, function(idx, data){
			if(data.name == 'weeks') {
				weeks += data.value + ",";
			}
			else if(data.name == 'except') {
				exceptDay += data.value + ",";
			}
			else if(data.name == 'deviceIds') {
				deviceIds.push(data.value);
			}
			else if(data.name == 'eventIds') {
				eventIds.push(data.value);
			}
			else if(data.name == 'startTime') {
				startTime.push(data.value);
			}
			else if(data.name == 'endTime') {
				endTime.push(data.value);
			}
			else if(data.name == 'eventGroupIds') {
				eventGroupIds.push(data.value);
			}
			else {
				obj[data.name] = data.value;
			}
		});
		obj.weeks = weeks.slice(0, -1);
		obj.recurrenceException = exceptDay.slice(0, -1);
		obj.deviceIds = deviceIds;
		obj.eventIds = eventIds;
		obj.startTime = startTime;
		obj.endTime = endTime;
		obj.eventGroupIds = eventGroupIds;
		
		return obj;
	}
	
});