package softablitz;

import java.sql.*;

public class HomeSQL {

    HomeAPI homeAPI = new HomeAPI();
    public  void HomeSQL() {

        Connection connection = SQLConnection.getConnection();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE STATEWISE");

            Home home = homeAPI.HomeAPI();
            for(Home.regionData regiondata: home.regionData) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STATEWISE VALUES (?,?,?,?,?)");
                preparedStatement.setString(1, regiondata.getRegion());
                preparedStatement.setInt(2, regiondata.getTotalInfected());

                preparedStatement.setInt(3, regiondata.getRecovered());

                preparedStatement.setInt(4, regiondata.getDeceased());
                preparedStatement.setInt(5, regiondata.getTotal());

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
