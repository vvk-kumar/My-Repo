package com.vivek.jpaSpecs;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Userspec, Long>, JpaSpecificationExecutor<Userspec>{

}
