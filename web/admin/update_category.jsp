<%-- 
    Document   : update_category
    Created on : May 10, 2017, 3:50:31 PM
    Author     : Nguyen
--%>

<%@page import="dao.DanhMucDAOImpl"%>
<%@page import="model.DanhMuc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

        <div id="wrapper">

        <jsp:include page="left.jsp"></jsp:include>

            <div id="rightContent">
                <h3>Cập nhật thông tin danh mục sản phẩm</h3>
                <form action="/MyProject/UpdateCategoryServlet" method="POST">
                    <table width="95%">
                    <%  DanhMucDAOImpl danh_mucdao = new DanhMucDAOImpl();
                        DanhMuc dm = new DanhMuc();
                        dm = danh_mucdao.getDanhMuc(Integer.parseInt(request.getParameter("ma_danh_muc")));
                    %>
                    <tr>
                        <td width="125px"><b>Tên danh mục</b></td>
                        <td><input type="text" class="pendek" name="TenDanhMuc" value="<%=dm.getTen_danh_muc()%>"></td></tr>

                   
                    <tr><td></td><td>
                            <input type="hidden" name="ma_danh_muc" value="<%=request.getParameter("ma_danh_muc") %>">
                            <input type="submit" class="button" value="Lưu dữ liệu">
                        </td>
                    </tr>

                </table>
            </form>
        </div>
        <div class="clear"></div>

        <jsp:include page="footer.jsp"></jsp:include>

    </div>
</body>
</html>
