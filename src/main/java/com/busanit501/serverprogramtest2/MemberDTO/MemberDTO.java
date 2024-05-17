package com.busanit501.serverprogramtest2.MemberDTO;

import java.time.LocalDate;

public class MemberDTO {
    // 인스턴스 멤버.
    private Long memberNum;
    private String memberName;
    private LocalDate memberDate;

    public LocalDate getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(LocalDate memberDate) {
        this.memberDate = memberDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Long memberNum) {
        this.memberNum = memberNum;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNum=" + memberNum +
                ", memberName='" + memberName + '\'' +
                ", memberDate=" + memberDate +
                '}';
    }

}