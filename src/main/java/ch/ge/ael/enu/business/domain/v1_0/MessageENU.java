package ch.ge.ael.enu.business.domain.v1_0;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Data
@SuperBuilder
public abstract class MessageENU {

    @NotBlank
    public String idPrestation;

    @NotBlank
    public String idUsager;

}
