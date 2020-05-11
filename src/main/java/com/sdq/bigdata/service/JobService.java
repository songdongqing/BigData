package com.sdq.bigdata.service;

import com.alibaba.fastjson.JSON;
import com.sdq.bigdata.dto.JobResult;
import com.sdq.bigdata.entity.Position;
import com.sdq.bigdata.entity.Result;
import com.sdq.bigdata.mapper.PositionMapper;
import com.sdq.bigdata.strategy.JobContext;
import com.sdq.bigdata.strategy.LaGouStrategy;
import com.sdq.bigdata.util.CommUtil;
import com.sdq.bigdata.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
@Slf4j
public class JobService {
    @Autowired
    PositionMapper positionMapper;

    public void getDatas(int pages){
        TreeSet treeSet = new TreeSet();
        List<Position> positionsAll = positionMapper.selectByExample(null);
        treeSet.addAll(positionsAll);

        JobContext jobContext = new JobContext(new LaGouStrategy());
        JobResult<List<Result>> resultsRes  = jobContext.getDatas(pages);

        List<Result> results = resultsRes.getJobs();
        List<Position> positions = new ArrayList<>();


        results.forEach(result -> {
            Position position = new Position();
            BeanUtils.copyProperties(result,position);
            position.setId(UuidUtil.getUUID32());

            position.setAggregatePositionIdsStr(CommUtil.listToStr(result.getAggregatePositionIds()));
            position.setBusinessZonesStr(CommUtil.listToStr(result.getBusinessZones()));
            position.setCompanyLabelListStr(CommUtil.listToStr(result.getCompanyLabelList()));
            position.setIndustryLablesStr(CommUtil.listToStr(result.getIndustryLables()));
            position.setPositionLablesStr(CommUtil.listToStr(result.getPositionLables()));
            position.setSkillLablesStr(CommUtil.listToStr(result.getSkillLables()));

            if(!treeSet.contains(position)){
                System.out.println("数据库不存在该数据："+ JSON.toJSONString(position));
                positions.add(position);
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                if(!positions.isEmpty()){
                    positionMapper.insertList(positions);
                }else {
                    System.out.println("没有新增数据");
                }
            }
        }).start();
    }
}