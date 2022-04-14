package ch.ge.ael.enu.business.domain.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(doNotUseGetters = true)
public class DemandeListePreference {
    public String idPrestation;
}
