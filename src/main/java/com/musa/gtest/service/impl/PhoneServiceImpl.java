package com.musa.gtest.service.impl;

import com.musa.gtest.entity.Phone;
import com.musa.gtest.entity.PhoneInput;
import com.musa.gtest.repository.PhoneRepository;
import com.musa.gtest.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhoneServiceImpl implements PhoneService {

    final
    PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<Phone> retrieveAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> saveAll(List<Phone> phones) {
        return phoneRepository.saveAll(phones.stream().map((phone) -> new Phone(phone.getId(),phone.getPhoneBrand(), phone.getPhoneName())).toList());
    }

    @Override
    public void delete(Integer id) {
         phoneRepository.deleteById(id);
    }
}
