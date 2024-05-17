package com.busanit501.serverprogramtest2.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

    //@Builder 기본 사용법
//    TodoVO  todo = TodoVO.builder()
//     .멤버의 이름으로 설정
//     .build();
//    TodoVO todo = TodoVO.builder()
//            .tno(100L)
//            .title("제목100")
//            .dueDate(LocalDate.now())
//            .build();

}
