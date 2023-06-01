<%-- 
    Document   : update_new
    Created on : May 11, 2017, 8:41:34 AM
    Author     : Nguyen
--%>

<%@page import="model.TinTuc"%>
<%@page import="dao.TinTucDAOImpl"%>
<%@page import="model.LoaiTin"%>
<%@page import="dao.LoaiTinDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhât tin tức</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
    </head>
    <body>
        <% TinTucDAOImpl tinTucDAO = new TinTucDAOImpl();
            TinTuc tt = tinTucDAO.getListTinTucTheoMa(Integer.parseInt(request.getParameter("ma_tin_tuc")));
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">

            <jsp:include page="left.jsp"></jsp:include>

                <div id="rightContent">
                    <h3> Nhập tin tức</h3>
                    <form action="/MyProject/UpdateNewServlet" method="POST" enctype="multipart/form-data">
                        <table width="95%">


                            <tr>
                                <td><b>Mã loại tin </b> </td>
                                <td>
                                    <select name="MaLoaiTin" >
                                        <option selected> Lựa chọn</option>
                                    <% LoaiTinDAOImpl loaiTinDAO = new LoaiTinDAOImpl();
                                        for (LoaiTin lt : loaiTinDAO.getListLoaiTin()) {

                                    %>
                                    <option  value="<%=lt.getMa_loai_tin()%>" <% if (lt.getMa_loai_tin() == tt.getMa_loai_tin()) {
                                             %>selected="true"<%
                                             } else {%> <%
                                            }
                                             %>>
                                        <%=lt.getTen_loai_tin()%>
                                    </option>

                                    <% }%>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Tên tin tức</b></td>
                            <td><input type="text" class="pendek" name="TenTinTuc" value="<%=tt.getTen_tin_tuc()%>">
                            </td>
                        </tr>



                        <tr>
                            <td width="125px"><b>Tiêu đề</b></td>
                            <td><input type="text" class="pendek" name="TieuDe" value="<%=tt.getTieu_de()%>">
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Nội dung</b></td>
                             <td>
                                <textarea  type="text" class="form-textarea" id="noiDung" name="NoiDung"><%=tt.getNoi_dung() %></textarea>
                                <script type="text/javascript" language="javascript">
                                    CKEDITOR.replace('noiDung', {width: '500px', height: '300px'});
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Hình ảnh</b></td>
                            <td>
                                <input type="file" name="HinhAnh" value="/MyProject/ImagesProduct/<%=tt.getHinh_anh()%>" />
                                <img style="width: 50px;heigth:70px;" src="/MyProject/ImagesProduct/<%=tt.getHinh_anh()%>" >
                            </td>

                        </tr>
                        <tr>
                            <td width="125px"><b>NgayDang</b></td>
                            <td><input type="text" class="pendek" name="NgayDang" value="<%=tt.getNgay_dang()%>">
                            </td>
                        </tr>



                        <tr><td></td><td>
                                <input type="hidden" name="ma_tin_tuc" value="<%=request.getParameter("ma_tin_tuc")%>">
                                <input type="submit" class="button" value="Lưu dữ liệu">


                    </table>
                </form>
            </div>
            <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
