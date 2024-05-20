package com.busanit501.serverprogramtest2.todo.service;

import com.busanit501.serverprogramtest2.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService_backup {
    INSTANCE;

    public void register(TodoDTO dto) {
        System.out.println("debug register dto 확인중 : " + dto);
    }

    // 임시 리스트 출력하는 기능.
    public List<TodoDTO> getList() {
        //샘플로, 더미 데이터 생성하기.
        // 자바 -> 병렬 처리(stream) , 중간 처리, 최종처리 단계로 진행.
        // 데이터 전달할 때 사용하는 (stream)
        // 리스트 안에서, 각 요소를 꺼내어서, 하나씩 작업 후 무언가 처리함.
        // map -> 대응되다, 예) 사랑의 짝대기, 남자1 --> 여자1, 여자1 --> 남자2
        // 예) 바나나 ---> banana,
        // mapToObj 작성시 자동 임포트 잘하기.
        List<TodoDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
            // 임시 Todo 하나를 의미,
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Sample Todo Title " + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;
    }

    public List<TodoDTO> getList2() {
        // 임시로 10개의 더미 데이터를 담을 공간.
        List<TodoDTO> sampleList = new ArrayList<>();

        for (int i = 0; i <10; i++) {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Sample Todo" + i);
            dto.setDueDate(LocalDate.now());
            sampleList.add(dto);
        }
        return sampleList;
    }

}
