package com.busanit501.serverprogramtest2.todo;

import com.busanit501.serverprogramtest2.todo.dto.TodoDTO;
import com.busanit501.serverprogramtest2.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="todoList" , urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        // 목록 화면으로 전달,

        List<TodoDTO> sampleList = TodoService.INSTANCE.getList();
        // 서버가 - > 클라이언트 ( 웹 , 브라우저 )
        // req 라는 수납 도구에서 , 임시 더미 리스트를 담기.
        req.setAttribute("list", sampleList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp");
        requestDispatcher.forward(req,resp);
    }
}
