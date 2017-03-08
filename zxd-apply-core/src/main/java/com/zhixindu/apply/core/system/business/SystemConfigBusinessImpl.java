package com.zhixindu.apply.core.system.business;

import com.zhixindu.apply.core.system.dao.BankMapper;
import com.zhixindu.apply.core.system.dao.RegionMapper;
import com.zhixindu.apply.core.system.enums.BinLength;
import com.zhixindu.apply.facade.system.bo.RegionBaseBO;
import com.zhixindu.apply.facade.system.business.DubboApplySystemConfigBusiness;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public class SystemConfigBusinessImpl implements DubboApplySystemConfigBusiness {

    @Inject
    private RegionMapper regionMapper;
    @Inject
    private BankMapper bankMapper;

    @Override
    public List<RegionBaseBO> getAllRegion() {
        return regionMapper.selectAll();
    }

    @Override
    public List<RegionBaseBO> getRegionList(Integer parentCode) {
        return regionMapper.selectListByParentCode(parentCode);
    }

    @Override
    public RegionBaseBO getRegion(Integer code) {
        return regionMapper.selectByCode(code);
    }

    @Override
    public String getBankName(Integer bankCardNumber) {
        for(BinLength binLength : BinLength.values()) {
            Integer bin = Integer.valueOf(bankCardNumber.toString().substring(0, binLength.getValue()));
            String bankName = bankMapper.selectBankNameByBin(bin);
            if(StringUtils.isNotBlank(bankName)) {
                return bankName;
            }
        }
        return "";
    }



}
