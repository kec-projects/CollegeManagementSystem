package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.RoleDto;
import java.util.List;
import java.util.Map;

public interface RoleService {
    Map save(RoleDto role);
    public List<RoleDto> allRole();
}
