<%-- 
    Document   : update_typenews
    Created on : May 11, 2017, 12:05:18 AM
    Author     : Nguyen
--%>

<%@page import="model.LoaiTin"%>
<%@page import="dao.LoaiTinDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <jsp:include page="header.jsp"></jsp:include>

        <div id="wrapper">

        <jsp:include page="left.jsp"></jsp:include>

            <div id="rightContent">
                <h3>Cập nhật thông tin danh mục sản phẩm</h3>
                <form action="/MyProject/UpdateTypeNewServlet" method="POST">
                    <table width="95%">
                    <%  LoaiTinDAOImpl loaiTinDAO= new LoaiTinDAOImpl();
                    LoaiTin loai_tin= new LoaiTin();
               loai_tin = loaiTinDAO.getLoaiTin(Integer.parseInt(request.getParameter("ma_loai_tin")));
                       
                    %>
                    <tr>
                        <td width="125px"><b>Tên danh mục</b></td>
                        <td><input type="text" class="pendek" name="TenLoaiTin" value="<%=loai_tin.getTen_loai_tin() %>"></td></tr>

                   
                    <tr><td></td><td>
                            <input type="hidden" name="ma_loai_tin" value="<%=request.getParameter("ma_loai_tin") %>">
                            <input type="submit" class="button" value="Lưu dữ liệu">
                        </td>
                    </tr>

                </table>
            </form>
        </div>
        <div class="clear"></div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
