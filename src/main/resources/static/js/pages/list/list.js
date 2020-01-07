var $defaultApprovalControlTable = $('#approval-control-table');
var $addApprovalControlBtton = $('#add-approval-control-btton');
var $addApprovalControlExeBtton = $('#add-approval-control-exe-btton');
var $editApprovalControlBtton = $('#edit-approval-control-btton');
var $editApprovalControlExeBtton = $('#edit-approval-control-exe-btton');
var selectionsApprovalControl = [];
$table = $("#approval-control-table");

/**
 * 页面初始化方法
 */
function initApprovalControlPage(){
    initTable();
    initButton();
    initDialog();
}

/**
 * table数据加载方法
 * @param params
 */
function dataList(params){
    $defaultApprovalControlTable.bootstrapTable('showLoading');
    console.log(params.data);
    $.ajax({
        url : basePath + '/codeInter/dataList?limit='
        +params.data.limit+'&offset='+params.data.offset,
        type : "post",
        data : $("#search-approval-control-form").serialize(),
        dataType : "json",
        success : function(result, textStatus) {
            params.success(result);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
        },
        complete : function(XMLHttpRequest, textStatus) {
            $defaultApprovalControlTable.bootstrapTable('hideLoading');
        }
    });
}

/**
 * table初始化方法
 */
function initTable() {
    $defaultApprovalControlTable.on('check.bs.table uncheck.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table', function () {
        $editApprovalControlBtton.prop('disabled', !($defaultApprovalControlTable.bootstrapTable('getSelections').length==1));
        // save your data, here just save the current page
        selectionsApprovalControl = getIdSelectionsApprovalControl();
        // push or splice the selections if you want to save all data selections
    });
    $defaultApprovalControlTable.on('all.bs.table', function (e, name, args) {
        console.log(name, args);
    });

    $(window).resize(function () {
        $defaultApprovalControlTable.bootstrapTable('resetView', {
            height: getHeight()
        });
    });
}

/**
 * 按钮初始化方法
 */
function initButton(){

    /**
     * 查询按钮初始化
     */
    $("#search-approval-control-btton").click(function(){
        $defaultApprovalControlTable.bootstrapTable('refresh', null);
    });
    /**
    * 重置按钮初始化
    */
    $("#reset-approval-control-btton").click(function(){
                $("form[id=search-approval-control-form]  input[name=tag]").val("");
                $("form[id=search-approval-control-form]  input[name=infoCode]").val("");
                $("form[id=search-approval-control-form]  input[name=infoDesc]").val("");
                $("form[id=search-approval-control-form]  input[name=language]").val("");
            });
    /**
     * table上方按钮事件（添加）
     */
    $addApprovalControlBtton.click(function () {
        $('#add-approval-control-dialog').on('shown.bs.modal', function () {
            //$('#myInput').focus()
            $("form[id=add-approval-control-form]  input[name=tag]").val("");
			$("form[id=add-approval-control-form]  input[name=infoCode]").val("");
			$("form[id=add-approval-control-form]  input[name=appCode]").val("");
			$("form[id=add-approval-control-form]  input[name=simplfiedCnDesc]").val("");
			$("form[id=add-approval-control-form]  input[name=traditionalCnDesc]").val("");
			$("form[id=add-approval-control-form]  input[name=enDesc]").val("");
						$("form[id=add-approval-control-form]").bootstrapValidator( 'resetForm' , true);
        });
    });
    /**
     * 按钮执行区域（添加）
     */
    $addApprovalControlExeBtton.click(function(){
        console.log(JSON.stringify($("#add-approval-control-form").serialize()));
        var data = $("#add-approval-control-form").data('bootstrapValidator');
        if (data) {
            // 修复记忆的组件不验证
            data.validate();
            if (!data.isValid()) {
                return false;
            }
        }
        $.ajax({
            url : basePath + "/codeInter/save",
            type : "POST",
            data : $("#add-approval-control-form").serialize(),
            dataType : "json",
            success : function(data, textStatus) {
                alert(data.msg);

            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
            },
            complete : function(XMLHttpRequest, textStatus) {
                // location.href=location.href;
                $('#add-approval-control-dialog').modal('hide');
                $defaultApprovalControlTable.bootstrapTable('refresh', null);
                $defaultApprovalControlTable.bootstrapTable('uncheckAll');
            }
        });
    });

    /**
     * table上方按钮事件（编辑）
     */
    $editApprovalControlBtton.click(function () {
        var id = selectionsApprovalControl[0];
        console.log(id);
        $('#edit-approval-control-dialog').on('shown.bs.modal', function () {
            var getSelections = $table.bootstrapTable('getSelections');
            if (getSelections && getSelections.length == 1) {
                var curOrder = getSelections[0];
                $("form[id=edit-approval-control-form]  input[name=id]").val(curOrder.id);
                $("form[id=edit-approval-control-form]  input[name=version]").val(curOrder.version);
                $("form[id=edit-approval-control-form]  input[name=tag]").val(curOrder.tag);
                $("form[id=edit-approval-control-form]  input[name=infoCode]").val(curOrder.infoCode);
                $("form[id=edit-approval-control-form]  input[name=appCode]").val(curOrder.appCode);
                $("form[id=edit-approval-control-form]  input[name=simplfiedCnDesc]").val(curOrder.simplfiedCnDesc);
                $("form[id=edit-approval-control-form]  input[name=traditionalCnDesc]").val(curOrder.traditionalCnDesc);
                $("form[id=edit-approval-control-form]  input[name=enDesc]").val(curOrder.enDesc);
            }
        });
    });

    /**
     * 按钮执行区域（编辑）
     */
    $editApprovalControlExeBtton.click(function (){
        console.log(JSON.stringify($("#edit-approval-control-form").serialize()));
        var data = $("#edit-approval-control-form").data('bootstrapValidator');
        if (data) {
            // 修复记忆的组件不验证
            data.validate();
            if (!data.isValid()) {
                return false;
            }
        }
        $.ajax({
            url : basePath + "/codeInter/modify",
            type : "POST",
            data : $("#edit-approval-control-form").serialize(),
            dataType : "json",
            success : function(data, textStatus) {
                alert(data.msg);

            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
            },
            complete : function(XMLHttpRequest, textStatus) {
                $('#edit-approval-control-dialog').modal('hide');
                $defaultApprovalControlTable.bootstrapTable('refresh', null);
                $defaultApprovalControlTable.bootstrapTable('uncheckAll');
            }
        });
    });
}

/**
 * 初始化弹出面板
 */
function initDialog(){
    $('#add-approval-control-dialog').modal({
        keyboard: false
    });
    $('#edit-approval-control-dialog').modal({
        keyboard: false
    });

    $('#add-approval-control-dialog').modal('hide');
    $('#edit-approval-control-dialog').modal('hide');
}

/**
 * 获取选中的table项目UUID
 * @returns {*}
 */
function getIdSelectionsApprovalControl() {
    return $.map($defaultApprovalControlTable.bootstrapTable('getSelections'), function (row) {
    	       return row.id

    });
}

function getHeight() {

}

// 数据表格展开内容
function detailFormatter(index, row) {
    var html = [];
    $.each(row, function (key, value) {
    html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}



$("#addBatchTemplate-approval-control-btton").on("click", function (e) {
    window.open("/codeInter/exportTemplate");
});
$("#addBatch-approval-control-btton").on("click", function (e) {
    $("#batchDiv").modal('show');
});
$("#batchConfirm").on("click", function (e) {
    var options = {
        type: 'POST',
        url: '/codeInter/batchCreateData',
        dataType: 'json',
        success: function (responseText, status, xhr, $form) {
            alert(responseText.msg);
            if (responseText.status) {
                location.href = location.href;
            }

        },
        error: function (xhr, status, err) {
            alert('system error,pls contact admin');
        }
    };
    $("#form-addBatchDetail-cc").ajaxSubmit(options);
    return false;

});