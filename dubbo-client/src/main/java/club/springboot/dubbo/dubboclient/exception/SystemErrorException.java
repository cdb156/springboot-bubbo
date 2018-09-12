package club.springboot.dubbo.dubboclient.exception;

import java.io.Serializable;

/**
 * @author ldj
 * @date 2018/09/12
 */
public class SystemErrorException implements Serializable {

    private String url;

    private String message;

    public SystemErrorException() {

    }

    public SystemErrorException(String url, String message) {
        this.url = url;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
