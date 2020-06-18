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
public class ProvinceController {

    @Autowired
    IProvinceService<Province> iProvinceService;
    @Autowired
    ICustomerService<Customer> iCustomerService;

    @GetMapping("/province")
    ModelAndView showProvince() {
        ModelAndView modelAndView = new ModelAndView("province/province");
        Iterable<Province> provinces = iProvinceService.findAll();
        modelAndView.addObject("provinceList", provinces);
        return modelAndView;
    }

    @GetMapping("/view-province/{id}")
    ModelAndView showProvinceDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = null;
        Optional<Province> province = iProvinceService.findById(id);

        if (province.isPresent()) {
            modelAndView = new ModelAndView("/province/view");
            Iterable<Customer> customers = iCustomerService.findAllByProvince(province.get());
            modelAndView.addObject("province", province.get());
            modelAndView.addObject("customers", customers);

        } else {
            modelAndView = new ModelAndView("/403");
            modelAndView.addObject("message", "not found province with id =" + id);
        }
        return modelAndView;
    }
}
