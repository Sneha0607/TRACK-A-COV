package softablitz;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.DriverManager;
import java.sql.Statement;
import java.net.http.HttpClient;
import java.net.URI;

import java.sql.*;


import com.google.gson.*;
public class Dashboard {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/";
    static final String user = "root";
    static final String pass = "Sneha@0607";


    public static void Homeapi(){
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            st = conn.createStatement();


            var url = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";
            //httprequest
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            var client = HttpClient.newBuilder().build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String JsonObject = response.body();
            Home data = new Gson().fromJson(JsonObject, Home.class);
            for(Home.regionData reg: data.regionData){
                System.out.println(reg);
            }
            Statement s = conn.createStatement();
            s.executeUpdate("Use COVIDDATABASE");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO DASHBOARD VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, data.activeCases);
            ps.setInt(2, data.activeCasesNew);
            ps.setInt(3, data.recovered);
            ps.setInt(4, data.recoveredNew);
            ps.setInt(5, data.deaths);
            ps.setInt(6, data.deathsNew);
            ps.setInt(7, data.previousDayTests);
            ps.setInt(8, data.totalCases);
            ps.setString(9, data.sourceUrl);
            ps.setString(10, data.lastUpdatedAtApify);
            ps.setString(11, data.readMe);
            ps.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
    public static void Helplineapi(){
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            st = conn.createStatement();


            var url = "https://api.rootnet.in/covid19-in/contacts";
            //httprequest
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            var client = HttpClient.newBuilder().build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String JsonObject = response.body();
            Helpline helplinedata = new Gson().fromJson(JsonObject, Helpline.class);
          //  System.out.println(helplinedata.getLastRefreshed());
            Statement s = conn.createStatement();

            /*s.executeUpdate("Use COVIDDATABASE");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO  VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.executeUpdate();*/
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
    public static void Notificationsapi(){
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            st = conn.createStatement();


            var url = "https://api.rootnet.in/covid19-in/notifications";
            //httprequest
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            var client = HttpClient.newBuilder().build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String JsonObject = response.body();
           // News NewsData = new Gson().fromJson(JsonObject, News.class);
            // Statement s = conn.createStatement();

            /*s.executeUpdate("Use COVIDDATABASE");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO  VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.executeUpdate();*/
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
    public static void Datewiseapi(){
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            st = conn.createStatement();


            var url = "https://api.rootnet.in/covid19-in/stats/history";
            //httprequest
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            var client = HttpClient.newBuilder().build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String JsonObject = response.body();
            Datewise datewisedata = new Gson().fromJson(JsonObject, Datewise.class);
            Statement s = conn.createStatement();

            s.executeUpdate("Use COVIDDATABASE");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO  VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
