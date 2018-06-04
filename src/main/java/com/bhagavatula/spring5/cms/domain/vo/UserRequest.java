package com.bhagavatula.spring5.cms.domain.vo;

import com.bhagavatula.spring5.cms.domain.models.Role;
import lombok.Data;

@Data
public class UserRequest {

    String identity;
    String name;
    Role role;

}
