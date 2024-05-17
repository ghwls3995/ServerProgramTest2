package com.busanit501.serverprogramtest2.todo.dto;

import java.time.LocalDate;

public class menu2DTO {
  // 인스턴스 멤버.
  private Long menuNo;
  private String MenuTitle ;
  private LocalDate MenuRegDate;

  @Override
  public String toString() {
    return "menu2DTO{" +
            "menuNo=" + menuNo +
            ", MenuTitle='" + MenuTitle + '\'' +
            ", MenuRegDate=" + MenuRegDate +
            '}';
  }

  public Long getMenuNo() {
    return menuNo;
  }

  public void setMenuNo(Long menuNo) {
    this.menuNo = menuNo;
  }

  public String getMenuTitle() {
    return MenuTitle;
  }

  public void setMenuTitle(String menuTitle) {
    MenuTitle = menuTitle;
  }

  public LocalDate getMenuRegDate() {
    return MenuRegDate;
  }

  public void setMenuRegDate(LocalDate menuRegDate) {
    MenuRegDate = menuRegDate;
  }
}



