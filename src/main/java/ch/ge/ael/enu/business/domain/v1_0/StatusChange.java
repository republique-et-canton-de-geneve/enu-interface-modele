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

import ch.ge.ael.enu.business.domain.validation.NotNullIfAnotherFieldIsNotNull;
import ch.ge.ael.enu.business.domain.validation.NullIfAnotherFieldIsNull;
import ch.ge.ael.enu.business.domain.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.net.URL;
import java.time.LocalDate;

/**
 * Donnees contenues dans un message JSON de changement d'etat d'une demarche existante.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
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
public class StatusChange {

    @NotBlank
    @Size(min=1, max=50)
    private String idPrestation = null;

    @NotBlank
    @Size(min=1, max=50)
    private String idUsager = null;

    @NotBlank
    @Size(min=1, max=50)
    private String idDemarcheSiMetier = null;

    @NotNull
//    @ValueOfEnum(enumClass = DemarcheStatus.class)
//    @Schema(allowableValues = {"BROUILLON","DEPOSEE","EN_TRAITEMENT","TERMINEE"})
    private DemarcheStatus nouvelEtat = null;

    @NotNull
    @PastOrPresent
    private LocalDate dateNouvelEtat = null;

    @Size(max=250)
    private String libelleAction;

//    @ValueOfEnum(enumClass = ActionType.class)
//    @Schema(allowableValues = {"ENRICHISSEMENT_DE_DEMANDE","REPONSE_DEMANDE_RENSEIGNEMENT"})
    private ActionType typeAction;

    private URL urlAction;

    @Future
    private LocalDate dateEcheanceAction;

    private URL urlRenouvellementDemarche = null;

}
