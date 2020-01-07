
/**
 * 将date类型的时期转换成hh:mi:ss
 * @param value
 * @returns {*}
 */
function timeFormatter(value){
  if (value == null) {
    return "";
  }
  var dateVal = new Date(value);
  var year = dateVal.getFullYear();
  var month = dateVal.getMonth() + 1;
  var date = dateVal.getDate();
  var hour = dateVal.getHours();
  var minute = dateVal.getMinutes();
  var second = dateVal.getSeconds();
  // commonTime = dateVal.toString();
  commonTime = hour + ":" + minute + ":" + second;
  return commonTime;
}
/**
 * 将date类型的时期转换成yyyy-MM-dd
 * @param value
 * @returns {*}
 */
function dateFormatter(value){
  if (value == null) {
    return "";
  }
  var dateVal = new Date(value);
  var year = dateVal.getFullYear();
  var month = dateVal.getMonth() + 1;
  var date = dateVal.getDate();
  var hour = dateVal.getHours();
  var minute = dateVal.getMinutes();
  var second = dateVal.getSeconds();
  // commonTime = dateVal.toString();
  commonTime = year + "-" + month + "-" + date;
  return commonTime;
}

/**
 * 将date类型的时期转换成yyyy-MM-dd
 * @param value
 * @returns {*}
 */
function datetimeFormatter(value){
  if (value == null) {
    return "";
  }
  var dateVal = new Date(value);
  var year = dateVal.getFullYear();
  var month = dateVal.getMonth() + 1;
  var date = dateVal.getDate();
  var hour = dateVal.getHours();
  var minute = dateVal.getMinutes();
  var second = dateVal.getSeconds();

  commonTime = year + "-" + (month<10?('0'+month):month) + "-" + (date<10?('0'+date):date)+" "+(hour<10?('0'+hour):hour)+":"+(minute<10?('0'+minute):minute)+":"+(second<10?('0'+second):second);

  //commonTime = year + "-" + (month<10?('0'+month):month) + "-" + (date<10?('0'+date):date);
  return commonTime;
}


/**
  *日期控件
  * @param obj eles 日期输入框
  * @param boolean dobubble 是否为双日期（true）
  * @param boolean secondNot 有无时分秒（有则true）
  * @return none
  */
function calenders(eles,dobubble,secondNot){
  var singleNot,formatDate;
  if(dobubble ==true){
    singleNot = false;
  }else{
    singleNot = true;
  }
  if(secondNot ==true){
    formatDate = "YYYY-MM-DD HH:mm:ss";
  }else{
    formatDate = "YYYY-MM-DD";
  }
  var timePicker12Hour = !secondNot;
  $(eles).daterangepicker({
    "format":formatDate,
    "singleDatePicker": singleNot,//是否为单日期
    "timePicker": secondNot,//时间显示与否
    /* "timePicker24Hour": secondNot,//是否按24小时式来显示*/
    "timePicker12Hour" : timePicker12Hour,
    "timePickerSeconds": secondNot,//是否带秒
    "showDropdowns":true,//是否显示年月下拉选项，可以快速定位到哪一年哪一月
    "timePickerIncrement" :1,
    "linkedCalendars": false,//是否开始和结束连动，建议设为false，不然日期一直跳来跳去，首次使用者会觉得用户体检极度不佳
    "autoApply":true,//是否自动应用，不带时分秒的都可以实现在选择完日期后自动关闭，带时分秒时不会自动关闭
    "autoUpdateInput":false, //是否自动应用初始当前日期
    "locale": {
      "direction": "ltr",
      "format": formatDate,
      "separator": " - ",
      "applyLabel": "Apply",
      "cancelLabel": "Cancel",
      "fromLabel": "From",
      "toLabel": "To",
      "customRangeLabel": "Custom",
      "daysOfWeek": [
        "Su",
        "Mo",
        "Tu",
        "We",
        "Th",
        "Fr",
        "Sa"
      ],
      "monthNames": [
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sept",
        "Oct",
        "Nov",
        "Dec"
      ],
      "firstDay": 1
    }
  }, function(start,end, label) {
    if(secondNot ==true&&dobubble ==true){
      $(eles).val($.trim(start.format('YYYY-MM-DD HH:mm:ss')+' - '+end.format('YYYY-MM-DD HH:mm:ss')));
    }else if(secondNot ==false&&dobubble ==true){
      $(eles).val($.trim(start.format('YYYY-MM-DD')+' - '+ end.format('YYYY-MM-DD')));
    }else if(secondNot ==false&&dobubble ==false){
      $(eles).val(start.format('YYYY-MM-DD'));
    }else if(secondNot ==true&&dobubble ==false){
      $(eles).val(start.format('YYYY-MM-DD HH:mm:ss'));
    }
  });
  //清空
  $(document).off('click','.clearBtns').on('click','.clearBtns',function(){
    $(eles).val('');
  })
}