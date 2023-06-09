package org.hzy.bshop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hzy.bshop.entity.User;
import org.hzy.bshop.entity.UserExample;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKey(User record);
}