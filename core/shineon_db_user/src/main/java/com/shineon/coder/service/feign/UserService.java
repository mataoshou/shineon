package com.shineon.coder.service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("shineon_server_uauth")
public interface UserService {


}
