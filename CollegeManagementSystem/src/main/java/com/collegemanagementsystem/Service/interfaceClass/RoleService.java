package com.collegemanagementsystem.Service.interfaceClass;

import com.collegemanagementsystem.Dto.RoleDto;
import java.util.List;
import java.util.Map;

public interface RoleService {
    Map save(RoleDto role);
    public List<RoleDto> allRole();
}
