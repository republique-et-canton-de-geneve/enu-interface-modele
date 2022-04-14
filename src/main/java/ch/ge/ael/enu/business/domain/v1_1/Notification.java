package ch.ge.ael.enu.business.domain.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Jacksonized @SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(doNotUseGetters = true)
public class Notification {
    @Size(max = 20)
    public String numeroSMS;

    @Email
    public String email;
}
