package com.zhixindu.apply.facade.system.bo;

import java.io.Serializable;

public class IdCardAttributionBO implements Serializable {

    private static final long serialVersionUID = 4366609262925539788L;
    /** 归属地ID */
    private Integer attribution_id;
    /** 行政区划代码 */
    private Integer region_code;
    /** 地区名称 */
    private String region_name;
    /** 城市代码 */
    private Integer city_code;
    /** 城市名称 */
    private String city_name;

    public Integer getAttribution_id() {
        return attribution_id;
    }

    public void setAttribution_id(Integer attribution_id) {
        this.attribution_id = attribution_id;
    }

    public Integer getRegion_code() {
        return region_code;
    }

    public void setRegion_code(Integer region_code) {
        this.region_code = region_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name == null ? null : region_name.trim();
    }

    public Integer getCity_code() {
        return city_code;
    }

    public void setCity_code(Integer city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name == null ? null : city_name.trim();
    }
}