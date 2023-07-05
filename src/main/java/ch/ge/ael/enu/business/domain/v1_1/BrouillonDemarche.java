package ch.ge.ael.enu.business.domain.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Jacksonized @SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class BrouillonDemarche extends MessageENU implements MesActions, Demarche {
    @NotBlank
    public String idDemarcheSiMetier;

    @NotNull
    public URL urlAction;

    public LocalDate dateEcheanceAction;

    public LocalDateTime dateDepot = LocalDateTime.now();
}
