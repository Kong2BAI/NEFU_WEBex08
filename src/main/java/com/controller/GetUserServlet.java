package com.controller;

import com.service.ServiceFactory;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/getUser")
public class GetUserServlet extends HttpServlet {
    // 基于ServiceFactory工厂，获取单例的UserService组件
    private final UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("uid");
        req.setAttribute("user", userService.getUser(id));
        req.getRequestDispatcher("/WEB-INF/JSP/query.jsp")
                .forward(req,resp);
    }
}
