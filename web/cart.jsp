<%-- 
    Document   : cart
    Created on : Apr 25, 2017, 10:11:10 PM
    Author     : Nguyen
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="model.GioHang"%>
<%@page import="java.util.Map"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.TreeMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
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
        <%
            GioHang cart = (GioHang) session.getAttribute("cart");
            if (cart == null) {
                cart = new GioHang();
                session.setAttribute("cart", cart);

            }
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
            TreeMap<SanPham, Integer> list = cart.getList();
        %>
        <jsp:include page="header1.jsp"></jsp:include>
            <section id="cart_items">
                <div class="container">
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li class="active">Shopping Cart</li>
                        </ol>
                    </div>
                    <div class="table-responsive cart_info">
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">
                                    <td class="image">Sản phẩm</td>
                                    <td class="description"></td>
                                    <td class="price">Gía</td>
                                    <td class="price">Giảm giá</td>
                                    <td class="quantity">Số lượng</td>
                                    <td class="total">Thành tiền</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                                for (Map.Entry<SanPham, Integer> ds : list.entrySet()) {
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
                                        <input class="cart_quantity_input" type="text" value="<%=ds.getValue() %>" autocomplete="off" size="2" disabled="">
                                        <a class="cart_quantity_down" href="GioHangServlet?command=sub&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"> - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price"><%= nf.format(ds.getValue()*ds.getKey().getDon_gia()- ds.getValue()*ds.getKey().getDon_gia()*ds.getKey().getGiamgia()/100)%> VND</p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="GioHangServlet?command=remove&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis() %>"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <%
                                }%>


                        </tbody>
                    </table>
                </div>
            </div>
        </section> 
        <section id="do_action">
            <div class="container">
                
                <div class="row">
                   
                    <div class="col-sm-6">
                        <div class="total_area">
                            <ul>
                                <li>Tổng tiền <span><%=nf.format(cart.total()) %></span></li>
                               
                            </ul>
                            <a class="btn btn-default update" href="">Hủy đơn hàng</a>
                            <a class="btn btn-default check_out" href="checkout.jsp">Thanh toán</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
