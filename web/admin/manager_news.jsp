

<%@page import="java.util.ArrayList"%>
<%@page import="model.TinTuc"%>
<%@page import="dao.TinTucDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quản lý loại tin tức</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/MyProject/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Quản lý tin tức</h3>

                <p><a href="insert_new.jsp">Thêm tin tức</a></p>                 
                <table class="data">
                    <tr class="data">
                        <th class="data" width="30px">STT</th>
                        <th class="data">Mã  tin</th>
                        <th class="data">Mã loại tin</th>
                        <th class="data">Tên tin</th>
                        <th class="data">Tiêu đề</th>
                        <th class="data">Nội dung</th>
                        <th class="data">Hình ảnh</th>
                        <th class="data">Ngày đăng</th>

                        <th class="data" width="75px">Tùy chọn</th>
                    </tr>
                <%  TinTucDAOImpl tinTucDAOImpl = new TinTucDAOImpl();
                    ArrayList<TinTuc> arr = tinTucDAOImpl.getListTinTuc();
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
                    ArrayList<TinTuc> list = tinTucDAOImpl.getListTinTucTheoTrang(arr, start, end);
                    int count = 0;
                    for (TinTuc tt : list) {
                        count++;
                %>
                <tr class="data">
                    <td class="data" width="30px"><%=count%></td>
                    <td class="data"><%=tt.getMa_tin_tuc()%></td>
                    <td class="data"><%=tt.getMa_loai_tin()%></td>
                    <td class="data"><%=tt.getTen_tin_tuc()%></td>
                    <td class="data"><%=tt.getTieu_de()%></td>
                    <td class="data"><%=tt.getNoi_dung()%></td>
                    <td class="data"><img style="width: 200px;heigth:150px;" src="/MyProject/ImagesProduct/<%=tt.getHinh_anh()%>"</td>
                    <td class="data"><%=tt.getNgay_dang()%></td>
                    <td class="data" width="75px">
                <center>
                    <a href="/MyProject/admin/update_new.jsp?ma_tin_tuc=<%=tt.getMa_tin_tuc()%>">Sửa</a>&nbsp;||&nbsp;&nbsp;
                    <a href="/MyProject/DeleteNewServlet?ma_tin_tuc=<%=tt.getMa_tin_tuc()%>">Xóa</a>
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
                <li ><a href="/MyProject/admin/manager_news.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                    <% }
                    %>
            </ul>
        </div>
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body> 
</html>
