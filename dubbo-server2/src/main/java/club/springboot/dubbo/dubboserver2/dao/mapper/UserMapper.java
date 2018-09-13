package club.springboot.dubbo.dubboserver2.dao.mapper;

import club.springboot.dubbo.po.User;
import org.apache.ibatis.annotations.*;

/**
 * @author ldj
 * @date 2018/09/12
 */
@Mapper
public interface UserMapper {

    @Select("select * from t_user where user_id = #{userId}")
    public User getById(Integer userId);

    @Select("select * from t_user where user_name = #{userName}")
    public User getByUserName(@Param("userName") String userName);

    @Select("select * from t_user where phone = #{phone}")
    public User getByPhone(@Param("phone") String phone);

    @Results({@Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "userIdCart.userIdNo", column = "user_id_no"),
            @Result(property = "userIdCart.userIdNoToken", column = "user_id_no_token"),
            @Result(property = "userIdCart.userId", column = "iid")
    })
    @Select("select t.user_id, t.user_name, t.password, t.phone, i.user_id as iid, i.user_id_no, i.user_id_no_token from t_user as t left join t_user_id_info as i on t.user_id = i.user_id where t.user_id = #{userId}")
    public User selectUserAndUserID(Integer userId);

    @Insert("insert into t_user(user_name, password, phone) values (#{user.userName}, #{user.password}, #{user.phone})")
    public Integer saveUser(@Param("user") User user);
}
