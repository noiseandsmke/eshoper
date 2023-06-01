<%-- 
    Document   : category
    Created on : Apr 25, 2017, 9:14:47 PM
    Author     : Nguyen
--%>

<%@page import="model.DanhMuc"%>
<%@page import="dao.DanhMucDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <%
            DanhMucDAOImpl danhMucDAO = new DanhMucDAOImpl();
        %>
        <div class="col-sm-3">
            <div class="left-sidebar">
                <h2>Danh mục điện thoại</h2>
                <div class="well panel-group category-products" id="accordian"><!--category-productsr-->

                    <%
                        for (DanhMuc dannh_muc : danhMucDAO.getListDanhMuc()) {

                    %>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="index.jsp?ma_danh_muc=<%=dannh_muc.getMa_danh_muc() %>">

                                    <%=dannh_muc.getTen_danh_muc()%>
                                </a>
                            </h4>
                        </div>
                       
                    </div>
                    <% }%>


                </div><!--/category-products-->
                
<!--                <div class="price-range">price-range
                    <h2>Giá sản phẩm</h2>
                    <div class="well">
                        <ul>
                            <li><a href="SearchPriceServlet?gia1=0&gia2=1000000">0-10000 VND</li>
                            <li> 
                                <form method="Post" action="SearchPriceServlet">
                                    <input type="text" name="gia1" placeholder="Nhập tên muốn tìm">
                                    <input type="submit" value="Tìm kiếm" name="search">
                                </form>10000-3000000 VND</li>
                            <li><a href="SearchPriceServlet?gia1=3000000&gia2=5000000">30000-5000000 VND</a></li>
                            <li><a href="SearchPriceServlet?gia1=5000000&gia2=7000000">50000-7000000 VND</a></li>
                            <li><a href="SearchPriceServlet?gia1=7000000&gia2=10000000">70000-1000000 VND</a></li>
                            <li><a href="SearchPriceServlet?gia1=7000000&gia2=15000000">100000-1500000 VND</a></li>
                            <li><a href="SearchPriceServlet?gia1=15000000&gia2=30000000">150000-3000000 VND</a></li>
                        </ul>
                       
                         
                    </div>

                </div>-->
              

                <div class="shipping text-center"><!--shipping-->
                    <a href="shiper.jsp">  <img src="images/home/shipping.jpg" alt="" /></a>
                </div><!--/shipping-->
                <br/>

            </div>
        </div>
    </body>
</html>
