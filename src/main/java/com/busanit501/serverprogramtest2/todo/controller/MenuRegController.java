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
import java.time.LocalDate;

@WebServlet(name = "menuReg", urlPatterns = "/menu/register")
public class MenuRegController extends HttpServlet {

    //주입 , 서비스 인스턴스 , 포함.
    private Menu2Service menu2Service = Menu2Service.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo 글 입력 폼
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuReg.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // todo 글 입력 처리 하는 로직.
        // TodoDTO 타입을 받아서, 서비스에 전달하는 로직.
        Menu2DTO menu2DTO = Menu2DTO.builder()
                .MenuTitle(req.getParameter("title"))
                .MenuRegDate(LocalDate.parse(req.getParameter("dueDate")))
                .build();

        // 실제 데이터 입력하기.
        try {
            menu2Service.register2(menu2DTO);
            // 리다이렉트, 메인: 리스트
            resp.sendRedirect("/menu/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        

    }
}