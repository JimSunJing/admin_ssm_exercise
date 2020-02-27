<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>产品列表</title>

    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- iCheck -->
    <!-- Morris chart -->
    <!-- jvectormap -->
    <!-- Date Picker -->
    <!-- Daterange picker -->
    <!-- Bootstrap time Picker -->
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.css">-->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--数据表格-->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- Bootstrap Color Picker -->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--bootstrap-markdown-->
    <!-- Theme style -->
    <!-- AdminLTE Skins. Choose a skin from the css/skins
           folder instead of downloading all of them to reduce the load. -->
    <!-- Ion Slider -->
    <!-- ion slider Nice -->
    <!-- bootstrap slider -->
    <!-- bootstrap-datetimepicker -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->








    <!-- jQuery 2.2.3 -->
    <!-- jQuery UI 1.11.4 -->
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <!-- Bootstrap 3.3.6 -->
    <!-- Morris.js charts -->
    <!-- Sparkline -->
    <!-- jvectormap -->
    <!-- jQuery Knob Chart -->
    <!-- daterangepicker -->
    <!-- datepicker -->
    <!-- Bootstrap WYSIHTML5 -->
    <!-- Slimscroll -->
    <!-- FastClick -->
    <!-- iCheck -->
    <!-- AdminLTE App -->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- bootstrap color picker -->
    <!-- bootstrap time picker -->
    <!--<script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
    <!-- Bootstrap WYSIHTML5 -->
    <!--bootstrap-markdown-->
    <!-- CK Editor -->
    <!-- InputMask -->
    <!-- DataTables -->
    <!-- ChartJS 1.0.1 -->
    <!-- FLOT CHARTS -->
    <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
    <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
    <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
    <!-- jQuery Knob -->
    <!-- Sparkline -->
    <!-- Morris.js charts -->
    <!-- Ion Slider -->
    <!-- Bootstrap slider -->
    <!-- bootstrap-datetimepicker -->
    <!-- 页面meta /-->

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <%--页头部分--%>
    <jsp:include page="header.jsp"/>
    <%--页头部分--%>


    <%--侧边导航--%>
    <jsp:include page="aside.jsp"/>
    <%--侧边导航--%>

    <!-- 内容区域 -->
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                订单详情
            </h1>
            <ol class="breadcrumb">
                <li><a href="./home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
                <li><a href="#">基础数据</a></li>
                <li class="active">订单管理</li>
            </ol>
        </section>

            <!-- 正文区域 -->
            <section class="content"> <!--订单信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">订单信息</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">订单编号</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="订单编号"
                                   value="${order.orderNum }" readonly="readonly">
                        </div>

                        <div class="col-md-2 title">下单时间</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right"
                                       id="datepicker-a3" readonly="readonly"
                                       value="${order.orderTimeStr}">
                            </div>
                        </div>
                        <div class="col-md-2 title">路线名称</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="路线名称"
                                   value="${order.product.productName }" readonly="readonly">
                        </div>

                        <div class="col-md-2 title">出发城市</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="出发城市"
                                   value="${order.product.cityName }" readonly="readonly">
                        </div>

                        <div class="col-md-2 title">出发时间</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right"
                                       id="datepicker-a6" value="${order.product.departureTimeStr}"
                                       readonly="readonly">
                            </div>
                        </div>
                        <div class="col-md-2 title">出游人数</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="出游人数"
                                   value="${order.peopleCount}" readonly="readonly">
                        </div>

                        <div class="col-md-2 title rowHeight2x">其他信息</div>
                        <div class="col-md-10 data rowHeight2x">
                            <textarea class="form-control" rows="3" placeholder="其他信息">
                                ${order.orderDesc }
                            </textarea>
                        </div>

                    </div>
                </div>
                <!--订单信息/--> <!--游客信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">游客信息</div>
                    <!--数据列表-->
                    <table id="dataList"
                           class="table table-bordered table-striped table-hover dataTable">
                        <thead>
                        <tr>
                            <th class="">人群</th>
                            <th class="">姓名</th>
                            <th class="">性别</th>
                            <th class="">手机号码</th>
                            <th class="">证件类型</th>
                            <th class="">证件号码</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="traveller" items="${order.travellers}">

                            <tr>
                                <td>${traveller.travellerTypeStr}</td>
                                <td><input type="text" size="10" value="${traveller.name }"
                                           readonly="readonly"></td>
                                <td><input type="text" size="10" value="${traveller.sex }"
                                           readonly="readonly"></td>
                                <td><input type="text" size="20"
                                           value="${traveller.phoneNum }" readonly="readonly"></td>
                                <td><input type="text" size="15"
                                           value="${traveller.credentialsTypeStr}" readonly="readonly"></td>
                                <td><input type="text" size="28"
                                           value="${traveller.credentialsNum }" readonly="readonly"></td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                    <!--数据列表/-->
                </div>
                <!--游客信息/--> <!--联系人信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">联系人信息</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">会员</div>
                        <div class="col-md-4 data text">${order.member.nickname }</div>

                        <div class="col-md-2 title">联系人</div>
                        <div class="col-md-4 data text">${order.member.name}</div>

                        <div class="col-md-2 title">手机号</div>
                        <div class="col-md-4 data text">${order.member.phoneNum}</div>

                        <div class="col-md-2 title">邮箱</div>
                        <div class="col-md-4 data text">${order.member.email}</div>

                    </div>
                </div>
                <!--联系人信息/--> <!--费用信息--> <c:if test="${order.orderStatus==1}">
                    <div class="panel panel-default">
                        <div class="panel-heading">费用信息</div>
                        <div class="row data-type">

                            <div class="col-md-2 title">支付方式</div>
                            <div class="col-md-4 data text">在线支付-${order.payTypeStr}</div>

                            <div class="col-md-2 title">金额</div>
                            <div class="col-md-4 data text">￥${order.product.productPrice}</div>

                        </div>
                    </div>
                </c:if> <!--费用信息/--> <!--工具栏-->
                <div class="box-tools text-center">

                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回</button>
                </div>
                <!--工具栏/--> </section>
            <!-- 正文区域 /-->

                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!-- page script -->
    <!-- 内容区域 /-->

    <%--底部导航--%>
    <jsp:include page="tail.jsp"/>
    <%--底部导航--%>

    <%--底部的js--%>
    <jsp:include page="final_script.jsp"/>
    <%--底部的js--%>

    <script>
        // 改变页码大小的函数
        function changePageSize() {
            // 下拉框的值
            var size = $("#changePageSize").val();

            location.href = "${pageContext.request.contextPath}/order/findAll?page=1&pageSize="+size;
        }
    </script>
</div>
</body>
</html>
