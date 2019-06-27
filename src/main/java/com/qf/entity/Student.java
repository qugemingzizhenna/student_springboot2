package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//声明这个实体类对应的表名称
@TableName("student")
public class Student implements Serializable {
    @TableId(type = IdType.AUTO)
    @TableField(jdbcType = JdbcType.INTEGER)
    private Integer id;
    private String name;
    @TableField(jdbcType = JdbcType.INTEGER)
    private Integer age;
    private Double score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @TableField(jdbcType = JdbcType.INTEGER)
    private Integer cid;
    //声明classes不是表中的字段
    @TableField(exist = false)
    private  Classes classes;
}
