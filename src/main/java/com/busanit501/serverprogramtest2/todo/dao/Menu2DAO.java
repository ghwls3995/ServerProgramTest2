package com.busanit501.serverprogramtest2.todo.dao;

import com.busanit501.serverprogramtest2.todo.domain.Menu2VO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Menu2DAO {
    // 기능 구현만 만들고, 단위 테스트 진행중이고, 나중에 화면 붙여서 작업 할 예정.
    // 조회 select
    // 데이터베이스 직접적인 데이터 연동할 때 사용하는 모델 클래스 :VO
    public List<Menu2VO> selectAll() throws Exception{
        // 예외 처리 여부를 , throws 진행하기.
        // 디비 연결 하는 순서
        // 1) 연결 하는 도구 Connection 타입의 인스턴스 필요
        // 2) SQL 전달하는 도구 : PreparedStatement 타입의 인스턴스 필요
        // 3) select 할 때는, 조회 결과를 받기 위한 ResultSet 타입의 인스턴스 필요
        // 작업 후, 반납. -> @Cleanup 사용할 예정.
        String sql = "select * from lunchmenu";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        // 디비에서 조회한 데이터 내용들을 담을 임시 List 가 필요함. 여기에 담을 예정.
        List<Menu2VO> samples = new ArrayList<Menu2VO>();

        while (resultSet.next()){
//      // 기존에는 , set 를 이용해서 담는 방법
//      // 임시 TodoVO에 담기, -> 다시 임시 목록에 담기.
//      // 방법1
//      TodoVO todoVO = new TodoVO();
//      // resultSet.getLong("tno"), 디비에서 조회한 내용.
//      todoVO.setTno(resultSet.getLong("tno"));
//      todoVO.setTitle(resultSet.getString("title"));
//      todoVO.setDueDate(resultSet.getDate("dueDate").toLocalDate());
//      todoVO.setFinished(resultSet.getBoolean("finished"));
//      // 리스트에 담기.
//      samples.add(todoVO);
            // builder 패턴으로 담는 방법.
            // 방법2
            Menu2VO menu2VO1Builder = Menu2VO.builder()
                    .menuNo(resultSet.getLong("menuNo"))
                    .MenuTitle(resultSet.getString("MenuTitle"))
                    .MenuRegDate(resultSet.getDate("MenuRegDate").toLocalDate())
                    .build();
            // 리스트에 담기.
            samples.add(menu2VO1Builder);
        }

        //임시 반환값.
        return samples;
    }
    public Menu2VO selectOne(Long menuNo) throws Exception{
        String sql = "select * from lunchmenu where menuNo = ?";
        //1) @Cleanup ,자원 반납 자동으로 lombok 라는 도구 이용해서.
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        // 화면에서 , 특정 게시글 선택하면,
        // get : URL: http://localhost:8080/todo/read?tno=3
        pstmt.setLong(1,menuNo);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        // 값이 하나여서, 반복문 필요없음.
        resultSet.next();
        // 임시 로 담을 인스턴스 . builder 패턴 이용해보기.
        // 데이터베이스에서 조회한 1개의 행을 넣기.
        Menu2VO menu2VO = Menu2VO.builder()
                .menuNo(resultSet.getLong("menuNo"))
                .MenuTitle(resultSet.getString("MenuTitle"))
                .MenuRegDate(resultSet.getDate("MenuRegDate").toLocalDate())
                .build();
        // 임시 인스턴스
        return menu2VO;
    }

    // 쓰기 insert
    public void insert(Menu2VO vo) throws Exception {
        String sql = "insert into lunchmenu (MenuTitle, MenuRegDate) values (?,?);";
        //1) @Cleanup ,자원 반납 자동으로 lombok 라는 도구 이용해서.
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        // 화면에서 , 특정 게시글 선택하면,
        // get : URL: http://localhost:8080/todo/read?tno=3
//        pstmt.setLong(1,vo.getMenuNo());
        //vo.getDueDate() : LocalDate
        // Date.valueOf 메서드의 결과 타입 Date 로 변환함.
        pstmt.setString(1, vo.getMenuTitle());
        pstmt.setDate(2,Date.valueOf(vo.getMenuRegDate()));

        // select 조회 할 때, pstmt.executeQuery();
        // insert, update, delete , executeUpdate();
//    int result = pstmt.executeUpdate();
//    return result;
        pstmt.executeUpdate();
    }
    // 수정 update
    public void update(Menu2VO menu2VO) throws Exception {
        String sql = "update lunchmenu set MenuTitle = ?, MenuRegDate = ? where MenuNo = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        // 임시 모델에 담겨진 변경할 데이터의 내용을 가져와서, 디비에 전달 할 예정.
        pstmt.setString(1,menu2VO.getMenuTitle());
        pstmt.setDate(2, Date.valueOf(menu2VO.getMenuRegDate()));
        pstmt.setLong(3,menu2VO.getMenuNo());
        pstmt.executeUpdate();
    }

    // 삭제 delete
    public void delete(Long MenuNo) throws Exception {
        String sql = "delete from lunchmenu where MenuNo = ?;";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1,MenuNo);
        pstmt.executeUpdate();
    }


    public String  getTime2() throws Exception{
        // 자원 반납 자동으로 처리해보기, 롬복의 @Cleanup 기능 이용하기.
        //사용법 : @Cleanup , 자동으로 반납 하고 싶은 메서드에 붙이기.
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }
    // 데이터베이스 직접적인 비지니스 로직 처리하는 기능을 만들기.
    // 샘플
    // 현재 시간을 가져오는 기능.
    public String getTime() {
        // HikariCP 이용해서, 디비 연결하는 도구 Connection  타입의 인스턴스 만들기.
        // 사용법.
//    Connection conn = ConnectionUtil.INSTANCE.getConnection();
        // 디비에 접근 하려면, 반드시 예외 처리를 해야함.
        // 3가지 방법. 1) try catch finally 2) throws 3) try resources with (자동 close)
        // 결론, 롬복의 @cleanup , 자동으로 반납함.

        // 예시 try with resources  (자동 close)
        String now = null;
        // 디비 연결해서, 시각 가져오는 코드.
        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            // sql 전달하는 도구.
            // String sql = "select now()"
            PreparedStatement pstmt = connection.prepareStatement("select now()");
            // 조회한 결과 테이블을 담기위한 임시 테이블
            // 0 행부터 대기중.
            ResultSet rs = pstmt.executeQuery();
        ){
            // 1행 만 있어서, while 문 없음.
            rs.next();
            // 1행의 결과를 가져오기. 문자열
            now = rs.getString(1);

        } catch (Exception exception) {
            exception.printStackTrace();
        } //원래는 finally 구문으로 close 해야하지만,
        // try resource , 자동 close 가 포함되어 있다.
        return now;
    }
}

