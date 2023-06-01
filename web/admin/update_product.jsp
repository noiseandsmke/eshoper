<%-- 
    Document   : update_product
    Created on : May 10, 2017, 10:40:56 PM
    Author     : Nguyen
--%>

<%@page import="model.SanPham"%>
<%@page import="dao.SanPhamDAOImpl"%>
<%@page import="model.DanhMuc"%>
<%@page import="dao.DanhMucDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <% SanPhamDAOImpl sanPhamDAO = new SanPhamDAOImpl();
        SanPham sp = new SanPham();
        sp = sanPhamDAO.getChiTietSanPham(Integer.parseInt(request.getParameter("ma_san_pham")));
    %>
    <jsp:include page="header.jsp"></jsp:include>

        <div id="wrapper">

        <jsp:include page="left.jsp"></jsp:include>

            <div id="rightContent">
                <h3>Thông tin sản phẩm</h3>
                <form action="/MyProject/UpdateProductServlet" method="POST" enctype="multipart/form-data">
                    <table width="95%">
                        <tr>
                            <td width="125px"><b>Tên sản phẩm</b></td>
                            <td><input type="text" class="pendek" name="TenSanPham" value="<%=sp.getTen_san_pham()%>">
                        </td>
                    </tr>

                    <tr>
                        <td><b>Mã danh mục</b> </td>
                        <td>
                            <select name="MaDanhMuc" >
                                <option selected> Lựa chọn</option>
                                <% DanhMucDAOImpl danhMucDAO = new DanhMucDAOImpl();
                                    for (DanhMuc dm : danhMucDAO.getListDanhMuc()) {

                                %>
                                <option  value="<%=dm.getMa_danh_muc()%>" <% if (dm.getMa_danh_muc() == sp.getMa_danh_muc()) {
                                         %>selected="true"<%
                                        } else {%> <%
                                             }
                                         %>>
                                    <%=dm.getTen_danh_muc()%>
                                </option>

                                <% }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Hình ảnh</b></td>
                        <td>
                            <input type="file" name="HinhAnh" value="<%=sp.getHinh_anh() %>"/>
                        </td>

                    </tr>

                    <tr>
                        <td width="125px"><b>Số lượng</b></td>
                        <td><input type="number" class="pendek" name="SoLuong" value="<%=sp.getSo_luong()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Đơn giá</b></td>
                        <td><input type="number" class="pendek" name="DonGia" value="<%=sp.getDon_gia()%>">  VND
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b> Giảm giá</b></td>
                        <td><input type="number" class="pendek" name="GiamGia" value="<%=sp.getGiamgia()%>"> %
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Màn hình</b></td>
                        <td><input type="text" class="pendek" name="ManHinh" value="<%=sp.getMan_hinh()%>" >
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Camera sau</b></td>
                        <td><input type="text" class="pendek" name="CameraSau" value="<%=sp.getCamera_sau()%>">
                        </td>
                    </tr>


                    <tr>
                        <td width="125px"><b>Camera trước</b></td>
                        <td><input type="text" class="pendek" name="CameraTruoc" value="<%=sp.getCamera_truoc()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Hệ điều hành</b></td>
                        <td><input type="text" class="pendek" name="HeDieuHanh" value="<%=sp.getHe_dieu_hanh()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>cpu</b></td>
                        <td><input type="text" class="pendek" name="Cpu" value="<%=sp.getCpu()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Bộ nhớ</b></td>
                        <td><input type="text" class="pendek" name="BoNho" value="<%=sp.getBo_nho()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Ram</b></td>
                        <td><input type="text" class="pendek" name="Ram" value="<%=sp.getRam()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Kết nối</b></td>
                        <td><input type="text" class="pendek" name="KetNoi" value="<%=sp.getKet_noi()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Pin sạc</b></td>
                        <td><input type="text" class="pendek" name="PinSac" value="<%=sp.getPin_sac()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b> Bảo hành</b></td>
                        <td>
                           <input type="text" class="pendek" name="BaoHanh" value="<%=sp.getBao_hanh() %>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Mô tả</b></td>
                        <td><input type="text" class="pendek" name="MoTa" value="<%=sp.getMo_ta()%>">
                        </td>
                    </tr>



                    <tr><td></td><td>
                            <input type="hidden" name="ma_san_pham" value="<%=request.getParameter("ma_san_pham")%>">
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
