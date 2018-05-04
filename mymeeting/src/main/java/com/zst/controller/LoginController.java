package com.zst.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zst.model.SysUser;
import com.zst.service.impl.PermissionService;

/**
 * Created by sun on 2017-4-2.
 */
@Controller
public class LoginController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public ModelAndView loginForm(){
        ModelAndView model = new ModelAndView();
        model.addObject("user", new SysUser());
        model.addObject("message", "请输入用户账号");
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(@Valid SysUser user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "redirect:login";
        }
        String email = user.getEmail();
        if(StringUtils.isBlank(user.getEmail()) || StringUtils.isBlank(user.getPswd())){
            logger.info("用户名或密码为空! ");
            redirectAttributes.addFlashAttribute("message", "用户名或密码为空!");
            return "redirect:login";
        }
        //验证
        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPswd());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.info("对用户[" + email + "]进行登录验证..验证开始");
            currentUser.login(token);
            logger.info("对用户[" + email + "]进行登录验证..验证通过");
        }catch(UnknownAccountException uae){
            logger.info("对用户[" + email + "]进行登录验证..验证未通过,未知账户");
            redirectAttributes.addFlashAttribute("message", "未知账户");
        }catch(IncorrectCredentialsException ice){
            logger.info("对用户[" + email + "]进行登录验证..验证未通过,错误的凭证");
            redirectAttributes.addFlashAttribute("message", "密码不正确");
        }catch(LockedAccountException lae){
            logger.info("对用户[" + email + "]进行登录验证..验证未通过,账户已锁定");
            redirectAttributes.addFlashAttribute("message", "账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            logger.info("对用户[" + email + "]进行登录验证..验证未通过,错误次数大于5次,账户已锁定");
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数大于5次,账户已锁定");
        }catch (DisabledAccountException sae){
            logger.info("对用户[" + email + "]进行登录验证..验证未通过,帐号已经禁止登录");
            redirectAttributes.addFlashAttribute("message", "帐号已经禁止登录");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + email + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
        }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            logger.info("用户[" + email + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            //把当前用户放入session
            Session session = currentUser.getSession();
            SysUser tUser = permissionService.findByUserEmail(email);
            session.setAttribute("currentUser",tUser);
            return "/welcome";
        }else{
            token.clear();
            return "redirect:login";
        }
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes ){
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        logger.info("------没有权限-------");
        return "errorPermission";
    }

}