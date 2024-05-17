package com.busanit501.serverprogramtest2.todo.dto;

import java.time.LocalDate;

public class MenuDTO {
  // 인스턴스 멤버.
  private Long menunum;
  private String menuname ;
  private LocalDate menuDate;

  public Long getMenunum() {
    return menunum;
  }

  public void setMenunum(Long menunum) {
    this.menunum = menunum;
  }

  public String getMenuname() {
    return menuname;
  }

  public void setMenuname(String menuname) {
    this.menuname = menuname;
  }

  public LocalDate getMenuDate() {
    return menuDate;
  }

  public void setMenuDate(LocalDate menuDate) {
    this.menuDate = menuDate;
  }


  @Override
  public String toString() {
    return "MenuDTO{" +
            "menunum=" + menunum +
            ", menuname='" + menuname + '\'' +
            ", menuDate=" + menuDate +
            '}';
  }

}




