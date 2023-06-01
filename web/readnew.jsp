<%-- 
    Document   : typenews
    Created on : May 8, 2017, 2:59:52 PM
    Author     : Nguyen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.TinTuc"%>
<%@page import="dao.TinTucDAOImpl"%>
<%@page import="model.LoaiTin"%>
<%@page import="dao.LoaiTinDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Tin tức</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>
        <%  LoaiTinDAOImpl loaiTinDAO = new LoaiTinDAOImpl();
            TinTucDAOImpl tinTucDAO = new TinTucDAOImpl();
            int ma_tin_tuc = Integer.parseInt(request.getParameter("ma_tin_tuc"));
            TinTuc tt = tinTucDAO.getListTinTucTheoMa(ma_tin_tuc);
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="slider.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <h2>Loại tin</h2>
                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                            <% for (LoaiTin loaitin : loaiTinDAO.getListLoaiTin()) {


                            %>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="typenews.jsp?ma_loai_tin=<%=loaitin.getMa_loai_tin()%>">
                                            <%=loaitin.getTen_loai_tin()%>

                                        </a>
                                    </h4>
                                </div>

                            </div>
                            <%
                                }%>
                        </div>


                    </div>
                  </div>
                <div class="col-sm-9">
                    <div class="blog-post-area">
                        <h2 class="title text-center">TIN TỨC</h2>
                        <div class="single-blog-post">
                            <h3><%=tt.getTen_tin_tuc()%></h3>
                            <div class="post-meta">
                                <ul>

                                    <li><i class="fa fa-calendar"></i><%=tt.getNgay_dang()%></li>
                                </ul>

                            </div>
                            <a href="">
                                <img src="/MyProject/ImagesProduct/<%=tt.getHinh_anh()%>" alt="">
                            </a>
                            <p><%=tt.getNoi_dung()%></p>

                        </div>
                    </div><!--/blog-post-area-->



                    <div class="socials-share">
                        <a href=""><img src="images/blog/socials.png" alt=""></a>
                    </div><!--/socials-share-->
                </div>	
            </div>
        </div>

    </div>

</body>
</html>
