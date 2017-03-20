package com.zhixindu.apply.facade.system.bo;

import com.zhixindu.apply.facade.system.enums.RegionLevel;

import java.io.Serializable;

public class RegionBO extends RegionBaseBO implements Serializable {

    private static final long serialVersionUID = -1462132026717362545L;
    /** 行政区划ID */
    private Integer region_id;
    /** 行政单位 */
    private String suffix;
    /** 全拼 */
    private String pinyin;
    /** 简拼 */
    private String py;
    /** 区划级别（1省，2市，3区/县） */
    private RegionLevel level;

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py == null ? null : py.trim();
    }

    public RegionLevel getLevel() {
        return level;
    }

    public void setLevel(RegionLevel level) {
        this.level = level;
    }
}