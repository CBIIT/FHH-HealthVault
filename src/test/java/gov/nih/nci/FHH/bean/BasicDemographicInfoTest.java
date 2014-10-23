
import gov.nih.nci.FHH.bean.BasicDemographicInfo;
import gov.nih.nci.FHH.bean.DataBean;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicDemographicInfoTest {
	BasicDemographicInfo basicDemographicInfo = null;
	DataBean dataBean = null;
	
	@Before
    public void setUp() {
		basicDemographicInfo = new BasicDemographicInfo();
		dataBean = new DataBean();
		
		dataBean.setXmlData("<FamilyHistory moodCode=\"EVN\" classCode=\"OBS\"><id extention=\"gov.hhs.fhh:718163810183\"/><effectiveTime value=\"10/15/2014\"/><methodCode displayName=\"Surgeon General's Family Heath History Tool\"/><subject typeCode=\"SBJ\"><patient classCode=\"PAT\"><patientPerson><id extension=\"c63f7ede-18e3-4627-9662-f6a9ac8b28fd\"/><name formatted=\"Thiagarajan Prakash\"/><birthTime value=\"05/28/1986\"/><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"Asian\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2><clinicalObservation><code displayName=\"height\" codeSystemName=\"SNOMED_CT\" code=\"271603002\"/><value value=\"69\" unit=\"inches\"/></clinicalObservation><clinicalObservation><code displayName=\"weight\" codeSystemName=\"SNOMED_CT\" code=\"107647005\"/><value value=\"205\" unit=\"pound\"/></clinicalObservation><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"OTKIDDIS\" displayName=\"Other Kidney Disease\" originalText=\"Other Kidney Disease\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"30\"/><high value=\"39\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectof2><relative><code displayName=\"Mother\" codeSystemName=\"HL7 Family History Model\" code=\"NMTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"1e92eff2-86fa-4ac9-9b98-93eae628b863\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"44054006\" displayName=\"Type 2 Diabetes\" originalText=\"Type 2 Diabetes\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectof2><id extension=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/><name formatted=\"Myrna Brem\"/><birthTime value=\"06/04/1938\"/></relationshipHolder></relative><relative><code displayName=\"Father\" codeSystemName=\"HL7 Family History Model\" code=\"NFTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"087290fc-0caa-4172-9c4b-6381915cf468\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"OTCANCER\" displayName=\"Other Cancer\" originalText=\"Other Cancer\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectof2><id extension=\"19484bc3-6f74-4849-8193-8bc6badbf64f\"/><name formatted=\"Marshall Brem\"/><birthTime value=\"09/02/1936\"/></relationshipHolder></relative><relative><code displayName=\"Maternal Grandmother\" codeSystemName=\"HL7 Family History Model\" code=\"MGRMTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code displayName=\"Age at Death\" codeSystemName=\"LOINC\" code=\"39016-1\"/><value unit=\"year\"><low value=\"60\"/></value></deceasedEstimatedAge></subjectOf1><subjectof2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"363349007\" displayName=\"Gastric Cancer\" originalText=\"Gastric Cancer\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code displayName=\"Gastric Cancer\" originalText=\"Gastric Cancer\" codeSystemName=\"SNOMED COMPLETE\"/><sourceOf><code displayName=\"death\" codeSystemName=\"SNOMED_CT\" code=\"419620001\"/></sourceOf></clinicalObservation></subjectof2><id extension=\"1e92eff2-86fa-4ac9-9b98-93eae628b863\"/><name formatted=\"Jean Levetin\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code displayName=\"Maternal Grandfather\" codeSystemName=\"HL7 Family History Model\" code=\"MGRFTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code displayName=\"Age at Death\" codeSystemName=\"LOINC\" code=\"39016-1\"/><value unit=\"year\"><low value=\"60\"/></value></deceasedEstimatedAge></subjectOf1><subjectof2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"22298006\" displayName=\"Heart Attack\" originalText=\"Heart Attack\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code displayName=\"Heart Attack\" originalText=\"Heart Attack\" codeSystemName=\"SNOMED COMPLETE\"/><sourceOf><code displayName=\"death\" codeSystemName=\"SNOMED_CT\" code=\"419620001\"/></sourceOf></clinicalObservation></subjectof2><id extension=\"9657fdf7-aa1a-40a6-b844-8670bec72176\"/><name formatted=\"Samuel Levetin\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code displayName=\"Paternal Grandmother\" codeSystemName=\"HL7 Family History Model\" code=\"PGRMTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code displayName=\"Age at Death\" codeSystemName=\"LOINC\" code=\"39016-1\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></deceasedEstimatedAge></subjectOf1><subjectof2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"93143009\" displayName=\"Leukemia\" originalText=\"Leukemia\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code displayName=\"Leukemia\" originalText=\"Leukemia\" codeSystemName=\"SNOMED COMPLETE\"/><sourceOf><code displayName=\"death\" codeSystemName=\"SNOMED_CT\" code=\"419620001\"/></sourceOf></clinicalObservation></subjectof2><id extension=\"087290fc-0caa-4172-9c4b-6381915cf468\"/><name formatted=\"Sadie Brem\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code displayName=\"Paternal Grandfather\" codeSystemName=\"HL7 Family History Model\" code=\"PGRFTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code displayName=\"Age at Death\" codeSystemName=\"LOINC\" code=\"39016-1\"/><value unit=\"year\"><low value=\"60\"/></value></deceasedEstimatedAge></subjectOf1><subjectof2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"422504002\" displayName=\"Stroke/Brain Attack\" originalText=\"Stroke/Brain Attack\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code displayName=\"Stroke/Brain Attack\" originalText=\"Stroke/Brain Attack\" codeSystemName=\"SNOMED COMPLETE\"/><sourceOf><code displayName=\"death\" codeSystemName=\"SNOMED_CT\" code=\"419620001\"/></sourceOf></clinicalObservation></subjectof2><id extension=\"8627167f-d594-4674-bdd4-7a5e4954dff9\"/><name formatted=\"James Brem\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code displayName=\"Brother\" codeSystemName=\"HL7 Family History Model\" code=\"NBRO\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2/><id extension=\"bb977ba0-a00d-4cc3-9b4e-869ae2c05a69\"/><name formatted=\"Jeffrey Brem\"/><birthTime value=\"06/04/1960\"/></relationshipHolder></relative><relative><code displayName=\"Brother\" codeSystemName=\"HL7 Family History Model\" code=\"NBRO\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"87433001\" displayName=\"Emphysema\" originalText=\"Emphysema\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"40\"/><high value=\"49\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectof2><id extension=\"8ee135d5-442a-4a6e-9ce5-d8737b3815dd\"/><name formatted=\"Steven Brem\"/><birthTime value=\"02/19/1963\"/></relationshipHolder></relative><relative><code displayName=\"Sister\" codeSystemName=\"HL7 Family History Model\" code=\"NSIS\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2/><id extension=\"c33e7cf2-3710-480b-98e2-ce0de49b2330\"/><name formatted=\"Pamela Brem\"/><birthTime value=\"03/13/1970\"/></relationshipHolder></relative><relative><code displayName=\"Daughter\" codeSystemName=\"HL7 Family History Model\" code=\"DAU\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2/><id extension=\"a60fc415-5ed2-476e-b63f-079507ad903e\"/><name formatted=\"Samantha Brem\"/><birthTime value=\"04/03/2002\"/></relationshipHolder></relative><relative><code displayName=\"Daughter\" codeSystemName=\"HL7 Family History Model\" code=\"DAU\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2/><id extension=\"25fc620c-10f3-464b-8553-e1d8e83a003e\"/><name formatted=\"Miriam Brem\"/><birthTime value=\"10/14/2004\"/></relationshipHolder></relative><relative><code displayName=\"Maternal Aunt\" codeSystemName=\"HL7 Family History Model\" code=\"MAUNT\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"1e92eff2-86fa-4ac9-9b98-93eae628b863\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"22298006\" displayName=\"Heart Attack\" originalText=\"Heart Attack\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectof2><id extension=\"8c51fbcc-9546-4bd6-ab25-819d7f2ef084\"/><name formatted=\"Judy Goldman\"/><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></relationshipHolder></relative><relative><code displayName=\"Paternal Aunt\" codeSystemName=\"HL7 Family History Model\" code=\"PAUNT\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"087290fc-0caa-4172-9c4b-6381915cf468\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2/><id extension=\"fc046b5f-0b61-4014-8310-77bea8a00cb1\"/><name formatted=\"Phyllis Shepard\"/><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></relationshipHolder></relative><relative><code displayName=\"Maternal Cousin\" codeSystemName=\"HL7 Family History Model\" code=\"MCOUSN\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"8c51fbcc-9546-4bd6-ab25-819d7f2ef084\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Not Hispanic or Latino\" code=\"2186-5\" codeSystemName=\"HL7-TBD\" id=\"3\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2/><id extension=\"e3b3aa0a-1ff8-4da4-8f87-aa300d2798cc\"/><name formatted=\"Alysa Glazer\"/><birthTime value=\"09/26/1968\"/></relationshipHolder></relative><relative><code displayName=\"Nephew\" codeSystemName=\"HL7 Family History Model\" code=\"NEPHEW\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"c33e7cf2-3710-480b-98e2-ce0de49b2330\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><ethnicGroupCode displayName=\"Not Hispanic or Latino\" code=\"2186-5\" codeSystemName=\"HL7-TBD\" id=\"3\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2/><id extension=\"1a670818-1c8f-40d2-813c-2ca8eb348fa3\"/><name formatted=\"Samuel Pardoe\"/><birthTime value=\"2003\"/></relationshipHolder></relative><relative><code displayName=\"Nephew\" codeSystemName=\"HL7 Family History Model\" code=\"NEPHEW\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"c33e7cf2-3710-480b-98e2-ce0de49b2330\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><ethnicGroupCode displayName=\"Not Hispanic or Latino\" code=\"2186-5\" codeSystemName=\"HL7-TBD\" id=\"3\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectof2/><id extension=\"717738ab-d56b-4ff1-9d97-95fc2ef9794f\"/><name formatted=\"Aiden Pardoe\"/><birthTime value=\"2006\"/></relationshipHolder></relative></patientPerson></patient></subject></FamilyHistory>");
		dataBean.setThingId("53afadb9-8eda-4517-845d-be99e163d8da");
		dataBean.setVersionStamp("d84898fe-6737-49cc-8750-e22d4c6457a1");
		
		basicDemographicInfo.setGender("male");
    }

    
    @Test
    public void testGetGender() {
        Assert.assertEquals("m", basicDemographicInfo.getGender() );
    }
    

}
