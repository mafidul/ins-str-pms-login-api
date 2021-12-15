package com.tcs.ins.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tcs.ins.login.repository.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>, JpaSpecificationExecutor<Login> {

}
