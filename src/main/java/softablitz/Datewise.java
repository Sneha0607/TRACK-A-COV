package softablitz;


public class Datewise {
    public Boolean success;
    public DatewiseData[] data;
    public String lastRefreshed;
    public String lastOriginUpdate;

    public static class DatewiseData {

        public String day;
        public Summary summary;
        public static RegionDatewise[] regional;

        public String getDay() {
            return day;
        }

        public static class Summary{
            private int total;
            private int confirmedCasesIndian;
            private int confirmedCasesForeign;
            private int discharged;
            private int deaths;
            private int confirmedButLocationUnidentified;

            public int getTotal() {
                return total;
            }

            public int getConfirmedCasesIndian() {
                return confirmedCasesIndian;
            }

            public int getConfirmedCasesForeign() {
                return confirmedCasesForeign;
            }

            public int getDischarged() {
                return discharged;
            }

            public int getDeaths() {
                return deaths;
            }

            public int getConfirmedButLocationUnidentified() {
                return confirmedButLocationUnidentified;
            }

        }
        public static class RegionDatewise{
            private String loc;
            private int confirmedCasesIndian;
            private int confirmedCasesForeign;
            private int discharged;
            private int deaths;
            private int totalConfirmed;

            public String getLoc() {
                return loc;
            }

            public int getConfirmedCasesIndian() {
                return confirmedCasesIndian;
            }

            public int getConfirmedCasesForeign() {
                return confirmedCasesForeign;
            }

            public int getDischarged() {
                return discharged;
            }

            public int getDeaths() {
                return deaths;
            }

            public int getTotalConfirmed() {
                return totalConfirmed;
            }


        }

    }
}


