(function (func) {
    $.ajax({
        url: "/getOtherInnerPageType",
        type: "GET",
        dataType: "json",
        success: function (data) {
            func(data);
        }
    });
})(function (data) {

    var dom = document.getElementById("other-inner-page");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '其他类数据构成';

    option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data: data.legend_data
        },
        series: [
            {
                name: '其他类占比',
                type: 'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: data.series_data
            }
        ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }

});