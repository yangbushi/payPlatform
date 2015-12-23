package com.defray.task;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.Trigger;
import org.quartz.helpers.TriggerUtils;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MyServlet() {
	}

	public void init() {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		
		Trigger trigger = TriggerUtils.makeWeeklyTrigger(3, 16, 38);
		//Trigger trigger2 = TriggerUtils.makeDailyTrigger(arg0, arg1);
        // 从现在开始1秒钟之后，每隔1秒钟执行一次job1
        service.scheduleAtFixedRate(
                new ScheduledExecutorTest("job"), 10,
                30, TimeUnit.SECONDS);
	}

	public void doGet(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse) throws ServletException,
			IOException {
	}

	public void destory() {
	}

}
