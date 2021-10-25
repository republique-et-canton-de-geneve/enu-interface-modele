package ch.ge.ael.enu.business.domain.v1_0;

import ch.ge.ael.enu.business.domain.serialization.IsoDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentAcces extends MessageENU {

    @NotBlank
    @Size(max = 50)
    public String idDocumentSiMetier;

    @NotNull
    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    public LocalDateTime dateConsultation;
}
