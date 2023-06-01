<%-- 
    Document   : newItem
    Created on : May 20, 2017, 10:56:49 PM
    Author     : Nguyen
--%>

<%@page import="dao.LoaiTinDAOImpl"%>
<%@page import="model.LoaiTin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% LoaiTinDAOImpl loaiTinDAO = new LoaiTinDAOImpl();
        %>
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
    </body>
</html>
