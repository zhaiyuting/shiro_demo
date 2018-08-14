package com.gentlehu.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 2018/8/13.
 */
@Controller
@RequestMapping("/default")
public class DefaultController {
    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();

        try{
            currentUser.login(token);
        }catch(UnknownAccountException uae){
            model.addAttribute("err_msg","UnknownAccountException");
        }catch(IncorrectCredentialsException ice){
            model.addAttribute("err_msg","");
        }catch(LockedAccountException lae){
            model.addAttribute("err_msg","LockedAccountException");
        }catch(ExcessiveAttemptsException eae){
            model.addAttribute("err_msg","ExcessiveAttemptsException");
        }catch(AuthenticationException ae){
            //注意：这个必须放在后面，因为这个异常可以处理所有认证失败的情况
            model.addAttribute("error_msg", "authentication faild");
        }
        // 验证是否登陆成功
        if(currentUser.isAuthenticated()){
            System.out.println("user[" + username + "]authentication success");
            return "main";
        }
        token.clear();
        return "login";
    }
    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:login";
    }
}
