import Interface.Pet;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccess implements Pet {

    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "020828";
    private static final String MYSQL_DATABASE_SERVER = "localhost:3306";
    private static final String MYSQL_DATABASE_NAME = "Pet_hospital_management_system";

    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载驱动成功");
            String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/" + MYSQL_DATABASE_NAME+ "?&useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
            con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
            System.out.println("连接数据库成功");
        } catch (SQLException e) {
            System.out.println("没报错");
            e.printStackTrace();
            System.err.println("student: Update the MySQL constants to correct values!");
        } catch (ClassNotFoundException e) {
            System.out.println("没报错");
            e.printStackTrace();
            System.err.println("student: Add the MySQL jar file to your build path!");
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean log_in_connected(String name,String password,String identify) throws SQLException {
        if(identify==null || identify==""){return false;}
        String sqlselect="select paswrd,user_status from person where user_name="+"'"+name+"'";
        ResultSet rs=getConnection().createStatement().executeQuery(sqlselect);
        String password1="";
        String identify1="";
        while(rs.next())
        {
            password1+=rs.getString("paswrd");
            identify1+=rs.getString("user_status");
        }
        if(password.equals(password1) && !password.equals("") && identify.equals(identify1)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void add(String ID,String pet_name,String pet_kind,String pet_status,String pet_photo) throws SQLException {
        String sqlInsert="insert into pet values('"+ID+"','"+pet_name+"','"+pet_kind+"','"+pet_status+"','"+pet_photo+"')";
        getConnection().createStatement().execute(sqlInsert);
    }

    @Override
    public void delete(String ID) throws SQLException {
        String sqldelete="delete from pet where ID='"+ID+"'";
        getConnection().createStatement().execute(sqldelete);
    }


    @Override
    public void update(String ID,String pet_name,String pet_kind,String pet_status,String pet_photo) throws SQLException {
        delete(ID);
        add(ID,pet_name,pet_kind,pet_status,pet_photo);
    }

    @Override
    public String select() throws SQLException {
        String tableHeaders="<tr><th>宠物编号</th><th>宠物名称</th><th>宠物种类</th><th>铲屎官</th><th>病情</th></tr>";
        String petsHTML = "";
        petsHTML += tableHeaders;
        final String petRow = "<tr><td>ID</td><td>PET_NAME</td><td>PET_KIND</td><td>PET_STATUS</td><td>PET_PHOTO</td></tr>";

        String sqlselect="select *from pet";
        ResultSet rs =getConnection().createStatement().executeQuery(sqlselect);
        while(rs.next()){

            String ID = rs.getString("ID");
            String pet_name = rs.getString("pet_name");
            String pet_kind = rs.getString("pet_kind");
            String pet_status = rs.getString("pet_status");
            String pet_photo = rs.getString("pet_photo");

            String thisPetHTML = petRow;
            thisPetHTML = thisPetHTML.replace("ID", ID);
            thisPetHTML = thisPetHTML.replace("PET_NAME", pet_name);
            thisPetHTML = thisPetHTML.replace("PET_KIND", pet_kind);
            thisPetHTML = thisPetHTML.replace("PET_STATUS", pet_status);
            thisPetHTML = thisPetHTML.replace("PET_PHOTO", pet_photo);

            petsHTML+=thisPetHTML;

        }
        return "<style>table, th, td {\n" +
                "    border:1px solid black;\n" +
                "}</style>"+
                "<table>"+petsHTML+"</table>";

    }



    public String select1(String ID1) throws SQLException {

        String tableHeaders="<tr><th>宠物编号</th><th>宠物名称</th><th>宠物种类</th><th>铲屎官</th><th>病情</th></tr>";
        String petsHTML = "";
        petsHTML += tableHeaders;
        final String petRow = "<tr><td>ID</td><td>PET_NAME</td><td>PET_KIND</td><td>PET_STATUS</td><td>PET_PHOTO</td></tr>";

        String sqlselect="select *from pet where ID="+"'"+ID1+"'";
        ResultSet rs =getConnection().createStatement().executeQuery(sqlselect);
        while(rs.next()){

            String ID = rs.getString("ID");
            String pet_name = rs.getString("pet_name");
            String pet_kind = rs.getString("pet_kind");
            String pet_status = rs.getString("pet_status");
            String pet_photo = rs.getString("pet_photo");

            String thisPetHTML = petRow;
            thisPetHTML = thisPetHTML.replace("ID", ID);
            thisPetHTML = thisPetHTML.replace("PET_NAME", pet_name);
            thisPetHTML = thisPetHTML.replace("PET_KIND", pet_kind);
            thisPetHTML = thisPetHTML.replace("PET_STATUS", pet_status);
            thisPetHTML = thisPetHTML.replace("PET_PHOTO", pet_photo);

            petsHTML+=thisPetHTML;


        }
        return "<style>table, th, td {\n" +
                "    border:1px solid black;\n" +
                "}</style>"+
                "<table>"+petsHTML+"</table>";
    }

    public Boolean Register(String name,String password ,String identify) throws SQLException {
        boolean valid=true;
        String sqlRegister="insert into person values('"+name+"','"+password+"','"+identify+"')";
        if(name=="" || password =="" || identify=="" || identify==null){
           valid=false;
        }
        try {
            getConnection().createStatement().execute(sqlRegister);
        }catch (SQLException e){
            valid=false;
        }
        return valid;
    }

   public static void main(String[] args) throws SQLException {
        DatabaseAccess a=new DatabaseAccess();
       // System.out.println(a.log_in_connected("zhangsan","020828"));
        //a.add("李四赵武","1","1","1","1");
        //a.delete("0000");
       /*StringBuffer c=null;*/
       //System.out.println(a.select());
       //System.out.println(a.Register("55555555ww","123","123"));
    }

}
