package com.task.ems.repository;

import com.task.ems.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login,Integer> {
}
