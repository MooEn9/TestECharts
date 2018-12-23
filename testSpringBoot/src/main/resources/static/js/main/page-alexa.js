(function (func) {
    $.ajax({
        url: "/getPageAlexa",
        type: "GET",
        dataType: "json",
        success: function (data) {
            func(data);
        }
    });
})(function (data) {

    var dom = document.getElementById("page_alexa");
    var myChart = echarts.init(dom, 'dark');
    var app = {};
    option = null;
    app.title = '访问排名';

    option = {
        title: {

        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['网页排名']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01]
        },
        yAxis: {
            type: 'category',
            data: data.yAxis_data
        },
        series: [
            {
                name: '网页排名',
                type: 'bar',
                data: data.series_data
            }
        ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }

});