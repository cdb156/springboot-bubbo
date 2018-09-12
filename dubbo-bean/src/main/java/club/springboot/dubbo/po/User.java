package club.springboot.dubbo.po;

import java.io.Serializable;

/**
 * @author ldj
 * @date 2018/09/12
 */
public class User implements Serializable {

    private Long userId;

    private String userName;

    private String password;

    private String phone;

    private UserIdCart userIdCart;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserIdCart getUserIdCart() {
        return userIdCart;
    }

    public void setUserIdCart(UserIdCart userIdCart) {
        this.userIdCart = userIdCart;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", userIdCart=" + userIdCart +
                '}';
    }
}
