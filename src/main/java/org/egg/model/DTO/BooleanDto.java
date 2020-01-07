package org.egg.model.DTO;

/**
 * @author dataochen
 * @Description 供形参传递Boolean
 * @date: 2018/12/11 15:59
 */
public class BooleanDto {

    public BooleanDto(Boolean value) {
        this.value = value;
    }

    private Boolean value;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
