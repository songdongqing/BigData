package com.sdq.bigdata.task;

import com.sdq.bigdata.entity.CompanySalary;
import com.sdq.bigdata.service.JobService;
import com.sdq.bigdata.wordcount.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Component
@Slf4j
@Data
public class JobTask {
    @Autowired
    JobService jobService;

    private ExecutorService cachedThreadPool;


    public void doingDay(){
        new Timer("testTimer").schedule(new TimerTask() {
            @Override
            public void run() {
                jobService.getDatas(-1);
                log.info("数据爬取完毕");
                new CompanySalaryJob().analyse();
                new CompanySizeJob().analyse();
                new IndustryFieldJob().analyse();
                new PositionJob().analyse();
                new SalaryJob().analyse();
                new SkillJob().analyse();
                new WorkYearJob().analyse();
                log.info("数据分析完毕");
           }
        }, 1000*60*60*24,1000*60*60*24);
    }

    public void doingSecond(){
        new Timer("testTimer").schedule(new TimerTask() {
            @Override
            public void run() {
                jobService.getDatas(3);
                log.info("数据爬取完毕");
                new CompanySalaryJob().analyse();
                new CompanySizeJob().analyse();
                new IndustryFieldJob().analyse();
                new PositionJob().analyse();
                new SalaryJob().analyse();
                new SkillJob().analyse();
                new WorkYearJob().analyse();
                log.info("数据分析完毕");
//                cachedThreadPool = Executors.newFixedThreadPool(7);
//                cachedThreadPool.execute(new CompanySalaryJob());
//                cachedThreadPool.execute(new CompanySizeJob());
//                cachedThreadPool.execute(new IndustryFieldJob());
//                cachedThreadPool.execute(new PositionJob());
//                cachedThreadPool.execute(new SalaryJob());
//                cachedThreadPool.execute(new SkillJob());
//                cachedThreadPool.execute(new WorkYearJob());
            }
        }, 0,1000*60*10);
    }


}