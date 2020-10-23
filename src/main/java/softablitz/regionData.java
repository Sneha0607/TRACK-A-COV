package softablitz;

public class regionData {
    String region;
    int totalInfected;
    int newInfected;
    int recovered;
    int newRecovered;
    int deceased;
    int newDeceased;

    public regionData() {
    }

    public int getDeceased() {
        return deceased;
    }

    public int getNewDeceased() {
        return newDeceased;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getTotalInfected() {
        return totalInfected;
    }

    public int getNewInfected() {
        return newInfected;
    }

    public String getRegion() {
        return region;
    }
    @Override
    public String toString(){
        return "Region: " + region + "TotalInfected: " + totalInfected + "NewInfected: " + newInfected + "Recovered: "
                + recovered + "NewRecovered:" + newRecovered + "Deceased: " + deceased + "NewDeceased: " +newDeceased;
    }
}
