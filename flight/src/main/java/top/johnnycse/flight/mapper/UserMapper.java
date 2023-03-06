package top.johnnycse.flight.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.johnnycse.flight.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from User where userId = #{id}")
    User getUserInfoById(Integer id);

    @Select("select * from User where userName  = #{UserName}")
    User getUserInfoByUserName(String UserName);

    @Insert("insert into User (userName,password) VALUES (#{userName},#{password})")
    Integer insertUser(String userName,String password);



}
