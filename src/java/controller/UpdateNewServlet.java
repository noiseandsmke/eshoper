/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TinTucDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TinTuc;
import utils.UploadFileUtils;

/**
 *
 * @author Nguyen
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class UpdateNewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
   
        String MaTinTuc = request.getParameter("ma_tin_tuc");
        String MaLoaiTin = request.getParameter("MaLoaiTin");
        String TenTin = request.getParameter("TenTinTuc");
        String TieuDe = request.getParameter("TieuDe");
        String NoiDung = request.getParameter("NoiDung");
        String image = UploadFileUtils.UploadFile(request);
        String NgayDang = request.getParameter("NgayDang");
        TinTuc tt = new TinTuc(Integer.parseInt(MaTinTuc),Integer.parseInt( MaLoaiTin), TenTin, TieuDe, NoiDung,image, NgayDang);
        TinTucDAOImpl ttDao = new TinTucDAOImpl();
        ttDao.updateTinTuc(tt);
        request.getRequestDispatcher("/admin/manager_news.jsp").forward(request, response);

    }

}
