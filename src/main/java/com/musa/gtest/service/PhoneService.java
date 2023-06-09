package com.musa.gtest.service;

import com.musa.gtest.entity.Phone;
import com.musa.gtest.entity.PhoneInput;

import java.util.List;

public interface PhoneService{

    List<Phone> retrieveAll();

    Phone savePhone(Phone phone);
    List<Phone> saveAll(List<Phone> phones);

    void delete(Integer id);
}
