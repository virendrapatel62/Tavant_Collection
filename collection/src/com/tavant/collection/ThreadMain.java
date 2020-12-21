package com.tavant.collection;

import com.tavant.collection.dao.EmployeeDaoImpl;

public class ThreadMain{

	public static void main(String[] args) {
		Runnable runnable = ()->{
			System.out.println(EmployeeDaoImpl.getInstance().hashCode());
		};
		
		Thread thread = new Thread(runnable);
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		Thread thread3 = new Thread(runnable);
		Thread thread4 = new Thread(runnable);
		
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
}
