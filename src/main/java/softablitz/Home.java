package softablitz;

import java.util.List;

public class Home {
    public int activeCases;
    public int activeCasesNew;
    public int recovered;
    public int recoveredNew;
    public int deaths;
    public int deathsNew;
    public int previousDayTests;
    public int totalCases;
    public String sourceUrl;
    public String lastUpdatedAtApify;
    public String readMe;
    public regionData[] regionData;


        public static class regionData {
            public String region;
            public int totalInfected;
            public int newInfected;
            public int recovered;
            public int newRecovered;
            public int deceased;
            public int newDeceased;

            public String getRegion() {
                return region;
            }

            public int getTotalInfected() {
                return totalInfected;
            }

            public int getNewInfected() {
                return newInfected;
            }

            public int getRecovered() {
                return recovered;
            }

            public int getNewRecovered() {
                return newRecovered;
            }

            public int getDeceased() {
                return deceased;
            }

            public int getNewDeceased() {
                return newDeceased;
            }

            @Override
            public String toString(){
                return "Region: " + region + "TotalInfected: " + totalInfected + "NewInfected: " + newInfected + "Recovered: "
                        + recovered + "NewRecovered:" + newRecovered + "Deceased: " + deceased + "NewDeceased: " +newDeceased;
            }
        }
}
