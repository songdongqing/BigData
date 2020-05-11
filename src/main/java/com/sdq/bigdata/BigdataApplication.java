package com.sdq.bigdata;

import com.sdq.bigdata.task.JobTask;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@SpringBootApplication
@MapperScan("com.sdq.*")
public class BigdataApplication {

    @Autowired
    private BeanFactory beanFactory1;

    static BeanFactory beanFactory2;

    @PostConstruct
    public void init(){
        beanFactory2 = beanFactory1;
    }
	public static void main(String[] args) {

		SpringApplication.run(BigdataApplication.class, args);
        doingTask();
	}

	public static void doingTask(){
        JobTask jobTask = beanFactory2.getBean(JobTask.class);
        jobTask.doingDay();
        jobTask.doingSecond();
    }



}
