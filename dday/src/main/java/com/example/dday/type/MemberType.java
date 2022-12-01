package com.example.dday.type;

public enum MemberType {
    NORMAL("일반회원"),
    PARTNER("파트너회원")
    ;

    private final String label;

    MemberType(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
