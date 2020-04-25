package com.sdq.bigdata.entity;

import lombok.Data;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
public class Position implements DBWritable, Writable {
    private String id;

    private Date lastLogin;

    private String education;

    private String jobNature;

    private boolean famousCompany;

    private String companyShortName;

    private String salary;

    private String secondType;

    private Integer score;

    private Integer appShow;

    private String companyFullName;

    private String industryLablesStr;

    private String longitude;

    private String businessZonesStr;

    private Integer count;

    private Integer pcShow;

    private String companySize;

    private String stationname;

    private String linestaion;

    private Double matchScore;

    private Integer companyId;

    private Integer newScore;

    private String district;

    private String financeStage;

    private Integer isHotHire;

    private String city;

    private String latitude;

    private Integer deliver;

    private String skillLablesStr;

    private String positionAdvantage;

    private String positionName;

    private Integer isSchoolJob;

    private String aggregatePositionIdsStr;

    private Integer publisherId;

    private Integer resumeProcessDay;

    private String thirdType;

    private String companyLogo;

    private String positionLablesStr;

    private String firstType;

    private String formatCreateTime;

    private Integer positionId;

    private Date createTime;

    private Integer approve;

    private String industryField;

    private String companyLabelListStr;

    private Integer resumeProcessRate;

    private String workYear;

    private String imState;

    private String subwayline;

    private Integer adWord;


    @Override
    public void write(DataOutput out) throws IOException {

        out.writeUTF(id);
        out.writeUTF(positionName);
//        out.writeUTF(city);

    }

    @Override
    public void readFields(DataInput in) throws IOException {

        id = in.readUTF();
        positionName = in.readUTF();
//        city = in.readUTF();
    }

    @Override
    public void write(PreparedStatement ps) throws SQLException {

        ps.setString(1,id);
//        ps.setString(2,positionName);
    }

    @Override
    public void readFields(ResultSet rs) throws SQLException {

        //结果集从SQL语句查出来的

        id = rs.getString(1);
        positionName = rs.getString("position_name");
        city = rs.getString("city");
        aggregatePositionIdsStr = rs.getString("aggregate_position_ids_str");
        financeStage = rs.getString("finance_stage");
        salary = rs.getString("salary");
        companySize = rs.getString("company_size");
        workYear = rs.getString("work_year");
        skillLablesStr = rs.getString("skill_lables_str");
        industryField = rs.getString("industry_field");

//        name = rs.getString(2);
//        txt = rs.getString(3);
    }
}