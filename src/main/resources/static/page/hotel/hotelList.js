layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#hotelList',
        url : '/findAllHotel',
        cellMinWidth : 95,
        page : true,
        height : "full-100",
        limit : 20,
        limits:[10,15,20,25],
        id : "hotelListTable",
        cols:[[
            {type: 'checkbox', fixed:'left', },
            {type:'numbers',title:'序号'},
            {field: 'hotelId', title: 'ID', width:80, align:"center"},
            {field: 'hotelName', title: '酒店名',width:80,align:"center"},
            {field: 'hotelPrice', title: '价格',align:'center'},
            {field: 'hotelLocation', title: '地址',align:'center'},
            {field: 'hotelRooms', title: '房间数',width:120, align:'center'},
            {title: '操作',  templet:'#hotelOperate',width:120,fixed:"right",align:"center"}
        ]]
    });


    //编辑机票
    function editHotel(edit){
        var index = layui.layer.open({
            title : "编辑",
            type : 2,
            content : "editHotel.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".hotelId").val(edit.hotelId);
                    body.find(".hotelName").val(edit.hotelName);
                    body.find(".hotelPrice").val(edit.hotelPrice);
                    body.find(".hotelLocation").val(edit.hotelLocation);
                    body.find(".hotelRooms").val(edit.hotelRooms);

                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回酒店列表', '.layui-layer-setwin .layui-layer-close', {
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

    //添加酒店
    function addHotel(){
        var index = layui.layer.open({
            title : "添加酒店",
            type : 2,
            content : "addHotel.html",
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }


    $(".addHotel_btn").click(function(){
        addHotel();
    })

    //列表操作
    table.on('tool(hotelList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑

            editHotel(data);

        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此酒店？',{icon:3, title:'提示信息'},function(index){
                $.post("/deleteHotelById",{
                    id : data.hotelId //将需要删除的newsId作为参数传入
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