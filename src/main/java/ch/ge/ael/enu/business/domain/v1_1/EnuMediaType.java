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
package ch.ge.ael.enu.business.domain.v1_1;

import ch.ge.ael.enu.business.domain.Version;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.HashMap;

public class EnuMediaType {

    public static final String VERSION = Version.V1_1;

    public static final String BROUILLON_ABANDON = "application/brouillon-abandon-v"+VERSION+"+json";
    public static final String BROUILLON_DEMARCHE = "application/brouillon-de-demarche-v"+VERSION+"+json";
    public static final String COURRIER = "application/courrier-v"+VERSION+"+json";
    public static final String COURRIER_HORS_DEMARCHE = "application/courrier-hors-demarche-v"+VERSION+"+json";
    public static final String DEMARCHE_ABANDONNEE = "application/demarche-abandonnee-v"+VERSION+"+json";
    public static final String DEMARCHE_ACTION_REQUISE = "application/demarche-action-requise-v"+VERSION+"+json";
    public static final String DEMARCHE_DEPOSEE = "application/demarche-deposee-v"+VERSION+"+json";
    public static final String DEMARCHE_EN_TRAITEMENT = "application/demarche-en-traitement-v"+VERSION+"+json";
    public static final String DEMARCHE_TERMINEE = "application/demarche-terminee-v"+VERSION+"+json";
    public static final String DOCUMENT_ACCES = "application/document-acces-v"+VERSION+"+json";
    public static final String DOCUMENT = "application/document-v"+VERSION+"+json";
    public static final String DOCUMENT_RECEPTION_MODE = "application/document-reception-mode-v"+VERSION+"+json";
    public static final String SEQUENCE_MESSAGES = "application/sequence-enu-v"+VERSION+"+json";
    public static final String SUGGESTION_ABANDON = "application/suggestion-abandon-v"+VERSION+"+json";
    public static final String SUGGESTION = "application/suggestion-v"+VERSION+"+json";
    public static final String HEALTH_CHECK = "application/health-check-v"+VERSION+"+json";
    public static final String CHANGEMENT_PREFERENCE = "application/changement-preference-v"+VERSION+"+json";
    public static final String LISTE_PREFERENCE = "application/liste-preference-v"+VERSION+"+json";
    public static final String DEMANDE_LISTE_PREFERENCE = "application/demande-liste-preference-v"+VERSION+"+json";

    public static final HashMap<String, TypeReference<?>> typeReferenceMap = new HashMap<String, TypeReference<?>>() {{
        put(BROUILLON_ABANDON, new TypeReference<BrouillonAbandon>(){});
        put(BROUILLON_DEMARCHE, new TypeReference<BrouillonDemarche>(){});
        put(COURRIER, new TypeReference<Courrier>(){});
        put(COURRIER_HORS_DEMARCHE, new TypeReference<CourrierHorsDemarche>(){});
        put(DEMARCHE_ABANDONNEE, new TypeReference<DemarcheAbandonnee>(){});
        put(DEMARCHE_ACTION_REQUISE, new TypeReference<DemarcheActionRequise>(){});
        put(DEMARCHE_DEPOSEE, new TypeReference<DemarcheDeposee>(){});
        put(DEMARCHE_EN_TRAITEMENT, new TypeReference<DemarcheEnTraitement>(){});
        put(DEMARCHE_TERMINEE, new TypeReference<DemarcheTerminee>(){});
        put(DOCUMENT_ACCES, new TypeReference<DocumentAcces>(){});
        put(DOCUMENT, new TypeReference<DocumentUsager>(){});
        put(DOCUMENT_RECEPTION_MODE, new TypeReference<ModeReceptionDocuments>(){});
        put(SEQUENCE_MESSAGES, new TypeReference<SequenceMessages>(){});
        put(SUGGESTION_ABANDON, new TypeReference<SuggestionAbandon>(){});
        put(SUGGESTION, new TypeReference<Suggestion>(){});
        put(HEALTH_CHECK, new TypeReference<HealthCheck>(){});
        put(CHANGEMENT_PREFERENCE, new TypeReference<ChangementPreference>() {});
        put(LISTE_PREFERENCE, new TypeReference<PreferenceListe>() {});
        put(DEMANDE_LISTE_PREFERENCE, new TypeReference<DemandeListePreference>() {});
    }};

    private EnuMediaType() {
    }
}
