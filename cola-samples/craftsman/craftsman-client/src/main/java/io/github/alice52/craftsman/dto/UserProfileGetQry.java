package io.github.alice52.craftsman.dto;

import lombok.Data;

@Data
public class UserProfileGetQry extends CommonCommand {
    private String userId;
    private String id;

    public UserProfileGetQry() {}
}
