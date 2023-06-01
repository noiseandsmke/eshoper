

<%@page import="model.TaiKhoan"%>
<%@page import="dao.TaiKhoanDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Cập nhật thông tin tài khoản </title>
        <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>
        <%
            TaiKhoanDAOImpl tkDao = new TaiKhoanDAOImpl();
            int ma_tai_khoan = Integer.parseInt(request.getParameter("ma_tai_khoan"));
            TaiKhoan tk = tkDao.getTaiKhoanTheoMa(ma_tai_khoan);
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="left.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Thông tin tài khoản</h3>
                    <form action="/MyProject/UpdateTaikhoanServlet" method="POST">
                        <table width="95%">
                            <tr>
                                <td width="125px"><b>Tên tài khoản</b></td>
                                <td><input type="text" class="pendek" name="TenTaiKhoan" value="<%=tk.getTen_tai_khoan()%>" >
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Tên đăng nhập</b></td>
                            <td><input type="text" class="pendek" name="TenDangNhap" value="<%=tk.getTen_dang_nhap()%>">
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Mật khẩu</b></td>
                            <td><input type="text" class="pendek" name="MatKhau" value="<%=tk.getMat_khau()%>">
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Quyền truy cập</b></td>
                            <td><input type="text" class="pendek" name="QuyenTruyCap" value="<%=tk.getQuyen_truy_cap()%>">
                            </td>
                        </tr>

                        <tr>
                            <td></td>
                            <td>
                                <input type="hidden" name="ma_tai_khoan" value="<%=request.getParameter("ma_tai_khoan")%>">
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
