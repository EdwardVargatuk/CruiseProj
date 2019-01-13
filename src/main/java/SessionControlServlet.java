import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionservlet")
public class SessionControlServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    HttpSession session = request.getSession(true);
if (session.getAttribute("role") == null) {
        session.setAttribute("role", "moder");
    }
    /* количество запросов, которые были сделаны
    к данному сервлету текущим пользователем
    в рамках текущей пользовательской сессии */
    Integer counter = (Integer) session.getAttribute("counter");
if (counter == null) {
        session.setAttribute("counter", 1);
    } else {
        /* увеличивает счетчик обращений к текущему сервлету и кладет его в сессию */
        counter++;
        session.setAttribute("counter", counter);
    }
request.setAttribute("lifecycle", "CONTROL request LIFECYCLE");
request.getRequestDispatcher("/sessionattr.jsp").forward(request, response);
}
}
