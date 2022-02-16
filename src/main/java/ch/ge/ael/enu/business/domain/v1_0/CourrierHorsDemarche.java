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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Donnees contenues dans un message JSON de creation d'un courrier, lie ou non a une demarche existante.
 */
@Data
@Jacksonized @SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class CourrierHorsDemarche extends MessageENU {

    @NotBlank
    @Size(max = 50)
    public String libelleCourrier;

    @NotEmpty
    @Size(max = 20)
    public List<CourrierDocument> documents;

    @Size(max = 64)
    public String idCourrier;

    public LocalDateTime dateEnvoi;

    /**
     * Champ cree par la mediation, ajoute' ici par simplicite.
     */
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    public String clef;

}
