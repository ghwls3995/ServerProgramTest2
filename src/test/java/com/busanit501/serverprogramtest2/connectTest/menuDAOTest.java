package com.busanit501.serverprogramtest2.connectTest;

import com.busanit501.serverprogramtest2.todo.dao.Menu2DAO;
import com.busanit501.serverprogramtest2.todo.domain.Menu2VO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class menuDAOTest {

// 디비연결하고 ,기능 테스트
    // 다른클래스의 인스턴스가 필요해요.
    // 사용하기위해서 방법 ? 주입, 포함
    // 선언만 햇음. null ( 집주소 없음 , 0x100 (x) )

    private Menu2DAO menu2DAO;

    // 각 단위 테스트가 실행되기전에,, 먼저 실행되는 어노테이션,
    // todoDAO 할당함.
    @BeforeEach
    public void ready(){
        menu2DAO = new Menu2DAO();
    }
    @Test
    public void getTimeTest() throws Exception{
//        todoDAO = new TodoDAO();
//        String time = todoDAO.getTime();
        String time = menu2DAO.getTime2();
        System.out.println("time : " + time);
    }

    @Test
    public void getSelectAll() throws Exception {
        List<Menu2VO> samples = menu2DAO.selectAll();
        // 기본 출력이고, 전체 출력
        System.out.println("samples : " + samples);
        // 향상된 for, 목록에서 요소를 하나씩 뽑아서 출력함.
        // samples 목록에서, 하나 요소를 꺼내서 vo 에 담고, 그리고 개별 요소 출력하기.
        samples.forEach(vo ->System.out.println("오늘의 메뉴는~~ : " + vo) );
    }
}
