var chart, paperTypeUserData = [], userPaperTypeData = [],x1=[],x2=[];
var selectionsApprovalControl = [];
$table = $("#approval-control-table");
/**
 * 页面初始化方法
 */
function initApprovalControlPage() {
    initButton();
    paperUser();
    updateSeries();
}


/**
 * 按钮初始化方法
 */
function initButton() {

    /**
     * 查询按钮初始化
     */
    $("#search-approval-control-btton").click(function () {
        updateSeries();
    });

    /**
     * 重置按钮初始化
     */
    $("#reset-approval-control-btton").click(function () {
        $("form[id=search-approval-control-form]  input[name=startTime]").val("");
        $("form[id=search-approval-control-form]  input[name=endTime]").val("");
    });

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

function clickedCheckBox(_this, flag) {
    if (_this.prop('checked') && !flag) {
        _this.trigger('click');
    }
    if (!_this.prop('checked') && flag) {
        _this.trigger('click');
    }
}
function updateSeries() {
    $.ajax({
        url: basePath + "/recordChart/sumPaperTypeAndUserTotalMoney",
        type: "GET",
        data: $("#search-approval-control-form").serialize(),
        dataType: "json",
        success: function (data, textStatus) {
            var list = data;
            var s = [];paperTypeUserData=[];
            if (list) {
                for (var obj in list) {
                    let paperType = list[obj].paperType ? list[obj].paperType : "未知";
                    var totalMoney = list[obj].totalMoney ? toDecimal2(list[obj].totalMoney) : 0
                    let o = {name: paperType, y: totalMoney, drilldown: true};
                    s.push(o);
                    let ll = list[obj].sumRecordUserMoneyVos;
                    let datas = [];
                    if (ll) {
                        for (var obj1 in ll) {
                            let item = [];
                            item.push(ll[obj1].userName);
                            var totalMoney2 = ll[obj1].totalMoney ? toDecimal2(ll[obj1].totalMoney) : 0;
                            item.push(totalMoney2);
                            datas.push(item);
                        }

                    }
                    let d = {name: paperType, colorByPoint: true, data: datas};
                    paperTypeUserData[paperType] = d;

                }
            }else{

            }
            var container = $("#container").highcharts();
            container.series[0].setData(s);

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        },
        complete: function (XMLHttpRequest, textStatus) {
        }
    });
    $.ajax({
        url: basePath + "/recordChart/sumUserAndPaperTypeTotalMoney",
        type: "GET",
        data: $("#search-approval-control-form").serialize(),
        dataType: "json",
        success: function (data, textStatus) {
            var list = data;
            var s = [];userPaperTypeData=[];
            if (list) {
                for (var obj in list) {
                    let userName = list[obj].userName ? list[obj].userName : "未知";
                    var totalMoney = list[obj].totalMoney ? toDecimal2(list[obj].totalMoney) : 0
                    let o = {name: userName, y: totalMoney, drilldown: true};
                    s.push(o);
                    let ll = list[obj].sumRecordSVos;
                    let datas = [];
                    if (ll) {
                        let da = 0;
                        for (var obj1 in ll) {
                            let item = {};
                            let paperType = ll[obj1].paperType ? ll[obj1].paperType : "未知";

                            item['name'] = (paperType);
                            //占比
                            var totalMoney2 = ll[obj1].totalMoney ? toDecimal2(ll[obj1].totalMoney) : 0;
                            if (obj1 == ll.length - 1) {
                                //    最后一个
                                item['description'] = (100 - da).toFixed(2) + '%';
                            } else {
                                item['description'] = ((totalMoney2 / totalMoney) * 100).toFixed(2) + '%';
                            }
                            da += (toDecimal2((totalMoney2 / totalMoney) * 100));
                            item['y'] = totalMoney2;
                            datas.push(item);
                        }

                    }
                    let d = {name: userName, type: "pie", colorByPoint: true, data: datas};
                    userPaperTypeData[userName] = d;

                }
            }
            var container2 = $("#container2").highcharts();
            container2.series[0].setData(s);

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        },
        complete: function (XMLHttpRequest, textStatus) {
        }
    });
    $.ajax({
        url: basePath + "/recordChart/querySumByUserSort",
        type: "GET",
        data: $("#search-approval-control-form").serialize(),
        dataType: "json",
        success: function (data, textStatus) {
            var list = data;
            let s = [];
                x1 = [];
            if (list) {
                for (var obj in list) {
                    let userName = list[obj].userName ? list[obj].userName : "未知";
                    var totalMoney = list[obj].sumtotalMoney ? toDecimal2(list[obj].sumtotalMoney) : 0
                    let o = { y: totalMoney};
                    x1.push(userName);
                    s.push(o);
                }
            }
            var container2 = $("#container3").highcharts();
            container2.series[0].setData(s);
            container2.xAxis[0].setCategories(x1);

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        },
        complete: function (XMLHttpRequest, textStatus) {
        }
    });
    $.ajax({
        url: basePath + "/recordChart/querySumByPaperTypeSort",
        type: "GET",
        data: $("#search-approval-control-form").serialize(),
        dataType: "json",
        success: function (data, textStatus) {
            var list = data;
            let s = [];
            x2 = [];

            if (list) {
                for (var obj in list) {
                    let paperType = list[obj].paperType ? list[obj].paperType : "未知";
                    var totalMoney = list[obj].sumtotalMoney ? toDecimal2(list[obj].sumtotalMoney) : 0;
                    let o = { y: totalMoney};
                    x2.push(paperType);
                    s.push(o);
                }
            }
            var container2 = $("#container4").highcharts();
            container2.series[0].setData(s);
            container2.xAxis[0].setCategories(x2);

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        },
        complete: function (XMLHttpRequest, textStatus) {
        }
    });

}
function paperUser() {
    Highcharts.chart('container', {
        chart: {
            type: 'column',
            events: {
                drillup: function (e) {
                    // 上钻回调事件
//                        console.log(e.seriesOptions);
                },
                drilldown: function (e) {
                    if (!e.seriesOptions) {
                        var chart = this,
                            series = paperTypeUserData[e.point.name];
                        chart.addSeriesAsDrilldown(e.point, series);
                    }
                },
            }
        },
        credits:{enabled: false},
        title: {
            text: '各纸种的销售总金额'
        },
        subtitle: {
            text: '点击可查看具体的用户数据'
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: '销售总金额'
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y} 元'
                }
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y} 元</b> <br/>'
        },
        series: [{
            name: '纸种',
            colorByPoint: true,
            data: []
        }],
        drilldown: {
            series: []
        }
    });
    Highcharts.chart('container2', {
        chart: {
            type: 'column',
            events: {
                drillup: function (e) {
                    // 上钻回调事件
//                        console.log(e.seriesOptions);
                },
                drilldown: function (e) {
                    if (!e.seriesOptions) {
                        var chart = this,
                            series = userPaperTypeData[e.point.name];
                        chart.addSeriesAsDrilldown(e.point, series);
                    }
                },
            }
        },
        credits:{enabled: false},
        title: {
            text: '各员工的销售总金额'
        },
        subtitle: {
            text: '点击可查看具体的纸种占比数据'
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: '销售总金额'
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y} 元'
                }
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormatter:function () {
                var rs = "";
                if (this.description) {
                    rs = '<span style="color:'+this.color+'">纸种</span>: <b>'+this.name+'</b><br/>'
                        + '<span style="color:'+this.color+'">总金额</span>: <b>'+this.y+'</b> 元<br/>'
                        + '<span style="color:'+this.color+'">占比</span>: <b>'+this.description+'</b><br/>';
                }else {
                    rs = '<span style="color:'+this.color+'">'+this.name+'</span>: <b>'+this.y+' 元</b> <br/>';
                }
                return rs;
            }
            // pointFormat: ''
        },
        series: [{
            name: '员工',
            colorByPoint: true,
            data: []
        }],
        drilldown: {
            series: []
        }
    });
    Highcharts.chart('container3', {
        chart: {
            type: 'column'
        },
        credits:{enabled: false},
        title: {
            text: '销售总金额排名前10的员工'
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: '销售总金额'
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            column: {
                borderWidth: 0
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:11px">{point.key}</span><br>',
            pointFormatter:function () {
                rs = '<span style="color:'+this.color+'}">总金额</span>: <b>'+this.y+' 元</b> <br/>';
                return rs;
            }
            // pointFormat: ''
        },
        series: [{
            name: '员工',
            colorByPoint: true,
            data: []
        }]
    });
    Highcharts.chart('container4', {
        chart: {
            type: 'column'
        },
        credits:{enabled: false},
        title: {
            text: '销售总金额排名前10的纸种'
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: '销售总金额'
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            column: {
                borderWidth: 0
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:11px">{point.key}</span><br>',
            pointFormatter:function () {
                    rs = '<span style="color:'+this.color+'}">总金额</span>: <b>'+this.y+' 元</b> <br/>';
                return rs;
            }
            // pointFormat: ''
        },
        series: [{
            name: '纸种',
            colorByPoint: true,
            data: []
        }]
    });
}
function toDecimal2(x) {
    var f = parseFloat(x);
    if (isNaN(f)) {
        return false;
    }
    var f = Math.round(x * 100) / 100;
    return f;
}