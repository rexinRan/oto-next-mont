(function(){

    $.ajax({
        url: "http://csee-china.cn/dxs-server/dxsDistProvinceController/list.do",
        crossDomain: true,
        dataType: 'jsonp',
        jsonp: 'callback',
        jsonpCallback: 'data',
        success: function (data, textStatus) {
            console.info(1);
            console.info(data.data);
            var html = "";
            for (var i = 0; i < data.data.length; i++) {
                html += ("<option id='" + (data.data)[i].provinceid + "'>" + (data.data)[i].pname + "</option>");
            }

            $("#privence").append(html);
            $("#city").empty().append("<option value='0'>-请选择-</option>");
            $("#area").empty().append("<option value='0'>-请选择-</option>");
            geetcity();
            geetarea();
        },
        error: function () {

        }


    });

    function geetcity() {
        $("#privence").change(function(){
            var pid = $("#privence option:selected").attr("id");
            $.ajax({
                url: "http://csee-china.cn/dxs-server/dxsDistCityController/provinceLinkageCity.do?provinceid=" + pid,
                crossDomain: true,
                dataType: 'jsonp',
                jsonp : 'callback',
                jsonpCallback: 'data',
                success: function(data, textStatus){
                    console.info(data);
                    var html ="";
                    html+= ("<option value='0'>-请选择-</option>");
                    for (var i=0; i<data.data.length; i++) {
                        html +=("<option id='"+(data.data)[i].cityid+"'>"+ (data.data)[i].city +"</option>");

                    }

//				   $("#privence").append(html);
//					 $("#city").empty().append(html);
                    $("#city").empty().append(html);
//					 $("#area").empty().append(html);
                    geetarea();
                },
                error: function(){

                }


            });
        });
    }

    function geetarea() {
        $("#city").change(function(){
            var pida = $("#city option:selected").attr("id");
            $.ajax({
                url: "http://csee-china.cn/dxs-server/dxsDistAreaController/CityLinkageArea.do?cityid=" + pida,
                crossDomain: true,
                dataType: 'jsonp',
                jsonp : 'callback',
                jsonpCallback: 'data',
                success: function(data, textStatus){
                    console.info(data);
                    var html = "";
                    for (var i=0; i<data.data.length; i++) {
                        html +=("<option id='(data.data)[i].areaid'>"+ (data.data)[i].area +"</option>");
                    }

//				   $("#privence").append(html);
//				  $("#city").empty().append(html);
                    $("#area").empty().append(html);
                },
                error: function(){

                }


            });
        });
    }

})();