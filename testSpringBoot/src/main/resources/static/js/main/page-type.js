(function (func) {
    $.ajax({
        url: "/getPageType",
        type: "GET",
        dataType: "json",
        success: function (data) {
            func(data);
        }
    });
})(function (data) {

    var dom = document.getElementById("page_type");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '网页类型';

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
                name: '网页类型',
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