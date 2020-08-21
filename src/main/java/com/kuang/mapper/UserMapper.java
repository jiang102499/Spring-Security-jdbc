package com.kuang.mapper;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author ht
 * @Date 2020/8/20 10:39
 * @Version 1.0
 **/

@Mapper
@Repository
public interface UserMapper {

  public User selectlimit(String username);

}//