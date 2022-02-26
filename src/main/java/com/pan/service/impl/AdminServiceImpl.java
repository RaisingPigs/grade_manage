package com.pan.service.impl;

import com.pan.bean.Admin;
import com.pan.bean.AdminExample;
import com.pan.dao.AdminMapper;
import com.pan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-16 18:19
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdmUsernameEqualTo(username).andAdmPasswordEqualTo(password);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        return admins.isEmpty() ? null : admins.get(0);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.selectByExample(null);
    }

}
