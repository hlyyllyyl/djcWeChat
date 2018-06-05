package com.decisioncustom.service;


import com.decisioncustom.domain.Role;

import java.util.List;

public interface IRoleService extends IBaseService<Role>{

    List<Role> getRoleByLoginId(Long loginId);
}
