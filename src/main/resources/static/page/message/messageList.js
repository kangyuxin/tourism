layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#messageList',
        url : '/findAllMessage',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 20,
        limits:[10,15,20,25],
        id : "messageListTable",
        cols:[[
            {type: 'checkbox', fixed:'left', },
            {type:'numbers',title:'序号'},
            {field: 'messageId', title: '留言ID', width:80, align:"center"},
            {field: 'messageContent', title: '留言内容',align:"center"},
            {field: 'userName', title: '留言用户',width:150,align:'center'},
            {field: 'createTime', title: '留言时间',width:180, align:'center'},
            {title: '操作',  templet:'#messageOperate',width:120,fixed:"right",align:"center"}
        ]]
    });

    //添加留言
    function addMessage(){
        var index = layui.layer.open({
            title : "添加留言",
            type : 2,
            content : "addMessage.html",
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }


    $(".addMessage_btn").click(function(){
        addMessage();
    })


    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //编辑留言
    function addNews(edit){
        var index = layui.layer.open({
            title : "编辑留言",
            type : 2,
            content : "editMessage.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".messageId").val(edit.messageId);
                    body.find(".messageContent").val(edit.messageContent);
                    body.find(".createTime").val(edit.createTime);
                    body.find(".userName").val(edit.userName);


                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回留言列表', '.layui-layer-setwin .layui-layer-close', {
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
    $(".addNews_btn").click(function(){
        addNews();
    })


    //列表操作
    table.on('tool(messageList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑

            addNews(data);

        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此条留言？',{icon:3, title:'提示信息'},function(index){
                $.post("/deleteMessageById",{
                   id : data.messageId //将需要删除的newsId作为参数传入
                },function(data){

                    tableIns.reload();
                    layer.close(index);
                   layer.msg("删除成功");

                })
            });
        } else if(layEvent === 'look'){ //预览
            layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问")
        }
    });

})