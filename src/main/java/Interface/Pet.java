package Interface;

import java.sql.SQLException;

public interface Pet {
    void add(String ID,String pet_name,String pet_kind,String pet_status,String pet_photo) throws SQLException;
    void delete(String ID) throws SQLException;
    void update(String ID,String pet_name,String pet_kind,String pet_status,String pet_photo) throws SQLException;
    String select() throws SQLException;
    String select1(String ID) throws SQLException;

}
