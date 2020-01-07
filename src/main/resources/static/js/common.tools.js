/**
 * 查询page
 * @param id
 */
function constructPageNameCombobox(id){

  var html = '';
  $.ajax({
    url : basePath + '/common/queryPage',
    type : "post",
    data : {},
    dataType : "json",
    success : function(result, textStatus) {
      html = '<option value="" selected>please select...</option>';
      $.each(result,function(index,value) {
        html += '<option value="'+value.code+'">'+value.name+'</option>';
      });
      $(id).append(html);
    },
    error : function(XMLHttpRequest, textStatus, errorThrown) {
    },
    complete : function(XMLHttpRequest, textStatus) {
    }
  });
}

/**
 * 查询UserGroup
 * @param id
 */
function constructUserGroupCombobox(id){

  var html = '';
  $.ajax({
    url : basePath + '/common/queryUserGroup',
    type : "post",
    data : {},
    dataType : "json",
    success : function(result, textStatus) {
      html = '<option value="" selected>please select...</option>';
      $.each(result,function(index,value) {
        html += '<option value="'+value.code+'">'+value.name+'</option>';
      });
      $(id).append(html);
    },
    error : function(XMLHttpRequest, textStatus, errorThrown) {
    },
    complete : function(XMLHttpRequest, textStatus) {
    }
  });
}

