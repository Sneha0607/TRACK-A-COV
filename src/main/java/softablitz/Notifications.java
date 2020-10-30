package softablitz;

import javafx.scene.control.Button;

public class Notifications {
    public Boolean success;
    public LatestData data;

    public static class LatestData {
        public NotificationsData[] notificationsData;

        public static class NotificationsData {
            public String title;
            public String link;

            public NotificationsData(String title, String link) {
                this.title = title;
                this.link = link;
            }

            public String getTitle() {
                return title;
            }

            public String getLink() {
                return link;
            }

            }
        }
}


