package com.busanit501.serverprogramtest2.todo.controller;

import com.busanit501.serverprogramtest2.todo.dto.Menu2DTO;
import com.busanit501.serverprogramtest2.todo.service.Menu2Service;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="menuList" , urlPatterns = "/menu/list")
public class MenuListController extends HttpServlet {

    private Menu2Service menu2Service = Menu2Service.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Menu2DTO> sampleList = null;
        try {
            sampleList = Menu2Service.INSTANCE.listAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("list",sampleList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuList.jsp");
        requestDispatcher.forward(req,resp);
    }
}
