package com.collegemanagementsystem.Service.interfaceClass;

import com.collegemanagementsystem.Dto.RoleDto;
import com.collegemanagementsystem.Dto.UserRoleDto;


import java.util.List;
import java.util.Map;

public interface UserRoleService {
    Map save(UserRoleDto userRoleDto);
    public List<UserRoleDto> allRole(Long userId);
}
