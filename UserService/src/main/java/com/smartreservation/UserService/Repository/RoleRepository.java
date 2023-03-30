package com.smartreservation.UserService.Repository;

import java.util.Optional;

import com.smartreservation.UserService.Enum.RoleEnum;
import com.smartreservation.UserService.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
