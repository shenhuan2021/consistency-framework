package cn.lifesmile.consistency.enums;

/**
 * 任务状态枚举类
 **/
public enum TaskStatusEnum {

    /**
     * 0:初始化 1:开始执行 2:执行失败 3:执行成功
     */
    INIT(0, "初始化"), START(1, "开始执行"), FAIL(2, "执行失败"), SUCCESS(3, "执行成功");

    private final int code;
    private final String desc;

    TaskStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
}
