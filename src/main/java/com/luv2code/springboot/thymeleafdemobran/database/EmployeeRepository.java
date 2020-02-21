package com.luv2code.springboot.thymeleafdemobran.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll();

    List<Employee> findByFirstName(String name);

    Employee findById(long id);

    void deleteEmployeeById(long id);

    @Modifying
    @Query("update Employee e set e.firstName = ?1, e.lastName = ?2, e.email = ?3 where e.id = ?4")
    void setEmployeeInfoById(String fName, String lName, String email, long id);
}
