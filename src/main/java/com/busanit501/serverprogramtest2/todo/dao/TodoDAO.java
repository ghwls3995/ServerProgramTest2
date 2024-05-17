package com.busanit501.serverprogramtest2.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {
    // 데이터베이스에 직접적인 비지니스 로직 처리하는 기능 만들기.
    // 샘플로 현재시간을 가져오는 기능 .
    public String getTime(){
        // HikariCP 이용해서, 디비 연결하는 도구 Connection 타입의 인스턴스 만들기.
        String now = null;

        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            // sql 전달하는 도구
            // String sql = "select now()"

            PreparedStatement pstmt = connection.prepareStatement("select now()");
            // 조회한 결과 테이블을 담기위한 임시테이블
            // 0행부터 대기
            ResultSet rs = pstmt.executeQuery();
        ){
            rs.next();
            now = rs.getString(1);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        // 디비에 접근 하려면 , 반드시 예외 처리를 해야함.
        // 2가지 방법 1) try catch 2) throws 3) try resources with (자동 close)
        // 결론 , 롬복의 @cleanup , 자동으로 반납함.
        return now;
    }
}
