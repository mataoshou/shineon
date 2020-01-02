package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.pojo.RmtOperateGroupInfo;
import com.shineon.coder.db.pojo.RmtOperateInfo;
import com.shineon.coder.db.pojo.RmtOrganizationInfo;
import com.shineon.coder.kernel.common.action.ActionFactory;
import com.shineon.coder.kernel.common.cache.CacheFactory;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.util.RmtOperateGroupInfoCommonUtil;
import com.shineon.coder.service.convert.util.RmtOperateInfoCommonUtil;
import com.shineon.coder.service.convert.util.RmtOrganizationInfoCommonUtil;

public class CacheBuildTool {

    public static void main(String[] args) throws Exception {
        CacheFactory factory = new CacheFactory("OperateGroup", RmtOperateGroupInfoCommonUtil.class,
                RmtOperateGroupInfo.class, ActionConstant.ACTION_METHOD, SysConstant.CURRENT_SYS_NAME);
        factory.build();
    }
}
