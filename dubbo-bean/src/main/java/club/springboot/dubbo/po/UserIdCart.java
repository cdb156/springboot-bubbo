package club.springboot.dubbo.po;

import java.io.Serializable;

/**
 * @author ldj
 * @date 2018/09/12
 */
public class UserIdCart implements Serializable {

    private Long userId;

    private String userIdNo;

    private String userIdNoToken;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserIdNo() {
        return userIdNo;
    }

    public void setUserIdNo(String userIdNo) {
        this.userIdNo = userIdNo;
    }

    public String getUserIdNoToken() {
        return userIdNoToken;
    }

    public void setUserIdNoToken(String userIdNoToken) {
        this.userIdNoToken = userIdNoToken;
    }

    @Override
    public String toString() {
        return "UserIdCart{" +
                "userId=" + userId +
                ", userIdNo='" + userIdNo + '\'' +
                ", userIdNoToken='" + userIdNoToken + '\'' +
                '}';
    }
}
