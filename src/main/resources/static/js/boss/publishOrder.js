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
        url: "/boss/order/publishOrderQueryList",
        method: 'get',
        queryParams: {
            condition: JSON.stringify(iparam)
        },
        onBeforeLoad: function (param) {
        },
        singleSelect: true,
        columns: [[
            {field: 'id', title: 'ID', width: 40, align: 'center'},
            {field: 'orderNo', title: '发布单号', width: 120, align: 'center'},
            {field: 'userNo', title: '会员编号', width: 120, align: 'center'},
            {field: 'weigth', title: '重量', width: 120, align: 'center'},
            {field: 'price', title: '金额', width: 120, align: 'center'},
            {field: 'kdType', title: '快递类型', width: 120, align: 'center'},
            {field: 'addressGet', title: '取货地址', width: 120, align: 'center'},
            {field: 'scoNo', title: '取货凭证', width: 120, align: 'center'},
            {field: 'addressServices', title: '送货地址', width: 120, align: 'center'},
            {field: 'timeDelay', title: '有效期', width: 120, align: 'center',
                formatter: function (value) {
                    if (!value) {
                        return "-";
                    }
                    var newDate = new Date();
                    newDate.setTime(Date.parse(value) );
                    return newDate.toLocaleString();
                }},
            {field: 'statusStr', title: '状态', width: 120, align: 'center'},
            {field: 'cancelReason', title: '取消原因', width: 120, align: 'center'},
            {field: 'wuliuNo', title: '物流单号', width: 120, align: 'center'},
            {field: 'wuliuJson', title: '物流详情', width: 120, align: 'center'},
            {field: 'createdDate', title: '创建时间', width: 240, align: 'center',
                formatter: function (value) {
                    if (!value) {
                        return "-";
                    }
                    var newDate = new Date();
                    newDate.setTime(Date.parse(value) );
                    return newDate.toLocaleString();
                }},
            {field: 'modifiedDate', title: '修改时间', width: 240, align: 'center',
                formatter: function (value) {
                    if (value) {
                        var newDate = new Date();
                        newDate.setTime(Date.parse(value) );
                        return newDate.toLocaleString();
                    }
                    return value;
                }},
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


    $("#query").click(function () {
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
        $("input[name='gameType']").val("");
        $("input[name='gameDistrict']").val("");
        $("input[name='orderStatus']").val("");
    });

});



