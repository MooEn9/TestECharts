(function (func) {
    $.ajax({
        url: "/getUserClickStats",
        type: "GET",
        dataType: "json",
        success: function (data) {
            func(data);
        }
    });
})(function (data) {

    var dom = document.getElementById("UserClickStats");
    var myChart = echarts.init(dom,'dark');
    var option = {
        xAxis: {
            scale: true
        },
        yAxis: {
            scale: true
        },
        series: [{
            type: 'effectScatter',
            symbolSize: 20,
            data: data.series_effectScatter
        }, {
            type: 'scatter',
            data: data.series_scatter,
        }]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }

});