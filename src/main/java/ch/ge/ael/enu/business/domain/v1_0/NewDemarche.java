/*
 * Espace numerique de l'usager - enu-interface-modele
 *
 * Copyright (C) 2021 Republique et canton de Geneve
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.ge.ael.enu.business.domain.v1_0;

import ch.ge.ael.enu.business.domain.serialization.IsoDateTimeDeserializer;
import ch.ge.ael.enu.business.domain.validation.NotNullIfAnotherFieldHasValue;
import ch.ge.ael.enu.business.domain.validation.NotNullIfAnotherFieldIsNotNull;
import ch.ge.ael.enu.business.domain.validation.NullIfAnotherFieldIsNull;
import ch.ge.ael.enu.business.domain.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ValidationException;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static ch.ge.ael.enu.business.domain.v1_0.DemarcheStatus.TERMINEE;

/**
 * Donnees contenues dans un message JSON de creation d'une nouvelle demarche.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
@NotNullIfAnotherFieldHasValue(
        message = "doit être présent si etat=DEPOSEE",
        fieldName = "etat",
        fieldValue = "DEPOSEE",
        dependFieldNames = {"libelleAction","dateDepot"})
@NotNullIfAnotherFieldHasValue(
        message = "doit être présent si etat=EN_TRAITEMENT",
        fieldName = "etat",
        fieldValue = "EN_TRAITEMENT",
        dependFieldNames = {"libelleAction","dateDepot"})
@NotNullIfAnotherFieldHasValue(
        message = "doit être présent si etat=BROUILLON",
        fieldName = "etat",
        fieldValue = "BROUILLON",
        dependFieldNames = {"libelleAction","urlAction","typeAction"})
@NullIfAnotherFieldIsNull(
        fieldName = "libelleAction",
        dependFieldNames = {"dateEcheanceAction"},
        message = "doit être null si libelleAction=null"
)
@NullIfAnotherFieldIsNull(
        fieldName = "urlAction",
        dependFieldNames = {"dateEcheanceAction"},
        message = "doit être null si urlAction=null"
)
@NotNullIfAnotherFieldIsNotNull(
        fieldName = "libelleAction",
        dependFieldNames = {"urlAction"},
        message = "doit être présent si libelleAction est présent"
)
@NotNullIfAnotherFieldIsNotNull(
        fieldName = "urlAction",
        dependFieldNames = {"dateEcheanceAction"},
        message = "doit être présent si urlAction est présent"
)
public class NewDemarche {

    @NotBlank
    @Size(max=50)
    private String idPrestation;

    @NotBlank
    @Size(max=50)
    private String idUsager;

    @NotBlank
    @Size(max=50)
    private String idDemarcheSiMetier;

    @NotBlank
    @ValueOfEnum(enumClass = DemarcheStatus.class)
    @Schema(allowableValues = {"BROUILLON","DEPOSEE","EN_TRAITEMENT","TERMINEE"})
    private String etat;

    @Size(max=250)
    private String libelleAction;

    @ValueOfEnum(enumClass = ActionType.class)
    @Schema(allowableValues = {"ENRICHISSEMENT_DE_DEMANDE","REPONSE_DEMANDE_RENSEIGNEMENT"})
    private String typeAction;

    private URL urlAction;

    @Future
    private LocalDate dateEcheanceAction;

    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    private LocalDateTime dateDepot;

    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    private LocalDateTime dateMiseEnTraitement;

    /* Validated automatically by JSR 303 */
    @JsonIgnore
    @AssertTrue
    public Boolean isValidated() {
        boolean result = true;
        if (DemarcheStatus.valueOf(etat) == TERMINEE) {
            log.warn("Erreur metier : on ne peut pas creer de demarche a l'etat {}", TERMINEE);
            throw new ValidationException("On ne peut pas creer de demarche directement a l'etat " + TERMINEE);
        }

        return result;
    }
}
