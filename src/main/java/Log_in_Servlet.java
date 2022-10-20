import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/Log_in_Servlet")
public class Log_in_Servlet  extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 将输出转换为中文
        request.setCharacterEncoding("UTF-8");

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String identify = request.getParameter("identify");

        try {

            boolean is_connected = new DatabaseAccess().log_in_connected(user,password,identify);
            if (is_connected) {
                // 如果验证成功，则转发succeed.jsp页面，并在页面显示用户名
                request.getRequestDispatcher("用户界面/用户界面.jsp").forward(request, response);
            } else {
               // response.sendRedirect("/_war_exploded/用户登录/用户登录.html");
                request.getRequestDispatcher("用户登录/用户登录.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}