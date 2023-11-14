package com.smartvoucher.webEcommercesmartvoucher.repository;

import com.smartvoucher.webEcommercesmartvoucher.entity.RolesUsersEntity;
import com.smartvoucher.webEcommercesmartvoucher.entity.keys.RolesUsersKeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IRoleUserRepository extends JpaRepository<RolesUsersEntity, RolesUsersKeys> {
    @Query("SELECT ru FROM roles_users ru" +
            " JOIN users u ON ru.roleUserKeys.idUser = u.id" +
            " JOIN roles r ON  ru.roleUserKeys.idRole = r.id" +
            " WHERE u.email = :email")
    RolesUsersEntity getEmail(String email);

    @Query("SELECT ru FROM roles_users ru" +
            " JOIN users u ON ru.roleUserKeys.idUser = u.id" +
            " join roles r ON ru.roleUserKeys.idRole = r.id" +
            " WHERE r.id = :idRole AND u.id = :idUser")
    RolesUsersEntity findByIdRoleAndIdUser(long idRole, long idUser);

    void deleteByRoleUserKeys(RolesUsersKeys keys);

    @Query("SELECT ru FROM roles_users ru" +
            " JOIN users u ON ru.roleUserKeys.idUser = u.id" +
            " join roles r ON ru.roleUserKeys.idRole = r.id" +
            " WHERE r.name = :roleName")
    Set<RolesUsersEntity> findOneByRoleName(String roleName);
}
