package com.fec.yunmall.projectcore.bean.home;

/**
 * @author tome
 * @date 2019/1/29  10:11
 * @describe ${丝阁项目的测试数据}
 */
public class TestRankingBean {

    /**
     * msg : 查询成功
     * obj : {"personalRankingData":{"monthlyRankingLow":"2","yearRankingLow":"2","rankingCount":"109","yearRankingHigh":"2","monthlyRankingHigh":"13"}}
     * state : 0
     */

    private String msg;
    private ObjBean obj;
    private String state;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static class ObjBean {
        /**
         * personalRankingData : {"monthlyRankingLow":"2","yearRankingLow":"2","rankingCount":"109","yearRankingHigh":"2","monthlyRankingHigh":"13"}
         */

        private PersonalRankingDataBean personalRankingData;

        public PersonalRankingDataBean getPersonalRankingData() {
            return personalRankingData;
        }

        public void setPersonalRankingData(PersonalRankingDataBean personalRankingData) {
            this.personalRankingData = personalRankingData;
        }

        public static class PersonalRankingDataBean {
            /**
             * monthlyRankingLow : 2
             * yearRankingLow : 2
             * rankingCount : 109
             * yearRankingHigh : 2
             * monthlyRankingHigh : 13
             */

            private String monthlyRankingLow;
            private String yearRankingLow;
            private String rankingCount;
            private String yearRankingHigh;
            private String monthlyRankingHigh;

            public String getMonthlyRankingLow() {
                return monthlyRankingLow;
            }

            public void setMonthlyRankingLow(String monthlyRankingLow) {
                this.monthlyRankingLow = monthlyRankingLow;
            }

            public String getYearRankingLow() {
                return yearRankingLow;
            }

            public void setYearRankingLow(String yearRankingLow) {
                this.yearRankingLow = yearRankingLow;
            }

            public String getRankingCount() {
                return rankingCount;
            }

            public void setRankingCount(String rankingCount) {
                this.rankingCount = rankingCount;
            }

            public String getYearRankingHigh() {
                return yearRankingHigh;
            }

            public void setYearRankingHigh(String yearRankingHigh) {
                this.yearRankingHigh = yearRankingHigh;
            }

            public String getMonthlyRankingHigh() {
                return monthlyRankingHigh;
            }

            public void setMonthlyRankingHigh(String monthlyRankingHigh) {
                this.monthlyRankingHigh = monthlyRankingHigh;
            }
        }
    }
}
