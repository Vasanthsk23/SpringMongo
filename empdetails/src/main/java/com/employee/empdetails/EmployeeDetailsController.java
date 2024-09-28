package com.employee.empdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeDetailsController {

    @Autowired
    EmployeeDetailsRepository employeeDetailsRepository;

    @GetMapping("/save-emp-details")
    public String saveDetails(@RequestParam String empid, @RequestParam String empname, @RequestParam String empemail, @RequestParam String location){
        System.out.println(empname);
        EmployeeDetails obj = new EmployeeDetails();
        obj.setEmpid(empid);
        obj.setEmpname(empname);
        obj.setEmpemail(empemail);
        obj.setLocation(location);
        employeeDetailsRepository.save(obj);
        return "Details saved Successfully";
    }

    @GetMapping("/displayAll")
    public List<EmployeeDetails> displayAll(){
        return employeeDetailsRepository.findAll();
    }

    @GetMapping("/display/{userid}")
    public Optional<EmployeeDetails> display(@PathVariable String userid){
        return employeeDetailsRepository.findById(userid);
    }
}
