package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){
        //First let's create an employee
        Employee employee= new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("555-12-1234");

        //Now let's create a Laptop
        Laptop laptop=new Laptop();
        laptop.setBrand("Deli");
        laptop.setModel("Latitude XL");

        //Add the laptop to the employee
        employee.setLaptop(laptop);

        //Save the employee to the databasr
        employeeRepository.save(employee);

        //Grab all the employees from the dagtabase and send them to the template
        model.addAttribute("employees",employeeRepository.findAll());
        return "index";
    }
}
