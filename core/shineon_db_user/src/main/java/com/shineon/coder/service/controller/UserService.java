package com.shineon.coder.service.controller;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("shineon_server_uauth")
public interface UserService {



}
