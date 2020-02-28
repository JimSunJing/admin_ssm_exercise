package com.jimmy.controller;

import com.jimmy.domain.SysLog;
import com.jimmy.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;

    private Date visitTime;
    private Class clazz;
    private Method method;
    private SysLog sysLog = new SysLog();

    // 前置
    @Before("execution(* com.jimmy.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        // 获取一开始访问的时间
        visitTime = new Date();
        sysLog.setVisitTime(visitTime);
        // 获取要访问的类
        clazz = jp.getTarget().getClass();
        // 获取方法名称
        String methodName = jp.getSignature().getName();
        sysLog.setMethod("类名: "+clazz.getName()+" 方法名: "+methodName);
        // 获取方法参数
        Object[] args = jp.getArgs();
        // 获取具体执行的method对象
        if (args.length==0 || args==null){
            method = clazz.getMethod(methodName);
        }else{
            // 需要获取所有参数的class
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,classes);
        }

    }

    // 后置
    @After("execution(* com.jimmy.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        long time = new Date().getTime() - visitTime.getTime();
        sysLog.setExecutionTime(time);

        // 获取URI
        StringBuilder uri = new StringBuilder();
        if (clazz!=null && method!=null && clazz!=LogAop.class){
            // 通过RequestMapping注解推断uri
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            String[] classValues = clazzAnnotation.value();
            if (classValues!=null){
                uri.append(classValues[0]);
            }
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            String[] methodValues = methodAnnotation.value();
            if (methodValues!=null){
                uri.append(methodValues[0]);
            }
        }
        String URL = uri.toString();
        sysLog.setUrl(URL);
        // 获取访问ip
        String ip = request.getRemoteAddr();
        sysLog.setIp(ip);

        // 获取SpringSecurity中存放的用户信息
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();

        String username = user.getUsername();
        sysLog.setUsername(username);

        sysLogService.save(sysLog);

    }
}
