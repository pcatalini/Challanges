package com.challange.InsuranceSimulator_API.feignclient;


import com.challange.InsuranceSimulator_API.feignclient.dto.UserRegistryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userRegistry", url = "http://localhost:8080/v1/users")
public interface UserRegistryFeign {

    @GetMapping("/{userId}")
    UserRegistryDTO getUserById(@PathVariable("userId") String userId);
}
