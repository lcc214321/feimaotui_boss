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
        url: "/boss/feedBack/feedbackList/queryList",
        method: 'get',
        queryParams: {
            condition: JSON.stringify(iparam)
        },
        onBeforeLoad: function (param) {
        },
        singleSelect: true,
        columns: [[
            {field: 'feedBackNo', title: '反馈流水号', width: 40, align: 'center'},
            {field: 'userNo', title: '用户编号', width: 120, align: 'center'},
            {field: 'feedBackContent', title: '反馈内容', width: 120, align: 'center'},
            {field: 'phoneType', title: '手机类型', width: 120, align: 'center'},
            {field: 'os', title: '系统', width: 120, align: 'center'},
            {field: 'browser', title: '浏览器类型', width: 120, align: 'center'},
            {field: 'ip', title: 'ip', width: 120, align: 'center'},
            {field: 'userAgent', title: 'userAgent', width: 120, align: 'center'},
            {field: 'createdDate', title: '创建时间', width: 240, align: 'center',
                formatter: function (value) {
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
                }}
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


