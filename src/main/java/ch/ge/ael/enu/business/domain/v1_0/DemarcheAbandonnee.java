package ch.ge.ael.enu.business.domain.v1_0;

import ch.ge.ael.enu.business.domain.serialization.IsoDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.net.URL;
import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemarcheAbandonnee extends MessageENU implements Demarche {

    @NotBlank
    public String idDemarcheSiMetier;

    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    public LocalDateTime dateAbandon;

    public URL urlRenouvellement;
}
