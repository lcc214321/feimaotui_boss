/**
 * Created by chendatao on 2018/3/9.
 */
$(function () {
    var iparam = {};
    $("#searchForm").serializeArray().map(function (x) {
        iparam[x.name] = x.value == "" ? null : x.value;
    });
    // console.log("iparam="+JSON.stringify(iparam));
    $('#MGrid').datagrid({
        url: "/boss/approveM/queryList",
        method: 'get',
        queryParams: {
            condition: JSON.stringify(iparam)
        },
        onBeforeLoad: function (param) {
        },
        singleSelect: true,
        columns: [[
            {field: 'id', title: 'ID', width: 40, align: 'center'},
            {field: 'userNo', title: '用户编号', width: 120, align: 'center'},
            {field: 'telNo', title: '手机号', width: 120, align: 'center'},
            {field: 'stuNo', title: '学号', width: 120, align: 'center'},
            {field: 'gender', title: '性别', width: 120, align: 'center'},
            {field: 'realName', title: '姓名', width: 120, align: 'center'},
            {field: 'realIdNo', title: '实名证件号', width: 120, align: 'center'},
            {field: 'stuSchName', title: '学校名称', width: 120, align: 'center'},
            {field: 'stuAddressL', title: '住址（楼号）', width: 120, align: 'center'},
            {field: 'stuAddressQ', title: '详细住址', width: 120, align: 'center'},
            {
                field: 'createdDate', title: '创建时间', width: 240, align: 'center',
                formatter: function (value) {
                    var newDate = new Date();
                    newDate.setTime(Date.parse(value));
                    return newDate.toLocaleString();
                }
            },
            {
                field: 'modifiedDate', title: '修改时间', width: 240, align: 'center',
                formatter: function (value) {
                    if (value) {
                        var newDate = new Date();
                        newDate.setTime(Date.parse(value));
                        return newDate.toLocaleString();
                    }
                    return value;
                }
            }
        ]],
        nowrap: false,
        // 显示行号
        rownumbers: true,
        /*fit: true,*/
        fitColumns: true,
        emptyMsg: 'No data found!',
        pagination: true,
        pageSize: 20,
        pageList: [5, 10, 15, 20, 25, 30, 40, 50],
        checkOnSelect: true,
        selectOnCheck: false
    });


    $(".queryBtn").click(function () {
        var qparam = {};
        $("#searchForm").serializeArray().map(function (x) {
            qparam[x.name] = x.value == "" ? null : x.value;
        });
        $('#MGrid').datagrid('reload', {
            condition: JSON.stringify(qparam)
        });
    });
    $(".resetBtn").click(function () {
        $("#searchForm").form('clear');
    });

});
function editDetail() {
    var row = $('#MGrid').datagrid('getSelected');
    if (row) {
        $('#dlg').dialog('open').dialog('center').dialog('setTitle', 'Edit Detail');
        $('#fm').form('load', row);
    }
}
// function agentDone() {
//     var row = $('#MGrid').datagrid('getSelected');
//     if (row) {
//         // $('#dlg').dialog('open').dialog('center').dialog('setTitle', 'agent');
//         $('#fm').form('load', row);
//     }
//     $.messager.confirm('提示框', '你确定让此用户变为代理吗?', function (data) {
//         if (data) {
//             $.ajax({
//                 type: 'POST',
//                 url: "updateAgent",
//                 dataType: 'json',
//                 data: $('form').serializeJSON(),
//                 success: function (result) {
//                     if (!result.success) {
//                         var errorDesc = 'system exception';
//                         $.messager.show({
//                             title: 'Error',
//                             msg: errorDesc
//                         });
//                     } else {
//                         $('#dlg').dialog('close');        // close the dialog
//                         $('#delayMGrid').datagrid('reload');    // reload the user data
//                         location.href = location.href;
//                     }
//                 }
//             });
//         }
//     })
// }
function checkSucc() {
    if (!$("#fm").form('validate')) {
        return;
    }
    $.ajax({
        type: 'POST',
        url: "approveSucc",
        dataType: 'json',
        data: $('form').serializeJSON(),
        success: function (result) {
            if (!result.success) {
                var errorDesc = 'system exception';
                $.messager.show({
                    title: 'Error',
                    msg: errorDesc
                });
            } else {
                $('#dlg').dialog('close');        // close the dialog
                $('#delayMGrid').datagrid('reload');    // reload the user data
                location.href = location.href;
            }
        }
    });
};
function checkFail() {
    if (!$("#fm").form('validate')) {
        return;
    }
    var val = $("[name='id']").val();
    $.ajax({
        type: 'POST',
        url: "approveFail",
        dataType: 'json',
        data: {id:val},
        success: function (result) {
            if (!result.success) {
                var errorDesc = 'system exception';
                $.messager.show({
                    title: 'Error',
                    msg: errorDesc
                });
            } else {
                $('#dlg').dialog('close');        // close the dialog
                $('#delayMGrid').datagrid('reload');    // reload the user data
                location.href = location.href;
            }
        }
    });
};
function cancel(_this) {
    $("#" + _this).dialog('close');
}



