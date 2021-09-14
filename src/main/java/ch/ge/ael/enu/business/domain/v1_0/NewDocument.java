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

import ch.ge.ael.enu.business.domain.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ValidationException;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;

/**
 * Donnees contenues dans un message JSON d'ajout d'un document a une demarche existante.
 */
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewDocument {

    @Size(min = 1, max = 50)
    private String idPrestation = null;

    @NotBlank
    @Size(min = 1, max = 50)
    private String idUsager = null;

    @Size(min = 1, max = 50)
    private String idDemarcheSiMetier = null;

    @ValueOfEnum(enumClass = DocumentType.class)
    @Schema(allowableValues = {"JUSTIFICATIF", "RECAPITULATIF"})
    private DocumentType typeDocument = null;

    @NotBlank
    @Size(min = 1, max = 50)
    private String libelleDocument = null;

    @NotBlank
    @Size(min = 1, max = 50)
    private String idDocumentSiMetier = null;

    @NotBlank
    @Size(min = 1, max = 50)
    private String mime = null;

    private static final List<String> ALLOWED_TYPES = Collections.singletonList(
            "application/pdf"
    );

    @Size(min = 1, max = 200 * 1024 * 1024)
    private String contenu = null;

    private GedData ged = null;

    @JsonIgnore
    @AssertTrue
    boolean isValidated() {
        if (!ALLOWED_TYPES.contains(mime)) {
            log.warn("Erreur metier : type MIME [{}] pas pris en charge", mime);
            throw new ValidationException("La valeur \"" + mime
                    + "\" du champ \"mime\" n'est pas valide." +
                    " Les types MIME pris en charge sont : " + ALLOWED_TYPES);
        }
        return true;
    }
}
