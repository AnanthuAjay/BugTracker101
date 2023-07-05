package com.bug.bg;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringbatchApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringbatchApplication.class, args);
		String[] springconfig= {"batch-job-demo.xml"};
		ApplicationContext context =new ClassPathXmlApplicationContext(springconfig);
		
		JobLauncher jobLauncher= (JobLauncher) context.getBean("jobLauncher");
		Job job=(Job) context.getBean("helloWorldBatchJob");
		try {
			JobExecution  jobExecution=jobLauncher.run(job, new JobParameters());
			System.out.println(""+jobExecution.getStatus());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
