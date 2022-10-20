
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 将输出转换为中文
        request.setCharacterEncoding("UTF-8");

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String identify = request.getParameter("identify");

        try {
            boolean is_connected = new DatabaseAccess().Register(user,password,identify);
            if (is_connected) {
                request.getRequestDispatcher("/用户登录/用户登录.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/用户注册/用户注册.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
