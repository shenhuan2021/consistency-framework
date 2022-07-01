package cn.lifesmile.consistency.enums;

/**
 * 执行方式
 */
public enum ExecuteWayEnum {
    /**
     * 立即执行
     */
    RIGHT_NOW(1, "立即执行"),
    /**
     * 调度执行
     */
    SCHEDULE(2, "调度执行");


    private final Integer code;

    private final String desc;

    ExecuteWayEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }
}
