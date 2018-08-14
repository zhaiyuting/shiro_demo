package com.gentlehu.shiro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by DELL on 2018/8/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
    public String info(HttpSession session,Model model){
        String currentUser = (String) session.getAttribute("currentUser");
        return "user/info.jsp";
    }
}
