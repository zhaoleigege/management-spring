package cn.edu.bnuz.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static cn.edu.bnuz.aop.aop.AopUtil.MethodString;

/**
 * 文件 WebAop 创建于 2018/4/11
 *
 * @author 赵磊
 * @version 1.0
 */
@Aspect
@Component
public class WebAop {
    @Pointcut("execution(* cn.edu.bnuz.*.web..*.*(..))")
    public void webPointcut() {

    }

    @Around("webPointcut()")
    public Object webAop(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest servlet = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if (servlet.getUserPrincipal() != null)
            System.out.println("用户: " + servlet.getUserPrincipal().getName() + " 访问了： " + MethodString(point.getArgs(), (CodeSignature) point.getSignature()));
        else
            System.out.println("IP: " + servlet.getRemoteAddr() + ":" + servlet.getRemotePort() + " 访问了: " + MethodString(point.getArgs(), (CodeSignature) point.getSignature()));

        return point.proceed();
    }
}
