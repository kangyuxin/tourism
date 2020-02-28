layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#carList',
        url : '/findAllCar',
        cellMinWidth : 95,
        page : true,
        height : "full-100",
        limit : 20,
        limits:[10,15,20,25],
        id : "carListTable",
        cols:[[
            {type: 'checkbox', fixed:'left', },
            {type:'numbers',title:'序号'},
            {field: 'carId', title: 'ID', width:80, align:"center"},
            {field: 'carPrice', title: '价格',width:80,align:"center"},
            {field: 'carSeats', title: '座位数',align:'center'},
            {field: 'carLocation', title: '地址',align:'center'},
            {title: '操作',  templet:'#carOperate',width:120,fixed:"right",align:"center"}
        ]]
    });

    function addCar(){
        var index = layui.layer.open({
            title : "添加出租车",
            type : 2,
            content : "addCar.html",
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }


    $(".addCar_btn").click(function(){
        addCar();
    })


    //编辑机票
    function editCar(edit){
        var index = layui.layer.open({
            title : "编辑",
            type : 2,
            content : "editCar.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".carId").val(edit.carId);
                    body.find(".carPrice").val(edit.carPrice);
                    body.find(".carSeats").val(edit.carSeats);
                    body.find(".carLocation").val(edit.carLocation);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回出租车列表', '.layui-layer-setwin .layui-layer-close', {
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
    table.on('tool(carList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑

            editCar(data);

        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此出租车？',{icon:3, title:'提示信息'},function(index){
                $.post("/deleteCarById",{
                    id : data.carId //将需要删除的newsId作为参数传入
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