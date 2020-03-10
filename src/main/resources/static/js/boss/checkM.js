/**
 * Created by chendatao on 2018/3/9.
 */
var url = '';
$(function () {
    var iparam = {};
    $("#searchForm").serializeArray().map(function (x) {
        iparam[x.name] = x.value == "" ? null : x.value;
    });
    // console.log("iparam="+JSON.stringify(iparam));
    $('#checkMGrid').datagrid({
        url: "/boss/order/queryList",
        method: 'get',
        queryParams: {
            condition: JSON.stringify(iparam)
        },
        onBeforeLoad: function (param) {
        },
        singleSelect: true,
        columns: [[
            {field: 'id', title: 'ID', width: 40, align: 'center'},
            {field: 'orderNo', title: '接单单号', width: 40, align: 'center'},
            {field: 'userNo', title: '接单用户编号', width: 120, align: 'center'},
            {field: 'pubOrderNo', title: '发布单号', width: 120, align: 'center'},
            {field: 'cancelReason', title: '取消原因', width: 120, align: 'center'},
            {field: 'amout', title: '接单奖励金额', width: 120, align: 'center'},
            {field: 'pubPrice', title: '发布单金额', width: 120, align: 'center'},
            {field: 'orderStatusStr', title: '状态', width: 120, align: 'center'},
            {
                field: 'timeDelay', title: '超时时间', width: 240, align: 'center',
                formatter: function (value) {
                    if (!value) {
                        return '-';
                    }
                    var newDate = new Date();
                    newDate.setTime(Date.parse(value));
                    return newDate.toLocaleString();
                }
            },
            {
                field: 'finishedDate', title: '完成时间', width: 240, align: 'center',
                formatter: function (value) {
                    if (!value) {
                        return '-';
                    }
                    var newDate = new Date();
                    newDate.setTime(Date.parse(value));
                    return newDate.toLocaleString();
                }
            }, {
                field: 'createdDate', title: '创建时间', width: 240, align: 'center',
                formatter: function (value) {
                    var newDate = new Date();
                    newDate.setTime(Date.parse(value));
                    return newDate.toLocaleString();
                }
            },
            {
                field: 'mofiedDate', title: '修改时间', width: 240, align: 'center',
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
                field: 'operation', title: 'Operation', width: 100, align: 'center',
                formatter: function (value, row, index) {
                    if(row.status=='ADMIN_CLOSE'){
                        return '';
                    }
                    var op = '<a  onclick=\"closeAdmin(\'' + row.orderNo  + '\')\" style=\"color: blue;cursor:pointer;\">手动关闭</a>&nbsp';
                    return op;
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
        $('#checkMGrid').datagrid('reload', {
            condition: JSON.stringify(qparam)
        });
    });
    $(".resetBtn").click(function () {
        $("#searchForm").form('clear');
        $("input[name='status']").val("");
    });

});


function closeAdmin(acceptOrderNo) {
    $.messager.confirm('提示框', '你确定要手动关闭订单吗?必须确定已经处理完成此单子才可以手动关闭哦',function(data){
        if (data) {
            $.ajax({
                type: 'POST',
                url: 'closeAdmin',
                dataType: 'json',
                data: {'acceptOrderNo':acceptOrderNo},
                success: function (result) {
                    if (!result.success) {
                        var errorDesc = 'system exception';
                        $.messager.show({
                            title: 'Error',
                            msg: errorDesc
                        });
                    } else {
                        location.href = location.href;
                    }
                }
            });
        }
    })
}