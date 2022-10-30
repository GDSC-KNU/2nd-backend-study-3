package com.backend3rd.BOGUdanyo.repository;

import com.backend3rd.BOGUdanyo.entity.AccidentArea;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
@PropertySource(value={"classpath:application.properties"})
public class MySQLStatisticRepository implements StatisticRepository{

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    // 현재 서버에서 MySQL에 데이터를 넣어줄 필요는 없음 -> store() 사용 안 함
    @Override
    public void store(AccidentArea aa) {
        return;
    }

    @Override
    public AccidentArea[] findByRegion(String regionName) {
        ArrayList<AccidentArea> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            String query = "select * from statistic where address like ?";

            if(connection != null){
                psmt = connection.prepareStatement(query);
                psmt.setString(1, regionName + "%");
                ResultSet rs = psmt.executeQuery();

                while (rs.next()) {
                    AccidentArea val = new AccidentArea(
                            rs.getString("address"),
                            rs.getFloat("lat"),
                            rs.getFloat("lon"),
                            rs.getInt("occur_cnt"),
                            rs.getInt("caslt_cnt"),
                            rs.getInt("death_cnt"),
                            rs.getInt("sever_cnt"),
                            rs.getInt("mild_cnt")
                    );
                    result.add(val);
                }

                rs.close();
                psmt.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Get Connection Error! SQLException = " + e.getSQLState());
        }
        finally {
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Connection Close Error! SQLException = " + e.getSQLState());
                }
            }
        }

        return result.toArray(new AccidentArea[0]);
    }
}
