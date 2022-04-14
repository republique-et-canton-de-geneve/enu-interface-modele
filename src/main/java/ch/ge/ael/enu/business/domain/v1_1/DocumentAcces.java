package ch.ge.ael.enu.business.domain.v1_1;

import ch.ge.ael.enu.business.domain.serialization.IsoDateTimeDeserializer;
import ch.ge.ael.enu.business.domain.v1_0.MessageENU;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Jacksonized @SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class DocumentAcces extends MessageENU {

    @NotBlank
    @Size(max = 50)
    public String idDocumentSiMetier;

    @NotNull
    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    public LocalDateTime dateConsultation;
}
