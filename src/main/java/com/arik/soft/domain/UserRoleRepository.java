package com.arik.soft.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

//        @Query("select a.role from UserRole a, User b where a.USER_ID = b.user_id and b.user_Name = ?1")
//        List<Roles> findRolesByUserName(String userName);
}
