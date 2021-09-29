package ch.ge.ael.enu.business.domain.v1_0;

import ch.ge.ael.enu.business.domain.serialization.IsoDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemarcheActionRequise extends MessageENU {

    @NotBlank
    public String idDemarcheSiMetier;

    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    public LocalDateTime dateActionRequise;

    @NotBlank
    @Size(max = 250)
    public String libelleAction;

    @NotNull
    public URL urlAction;

    public ActionType typeAction;

    @Future
    public LocalDate dateEcheanceAction;
}
