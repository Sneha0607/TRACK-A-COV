package softablitz;

import java.sql.*;

public class HomeSQL {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/";
    static final String user = "root";
    static final String pass = "Sneha@0607";
    HomeAPI homeAPI = new HomeAPI();
    public  void HomeSQL() {

        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            statement.executeUpdate("USE COVIDDATABASE");
            statement.executeUpdate("TRUNCATE TABLE STATEWISE");

            Home home = homeAPI.HomeAPI();
            for(Home.regionData regiondata: home.regionData) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STATEWISE VALUES (?,?,?,?,?,?,?)");
                preparedStatement.setString(1, regiondata.getRegion());
                preparedStatement.setInt(2, regiondata.getTotalInfected());
                preparedStatement.setInt(3, regiondata.getNewInfected());
                preparedStatement.setInt(4, regiondata.getRecovered());
                preparedStatement.setInt(5, regiondata.getNewRecovered());
                preparedStatement.setInt(6, regiondata.getDeceased());
                preparedStatement.setInt(7, regiondata.getNewDeceased());
                preparedStatement.executeUpdate();
            }


        }catch (SQLException e){
            e.printStackTrace();;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(statement!=null){
                    statement.close();
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            try{
                if(connection!=null){
                    connection.close();
                }
            }catch(SQLException e2){
                e2.printStackTrace();
            }
        }
    }
}
