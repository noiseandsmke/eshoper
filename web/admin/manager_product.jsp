
<%@page import="java.util.ArrayList"%>
<%@page import="model.SanPham"%>
<%@page import="dao.SanPhamDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <% SanPhamDAOImpl spdao = new SanPhamDAOImpl();
        ArrayList<SanPham> arr = spdao.getListSanPham();
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
        ArrayList<SanPham> list = spdao.getListSanPhamTheo(arr, start, end);
    %>

    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Quản lý sản phẩm</h3>

                <p><a href="insert_product.jsp">Thêm sản phẩm mới</a></p>                 
                <table class="data"style="width:1200px" >
                    <tr class="data" style="width:1000px">
                        <th class="data" width="30px">STT</th>
                        <th class="data"width="200px" >Mã sản phẩm</th>
                        <th class="data" width="200px">Tên sản phẩm</th>
                        <th class="data" width="200px">Mã danh mục</th>
                        <th class="data" width="200px">Hình ảnh</th>
                        <th class="data"width="200px">Số lượng</th>
                        <th class="data"width="200px">Đơn giá</th>
                        <th class="data"width="200px">Giảm giá</th>
                        <th class="data"width="200px">Màn hình</th>
                        <th class="data"width="200px">Camera trước</th>
                        <th class="data"width="200px">Camera sau</th>
                        <th class="data"width="200px">Hệ điều hành</th>
                        <th class="data"width="200px">CPU</th>
                        <th class="data"width="200px">Ram</th>
                        <th class="data"width="200px">Kết nối</th>
                        <th class="data"width="200px">PinSac</th>
                        <th class="data" width="200px">Bảo hành</th>
                        <th class="data"width="200px">Mô tả</th>

                        <th class="data" width="400px">Tùy chọn</th>
                    </tr>
                <% SanPhamDAOImpl sanPhamDAO = new SanPhamDAOImpl();
                    int count = 0;
                    for (SanPham sp : list) {
                        count++;
                %>
                <tr class="data">
                    <td class="data" width="30px"><%=count%></td>
                    <td class="data"><%=sp.getMa_san_pham()%></td>
                    <td class="data"><%=sp.getTen_san_pham()%></td>
                    <td class="data"><%=sp.getMa_danh_muc()%></td>
                    <td class="data"><img style="width: 50px;heigth:70px;" src="/MyProject/ImagesProduct/<%=sp.getHinh_anh()%>" ></td>
                    <td class="data"><%=sp.getSo_luong()%></td>
                    <td class="data"><%=sp.getDon_gia()%></td>
                    <td class="data"><%=sp.getGiamgia()%></td>
                    <td class="data"><%=sp.getMan_hinh()%></td>
                    <td class="data"><%=sp.getCamera_truoc()%></td>
                    <td class="data"><%=sp.getCamera_sau()%></td>
                    <td class="data"><%=sp.getHe_dieu_hanh()%></td>
                    <td class="data"><%=sp.getCpu()%></td>
                    <td class="data"><%=sp.getRam()%></td>
                    <td class="data"><%=sp.getKet_noi()%></td>
                    <td class="data"><%=sp.getPin_sac()%></td>
                    <td class="data"><%=sp.getBao_hanh() %></td>
                    <td class="data"><%=sp.getMo_ta()%></td>
                    <td class="data" width="75px">
                <center>
                    <a href="/MyProject/admin/update_product.jsp?ma_san_pham=<%=sp.getMa_san_pham()%>">Sửa</a>&nbsp;||&nbsp;&nbsp;
                    <a href="/MyProject/DeleteProductServlet?ma_san_pham=<%=sp.getMa_san_pham()%>">Xóa</a>
                </center>
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
                <li ><a href="/MyProject/admin/manager_product.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                    <% }
                    %>
            </ul>

        </div>

        <div class="clear"></div>

        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
