package test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable task = new Runnable(){
			int i = 0;
			public void run(){
				System.out.println("This is task No "+i++);
			}
		};
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);
	}

}
