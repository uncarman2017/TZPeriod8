package org.redmaplesoft.bigdata.hadoopstudy.lesson8.serializable.salarytotal;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//                                                                k2: 部门编号  v2: 员工
public class SalaryTotalMapper extends Mapper<LongWritable, Text, IntWritable, Emp> {

    @Override
    protected void map(LongWritable key1, Text value1, Context context)
            throws IOException, InterruptedException {

        String data = value1.toString();

        //分词
        String[] words = data.split(",");

        Emp emp = new Emp();
        emp.setEmpno(Integer.parseInt(words[0]));
        emp.setEname(words[1]);
        emp.setJob(words[2]);
        emp.setMgr(Integer.parseInt(words[3]));
        emp.setHiredate(words[4]);
        emp.setSal(Integer.parseInt(words[5]));
        emp.setComm(Integer.parseInt(words[6]));
        emp.setDeptno(Integer.parseInt(words[7]));

        context.write(new IntWritable(emp.getDeptno()), emp);
    }
}
