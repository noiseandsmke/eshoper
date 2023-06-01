<%-- 
    Document   : insert_product
    Created on : May 10, 2017, 1:18:33 PM
    Author     : Nguyen
--%>

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
    <jsp:include page="header.jsp"></jsp:include>

        <div id="wrapper">

        <jsp:include page="left.jsp"></jsp:include>

            <div id="rightContent">
                <h3>Thông tin sản phẩm</h3>
                <form action="/MyProject/UpLoadProduct" method="POST" enctype="multipart/form-data">
                    <table width="95%">
                        <tr>
                            <td width="125px"><b>Tên sản phẩm</b></td>
                            <td><input type="text" class="pendek" name="TenSanPham">
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
                                <option  value="<%=dm.getMa_danh_muc()%>"><%=dm.getTen_danh_muc()%></option>
                                <% }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Hình ảnh</b></td>
                        <td>
                            <input type="file" name="HinhAnh" />
                        </td>

                    </tr>

                    <tr>
                        <td width="125px"><b>Số lượng</b></td>
                        <td><input type="text" class="pendek" name="SoLuong">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Đơn giá</b></td>
                        <td><input type="text" class="pendek" name="DonGia">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b> Giảm giá</b></td>
                        <td><input type="text" class="pendek" name="GiamGia">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Màn hình</b></td>
                        <td><input type="text" class="pendek" name="ManHinh">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Camera sau</b></td>
                        <td><input type="text" class="pendek" name="CameraSau">
                        </td>
                    </tr>


                    <tr>
                        <td width="125px"><b>Camera trước</b></td>
                        <td><input type="text" class="pendek" name="CameraTruoc">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Hệ điều hành</b></td>
                        <td><input type="text" class="pendek" name="HeDieuHanh">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>cpu</b></td>
                        <td><input type="text" class="pendek" name="Cpu">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Bộ nhớ</b></td>
                        <td><input type="text" class="pendek" name="BoNho">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Ram</b></td>
                        <td><input type="text" class="pendek" name="Ram">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Kết nối</b></td>
                        <td><input type="text" class="pendek" name="KetNoi">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Pin sạc</b></td>
                        <td><input type="text" class="pendek" name="PinSac">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b> Bảo hành </b></td>
                        <td><select name="BaoHanh">
                                <option value="3 tháng">3 tháng</option>
                                <option value="6 tháng">6 tháng</option>
                                <option value="12 tháng">12 tháng</option>

                            </select>
                        </td>
                    <tr>
                    <tr>
                        <td width="125px"><b>Mô tả</b></td>
                        <td><input type="text" class="pendek" name="MoTa">
                        </td>
                    </tr>
                    <tr><td></td><td>

                            <input type="submit" class="button" value="Lưu dữ liệu">


                </table>
            </form>
        </div>
        <div class="clear"></div>

        <jsp:include page="footer.jsp"></jsp:include>

    </div>
</body>
</html>
