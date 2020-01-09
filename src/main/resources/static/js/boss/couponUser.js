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
        url: "/boss/couponUser/queryList",
        method: 'get',
        queryParams: {
            condition: JSON.stringify(iparam)
        },
        onBeforeLoad: function (param) {
        },
        singleSelect: true,
        columns: [[
            {field: 'couponId', title: '优惠券ID', width: 40, align: 'center'},
            {field: 'userNo', title: '用户', width: 120, align: 'center'},
            {field: 'thresholdValue', title: '阈值', width: 120, align: 'center'},
            {field: 'value', title: '优惠金额', width: 120, align: 'center'},
            {field: 'maxValue', title: '最大优惠金额', width: 120, align: 'center'},
            {field: 'giftFlag', title: '是否可赠送', width: 120, align: 'center'},
            {field: 'couponTypeStr', title: '优惠券类型', width: 120, align: 'center'},
            {field: 'statusStr', title: '状态', width: 120, align: 'center'},
            {
                field: 'expireDate', title: '过期时间', width: 120, align: 'center',
                formatter: function (value) {
                    var newDate = new Date();
                    newDate.setTime(Date.parse(value));
                    return newDate.toLocaleString();
                }
            },
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


