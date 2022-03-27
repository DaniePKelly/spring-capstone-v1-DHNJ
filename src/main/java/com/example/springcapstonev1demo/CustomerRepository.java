package com.example.springcapstonev1demo;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Customer repository
 *
 * @author Josh
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
