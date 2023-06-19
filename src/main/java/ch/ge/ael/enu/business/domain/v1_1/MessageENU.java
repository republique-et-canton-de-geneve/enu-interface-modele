package ch.ge.ael.enu.business.domain.v1_1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@SuperBuilder
@ToString(doNotUseGetters = true)
@AllArgsConstructor
public abstract class MessageENU implements Serializable {

    @NotBlank
    public String idPrestation;

    @NotBlank
    public String identifiant;

}
