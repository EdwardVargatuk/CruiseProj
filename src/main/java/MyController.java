import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/control")
public class MyController extends HttpServlet {

    MyModel myModelh = new MyModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
Person person= myModelh.getPerson();
req.setAttribute("pers", person);

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("one", "two", "three"));
        req.setAttribute("lst", list);

        RequestDispatcher  requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req,resp);





        //        HttpSession session = req.getSession();
//        Enumeration<String> attributeNames = session.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            String attNames = attributeNames.nextElement();
//            System.out.println(attNames +" = "+session.getAttribute(attNames));
//        }
//        session.setAttribute("ooo", 1+2);
//        System.out.println(session.getMaxInactiveInterval());



    }

}

