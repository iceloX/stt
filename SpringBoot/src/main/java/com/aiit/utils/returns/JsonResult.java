package com.aiit.utils.returns;
 
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JsonResult {
    /**
     * 响应代码
     */
    private int code;
 
    /**
     * 响应消息
     */
    private String message;
 
    /**
     * 响应结果
     */
    private Object result;
 
    public JsonResult() {
    }
 
    public int getCode() {
        return code;
    }
 
    public void setCode(int code) {
        this.code = code;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public Object getResult() {
        return result;
    }
 
    public void setResult(Object result) {
        this.result = result;
    }
 
    /**
     * 成功
     *
     * @return
     */
    public static JsonResult success() {
        return success(null);
    }
 
    /**
     * 成功
     * @param data
     * @return
     */
    public static JsonResult success(Object data) {
        JsonResult rb = new JsonResult();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMessage(CommonEnum.SUCCESS.getResultMessage());
        rb.setResult(data);
        return rb;
    }
 
    /**
     * 失败
     */
    public static JsonResult error(int code, String message) {
        JsonResult rb = new JsonResult();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }
 
    /**
     * 失败
     */
    public static JsonResult error( String message) {
        JsonResult rb = new JsonResult();
        rb.setCode(-1);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }
 
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
 
}