package club.springboot.dubbo.dto.activemq;

import java.io.Serializable;

/**
 * @author ldj
 * @date 2018/09/14
 */
public class MessageModel<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -9059052315779251054L;
    /**
     * 附加信息描述
     * */
    private String description;

    /**
     * 实体
     * */
    private T t;

    public MessageModel(String description, T t) {
        this.description = description;
        this.t = t;
    }

    public MessageModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "description='" + description + '\'' +
                ", t=" + t +
                '}';
    }
}
