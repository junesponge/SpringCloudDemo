package com.springcloud.demo.eurekaclient.repository;

import com.springcloud.demo.eurekaclient.bean.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TblUser, Integer> {
}
