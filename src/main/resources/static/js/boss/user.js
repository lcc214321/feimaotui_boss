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
        url: "/boss/user/userQueryList/queryList",
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
            {field: 'realName', title: '真实姓名', width: 120, align: 'center'},
            {field: 'gender', title: '性别', width: 120, align: 'center'},
            {field: 'nickName', title: '昵称', width: 120, align: 'center'},
            {field: 'userHeadPic', title: '头像', width: 120, align: 'center'},
            {field: 'telNo', title: '手机号', width: 120, align: 'center'},
            {field: 'wxOpenId', title: '公众号OPENID', width: 120, align: 'center'},
            {field: 'wxMiniOpenId', title: '小程序OPENID', width: 120, align: 'center'},
            {field: 'schName', title: '学校名称', width: 120, align: 'center'},
            {field: 'addressL', title: '住址（楼号）', width: 120, align: 'center'},
            {field: 'addressQ', title: '详细住址', width: 120, align: 'center'},
            {field: 'remark', title: '备注', width: 120, align: 'center'},
            {field: 'userStatusStr', title: '状态', width: 120, align: 'center'},
            {field: 'realStatusStr', title: '实名状态', width: 120, align: 'center'},
            {field: 'realIdNo', title: '实名证件号', width: 120, align: 'center'},
            {field: 'creditScore', title: '信誉分', width: 120, align: 'center'},
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
            },
            {
                field: 'version', title: 'version', width: 120, align: 'center'
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
        $("input[name='userStatus']").val("");
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
function save() {
    if (!$("#fm").form('validate')) {
        return;
    }
    $.ajax({
        type: 'POST',
        url: "updateStatus",
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
function cancel(_this) {
    $("#" + _this).dialog('close');
}



