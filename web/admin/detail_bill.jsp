<%-- 
    Document   : detail_bill
    Created on : May 18, 2017, 3:29:27 PM
    Author     : Nguyen
--%>

<%@page import="dao.SanPhamDAOImpl"%>
<%@page import="model.ChiTietHoaDon"%>
<%@page import="dao.ChiTietHoaDonDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <%
        String exportToExcel = request.getParameter("exportToExcel");
        if (exportToExcel != null
                && exportToExcel.toString().equalsIgnoreCase("YES")) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "inline;filename="
                    + "excel.xls");
            response.setIntHeader("Nguyen Van DUoc", 10);

        }
    %>

    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Quản lý loại tin tức</h3>


                <table class="data">
                    <tr class="data">
                        <th class="data">Mã chi tiết</th>
                        <th class="data">Mã sản phẩm</th>
                        <th class="data">Số lượng</th>
                        <th class="data">Đơn giá</th>
                        <th class="data">Giảm giá</th>      
                        <th class="data">Thành tiền</th>
                    </tr>
                <% SanPhamDAOImpl sanPhamDAO = new SanPhamDAOImpl();
                    int ma_hoa_don = Integer.parseInt(request.getParameter("ma_hoa_don"));
                    ChiTietHoaDonDAOImpl chiTietHoaDonDAOImpl = new ChiTietHoaDonDAOImpl();
                    for (ChiTietHoaDon cthd : chiTietHoaDonDAOImpl.getListChiTietHoaDonTheoMaHoaDon(ma_hoa_don)) {
                %>
                <tr class="data">
                    <td class="data"><%=cthd.getMa_chi_tiet_hoa_don()%></td>

                    <td class="data"><%=sanPhamDAO.getChiTietSanPham(cthd.getMa_san_pham()).getTen_san_pham()%></td>
                    <td class="data"><%=cthd.getSo_luong()%></td>
                    <td class="data"><%=cthd.getDon_gia()%></td>
                    <td class="data"><%=cthd.getGiam_gia()%></td>
                    <td class="data"><%=cthd.getThanh_tien()%></td>

                </tr>
                <% }%>

            </table>
            <%
                if (exportToExcel == null) {
            %>
            <a href="detail_bill.jsp?ma_hoa_don=<%=ma_hoa_don %>&exportToExcel=YES">Export to Excel</a>
            <%
                }
            %>
        </div>
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
