package ch.ge.ael.enu.business.domain.v1_0;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

@Data
@Jacksonized @SuperBuilder
public abstract class MessageENU {

    @NotBlank
    public String idPrestation;

    @NotBlank
    public String idUsager;

}
