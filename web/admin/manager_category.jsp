
<%@page import="java.util.ArrayList"%>
<%@page import="model.DanhMuc"%>
<%@page import="dao.DanhMucDAOImpl"%>
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
                <div>
                <%=request.getAttribute("msgDelete") != "" ? request.getAttribute("msgDelete") : ""%>
            </div>
            <p><a href="/MyProject/admin/insert_category.jsp">Thêm danh mục</a></p>                 
            <table class="data">
                <tr class="data">
                    <th class="data" width="30px">STT</th>
                    <th class="data">Mã danh mục</th>
                    <th class="data">Tên danh mục</th>

                    <th class="data" width="75px">Tùy chọn</th>
                </tr>
                <% DanhMucDAOImpl danhMucDAO = new DanhMucDAOImpl();
                    ArrayList<DanhMuc> arr = danhMucDAO.getListDanhMuc();
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
                    ArrayList<DanhMuc> list = danhMucDAO.getListDanhMucTheoTrang(arr, start, end);
                    int count = 0;
                    for (DanhMuc dm : list) {
                        count++;
                %>
                <tr class="data">
                    <td class="data" width="30px"><%=count%></td>
                    <td class="data"><%=dm.getMa_danh_muc()%></td>
                    <td class="data"><%=dm.getTen_danh_muc()%></td>

                    <td class="data" width="75px">
                <center>
                    <a href="/MyProject/admin/update_category.jsp?ma_danh_muc=<%=dm.getMa_danh_muc()%>">Sửa</a>&nbsp;||&nbsp;&nbsp;
                    <a href="/MyProject/DeleteCategoryServlet?ma_danh_muc=<%=dm.getMa_danh_muc()%>">Xóa</a>
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
                <li ><a href="/MyProject/admin/manager_category.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                    <% }
                    %>
            </ul>
        </div>

        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
