

<%@page import="java.util.ArrayList"%>
<%@page import="model.TaiKhoan"%>
<%@page import="dao.TaiKhoanDAOImpl"%>
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
                <h3>Quản lý danh mục</h3>

                <p><a href="/MyProject/admin/insertUser.jsp">Thêm tài khoản </a></p>                 
                <table class="data" style="width: 900px">
                    <tr class="data">
                        <th class="data" width="30px">STT</th>
                        <th class="data">Mã tài khoản</th>
                        <th class="data">Tên tài khoản</th>
                        <th class="data">Tên đăng nhập</th>
                        <th class="data">Mật khẩu</th>
                        <th class="data">Quyền truy cập</th>

                        <th class="data" width="75px">Tùy chọn</th>
                    </tr>
                <%  TaiKhoanDAOImpl tkdao = new TaiKhoanDAOImpl();
                    ArrayList<TaiKhoan> arr = tkdao.getListTaiKhoan();
                    int start = 0, end = 9;
                    if (arr.size() < 9) {
                        end = arr.size();

                    }
                    if (request.getParameter("start") != null) {
                        start = Integer.parseInt(request.getParameter("start"));

                    }
                    if (request.getParameter("end") != null) {
                        end = Integer.parseInt(request.getParameter("end"));

                    }
                    ArrayList<TaiKhoan> list = tkdao.getListTaiKhoanTheoTrang(arr, start, end);
                    int count = 0;
                    for (TaiKhoan tk : list) {
                        count++;
                %>


                <tr class="data">
                    <td class="data" width="30px"><%=count%></td>
                    <td class="data"><%=tk.getMa_tai_khoan()%></td>
                    <td class="data"><%=tk.getTen_tai_khoan()%></td>
                    <td class="data"><%=tk.getTen_dang_nhap()%></td>
                    <td class="data"><%=tk.getMat_khau()%></td>
                    <td class="data"><%=tk.getQuyen_truy_cap()%></td>

                    <td class="data" width="75px">
                <center>
                    <a href="/MyProject/admin/updateUser.jsp?ma_tai_khoan=<%=tk.getMa_tai_khoan()%>">Sửa</a>&nbsp;||&nbsp;&nbsp;
                    <a href="/MyProject/DeleteUserServlet?ma_tai_khoan=<%=tk.getMa_tai_khoan()%>">Xóa</a>
                </center>
                </td>
                </tr>
                <% }%>
            </table>
            <ul class="pagination">
                <%
                    int a, b;
                    int limit = arr.size() / 9;
                    if (limit * 9 < arr.size()) {
                        limit += 1;
                    }
                    for (int i = 1; i <= limit; i++) {
                        a = (i - 1) * 9;
                        b = i * 9;
                        if (b > arr.size()) {
                            b = arr.size();
                        }

                %>
                <li ><a href="/MyProject/admin/manager_user.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                    <% }
                    %>
            </ul>
        </div>
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
