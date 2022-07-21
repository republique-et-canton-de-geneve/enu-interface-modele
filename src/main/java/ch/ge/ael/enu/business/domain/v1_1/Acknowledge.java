package ch.ge.ael.enu.business.domain.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class Acknowledge {
    private String message = "OK";
}
