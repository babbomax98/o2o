package com.o2o.dao;

import com.o2o.entity.LocalAuth;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author shkstart
 * @create 2020-05-08 21:26
 */
public interface LocalAuthDao {
    //通过账号和密码查询对应信息，登录时用
    LocalAuth queryLocalByUserNameAndPwd(@Param("userName") String userName,
                                         @Param("password") String password);

    /**
     *通过用户id查询对应的localauth
     * @param userId
     * @return
     */
    LocalAuth queryLocalByUserId(@Param("userId") long userId);

    /**
     *添加平台账号
     * @param localAuth
     * @return
     */
    int insertLocalAuth(LocalAuth localAuth);

    /**
     *通过以下几个参数更改密码
     * @param// localAuth
     * @return
     */
    int updateLocalAuth(@Param("userId") Long userId,
                        @Param("userName") String userName,
                        @Param("password") String password,
                        @Param("newPassword") String newPassword,
                        @Param("lastEditTime") Date lastEditTime);

}
