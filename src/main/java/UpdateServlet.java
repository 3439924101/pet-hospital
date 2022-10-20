import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String ID=request.getParameter("ID");
        String name=request.getParameter("name");
        String kind=request.getParameter("kind");
        String status=request.getParameter("status");
        String photo_url=request.getParameter("photo_url");

        try {
            if(!ID.equals("")) {
            new DatabaseAccess().update(ID,name,kind,status,photo_url);
            out.println("更改成功！");
            }else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            out.println("更改失败！  请注意ID不能为空!");
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
