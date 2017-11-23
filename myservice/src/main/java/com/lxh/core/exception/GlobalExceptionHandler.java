package com.lxh.core.exception;

import com.lxh.result.ResultBody;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 * 主要做没有权限异常以及业务异常等处理，404,500异常自定义页面请使用EmbeddedServletContainerCustomizer接口的方式(相关类:AppErrorPagesConfiguration+ErrorPageController)(推荐)或者使用HandlerInterceptor的方式(相关类:ErrorInterceptorController)
 * sea
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html
 * Error Handling Created by Ason on 2017/8/30.
 */
// 表示 GlobalExceptionHandler 是一个全局的异常处理器.
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Log log = LogFactory.get();

	/**
	 * 拦截业务异常,这个用在Ajax操作时有用
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = RmsException.class)
	@ResponseBody
	public String handle(RmsException e) {
		System.out.println("系统异常");
		log.error("【系统异常】{}", e);
		return ResultBody.error(e.getResponseInfo());
	}

	@ExceptionHandler(value = UnauthorizedException.class)
	// @ExceptionHandler在此处定义全局处理，通过@ExceptionHandler的value属性可过滤拦截的条件，在此处我们可以看出我们拦截所有的Exception
	public ModelAndView exception(Exception ex, WebRequest request) {
		log.error("没有权限");
		ModelAndView modelAndView = new ModelAndView("errorpage/denied"); // error页面
		// modelAndView.addObject("errorMessage",e.getMessage());
		return modelAndView;
	}
	// @ExceptionHandler(value = Exception.class)
	// //@ExceptionHandler在此处定义全局处理，通过@ExceptionHandler的value属性可过滤拦截的条件，在此处我们可以看出我们拦截所有的Exception
	// public ModelAndView exception(Exception ex, WebRequest request){
	// if(ex instanceof UnauthorizedException) {
	// ModelAndView modelAndView = new ModelAndView("denied"); //error页面
	// //modelAndView.addObject("errorMessage",e.getMessage());
	// return modelAndView;
	// }
	// ex.printStackTrace();
	// System.out.println("==============异常结束=============");
	// ModelAndView mv = new ModelAndView("error");
	// mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
	// return mv;
	// }
}
