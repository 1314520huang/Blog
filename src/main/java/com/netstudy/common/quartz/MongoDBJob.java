package com.netstudy.common.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  MongoDB 与数据库同步
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-07
 */
public class MongoDBJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format("NowTIme = " + new Date()));
    }
}
