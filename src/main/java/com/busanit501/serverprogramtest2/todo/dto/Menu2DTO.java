package com.busanit501.serverprogramtest2.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu2DTO {
  // 인스턴스 멤버.
  private Long menuNo;
  private String MenuTitle;
  private LocalDate MenuRegDate;

}




