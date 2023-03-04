package top.johnnycse.flight.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.johnnycse.flight.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where userId = #{id}")
    User GetUserById(Integer id);
}
