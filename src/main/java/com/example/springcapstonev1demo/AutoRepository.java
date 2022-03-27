package com.example.springcapstonev1demo;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface AutoRepository extends CrudRepository <Auto, Integer> {

    //No queries beyond CrudRepository Needed most likely

}
