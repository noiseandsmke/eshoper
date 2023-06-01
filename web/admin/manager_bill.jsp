

<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="dao.TaiKhoanDAOImpl"%>
<%@page import="model.HoaDon"%>
<%@page import="dao.HoaDonDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <%
        HoaDonDAOImpl hoaDonDAO = new HoaDonDAOImpl();
        TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();
        ArrayList<HoaDon> arr = hoaDonDAO.getListHoaDon();
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
        ArrayList<HoaDon> list = hoaDonDAO.getListHoaDonTheoTrang(arr, start, end);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(0);
    %>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Quản lý loại hóa đơn</h3>


                <table class="data" style="width: 900px" >
                    <tr class="data">
                        <th class="data" width="50px">STT</th>
                        <th class="data" width="200px" >Mã hóa đơn</th>
                        <th class="data" width="200px">Tài khoản</th>
                        <th class="data" width="200px">Tổng tiền</th>
                        <th class="data" width="200px">Địa chỉ giao hàng</th>
                        <th class="data" width="200px">Số điện thoại</th>
                        <th class="data" width="200px">Phương thức thanh toán</th>
                        <th class="data" width="200px">Tình trạng đơn hàng</th>

                        <th class="data" width="400px">Tùy chọn</th>

                    </tr>
                <%
                    int count = 0;
                    for (HoaDon hd : list) {
                        count++;
                %>
                <tr class="data">
                    <td class="data" ><%=count%></td>
                    <td class="data"><%=hd.getMa_hoa_don()%></td>
                    <td class="data"  ><%=taiKhoanDAO.getTaiKhoanTheoMa(hd.getMa_tai_khoan()).getTen_tai_khoan()%></td>
                    <td class="data"><%=nf.format(hd.getTong_tien())%></td>
                    <td class="data"><%=hd.getDia_chi_giao_hang()%></td>
                    <td class="data"><%=hd.getSo_dien_thoai() %></td>
                    <td class="data" ><%=hd.getPhuong_thuc_thanh_toan()%></td>
                    <% if (hd.getTinh_trang_don_hang() == 1) { %> <td class="data">Đã giao hàng</td>
                    <% } else { %>   <td class="data">Chưa giao hàng</td>


                    <% }%>
                    <td class="data" >
                        <a href="/MyProject/UpdateBillServlet?ma_hoa_don=<%=hd.getMa_hoa_don()%>&command=update">Cập nhật</a> ||  
                        <a href="/MyProject/admin/detail_bill.jsp?ma_hoa_don=<%=hd.getMa_hoa_don()%>"> Xem chi tiet </a>
                    </td>


                </tr>
                <% }
                %>
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
                <li ><a href="/MyProject/admin/manager_bill.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                    <% }
                    %>
            </ul>

        </div>
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
