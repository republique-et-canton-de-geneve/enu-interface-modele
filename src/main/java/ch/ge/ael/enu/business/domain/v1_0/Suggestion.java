package ch.ge.ael.enu.business.domain.v1_0;

import ch.ge.ael.enu.business.domain.serialization.IsoDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URL;
import java.time.LocalDate;

@Data
@Jacksonized @SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class Suggestion extends MessageENU {

    @NotBlank
    @Size(max = 25)
    public String libelleAction;

    @NotNull
    public URL urlAction;

    @Future
    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    public LocalDate dateEcheanceAction;

    @NotBlank
    @Size(max = 150)
    public String descriptionAction;

    @NotNull
    public URL urlPrestation;
}
