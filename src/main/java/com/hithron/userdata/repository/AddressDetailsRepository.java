package com.hithron.userdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithron.userdata.entity.AddressDetailsEntity;

@Repository
public interface AddressDetailsRepository extends JpaRepository<AddressDetailsEntity, Long>{

}
