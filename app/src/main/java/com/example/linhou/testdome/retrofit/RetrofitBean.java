package com.example.linhou.testdome.retrofit;

import java.util.List;

/**
 * Created by Lin.Hou on 2017/8/28.
 */

public class RetrofitBean {

    /**
     * code : 0
     * message : success
     * rows : {"id":6,"startTime":"Aug 29, 2017 10:38:41 AM","status":"盘点中","userName":"admin","completedSubShelf":[{"lightid":1,"labelCode":"T-000001","labelSerial":"879906000000000001","status":0},{"lightid":3,"labelCode":"T-000002","labelSerial":"879906000000000002","status":0},{"lightid":5,"labelCode":"T-000004","labelSerial":"879906000000000008","status":0},{"lightid":6,"labelCode":"T-000005","labelSerial":"879906000000000010","status":0},{"lightid":7,"labelCode":"T-000006","labelSerial":"879906000000000020","status":0},{"lightid":8,"labelCode":"T-000007","labelSerial":"879906000000000040","status":0}]}
     */

    private int code;
    private String message;
    private RowsBean rows;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * id : 6
         * startTime : Aug 29, 2017 10:38:41 AM
         * status : 盘点中
         * userName : admin
         * completedSubShelf : [{"lightid":1,"labelCode":"T-000001","labelSerial":"879906000000000001","status":0},{"lightid":3,"labelCode":"T-000002","labelSerial":"879906000000000002","status":0},{"lightid":5,"labelCode":"T-000004","labelSerial":"879906000000000008","status":0},{"lightid":6,"labelCode":"T-000005","labelSerial":"879906000000000010","status":0},{"lightid":7,"labelCode":"T-000006","labelSerial":"879906000000000020","status":0},{"lightid":8,"labelCode":"T-000007","labelSerial":"879906000000000040","status":0}]
         */

        private int id;
        private String startTime;
        private String status;
        private String userName;
        private List<CompletedSubShelfBean> completedSubShelf;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public List<CompletedSubShelfBean> getCompletedSubShelf() {
            return completedSubShelf;
        }

        public void setCompletedSubShelf(List<CompletedSubShelfBean> completedSubShelf) {
            this.completedSubShelf = completedSubShelf;
        }

        public static class CompletedSubShelfBean {
            /**
             * lightid : 1
             * labelCode : T-000001
             * labelSerial : 879906000000000001
             * status : 0
             */

            private int lightid;
            private String labelCode;
            private String labelSerial;
            private int status;

            public int getLightid() {
                return lightid;
            }

            public void setLightid(int lightid) {
                this.lightid = lightid;
            }

            public String getLabelCode() {
                return labelCode;
            }

            public void setLabelCode(String labelCode) {
                this.labelCode = labelCode;
            }

            public String getLabelSerial() {
                return labelSerial;
            }

            public void setLabelSerial(String labelSerial) {
                this.labelSerial = labelSerial;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}