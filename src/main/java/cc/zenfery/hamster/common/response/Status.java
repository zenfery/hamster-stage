package cc.zenfery.hamster.common.response;

public enum Status {

    // 成功
    SUCCESS(0),
    // 失败
    ERROE(1);

    private int status = 0;

    private Status(int status) {
        this.status = status;
    }

    public int status() {
        return this.status;
    }
}
