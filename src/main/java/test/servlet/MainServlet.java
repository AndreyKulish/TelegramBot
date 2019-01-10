package test.servlet;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import test.bot.TestBot;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ApiContextInitializer.init(); // Инициализируем апи
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            TestBot testBot = new TestBot();
            botapi.registerBot(testBot);
            /*Thread thread = new Thread(new ThreadBotWorker(testBot));
            thread.start();*/
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello Servlet</h1>");
    }

}