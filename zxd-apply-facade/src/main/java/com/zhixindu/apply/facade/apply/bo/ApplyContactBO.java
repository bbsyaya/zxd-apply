package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.applicant.enums.ContactRelationship;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ApplyContactBO implements Serializable {
    private static final long serialVersionUID = -2075646585551667198L;
    /** 联系人ID */
    private Integer contact_id;
    /** 申请ID */
    private Integer apply_id;
    /** 申请人ID */
    private Integer applicant_id;
    /** 联系人关系 */
    private ContactRelationship contact_relationship;
    @NotBlank(message = "联系人姓名不能为空")
    private String contact_name;
    @NotBlank(message = "联系人手机不能为空")
    private String contact_mobile;
    @NotNull(message = "contact_relationship_value不能为空")
    private Integer contact_relationship_value;
    /** 创建时间 */
    private Date create_time;

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    @NotNull(message = "联系人关系不能为空")
    public ContactRelationship getContact_relationship() {
        return contact_relationship == null ? ContactRelationship.resolve(contact_relationship_value) : contact_relationship;
    }

    public void setContact_relationship(ContactRelationship contact_relationship) {
        this.contact_relationship = contact_relationship;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name == null ? null : contact_name.trim();
    }

    public String getContact_mobile() {
        return contact_mobile;
    }

    public void setContact_mobile(String contact_mobile) {
        this.contact_mobile = contact_mobile == null ? null : contact_mobile.trim();
    }

    public Integer getContact_relationship_value() {
        return contact_relationship_value == null && null != contact_relationship ? contact_relationship.getValue() : contact_relationship_value;
    }

    public void setContact_relationship_value(Integer contact_relationship_value) {
        this.contact_relationship_value = contact_relationship_value;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}