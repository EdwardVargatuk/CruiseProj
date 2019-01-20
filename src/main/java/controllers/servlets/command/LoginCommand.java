package controllers.servlets.command;


import Beans.Client;
import controllers.resourse.ConfigurationManager;
import controllers.resourse.MessageManager;
import dao.mysql.MySqlClientDao;
import dao.mysql.MySqlDaoFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ActionCommand {

    private boolean hasError = false;
    private static final Logger log = LogManager.getLogger(LoginCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request) {
        log.log(Level.INFO, "enter action command LoginCommand");
        String page = null;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
//        String rememberMeStr = request.getParameter("rememberMe");
//        boolean remember = "Y".equals(rememberMeStr);

        Client client = null;

//        String errorString = null;

        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
//            hasError = true;
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerrorNull"));
            page = ConfigurationManager.getProperty("path.page.login");
//            errorString = "Required username and password!";
        } else {
//            Connection conn = MyUtils.getStoredConnection(request);
            try {
                // Найти user в DB.
//                MySqlClientDao mySqlClientDao = new MySqlClientDao();
                client = ServiceFactoryImpl.getInstance().getClientService().checkLogin(userName, password);
//                        MySqlDaoFactory.getInstance().getClientDao().checkLogin(userName, password);

                if (client != null) {
//                    System.out.println(client);
                    request.setAttribute("userName", userName);
                    page = ConfigurationManager.getProperty("path.page.main");
                } else {
                    hasError = true;
                    request.setAttribute("errorLoginPassMessage",
                            MessageManager.getProperty("message.loginerror"));
                    page = ConfigurationManager.getProperty("path.page.login");
//                    errorString = "User Name or password invalid";
                }
            } catch (Exception e) {
                log.log(Level.ERROR, "login error" +e);
//                e.printStackTrace();
                hasError = true;
//                errorString = e.getMessage();
            }
            if (hasError)
            {
                HttpSession session = request.getSession();
                MyUtils.storeLoginedUser(session, client);

                client = new Client();
                client.setUserName(userName);
                client.setPassword(password);

//                // Сохранить информацию в request attribute перед forward.
//                request.setAttribute("errorString", errorString);
                request.setAttribute("user", client);
            }
//                // Forward (перенаправить) к странице /WEB-INF/views/login.jsp
//                RequestDispatcher dispatcher
//                        = this.getServletContext().getRequestDispatcher("/jsp/loginView.jsp");
//
//                dispatcher.forward(request, response);

            // В случае, если нет ошибки.
            // Сохранить информацию пользователя в Session.
            // И перенаправить к странице userInfo.
            else {
                HttpSession session = request.getSession();
                MyUtils.storeLoginedUser(session, client);
            }


        }
        return page;
    }


//
//    @Override
//    public String execute(HttpServletRequest request) {
//        String page = null;
//// извлечение из запроса логина и пароля
//        String login = request.getParameter(PARAM_NAME_LOGIN);
//        String pass = request.getParameter(PARAM_NAME_PASSWORD);
//// проверка логина и пароля
//
//        if (LoginLogic.checkLogin(login, pass)) {
//            request.setAttribute("user", login);
//// определение пути к main.jsp
//            page = ConfigurationManager.getProperty("path.page.main");
//        } else {
//            request.setAttribute("errorLoginPassMessage",
//                    MessageManager.getProperty("message.loginerror"));
//            page = ConfigurationManager.getProperty("path.page.login");
//        }
//        return page;
//    }
}
