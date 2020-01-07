package org.egg.model.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/5 15:27
 */
@Data
public class ResetPwdDto {
    @NotBlank
    private String telNo;
    @NotBlank
    private String pwd;
    @NotBlank
    private String smsCode;
}
