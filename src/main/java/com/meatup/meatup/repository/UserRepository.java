package com.meatup.meatup.repository;

import com.meatup.meatup.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {
    Users findByUid(String uid);
    Users findByEmail(String email);
//    Friend findbyFriendId(String uid);
    boolean existsByUid(String id);
}
