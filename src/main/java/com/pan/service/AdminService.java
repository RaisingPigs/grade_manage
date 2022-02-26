package com.pan.service;

import com.pan.bean.Admin;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2020-12-16 17:32
 **/
public interface AdminService {
    Admin login(String username, String password);

    List<Admin> getAllAdmins();
}
