package com.qf.controller;

import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClassesService;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Autowired
    private IStuService stuService;
    @Autowired
    private IClassesService classesService;
    @RequestMapping("/list")
    public String listStudent(Model model){
        List<Student> students = stuService.queryAll();
        model.addAttribute("stus",students);
        return "stuList";
    }

    @RequestMapping("/toAdd")
    public String addStudent(Model model){
        //1.进入控制层进行页面跳转时，查询所有的班级给下拉框赋值
        List<Classes> classes = classesService.queryAll();
        model.addAttribute("classes",classes);
        return "addStudent";
    }

    @RequestMapping("/insert")
    public String insert(Student student){
        stuService.insertStudent(student);
        return "redirect:/stu/list";
    }

    @RequestMapping("/delete")
    public String deleteStudent(Integer sid){
        stuService.deleteStudent(sid);
        return "redirect:/stu/list";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(Integer sid,Model model){
        Student student = stuService.queryById(sid);
        model.addAttribute("student",student);
        Classes classes = classesService.queryById(sid);
        List<Classes> classList = classesService.queryAll();
        model.addAttribute("classList",classList);
        model.addAttribute("classes",classes);
        return "updateStudent";
    }
    @RequestMapping("/update")
    public String update(Student student){
        stuService.updateStudent(student);
        System.out.println(student);
        return "redirect:/stu/list";
    }

}
