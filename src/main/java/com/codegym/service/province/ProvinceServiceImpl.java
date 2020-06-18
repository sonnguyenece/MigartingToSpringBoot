package com.codegym.service.province;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceServiceImpl implements IProvinceService<Province> {

    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public void insert(Province model) {
        iProvinceRepository.save((Province) model);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return iProvinceRepository.findById(id);
    }
}
