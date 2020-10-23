package softablitz;

public class Notifications {
    Boolean success;
    LatestData data;

    public class LatestData {
        NotificationsData[] notifications;
    }

    public class NotificationsData{
        String title;
        String link;
    }

}

