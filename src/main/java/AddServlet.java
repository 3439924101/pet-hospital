import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
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
                new DatabaseAccess().add(ID, name, kind, status, photo_url);
                out.print("添加成功!");
            }else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            out.print("添加失败!  请注意ID不能为空且不能重复！");
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
