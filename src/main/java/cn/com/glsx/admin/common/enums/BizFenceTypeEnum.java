package cn.com.glsx.admin.common.enums;

public enum BizFenceTypeEnum {

    TRIAL_DRIVE_ROUTE {
        @Override
        public Integer getCode() {
            return 12;
        }

        @Override
        public String getName() {
            return " 试驾线路";
        }
    },
    TRIAL_DRIVE_SHOP {
        @Override
        public Integer getCode() {
            return 13;
        }

        @Override
        public String getName() {
            return "特约店围栏";
        }
    }, ALARM_FENCE {
        @Override
        public Integer getCode() {
            return 14;
        }

        @Override
        public String getName() {
            return "警情围栏";
        }
    };

    public static String getNameByCode(Integer code) {
        for (BizFenceTypeEnum typeEnum : BizFenceTypeEnum.values()) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum.getName();
            }
        }
        return null;
    }

    public abstract String getName();

    public abstract Integer getCode();

}
