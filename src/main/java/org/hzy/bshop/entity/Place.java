package org.hzy.bshop.entity;

public class Place {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_place.id
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_place.value
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    private String value;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_place.id
     *
     * @return the value of t_place.id
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_place.id
     *
     * @param id the value for t_place.id
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_place.value
     *
     * @return the value of t_place.value
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_place.value
     *
     * @param value the value for t_place.value
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}