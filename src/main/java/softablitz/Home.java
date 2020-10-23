package softablitz;

import java.util.List;

public class Home {
    int activeCases;
    int activeCasesNew;
    int recovered;
    int recoveredNew;
    int deaths;
    int deathsNew;
    int previousDayTests;
    int totalCases;
    String sourceUrl;
    String lastUpdatedAtApify;
    String readMe;
    List<regionData> regionData;

    public Home() {

    }

    public int getActiveCases(){
        return activeCases;
    }
    public int getActiveCasesNew(){
        return activeCasesNew;
    }
    public int getRecovered(){
        return recovered;
    }
    public int getRecoveredNew(){
        return recoveredNew;
    }
    public int getDeaths(){
        return deaths;
    }
    public int getDeathsNew(){
        return deathsNew;
    }
    public int getPreviousDayTests(){
        return previousDayTests;
    }
    public int getTotalCases(){
        return totalCases;
    }
    public String getSourceUrl(){
        return sourceUrl;
    }
    public String getLastUpdatedAtApify(){
        return lastUpdatedAtApify;
    }
    public String getReadMe(){
        return readMe;
    }

    public List<softablitz.regionData> getRegionData() {
        return regionData;
    }
}
