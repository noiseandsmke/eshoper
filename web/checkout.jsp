<%-- 
    Document   : checkout
    Created on : Apr 25, 2017, 10:56:02 PM
    Author     : Nguyen
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page import="model.SanPham"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="model.GioHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Thanh toan</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>
        <% String dia_chi_erro = "", phuong_thuc_erro = "";
            if (request.getAttribute("dia_chi_erro") != null) {
                dia_chi_erro = (String) request.getAttribute("dia_chi_erro");
            }
            if (request.getAttribute("phuong_thuc_erro") != null) {
                phuong_thuc_erro = (String) request.getAttribute("phuong_thuc_erro");
            }

            if (session.getAttribute("username") == null) {
                response.sendRedirect("/MyProject/account.jsp");

            } else {
                GioHang cart = (GioHang) session.getAttribute("cart");
                if (cart == null) {
                    cart = new GioHang();
                    session.setAttribute("cart", cart);

                }
                TreeMap<SanPham, Integer> list = cart.getList();
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMinimumIntegerDigits(0);


        %>
        <jsp:include page="header1.jsp"></jsp:include>
            <section id="cart_items">
                <div class="container">


                    <div class="review-payment">
                        <h2>Thông tin đơn hàng</h2>
                    </div>

                    <div class="table-responsive cart_info">
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">
                                    <td class="image">Sản phẩm</td>
                                    <td class="description"></td>
                                    <td class="price"> Giá</td>
                                    <td class="price">Giảm giá </td>
                                    <td class="quantity">Số Lượng</td>
                                    <td class="total">Thành tiền</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                            <%                                for (Map.Entry<SanPham, Integer> ds : list.entrySet()) {
                            %>

                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="/MyProject/ImagesProduct/<%=ds.getKey().getHinh_anh()%>" alt=""></a>
                                </td>
                                <td class="cart_description">
                                    <h4><a href=""><%=ds.getKey().getTen_san_pham()%></a></h4>
                                    <p>Ma SP :<%=ds.getKey().getMa_san_pham()%></p>
                                </td>
                                <td class="cart_price">
                                    <p><%=nf.format(ds.getKey().getDon_gia())%></p>
                                </td>
                                <td >
                                    <p><%=ds.getKey().getGiamgia()%> %</p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a class="cart_quantity_up" href="GioHangServlet?command=plus&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"> + </a>
                                        <input class="cart_quantity_input" type="text" value="<%=ds.getValue()%>" autocomplete="off" size="2" disabled="">
                                        <a class="cart_quantity_down" href="GioHangServlet?command=sub&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"> - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price"><%= nf.format(ds.getValue() * ds.getKey().getDon_gia())%> VND</p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="GioHangServlet?command=remove&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <%
                                }%>
                            <tr>
                                <td colspan="4">&nbsp;</td>
                                <td colspan="2">
                                    <table class="table table-condensed total-result">

                                        <tr>
                                            <td>Tổng tiền</td>
                                            <td><span><%=nf.format(cart.total())%></span></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="shopper-informations">
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="shopper-info">
                                <p>Thông tin thanh toán</p>
                                <form action="ThanhToanServlet" method="POST">
                                    <p style="color:red"><%=dia_chi_erro%></p>
                                    <p> Địa chỉ giao hàng</p>
                                    <textarea name="dia_chi_giao_hang" rows="5"></textarea>
                                    <p> Số điện thoại<p>
                                        <input type="number" name="so_dien_thoai"/>
                                    <p> Phương thức thanh toán </p>  
                                    <select name="phuong_thuc_thanh_toan">
                                        <option value="Thanh toán khi giao hàng">Thanh toán khi giao hàng</option>
                                        <option value="Chuyển khoản">Chuyển khoản</option>

                                    </select>
                                    <input type="hidden" value="<%=session.getAttribute("username")%>"/>
                                    <input type="submit" value="Xác nhận đặt hàng" class="btn btn-primary">
                                </form>

                            </div>
                        </div>


                    </div>
                </div>

            </div>
        </section> 

        <jsp:include page="footer.jsp"></jsp:include>
        <% }%>
    </body>
</html>
