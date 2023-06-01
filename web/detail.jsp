

<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="model.SanPham"%>
<%@page import="dao.SanPhamDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    <div id="fb-root"></div>
    <script>(function (d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id))
                return;
            js = d.createElement(s);
            js.id = id;
            js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.9&appId=448415815535353";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));</script>
</head>
<body>
    <% SanPhamDAOImpl sanPhamDAO = new SanPhamDAOImpl();
        SanPham sp = sanPhamDAO.getChiTietSanPham(Integer.parseInt(request.getParameter("ma_san_pham")));
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(0);

    %>
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="slider.jsp"></jsp:include>
        <section>
            <div class="container">
                <div class="row">
                <jsp:include page="category.jsp"></jsp:include>
                    <div class="col-sm-9 padding-right">
                        <div class="product-details"><!--product-details-->
                            <div class="col-sm-5">
                                <div class="view-product">
                                    <img src="/MyProject/ImagesProduct/<%=sp.getHinh_anh()%>" alt="" />

                            </div>

                        </div>
                        <div class="col-sm-7">
                            <div class="product-information"><!--/product-information-->
                                <img src="images/product-details/new.jpg" class="newarrival" alt="" />
                                <h2><%=sp.getTen_san_pham()%></h2>
                                <h4> Mã sản phẩm:<%=request.getParameter("ma_san_pham")%></h4>
                                <span>
                                    <span><%=nf.format(sp.getDon_gia())%>VND</span>

                                </span>
                                <p>Màn hình : <%=sp.getMan_hinh()%></p>
                                <p>Hệ điều hành : <%=sp.getHe_dieu_hanh()%></p>
                                <p>Camera sau : <%=sp.getCamera_sau()%></p>
                                <p>Camera trước : <%=sp.getCamera_truoc()%></p>
                                <p>CPU : <%=sp.getCpu() %></p>
                                <p><a type="button" class="btn btn-fefault cart" href="GioHangServlet?command=insert&ma_san_pham=<%=sp.getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>">
                                        <i class="fa fa-shopping-cart"></i>
                                        Thêm vào giỏ hàng
                                    </a>
                                </p>

                               

                                <div class="container">

                                    <!-- Trigger the modal with a button -->
                                    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Xem chi tiết sản phẩm</button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="myModal" role="dialog">
                                        <div class="modal-dialog">

                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <center>  <h4 class="modal-title">Thông tin chi tiết sản phẩm</h4></center>
                                                </div>
                                                <div class="modal-body" align="left">
                                                    <p><center><img class="etalage_thumb_image img-responsive" src="/MyProject/ImagesProduct/<%=sp.getHinh_anh()%>" alt="" ></center></p>
                                                    <p>Tên sản phẩm:<%=sp.getTen_san_pham()%></p><br/>
                                                    <p> Màn hình :<%=sp.getMan_hinh()%> </p>
                                                    <p>Camera sau : <%=sp.getCamera_sau()%></p>
                                                    <p>Camera trước :<%=sp.getCamera_truoc()%></p>
                                                    <p>Hệ điều hành :<%=sp.getHe_dieu_hanh()%> </p>
                                                    <p> CPU :<%=sp.getCpu()%> </p>
                                                    <p>RAM :<%=sp.getRam()%> </p>
                                                    <p>Kết nối :<%=sp.getKet_noi()%> </p>
                                                    <p>Pin sạc :<%=sp.getPin_sac()%> </p>
                                                    <p>Mo ta :<%=sp.getMo_ta()%> </p>

                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                </div>
                                            </div>

                                        </div>
                                    </div>

                                </div>
                                <div class="fb-like" data-href="https://www.facebook.com/Status-y%C3%AAu-th%C6%B0%C6%A1ng-611801445540447/" data-width="300px" data-layout="standard" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>
                            </div><!--/product-information-->
                        </div>
                    </div><!--/product-details-->

                    <div class="category-tab shop-details-tab"><!--category-tab-->
                        <div class="col-sm-12">
                            <ul class="nav nav-tabs">
                                <li><a href="#details" data-toggle="tab">Sản phẩm tương tự</a></li>

                                <li class="active"><a href="#reviews" data-toggle="tab">Bình luận</a></li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade" id="details" >
                                <% for (SanPham s_pham : sanPhamDAO.getListSanPhamTheoDanhMuc(sp.getMa_danh_muc())) {
                                %>
                                <div class="col-sm-3">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">

                                            <div class="productinfo text-center">
                                                <img src="/MyProject/ImagesProduct/<%=s_pham.getHinh_anh()%>" alt="" />
                                                <h2><%=nf.format(s_pham.getDon_gia())%></h2>
                                                <a href="detail.jsp?ma_san_pham=<%=s_pham.getMa_san_pham()%>"><%=s_pham.getTen_san_pham()%></a>

                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <% } %>

                            </div>

                            <div class="tab-pane fade active in" id="reviews" >
                                <div class="col-sm-12">
                                    <ul>
                                        <%
                                            Date date = new Date();
                                            Timestamp time = new Timestamp(date.getTime());
                                        %>
                                        <li><a href=""><i class="fa fa-user"></i><%=date%></a></li>

                                    </ul>
                                    <div class="fb-comments" data-href="http://localhost:8080/MyProject/detail.jsp?ma_san_pham<%=Integer.parseInt(request.getParameter("ma_san_pham"))%>" data-width="700" data-numposts="5"></div>

                                </div>
                            </div>
                        </div>

                    </div>
                </div><!--/category-tab-->


            </div>
        </div>
    </div>
</div>
</section>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
