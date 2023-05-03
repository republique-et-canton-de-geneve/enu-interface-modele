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
package ch.ge.ael.enu.business.domain.v1_1;

import ch.ge.ael.enu.business.domain.validation.ValidDocumentUsager;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Donnees contenues dans un message JSON d'ajout d'un document a une demarche existante.
 */
@Data
@Jacksonized @SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true, doNotUseGetters = true)
@ValidDocumentUsager
public class DocumentUsager extends MessageENU implements MesDocuments {

    @NotBlank
    public String idDemarcheSiMetier;

    @NotNull
    public DocumentType typeDocument;

    @Size(max = 250)
    public String libelleDocument;

    @Size(max = 50)
    public String idDocumentSiMetier;

    @NotBlank
    @Size(max = 50)
    public String mime;

    @EqualsAndHashCode.Exclude
    public LocalDateTime dateEnvoi;

    @EqualsAndHashCode.Exclude
    public List<Notification> notifications;

    @NotNull
    public GedData ged;
}
