package ch.ge.ael.enu.business.domain.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

@Data
@Jacksonized @SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(doNotUseGetters = true)
public class ChangementPreference {
    @NotBlank
    public String identifiant;

    public PreferenceType preferenceType;

    public Boolean preferenceCourrierSMS;
    public Boolean preferenceCourrierEmail;

    public Boolean preferenceTacheSMS;
    public Boolean preferenceTacheEmail;

    public Boolean preferenceDemarcheSMS;
    public Boolean preferenceDemarcheEmail;

    public Boolean preferenceDepotDemarcheSMS;
    public Boolean preferenceDepotDemarcheEmail;
}
