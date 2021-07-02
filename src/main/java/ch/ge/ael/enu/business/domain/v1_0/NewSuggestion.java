/*
 * Espace numerique de l'usager - enu-mediation
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.net.URL;
import java.time.LocalDate;

/**
 * Donnees contenues dans un message JSON de creation d'une nouvelle suggestion de demarche.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewSuggestion {

    @NotBlank
    @Size(min=1, max=50)
    private String idPrestation = null;

    @NotBlank
    @Size(min=1, max=50)
    private String idUsager = null;

    /** Texte du bouton. */
    @NotBlank
    @Size(min=1, max=25)
    private String libelleAction = null;

    /** URL du bouton. */
    @NotBlank
    @Size(min=1, max=256)
    private URL urlAction = null;

    @NotBlank
    @Future
    private LocalDate dateEcheanceAction = null;

    /** Description complete de l'action. */
    @NotBlank
    @Size(min=1, max=150)
    private String descriptionAction = null;

    /** URL du livret de la prestation. */
    @NotBlank
    @Size(min=1, max=256)
    private URL urlPrestation = null;

}
