
<%@page import="model.LoaiTin"%>
<%@page import="dao.LoaiTinDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">

            <jsp:include page="left.jsp"></jsp:include>

                <div id="rightContent">
                    <h3> Nhập tin tức</h3>
                    <form action="/MyProject/UpLoadNewServlet" method="POST" enctype="multipart/form-data">
                        <table width="95%">


                            <tr>
                                <td><b>Mã loại tin </b> </td>
                                <td>
                                    <select name="MaLoaiTin" >
                                        <option selected> Lựa chọn</option>
                                    <%   LoaiTinDAOImpl loaiTinDAO = new LoaiTinDAOImpl();
                                        for (LoaiTin loaitin : loaiTinDAO.getListLoaiTin()) {
                                    %>
                                    <option  value="<%=loaitin.getMa_loai_tin()%>"><%=loaitin.getTen_loai_tin()%></option>
                                    <% }%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Tên tin tức</b></td>
                            <td><input type="text" class="pendek" name="TenTinTuc">
                            </td>
                        </tr>



                        <tr>
                            <td width="125px"><b>Tiêu đề</b></td>
                            <td><input type="text" class="pendek" name="TieuDe">
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Nội dung</b></td>
                            <td>
                                <textarea  type="text" class="form-textarea" id="noiDung" name="NoiDung"></textarea>
                                <script type="text/javascript" language="javascript">
                                    CKEDITOR.replace('noiDung', {width: '500px', height: '300px'});
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Hình ảnh</b></td>
                            <td>
                                <input type="file" name="HinhAnh" />
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
    </body>
</html>
