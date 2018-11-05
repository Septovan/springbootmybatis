package id.tokoonderdil.study.springbootmybatis.mapper;

import id.tokoonderdil.study.springbootmybatis.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {

    final String insert = "INSERT INTO user(user_name, user_password) VALUES (#{user_name}, #{user_password})";
    final String getAll = "SELECT * FROM user";
    final String getById = "SELECT * FROM user WHERE ID = #{id}";
    final String update = "UPDATE user SET user_name = #{user_name}, user_password = #{user_password} WHERE id = #{id}";
    final String deleteById = "DELETE FROM user WHERE ID = #{id}";

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Users users);

    @Select(getAll)
    List<Users> findAll();

    @Select(getById)
    List<Users> findById(int id);

    @Update(update)
    void update(Users users);

    @Delete(deleteById)
    void delete(int id);
}
