<%-- 
    Document   : news
    Created on : May 7, 2017, 10:53:33 PM
    Author     : Nguyen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.TinTuc"%>
<%@page import="dao.TinTucDAOImpl"%>
<%@page import="dao.LoaiTinDAOImpl"%>
<%@page import="model.LoaiTin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tin tức</title>
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
    </head>
    <body>
        <%  LoaiTinDAOImpl loaiTinDAO = new LoaiTinDAOImpl();
            TinTucDAOImpl tinTucDAO = new TinTucDAOImpl();
            int ma_loai_tin = Integer.parseInt(request.getParameter("ma_loai_tin"));
            ArrayList<TinTuc> arr = tinTucDAO.getListTinTucTheoLoaiTin(ma_loai_tin);
            int start = 0, end = 2;
            if (arr.size() < 2) {
                end = arr.size();

            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));

            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));

            }
            ArrayList<TinTuc> list = tinTucDAO.getListTinTucTheoTrang(arr, start, end);

        %>
        <jsp:include page="header.jsp"></jsp:include>
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
                        <%  for (TinTuc tt : list) {
                        %>
                        <div class="single-blog-post">
                            <h3><%=tt.getTen_tin_tuc()%></h3>
                            <div class="post-meta">
                                <ul>

                                    <li><i class="fa fa-calendar"></i><%=tt.getNgay_dang()%></li>
                                </ul>

                            </div>
                            <a href="">
                                <img style="width:600px;height: 300px"  src="/MyProject/ImagesProduct/<%=tt.getHinh_anh()%>" alt="">
                            </a>
                            <p><%=tt.getTieu_de()%></p>
                            <a  class="btn btn-primary" href="readnew.jsp?ma_tin_tuc=<%=tt.getMa_tin_tuc()%>">Đọc thêm</a>
                        </div>
                        <% } %>
                        <div style="clear: both"></div>
                        <ul class="pagination">
                            <%
                                int a, b;
                                int limit = arr.size() / 2;
                                if (limit * 2 < arr.size()) {
                                    limit += 1;
                                }
                                for (int i = 1; i <= limit; i++) {
                                    a = (i - 1) * 2;
                                    b = i * 2;
                                    if (b > arr.size()) {
                                        b = arr.size();
                                    }

                            %>
                            <li class="active"><a href="typenews.jsp?ma_loai_tin=<%=ma_loai_tin %>&start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                                <% }
                                %>
                        </ul>


                    </div>
                </div>
            </div>

        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
