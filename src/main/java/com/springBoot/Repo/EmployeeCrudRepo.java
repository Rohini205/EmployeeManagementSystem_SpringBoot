package com.springBoot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.entitiy.Employee;

//Repository class to connect with the database

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {

}
