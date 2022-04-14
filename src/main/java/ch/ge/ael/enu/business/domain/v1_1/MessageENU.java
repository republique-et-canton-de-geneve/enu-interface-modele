package ch.ge.ael.enu.business.domain.v1_1;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Data
@SuperBuilder
@ToString(doNotUseGetters = true)
public abstract class MessageENU {

    @NotBlank
    public String idPrestation;

    @NotBlank
    public String identifiant;

}
