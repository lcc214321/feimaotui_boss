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
        url: "/boss/active/queryList",
        method: 'get',
        queryParams: {
            condition: JSON.stringify(iparam)
        },
        onBeforeLoad: function (param) {
        },
        singleSelect: true,
        columns: [[
            {field: 'id', title: 'ID', width: 40, align: 'center'},
            {field: 'teamNo', title: '队伍编号', width: 120, align: 'center'},
            {field: 'teamName', title: '队伍名称', width: 120, align: 'center'},
            {field: 'integralTotal', title: '总积分', width: 120, align: 'center'},
            {field: 'priceStatus', title: '开奖状态', width: 120, align: 'center'},
            {
                field: 'createdTime', title: '创建时间', width: 240, align: 'center',
                formatter: function (value) {
                    var newDate = new Date();
                    newDate.setTime(Date.parse(value));
                    return newDate.toLocaleString();
                }
            },
            {
                title: '操作', width: 240, align: 'center',
                formatter: function (value) {
                    var html='';
                    var size=value.userList.size()
                    if (size>=4&&size<=8&&value.integralTotal>=10){
                     html = '<a onclick="sendPrice('+value.teamNo+')">发奖</a>';
                    }
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


    $("#cquery").click(function () {
        var qparam = {};
        $("#searchForm").serializeArray().map(function (x) {
            qparam[x.name] = x.value == "" ? null : x.value;
        });
        qparam['orderByColumn'] = 'createdTime';
        $('#MGrid').datagrid('reload', {
            condition: JSON.stringify(qparam)
        });
    });

    $("#squery").click(function () {
        var qparam = {};
        $("#searchForm").serializeArray().map(function (x) {
            qparam[x.name] = x.value == "" ? null : x.value;
        });
        qparam['orderByColumn'] = 'integralTotal';
        $('#MGrid').datagrid('reload', {
            condition: JSON.stringify(qparam)
        });
    });
    $(".resetBtn").click(function () {
        $("#searchForm").form('clear');
    });

});
function sendPrice(teamNo) {
    $.messager.confirm('继续操作', '确定执行发奖操作吗?', function (data) {
        if (data) {
            $.ajax({
                url: 'allocationPrice',
                type: 'post',
                dateType: 'json',
                data: {'teamNo': teamNo},
                success: function (data) {
                    if (!data.success) {
                        var errorDesc = 'system exception';
                        $.messager.show({
                            title: 'Error',
                            msg: errorDesc
                        });
                    } else {
                        $('#MGrid').datagrid('reload');    // reload the user data
                    }
                }

            });

        }

    });
};

