package ch.ge.ael.enu.business.domain.v1_0;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModeReceptionDocuments {
    @NotBlank
    public String idUsager;

    @NotNull
    public ReceptionChoix choixReception;
}
