package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.db.sql.pojo.RmtOperateGroupInfo;
import com.shineon.coder.kernel.common.bo.BOFactory;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.util.RmtOperateGroupInfoCommonUtil;

public class BOBuildTool {

    public static void main(String[] args) throws Exception {
//        BOFactory factory = new BOFactory("matao", RmtOperateGroupInfoCommonUtil.class,
//                RmtOperateGroupInfo.class, BOConstant.BO_METHOD, SysConstant.CURRENT_SYS_NAME);
//        factory.rebuild();

        BOFactory factory = new BOFactory("matao", RmtOperateGroupInfoCommonUtil.class,
                RmtOperateGroupInfo.class, new String[]{"matao"}, SysConstant.CURRENT_SYS_NAME);
        factory.delete();
    }
}
