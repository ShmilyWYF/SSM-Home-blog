package com.peak.ssm.httpUiltr;

public enum HttpEnum {
        /**
         * 请求处理正常
         */
        OK_200(200, "请求成功","success"),

        /**
         * 请求处理正常
         */
        CREATED_201(201, "创建成功","success"),


        /**
         * 请求处理异常，请稍后再试
         */
        ERROR_400(400, "非法请求","warning"),

        /**
         * 访问内容不存在
         */
        NotFound_400(404, "访问内容不存在","warning"),

        /**
         * 系统内部错误
         */
        ERROR_500(500, "系统内部错误","error"),

        /**
         * 参数校验失败
         */
        ERROR_600(600, "参数校验失败","warning");

        private String desc;
        private String type;
        private int code;

        private HttpEnum(int code, String desc , String type) {
            this.desc = desc;
            this.code = code;
            this.type = type;
        }

        public String desc() {
            return desc;
        }

        public int code() {
            return code;
        }

        public String type(){ return type;}
}

