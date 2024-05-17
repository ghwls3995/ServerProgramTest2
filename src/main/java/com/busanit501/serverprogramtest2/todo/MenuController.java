package com.busanit501.serverprogramtest2.todo;

import com.busanit501.serverprogramtest2.todo.dto.MenuDTO;
import com.busanit501.serverprogramtest2.todo.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="MenuController" , urlPatterns = "/menu/list")
public class MenuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        // 목록 화면으로 전달,

//        List<MenuDTO> sampleList = MenuService.INSTANCE.getList();
//        // 서버가 - > 클라이언트 ( 웹 , 브라우저 )
//        // req 라는 수납 도구에서 , 임시 더미 리스트를 담기.
//        req.setAttribute("list", sampleList);
        List<MenuDTO> sampleList = MenuService.INSTANCE.getList();
        req.setAttribute("list",sampleList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuList.jsp");
        requestDispatcher.forward(req,resp);
    }
}
