package dev.uni.infrastructure.share;

public enum ExceptionCode {
    CAR_NOT_FOUND("COR_231", "CAR_NOT_FOUND");
    private final String code;
    private final String type;

    ExceptionCode(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}

