layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#flightList',
        url : '/findAllFlight',
        cellMinWidth : 95,
        page : true,
        height : "full-100",
        limit : 20,
        limits:[10,15,20,25],
        id : "flightListTable",
        cols:[[
            {type: 'checkbox', fixed:'left', },
            {type:'numbers',title:'序号'},
            {field: 'flightId', title: 'ID', width:80, align:"center"},
            {field: 'flightPrice', title: '价格',width:80,align:"center"},
            {field: 'flightSeats', title: '座位数',align:'center'},
            {field: 'flightFromCity', title: '出发地',align:'center'},
            {field: 'flightToCity', title: '目的地',width:120, align:'center'},
            {title: '操作',  templet:'#flightOperate',width:120,fixed:"right",align:"center"}
        ]]
    });

    function addFlight(){
        var index = layui.layer.open({
            title : "添加航班",
            type : 2,
            content : "addFlight.html",
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }


    $(".addFlight_btn").click(function(){
        addFlight();
    })


    //编辑机票
    function editFlight(edit){
        var index = layui.layer.open({
            title : "编辑",
            type : 2,
            content : "editFlight.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".flightId").val(edit.flightId);
                    body.find(".flightPrice").val(edit.flightPrice);
                    body.find(".flightSeats").val(edit.flightSeats);
                    body.find(".flightFromCity").val(edit.flightFromCity);
                    body.find(".flightToCity").val(edit.flightToCity);

                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回机票列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }

    //列表操作
    table.on('tool(flightList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑

            editFlight(data);

        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此机票？',{icon:3, title:'提示信息'},function(index){
                $.post("/deleteFlightById",{
                    id : data.flightId  //将需要删除的newsId作为参数传入
                },function(data){
                    // tableIns.reload();
                    layer.close(index);
                    layer.msg("权限不够！");

                })
            });
        } else if(layEvent === 'look'){ //预览
            layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问")
        }
    });


})