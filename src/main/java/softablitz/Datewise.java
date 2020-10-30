package softablitz;


public class Datewise {
    public NationalData[] case_time_series;
    public StateData[] statewise;

    public Datewise(NationalData[] case_time_series, StateData[] statewise) {
        this.case_time_series = case_time_series;
        this.statewise = statewise;
    }

    public class NationalData {
        public String dailyconfirmed;
        public String dailydeceased;
        public String dailyrecovered;
        public String date;
        public String dateymd;
        public String totalconfirmed;
        public String totaldeceased;
        public String totalrecovered;

        public NationalData(String dailyconfirmed, String dailydeceased, String dailyrecovered, String date, String dateymd, String totalconfirmed, String totaldeceased, String totalrecovered) {
            this.dailyconfirmed = dailyconfirmed;
            this.dailydeceased = dailydeceased;
            this.dailyrecovered = dailyrecovered;
            this.date = date;
            this.dateymd = dateymd;
            this.totalconfirmed = totalconfirmed;
            this.totaldeceased = totaldeceased;
            this.totalrecovered = totalrecovered;
        }

        public String getDailyconfirmed() {
            return dailyconfirmed;
        }

        public String getDailydeceased() {
            return dailydeceased;
        }

        public String getDailyrecovered() {
            return dailyrecovered;
        }

        public String getDate() {
            return date;
        }

        public String getDateymd() {
            return dateymd;
        }

        public String getTotalconfirmed() {
            return totalconfirmed;
        }

        public String getTotaldeceased() {
            return totaldeceased;
        }

        public String getTotalrecovered() {
            return totalrecovered;
        }
    }

    public class StateData {
        public String active;
        public String confirmed;
        public String deaths;
        public String deltaconfirmed;
        public String deltadeaths;
        public String deltarecovered;
        public String lastupdatedtime;
        public String migratedother;
        public String recovered;
        public String state;
        public String statecode;
        public String statenotes;

        public StateData(String active, String confirmed, String deaths, String deltaconfirmed, String deltadeaths, String deltarecovered, String lastupdatedtime, String migratedother, String recovered, String state, String statecode, String statenotes) {
            this.active = active;
            this.confirmed = confirmed;
            this.deaths = deaths;
            this.deltaconfirmed = deltaconfirmed;
            this.deltadeaths = deltadeaths;
            this.deltarecovered = deltarecovered;
            this.lastupdatedtime = lastupdatedtime;
            this.migratedother = migratedother;
            this.recovered = recovered;
            this.state = state;
            this.statecode = statecode;
            this.statenotes = statenotes;
        }

        public String getActive() {
            return active;
        }

        public String getConfirmed() {
            return confirmed;
        }

        public String getDeaths() {
            return deaths;
        }

        public String getDeltaconfirmed() {
            return deltaconfirmed;
        }

        public String getDeltadeaths() {
            return deltadeaths;
        }

        public String getDeltarecovered() {
            return deltarecovered;
        }

        public String getLastupdatedtime() {
            return lastupdatedtime;
        }

        public String getMigratedother() {
            return migratedother;
        }

        public String getRecovered() {
            return recovered;
        }

        public String getState() {
            return state;
        }

        public String getStatecode() {
            return statecode;
        }

        public String getStatenotes() {
            return statenotes;
        }
    }
}


