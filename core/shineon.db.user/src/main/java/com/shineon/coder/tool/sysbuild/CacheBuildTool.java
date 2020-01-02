package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.sql.pojo.RmtOperateGroupInfo;
import com.shineon.coder.kernel.common.cache.CacheFactory;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.util.RmtOperateGroupInfoCommonUtil;

public class CacheBuildTool {

    public static void main(String[] args) throws Exception {
        CacheFactory factory = new CacheFactory("matao", RmtOperateGroupInfoCommonUtil.class,
                RmtOperateGroupInfo.class, ActionConstant.ACTION_METHOD, SysConstant.CURRENT_SYS_NAME);
        factory.build();
    }
}
