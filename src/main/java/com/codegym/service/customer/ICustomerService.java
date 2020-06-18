package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.IService;

public interface ICustomerService<Customer> extends IService<Customer> {
    Iterable<com.codegym.model.Customer> findAllByProvince(Province province);
}
