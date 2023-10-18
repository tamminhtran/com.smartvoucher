package com.smartvoucher.webEcommercesmartvoucher.converter;

import com.smartvoucher.webEcommercesmartvoucher.dto.RoleDTO;
import com.smartvoucher.webEcommercesmartvoucher.entity.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RoleConverter {
    public List<RoleDTO> findAllRole(List<RoleEntity> list) {

        List<RoleDTO> listRole = new ArrayList<>();

        for (RoleEntity data : list) {

            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setRoleCode(data.getRoleCode());
            roleDTO.setCreatedAt(data.getCreatedAt());
            roleDTO.setUpdatedAt(data.getUpdatedAt());
            roleDTO.setCreatedBy(data.getCreatedBy());
            roleDTO.setUpdatedBy(data.getUpdatedBy());

            listRole.add(roleDTO);
        }

        return listRole;
    }

    public RoleEntity insertRole(RoleDTO roleDTO) {

        RoleEntity role = new RoleEntity();
        role.setName(roleDTO.getName());
        role.setRoleCode(roleDTO.getRoleCode());

        return role;
    }

    public RoleEntity updateRole(RoleDTO roleDTO, RoleEntity oldRole) {

        if (roleDTO.getName() != null
                && !roleDTO.getName().isEmpty()
                && !roleDTO.getName().substring(5).isEmpty()
                && !Objects.equals(roleDTO.getName(), oldRole.getName()) ) {
            oldRole.setName(roleDTO.getName());
        }

        if (roleDTO.getRoleCode() != null
                && !roleDTO.getRoleCode().isEmpty()
                && !Objects.equals(roleDTO.getRoleCode(), oldRole.getRoleCode()) ) {
            oldRole.setRoleCode(roleDTO.getRoleCode());
        }

        return oldRole;

    }
}
