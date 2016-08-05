package com.funny.result;

/**
 * 对外提供接口返回的json结果类
 * 
 * @author fangli
 *
 * @param <T>
 */
public class JsonResult<T> {

    private int returncode;

    private String message;

    private T result;

    public JsonResult() {
    }

    public JsonResult(T result) {
        this.result = result;
    }

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setSuccess() {
        this.returncode = 0;
        this.message = "成功";
    }

    public void setSuccess(T result) {
        setSuccess();
        setResult(result);
    }

    public boolean isSuccess() {
        if (returncode == 0) {
            return true;
        }
        return false;
    }

}
