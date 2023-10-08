package io.github.alice52.craftsman.dto;

import io.github.alice52.craftsman.dto.clientobject.UserProfileCO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserProfileUpdateCmd extends CommonCommand {

    @NotNull private UserProfileCO userProfileCO;
}
