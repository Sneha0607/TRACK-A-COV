package softablitz;

import javafx.scene.control.Button;

public class Notifications {
    public Boolean success;
    public LatestData data;

    public class LatestData {
        public NotificationsData[] notifications;

        public class NotificationsData {
            public String title;
            public String link;

            public String getTitle() {
                return title;
            }

            public String getLink() {
                return link;
            }

            }
        }
}


