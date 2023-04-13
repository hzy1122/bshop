package org.hzy.bshop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hzy.bshop.entity.Plume;
import org.hzy.bshop.entity.PlumeExample;

public interface PlumeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    long countByExample(PlumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByExample(PlumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insert(Plume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int insertSelective(Plume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    List<Plume> selectByExample(PlumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    Plume selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExampleSelective(@Param("record") Plume record, @Param("example") PlumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByExample(@Param("record") Plume record, @Param("example") PlumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKeySelective(Plume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plume
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    int updateByPrimaryKey(Plume record);
}