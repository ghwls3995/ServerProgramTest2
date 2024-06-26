package com.busanit501.serverprogramtest2.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="MemberInputController" , urlPatterns = "/member/input")
public class MemberInputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 기본, 뷰 jsp 파일로 전달하기.
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/member/memberInput.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 입력 받은 메뉴를 , 데이터 베이스에 저장.
        String memberNum = req.getParameter("memberNum");
        System.out.println("받은 멤버값출력 member1: " + memberNum );
        // 단순, 메인 메뉴 로 이동.
        resp.sendRedirect("/member/list");
    }
}


