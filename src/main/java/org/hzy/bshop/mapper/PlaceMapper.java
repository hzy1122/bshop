package org.hzy.bshop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hzy.bshop.entity.Place;
import org.hzy.bshop.entity.PlaceExample;

public interface PlaceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    long countByExample(PlaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByExample(PlaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insert(Place record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insertSelective(Place record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    List<Place> selectByExample(PlaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    Place selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExampleSelective(@Param("record") Place record, @Param("example") PlaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExample(@Param("record") Place record, @Param("example") PlaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKeySelective(Place record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_place
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKey(Place record);
}