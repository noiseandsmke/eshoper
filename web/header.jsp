

<%@page import="model.TaiKhoan"%>
<%@page import="model.LoaiTin"%>
<%@page import="dao.TinTucDAO"%>
<%@page import="dao.LoaiTinDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home | E-Shopper</title>

    </head>
    <body>
        <% 
            LoaiTinDAOImpl loaiTinDAO= new LoaiTinDAOImpl();
          
           
        %>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="#"><i class="fa fa-phone"></i> 0968727900</a></li>
                                    <li><a href="https://mail.google.com/mail"><i class="fa fa-envelope"></i>truongchikien2021@gmail.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="https://www.facebook.com/profile.php?id=100005723765570"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="https://www.instagram.com/kien_84/"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="default.jsp"><img src="images/home/logo.png" alt="" /></a>
                            </div>
                           
                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="DangNhapServlet?command=logout"><i class="fa fa-user"></i><%=session.getAttribute("username")%></a></li>
                                    
                                    <li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i>Thanh toán</a></li>
                                    <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i>Giỏ hàng</a></li>
                                    <li><a href="account.jsp"><i class="fa fa-lock"></i>Đăng nhập</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="default.jsp" class="active">Trang chủ</a></li>
                                  
                                     
                                    </li>
                                    <li class="dropdown"><a href="news.jsp">Tin tức<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <% 
                                                  for(LoaiTin loaitin: loaiTinDAO.getListLoaiTin())
                                                  {
                                            %>
                                            <li><a href="typenews.jsp?ma_loai_tin=<%=loaitin.getMa_loai_tin() %>"><%=loaitin.getTen_loai_tin() %></a></li>
                                            <% 
                                            }%>
                                           
                                        </ul>
                                    </li> 
                                    <li><a href="contact.jsp">Liên hệ</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="search">
                                <form method="Post" action="SearchServlet">
                                    <input type="text" name="ten_san_pham" placeholder="Nhập tên muốn tìm">
                                    <input type="submit" value="Tìm kiếm" name="search">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-bottom-->
        </header
    </body>
</html>
