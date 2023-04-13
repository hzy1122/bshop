package org.hzy.bshop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hzy.bshop.entity.Order;
import org.hzy.bshop.entity.OrderExample;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    long countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKey(Order record);

    List<Order> selectAll();
}