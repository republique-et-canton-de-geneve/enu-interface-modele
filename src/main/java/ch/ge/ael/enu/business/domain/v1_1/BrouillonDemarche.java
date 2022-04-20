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
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.time.LocalDate;

@Data
@Jacksonized @SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class BrouillonDemarche extends MessageENU {
    @NotBlank
    public String idDemarcheSiMetier;

    @NotNull
    public URL urlAction;

    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    public LocalDate dateEcheanceAction;
}
