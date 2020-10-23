package softablitz;

import java.util.List;

public class Datewise {
    Boolean success;
    Datedata data;
    String lastRefreshed;
    String lastOriginUpdate;
}
class Datedata{
    String day;
    Summary summary;
    List<Regiondatewise> region;
}
class Summary{
    int total;
    int confirmedCasesIndian;
    int confirmedCasesForeign;
    int discharged;
    int deaths;
    int confirmedButLocationUnidentified;
}
class Regiondatewise{
    String loc;
    int confirmedCasesIndian;
    int confirmedCasesForeign;
    int discharged;
    int deaths;
    int totalConfirmed;
}

