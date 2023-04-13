package org.hzy.bshop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hzy.bshop.entity.Address;
import org.hzy.bshop.entity.AddressExample;

public interface AddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    long countByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insert(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insertSelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    List<Address> selectByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    Address selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKeySelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKey(Address record);
}