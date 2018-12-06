package cn.edu.bnuz.domain.error;

/**
 * 文件 ErrorResponse 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
public class ErrorResponse {
    private String error;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
