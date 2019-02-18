package com.fec.yunmall.mall.bean;

/**
 * @author tome
 * @date 2019/1/11  11:06
 * @describe ${TODO}
 */
public class ConsumpBean {

    /**
     * consumpData : {"LastMonth":"12","LastMonthPeople":0,"ThisMonth":"01","ThisMonthPeople":0,"baseScore":0,"thisMeMonthFinish":0,"thisMeMonthPay":0,"thisMeUpMonthFinish":0,
     * "thisMeUpMonthPay":0}
     */

    private ConsumpDataBean consumpData;

    public ConsumpDataBean getConsumpData() {
        return consumpData;
    }

    public void setConsumpData(ConsumpDataBean consumpData) {
        this.consumpData = consumpData;
    }

    public static class ConsumpDataBean {
        /**
         * LastMonth : 12
         * LastMonthPeople : 0.0
         * ThisMonth : 01
         * ThisMonthPeople : 0.0
         * baseScore : 0.0
         * thisMeMonthFinish : 0.0
         * thisMeMonthPay : 0.0
         * thisMeUpMonthFinish : 0.0
         * thisMeUpMonthPay : 0.0
         */

        private String LastMonth;
        private double LastMonthPeople;
        private String ThisMonth;
        private double ThisMonthPeople;
        private double baseScore;
        private double thisMeMonthFinish;
        private double thisMeMonthPay;
        private double thisMeUpMonthFinish;
        private double thisMeUpMonthPay;

        public String getLastMonth() {
            return LastMonth;
        }

        public void setLastMonth(String LastMonth) {
            this.LastMonth = LastMonth;
        }

        public double getLastMonthPeople() {
            return LastMonthPeople;
        }

        public void setLastMonthPeople(double LastMonthPeople) {
            this.LastMonthPeople = LastMonthPeople;
        }

        public String getThisMonth() {
            return ThisMonth;
        }

        public void setThisMonth(String ThisMonth) {
            this.ThisMonth = ThisMonth;
        }

        public double getThisMonthPeople() {
            return ThisMonthPeople;
        }

        public void setThisMonthPeople(double ThisMonthPeople) {
            this.ThisMonthPeople = ThisMonthPeople;
        }

        public double getBaseScore() {
            return baseScore;
        }

        public void setBaseScore(double baseScore) {
            this.baseScore = baseScore;
        }

        public double getThisMeMonthFinish() {
            return thisMeMonthFinish;
        }

        public void setThisMeMonthFinish(double thisMeMonthFinish) {
            this.thisMeMonthFinish = thisMeMonthFinish;
        }

        public double getThisMeMonthPay() {
            return thisMeMonthPay;
        }

        public void setThisMeMonthPay(double thisMeMonthPay) {
            this.thisMeMonthPay = thisMeMonthPay;
        }

        public double getThisMeUpMonthFinish() {
            return thisMeUpMonthFinish;
        }

        public void setThisMeUpMonthFinish(double thisMeUpMonthFinish) {
            this.thisMeUpMonthFinish = thisMeUpMonthFinish;
        }

        public double getThisMeUpMonthPay() {
            return thisMeUpMonthPay;
        }

        public void setThisMeUpMonthPay(double thisMeUpMonthPay) {
            this.thisMeUpMonthPay = thisMeUpMonthPay;
        }
    }
}
