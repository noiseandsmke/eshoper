

<%@page import="java.util.ArrayList"%>
<%@page import="model.LoaiTin"%>
<%@page import="dao.LoaiTinDAOImpl"%>
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
                <h3>Quản lý loại tin tức</h3>
                <div>
                <%=request.getAttribute("msgDelete") != "" ? request.getAttribute("msgDelete") : ""%>
            </div>
            <p><a href="insert_typenews.jsp">Thêm loại tin tức</a></p>                 
            <table class="data">
                <tr class="data">
                    <th class="data" width="30px">STT</th>
                    <th class="data"  width="50px">Mã loại tin</th>
                    <th class="data" width="50px">Tên loại tin</th>

                    <th class="data" width="75px">Tùy chọn</th>
                </tr>
                <%  LoaiTinDAOImpl loaiTinDAO = new LoaiTinDAOImpl();
                    ArrayList<LoaiTin> arr = loaiTinDAO.getListLoaiTin();
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
                    ArrayList<LoaiTin> list = loaiTinDAO.getListLoaiTinTheoTrang(arr, start, end);
                    int count = 0;
                    for (LoaiTin loaitin : list) {
                        count++;
                %>
                <tr class="data">
                    <td class="data" width="30px"><%=count%></td>
                    <td class="data" width="50px"><%=loaitin.getMa_loai_tin()%></td>

                    <td class="data" width="50px"><%=loaitin.getTen_loai_tin()%></td>
                    <td class="data" width="75px">
                <center>
                    <a href="/MyProject/admin/update_typenews.jsp?ma_loai_tin=<%=loaitin.getMa_loai_tin()%>">Sửa</a>&nbsp;||&nbsp;&nbsp;
                    <a href="/MyProject/DeleteTypeNewServlet?ma_loai_tin=<%=loaitin.getMa_loai_tin()%>">Xóa</a>
                </center>
                </td>
                </tr>
                <%
                    }%>
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
                <li ><a href="/MyProject/admin/manager_typenew.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                    <% }
                    %>
            </ul>
        </div>
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
