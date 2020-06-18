package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    ICustomerService<Customer> iCustomerService;

    @GetMapping("/customer")
    ModelAndView showProvince() {
        ModelAndView modelAndView = new ModelAndView("customer/customer");
        Iterable<Customer> customers = iCustomerService.findAll();
        modelAndView.addObject("customerList", customers);
        return modelAndView;
    }

    @GetMapping("/view-customer/{id}")
    ModelAndView showCustomerDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = null;
        Optional<Customer> customer = iCustomerService.findById(id);


        if (customer.isPresent()) {
            modelAndView = new ModelAndView("/customer/view");

            modelAndView.addObject("customer",  customer.get());
        } else {
            modelAndView = new ModelAndView("/403");
            modelAndView.addObject("message","not found customer with id ="+id);
        }
        return modelAndView;
    }
}
