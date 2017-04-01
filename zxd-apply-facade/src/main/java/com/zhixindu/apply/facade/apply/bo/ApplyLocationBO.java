package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ApplyLocationBO implements Serializable {
    private static final long serialVersionUID = -4834418728836590839L;
    /** 位置ID */
    private Integer location_id;
    /** 申请ID */
    private Integer apply_id;
    /** 微信ID */
    private String open_id;
    /** 地址位置纬度 */
    private BigDecimal latitude;
    /** 地址位置经度 */
    private BigDecimal longitude;
    /** 地址位置精度 */
    private BigDecimal precision;
    /** 创建时间 */
    private Date create_time;

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id == null ? null : open_id.trim();
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getPrecision() {
        return precision;
    }

    public void setPrecision(BigDecimal precision) {
        this.precision = precision;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}