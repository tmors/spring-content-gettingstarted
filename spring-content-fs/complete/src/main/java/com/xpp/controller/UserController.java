package com.xpp.controller;

import com.xpp.vo.UserVO;
import com.xpp.mapper.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengyuxiang
 * @date 2019/1/10
 */
@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value="/users/{userId}", method = RequestMethod.GET)
    public UserVO getCurrentUserInfo(@PathVariable("userId") String id){
        UserVO userVO = iUserService.getUserById(id);
        return userVO;
    }
}
