(function (func) {
    $.ajax({
        url: "/getMonthCount",
        type: "GET",
        dataType: "json",
        success: function (data) {
            func(data);
        }
    });
})(function (data) {
    var dom = document.getElementById("map-container");
    var myChart = echarts.init(dom, "dark");
    var dataMap = {};

    function dataFormatter(pList, obj) {
        var temp;
        for (var year = 2; year <= 4; year++) {
            var max = 0;
            var sum = 0;
            temp = obj["2015-0" + year];
            for (var i = 0, l = temp.length; i < l; i++) {
                max = Math.max(max, temp[i]);
                sum += temp[i];
                obj["2015-0" + year][i] = {
                    name: pList[i],
                    value: temp[i]
                }
            }
            obj["2015-0" + year + 'max'] = Math.floor(max / 100) * 100;
            obj["2015-0" + year + 'sum'] = sum;
        }
        return obj;
    }

    dataMap.dataGDP = dataFormatter(data.page_type, data.series);


    var option = {
        baseOption: {
            timeline: {
                // y: 0,
                axisType: 'category',
                // realtime: false,
                // loop: false,
                autoPlay: true,
                // currentIndex: 2,
                playInterval: 1000,
                // controlStyle: {
                //     position: 'left'
                // },
                data: [
                    '2015-02', '2015-03', '2015-04'
                ],
                label: {
                    formatter: function (s) {
                        var date = new Date(s);
                        return date.getFullYear() + "-" + date.getMonth();
                    }
                }
            },
            title: {},
            tooltip: {},
            legend: {
                x: 'right',
                data: ['访问量'],

            },
            calculable: true,
            grid: {
                top: 80,
                bottom: 100,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow',
                        label: {
                            show: true,
                            formatter: function (params) {
                                return params.value.replace('\n', '');
                            }
                        }
                    }
                }
            },
            xAxis: [
                {
                    'type': 'category',
                    'axisLabel': {'interval': 0},
                    'data': data.page_type,
                    splitLine: {show: false}
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '次数'
                }
            ],
            series: [
                {name: '访问量', type: 'bar'},

            ]
        },
        options: [
            {
                title: {text: '2015年2月访问情况'},
                series: [
                    {data: dataMap.dataGDP['2015-02']},

                ]
            }, {
                title: {text: '2015年3月访问情况'},
                series: [
                    {data: dataMap.dataGDP['2015-03']},

                ]
            }, {
                title: {text: '2015年4月访问情况'},
                series: [
                    {data: dataMap.dataGDP['2015-04']},

                ]
            }
        ]
    };

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }


});