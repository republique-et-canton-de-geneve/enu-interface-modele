package ch.ge.ael.enu.business.domain.v1_1;

import ch.ge.ael.enu.business.domain.serialization.IsoDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import java.net.URL;
import java.time.LocalDateTime;

@Data
@Jacksonized @SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class DemarcheAbandonnee extends MessageENU implements Demarche {

    @NotBlank
    public String idDemarcheSiMetier;

    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    public LocalDateTime dateAbandon;

    public URL urlRenouvellement;
}
