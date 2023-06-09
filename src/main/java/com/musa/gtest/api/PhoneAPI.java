package com.musa.gtest.api;

import com.musa.gtest.entity.Phone;
import com.musa.gtest.entity.PhoneInput;
import com.musa.gtest.service.PhoneService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/phone")
public class PhoneAPI {


    final
    PhoneService phoneService;

    public PhoneAPI(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @QueryMapping
    public List<Phone> findAllPhones(){
        return phoneService.retrieveAll();
    }

    @MutationMapping
    public List<Phone> savePhones(@Argument List<PhoneInput> phones) {
        return phoneService.saveAll(phones.stream().map((phone) -> new Phone(null,phone.phone_brand(), phone.phone_name())).toList());
    }

    @MutationMapping
    public Phone updatePhone(@Argument Integer id, @Argument String phoneBrand, @Argument String phoneName){
        return phoneService.savePhone(new Phone(id, phoneBrand,phoneName));
    }

    @QueryMapping
    public void deletePhone(@Argument Integer id) {
        phoneService.delete(id);
    }


}
