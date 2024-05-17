package com.busanit501.serverprogramtest2.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class menu2VO {
    private Long menuNo;
    private String MenuTitle;
    private LocalDate MenuRegDate;

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
