package com.yzh.study.designPattern.delegate.imitateSpringMVC;

import com.yzh.study.designPattern.delegate.imitateSpringMVC.controller.Controller;
import com.yzh.study.designPattern.delegate.imitateSpringMVC.controller.SystemController;
import com.yzh.study.designPattern.delegate.imitateSpringMVC.controller.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: servlet委派类
 * @author: HeroYang
 * @create: 2019-08-21 10:15
 * spring 中的委派 一般以 Dispatcher、delegate 结尾
 **/
public class DispatcherServlet {

	private  static  List<CustomHandler> handlerMapping = new ArrayList<>();

	static {
		//模拟controller注入的过程
		Class<?> systemControllerClass = SystemController.class;
		SystemController systemController = SystemController.getInstance();
		Class<?> userControllerClass = UserController.class;
		UserController userController =UserController.getInstance();
		try {
			handlerMapping.add(new CustomHandler("/system/add",systemControllerClass.getMethod("addSystem"),systemController));
			handlerMapping.add(new CustomHandler("/system/update",systemControllerClass.getMethod("updateSystem"),systemController));
			handlerMapping.add(new CustomHandler("/user/add",userControllerClass.getMethod("addUser"),userController));
			handlerMapping.add(new CustomHandler("/user/update",userControllerClass.getMethod("updateUser"),userController));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public void doService(HttpServletRequest request, HttpServletResponse response){
		try {
			doDispatcher(request,response);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 此处为委派方法
	 * （1）委派者只负责 分发，调度，派遣
	 * （2）委派者 持有 被委派者的引用（此处handlerMapping既是）
	 * （3）与代理区别：代理 是帮被代理做了部分工作（中介），而委派是根据策略是分发任务（领导）
	 * （4）与策略区别：策略注重外部拓展 -- 多实现（算法）抽象【例如：规范编码，新员工来了能更快参与项目】，委派注重 内部复用（例如：领导多了解员工，更合适地安排工作）
	 * （5）委派算是 静态代理 与 策略模式的一个特殊的组合
	 * @param request
	 * @param response
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public void doDispatcher(HttpServletRequest request, HttpServletResponse response)
			throws InvocationTargetException, IllegalAccessException, IOException {
		Object result = null;
		String reqUrl = request.getRequestURI();
		for (CustomHandler customHandler : handlerMapping) {
			if (customHandler.getUrl().equals(reqUrl)){
				Method method = customHandler.getMethod();
				Controller controller =  customHandler.getController();
				//此处只用了无参的调用 TODO 有参数的待补充
				result = method.invoke(controller);
				break;
			}
		}
		response.getWriter().write(result.toString());
	}

}
