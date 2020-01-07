// var userStatus=[];
//
// var onlineStatus=[];
//
// var dailyExecutionStatus=[];
//
// var userCategoryType=[];
//
// var touchChannelType=[];
//
// var eachWeek=[];
//
// var frequencyType=[];
//
// var taskType=[];
//
// var pageType=[];
//
// var pageStatus=[];
//
// var groupNumberType=[];
//
// var groupStrategyType=[];
//
//
//
// //initilize All type status
// $(function () {
//   getStatusAll();
//   getTypeAll();
// });
//
// function getStatusAll() {
//   var enumName = "";
//   enumName = "UserStatus";
//   $.ajax({
//     url : basePath + '/utils/queryStatus',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       userStatus = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//   enumName = "OnlineStatus";
//   $.ajax({
//     url : basePath + '/utils/queryStatus',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       onlineStatus = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//
//
//   enumName = "PageStatus";
//   $.ajax({
//     url : basePath + '/utils/queryStatus',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       pageStatus = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//
//
//   enumName = "DailyExecutionStatus";
//   $.ajax({
//     url : basePath + '/utils/queryStatus',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       dailyExecutionStatus = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
// }
// function getTypeAll(){
//   var enumName ="";
//   enumName = "UserCategory";
//   $.ajax({
//     url : basePath + '/utils/queryType',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       userCategoryType = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//   enumName = "TouchChannelType";
//   $.ajax({
//     url : basePath + '/utils/queryType',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       touchChannelType = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//
//
//   enumName = "FrequencyType";
//   $.ajax({
//     url : basePath + '/utils/queryType',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       frequencyType = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//
//
//   enumName = "TaskType";
//   $.ajax({
//     url : basePath + '/utils/queryType',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       taskType = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//
//
//   enumName = "PageType";
//   $.ajax({
//     url : basePath + '/utils/queryType',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       pageType = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//
//
//
//   enumName = "GroupNumberType";
//   $.ajax({
//     url : basePath + '/utils/queryType',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       groupNumberType = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//
//
//   enumName = "GroupStrategyType";
//   $.ajax({
//     url : basePath + '/utils/queryType',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       groupStrategyType = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//
//
//   enumName = "EachWeek";
//   $.ajax({
//     url : basePath + '/utils/queryType',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       eachWeek = result;
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
//
//
//
//
//
// }
//
//
// function constructStatus(id,enumName){
//
//   var html = '';
//   $.ajax({
//     url : basePath + '/utils/queryStatus',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       html = '<option value="" selected>please select...</option>';
//       $.each(result,function(index,value) {
//         html += '<option value="'+value.code+'">'+value.name+'</option>';
//       });
//       $(id).append(html);
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
// }
//
// /**
//  * 获取类型enum常量值，并且转化成select控件中option
//  * @param id 控件ID
//  * @param enumName [AccountRunType<流水类型>|RuleType<积分规则类型>|BizType<系统来源业务分类>|ClientType<设备来源类型>]
//  * @returns void
//  */
// function constructType(id,enumName){
//
//   var html = '';
//   $.ajax({
//     url : basePath + '/utils/queryType',
//     type : "post",
//     data : {"EnumName":enumName},
//     dataType : "json",
//     success : function(result, textStatus) {
//       if(enumName != "RegulationType")
//         html = '<option value="" selected>please select...</option>';
//       $.each(result,function(index,value) {
//         html += '<option  value='+value.code+' >'+value.name+'</option>';
//       });
//       $(id).append(html);
//     },
//     error : function(XMLHttpRequest, textStatus, errorThrown) {
//     },
//     complete : function(XMLHttpRequest, textStatus) {
//     }
//   });
// }