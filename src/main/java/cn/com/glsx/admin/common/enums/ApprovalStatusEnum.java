package cn.com.glsx.admin.common.enums;


/**
 * 审批状态
 *
 * @author zhouhaibao
 * @date 2021/5/20 11:05
 */
public enum ApprovalStatusEnum {

    APPROVAL_STATUS_START {
        @Override
        public Integer getCode() {
            return 0;
        }

        @Override
        public String getName() {
            return "初始状态";
        }
    },
    APPROVAL_STATUS_TODO {
        @Override
        public Integer getCode() {
            return 1;
        }

        @Override
        public String getName() {
            return "待处理";
        }
    },
    APPROVAL_STATUS_PROCESSED {
        @Override
        public Integer getCode() {
            return 2;
        }

        @Override
        public String getName() {
            return "已处理";
        }
    },
    APPROVAL_STATUS_REJECT {
        @Override
        public Integer getCode() {
            return 3;
        }

        @Override
        public String getName() {
            return "已驳回";
        }
    };

    public static String getValueByCode(Integer code) {
        for (ApprovalStatusEnum approvalStatusEnum : ApprovalStatusEnum.values()) {
            if (approvalStatusEnum.getCode().equals(code)) {
                return approvalStatusEnum.getName();
            }
        }
        return null;
    }

    public abstract String getName();

    public abstract Integer getCode();

}
