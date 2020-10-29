package softablitz;


public class Datewise {
    public NationalData[] case_time_series;
    public StateData[] statewise;

    public class NationalData {
        public String dailyconfirmed;
        public String dailydeceased;
        public String dailyrecovered;
        public String date;
        public String dateymd;
        public String totalconfirmed;
        public String totaldeceased;
        public String totalrecovered;
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
    }
}


