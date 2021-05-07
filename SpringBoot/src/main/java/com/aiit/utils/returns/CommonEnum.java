package com.aiit.utils.returns;



public enum CommonEnum implements BaseErrorInfoInterface {

    SUCCESS(200, "成功"),
    BODY_NOT_MATCH(400, "请求的数据格式不符"),
    PARAME_NOT_EMTYPE(403,"请求参数不能为空"),
    SIGNAUTION_NOT_MATCH(401, "请求的数据签名不符"),
    NOT_FOUND(404, "未找到资源"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVER_BUSY(503, "服务器忙，请稍后重试。。。");

    private int resultCode;

    private String resultMsg;

    CommonEnum() {
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    CommonEnum(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public int getResultCode() {
        return this.resultCode;
    }

    @Override
    public String getResultMessage() {
        return this.resultMsg;
    }
}