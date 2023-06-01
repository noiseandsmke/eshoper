

<%@page import="dao.DanhMucDAOImpl"%>
<%@page import="model.DanhMuc"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Thông tin danh mục sản phẩm</h3>
                <form action="/MyProject/UpLoadCategoryServlet" method="POST">
                    <table width="95%">
                        <tr>
                            <td width="125px"><b>Tên danh mục</b></td>
                            <td><input type="text" class="pendek" name="TenDanhMuc">
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>

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
