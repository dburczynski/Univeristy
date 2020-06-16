package com.jee.demo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

    List<Customer> findByMoney(Double money);

    List<Customer> findByDate(Date date);
}
