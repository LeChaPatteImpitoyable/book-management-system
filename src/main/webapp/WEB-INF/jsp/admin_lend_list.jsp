<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>借还日志</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <script src="js/layui.all.js" ></script>
    <style src="css/layui.css"></style>
    <script src="js/initPage.js" ></script>
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>

</head>
<body>
<jsp:include page="head.jsp"/>
<div style="padding: 70px 550px 10px">
    <form   method="post" action="querybook.html" class="form-inline"  id="searchform">
        <div class="input-group">
            <input type="text" placeholder="输入图书名" class="form-control" id="search" name="searchWord" class="form-control">
            <span class="input-group-btn">
                            <input type="submit" value="搜索" class="btn btn-default">
            </span>
        </div>
    </form>
    <script>
        function mySubmit(flag){
            return flag;
        }
        $("#searchform").submit(function () {
            var val=$("#search").val();
            if(val==''){
                alert("请输入关键字");
                return mySubmit(false);
            }
        })
    </script>
</div>
<div style="position: relative;top: 10%">
    <c:if test="${!empty succ}">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${succ}
        </div>
    </c:if>
    <c:if test="${!empty error}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${error}
        </div>
    </c:if>
</div>
<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading">
        <h3 class="panel-title">
            借还日志
        </h3>
    </div>
    <div class="panel-body" id="listBody">
        <jsp:include page="lend_list.jsp" />
    </div>
    <div style="width: 90%;text-align: center;background-color: #ffffff;margin-left: 5%;margin-bottom: 15px;">
        <div id="page"></div>
    </div>
</div>

<script>

    //    setTimeout(function(){document.getElementsByClassName("alert-dismissable").style.display="none";},1000);
    //
    //    $(document).ready(function(){//页面加载完之后，自动执行该方法
    //        setTimeout(function(){$("#test").hide();},2000);//2秒后执行该方法
    //    });

    /**
     * 纯粹的JS分页插件，代码缺点：JS操作DOM冗余太多，太繁琐
     */
    pageUtil.initPage('page',{
        totalCount:${totalCount},//总页数，一般从回调函数中获取。如果没有数据则默认为1页
        curPage:1,//初始化时的默认选中页，默认第一页。如果所填范围溢出或者非数字或者数字字符串，则默认第一页
        showCount:9,//分页栏显示的数量
        pageSizeList:[9],//自定义分页数，默认[5,10,15,20,50]
        defaultPageSize:9,//默认选中的分页数,默认选中第一个。如果未匹配到数组或者默认数组中，则也为第一个
        isJump:false,//是否包含跳转功能，默认false
        isPageNum:false,//是否显示分页下拉选择，默认false
        isPN:true,//是否显示上一页和下一面，默认true
        isFL:true,//是否显示首页和末页，默认true
        jump:function(curPage,pageSize){//跳转功能回调，传递回来2个参数，当前页和每页大小。如果没有设置分页下拉，则第二个参数永远为0。这里的this被指定为一个空对象，如果回调中需用到this请自行使用bind方法
            console.log(curPage,pageSize);
            if(pageSize == 0){
                pageSize = 9;
            }
            refrechHtm(curPage,pageSize);
//            $("#book_list").html("");
        },
    });

    function refrechHtm (curPage,pageSize) {
        $.ajax({
            type: "get",
            url: "/lendlist_do.html?curPage="+curPage+"&pageSize="+pageSize,
            dateType: "html",
            success: function (res) {
                console.log(JSON.stringify(${totalCount}));
                $("#listBody").html(res);
            }
        });
    }
</script>

</body>
</html>
