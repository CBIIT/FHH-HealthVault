'use strict';
var globalXmlData = "<FamilyHistory moodCode=\"EVN\" classCode=\"OBS\"><id extention=\"gov.hhs.fhh:718163810183\"/><effectiveTime value=\"1/2/2015\"/><methodCode displayName=\"Surgeon General's Family Heath History Tool\"/><subject typeCode=\"SBJ\"><patient classCode=\"PAT\"><patientPerson><id extension=\"52a4747d-a295-44c6-891e-013d0dfa43cd\"/><name formatted=\"Lawrence Brem\"/><birthTime value=\"11/19/1968\"/><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2><clinicalObservation><code displayName=\"height\" codeSystemName=\"SNOMED_CT\" code=\"271603002\"/><value value=\"69\" unit=\"inches\"/></clinicalObservation><clinicalObservation><code displayName=\"weight\" codeSystemName=\"SNOMED_CT\" code=\"107647005\"/><value value=\"205\" unit=\"pound\"/></clinicalObservation><clinicalObservation><code displayName=\"Other Kidney Disease\" originalText=\"Other Kidney Disease\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"30\"/><high value=\"39\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectOf2><relative><code displayName=\"Mother\" codeSystemName=\"HL7 Family History Model\" code=\"NMTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"1e92eff2-86fa-4ac9-9b98-93eae628b863\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"44054006\" displayName=\"Type 2 Diabetes\" originalText=\"Type 2 Diabetes\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectOf2><id extension=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/><name formatted=\"Myrna Brem\"/><birthTime value=\"6/4/1938\"/></relationshipHolder></relative><relative><code displayName=\"Father\" codeSystemName=\"HL7 Family History Model\" code=\"NFTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"087290fc-0caa-4172-9c4b-6381915cf468\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"empty\" displayName=\"Other Cancer\" originalText=\"Other Cancer\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectOf2><id extension=\"19484bc3-6f74-4849-8193-8bc6badbf64f\"/><name formatted=\"Marshall Brem\"/><birthTime value=\"9/2/1936\"/></relationshipHolder></relative><relative><code displayName=\"Maternal Grandmother\" codeSystemName=\"HL7 Family History Model\" code=\"MGRMTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code displayName=\"Age at Death\" codeSystemName=\"LOINC\" code=\"39016-1\"/><value unit=\"year\"><low value=\"60\"/></value></deceasedEstimatedAge></subjectOf1><subjectOf2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"363349007\" displayName=\"Gastric Cancer\" originalText=\"Gastric Cancer\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code displayName=\"Gastric Cancer\" originalText=\"Gastric Cancer\" codeSystemName=\"SNOMED COMPLETE\"/><sourceOf><code displayName=\"death\" codeSystemName=\"SNOMED_CT\" code=\"419620001\"/></sourceOf></clinicalObservation></subjectOf2><id extension=\"1e92eff2-86fa-4ac9-9b98-93eae628b863\"/><name formatted=\"Jean Levetin\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code displayName=\"Maternal Grandfather\" codeSystemName=\"HL7 Family History Model\" code=\"MGRFTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code displayName=\"Age at Death\" codeSystemName=\"LOINC\" code=\"39016-1\"/><value unit=\"year\"><low value=\"60\"/></value></deceasedEstimatedAge></subjectOf1><subjectOf2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"22298006\" displayName=\"Heart Attack\" originalText=\"Heart Attack\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code displayName=\"Heart Attack\" originalText=\"Heart Attack\" codeSystemName=\"SNOMED COMPLETE\"/><sourceOf><code displayName=\"death\" codeSystemName=\"SNOMED_CT\" code=\"419620001\"/></sourceOf></clinicalObservation></subjectOf2><id extension=\"9657fdf7-aa1a-40a6-b844-8670bec72176\"/><name formatted=\"Samuel Levetin\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code displayName=\"Paternal Grandmother\" codeSystemName=\"HL7 Family History Model\" code=\"PGRMTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code displayName=\"Age at Death\" codeSystemName=\"LOINC\" code=\"39016-1\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></deceasedEstimatedAge></subjectOf1><subjectOf2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"93143009\" displayName=\"Leukemia\" originalText=\"Leukemia\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code displayName=\"Leukemia\" originalText=\"Leukemia\" codeSystemName=\"SNOMED COMPLETE\"/><sourceOf><code displayName=\"death\" codeSystemName=\"SNOMED_CT\" code=\"419620001\"/></sourceOf></clinicalObservation></subjectOf2><id extension=\"087290fc-0caa-4172-9c4b-6381915cf468\"/><name formatted=\"Sadie Brem\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code displayName=\"Paternal Grandfather\" codeSystemName=\"HL7 Family History Model\" code=\"PGRFTH\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder/></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code displayName=\"Age at Death\" codeSystemName=\"LOINC\" code=\"39016-1\"/><value unit=\"year\"><low value=\"60\"/></value></deceasedEstimatedAge></subjectOf1><subjectOf2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"422504002\" displayName=\"Stroke/Brain Attack\" originalText=\"Stroke/Brain Attack\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code displayName=\"Stroke/Brain Attack\" originalText=\"Stroke/Brain Attack\" codeSystemName=\"SNOMED COMPLETE\"/><sourceOf><code displayName=\"death\" codeSystemName=\"SNOMED_CT\" code=\"419620001\"/></sourceOf></clinicalObservation></subjectOf2><id extension=\"8627167f-d594-4674-bdd4-7a5e4954dff9\"/><name formatted=\"James Brem\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code displayName=\"Brother\" codeSystemName=\"HL7 Family History Model\" code=\"NBRO\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2/><id extension=\"bb977ba0-a00d-4cc3-9b4e-869ae2c05a69\"/><name formatted=\"Jeffrey Brem\"/><birthTime value=\"6/4/1960\"/></relationshipHolder></relative><relative><code displayName=\"Brother\" codeSystemName=\"HL7 Family History Model\" code=\"NBRO\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"87433001\" displayName=\"Emphysema\" originalText=\"Emphysema\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value/></dataEstimatedAge></subject></clinicalObservation></subjectOf2><id extension=\"8ee135d5-442a-4a6e-9ce5-d8737b3815dd\"/><name formatted=\"Steven Brem\"/><birthTime value=\"2/19/1963\"/></relationshipHolder></relative><relative><code displayName=\"Sister\" codeSystemName=\"HL7 Family History Model\" code=\"NSIS\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2/><id extension=\"c33e7cf2-3710-480b-98e2-ce0de49b2330\"/><name formatted=\"Pamela Brem\"/><birthTime value=\"3/13/1970\"/></relationshipHolder></relative><relative><code displayName=\"Daughter\" codeSystemName=\"HL7 Family History Model\" code=\"DAU\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"52a4747d-a295-44c6-891e-013d0dfa43cd\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2/><id extension=\"a60fc415-5ed2-476e-b63f-079507ad903e\"/><name formatted=\"Samantha Brem\"/><birthTime value=\"4/3/2002\"/></relationshipHolder></relative><relative><code displayName=\"Daughter\" codeSystemName=\"HL7 Family History Model\" code=\"DAU\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"52a4747d-a295-44c6-891e-013d0dfa43cd\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2/><id extension=\"25fc620c-10f3-464b-8553-e1d8e83a003e\"/><name formatted=\"Miriam Brem\"/><birthTime value=\"10/14/2004\"/></relationshipHolder></relative><relative><code displayName=\"Maternal Aunt\" codeSystemName=\"HL7 Family History Model\" code=\"MAUNT\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"1e92eff2-86fa-4ac9-9b98-93eae628b863\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2><clinicalObservation><code codeSystemName=\"SNOMED_CT\" code=\"22298006\" displayName=\"Heart Attack\" originalText=\"Heart Attack\"/><subject><dataEstimatedAge><code displayName=\"Estimated Age\" codeSystemName=\"LOINC\" code=\"21611-9\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectOf2><id extension=\"8c51fbcc-9546-4bd6-ab25-819d7f2ef084\"/><name formatted=\"Judy Goldman\"/></relationshipHolder></relative><relative><code displayName=\"Paternal Aunt\" codeSystemName=\"HL7 Family History Model\" code=\"PAUNT\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"087290fc-0caa-4172-9c4b-6381915cf468\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2/><id extension=\"fc046b5f-0b61-4014-8310-77bea8a00cb1\"/><name formatted=\"Phyllis Shepard\"/></relationshipHolder></relative><relative><code displayName=\"Maternal Cousin\" codeSystemName=\"HL7 Family History Model\" code=\"MCOUSN\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"8c51fbcc-9546-4bd6-ab25-819d7f2ef084\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"female\" code=\"248152002\"/><ethnicGroupCode displayName=\"Not Hispanic or Latino\" code=\"2186-5\" codeSystemName=\"HL7-TBD\" id=\"3\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2/><id extension=\"e3b3aa0a-1ff8-4da4-8f87-aa300d2798cc\"/><name formatted=\"Alysa Glazer\"/><birthTime value=\"9/26/1968\"/></relationshipHolder></relative><relative><code displayName=\"Nephew\" codeSystemName=\"HL7 Family History Model\" code=\"NEPHEW\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"c33e7cf2-3710-480b-98e2-ce0de49b2330\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Not Hispanic or Latino\" code=\"2186-5\" codeSystemName=\"HL7-TBD\" id=\"3\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2/><id extension=\"717738ab-d56b-4ff1-9d97-95fc2ef9794f\"/><name formatted=\"Aiden Pardoe\"/><birthTime value=\"2006\"/></relationshipHolder></relative><relative><code displayName=\"Nephew\" codeSystemName=\"HL7 Family History Model\" code=\"NEPHEW\"/><relationshipHolder><relative><code displayName=\"Parent\" codeSystemName=\"HL7 Family History Model\" code=\"PAR\"/><relationshipHolder><id extension=\"c33e7cf2-3710-480b-98e2-ce0de49b2330\"/></relationshipHolder></relative><administrativeGenderCode codeSystemName=\"SNOMED_CT\" displayName=\"male\" code=\"248153007\"/><ethnicGroupCode displayName=\"Ashkenazi Jewish\" code=\"81706006\" codeSystemName=\"SNOMED_CT\" id=\"2\"/><raceCode displayName=\"White\" code=\"2106-3\" codeSystemName=\"HL7\" id=\"5\"/><subjectOf2/><id extension=\"1a670818-1c8f-40d2-813c-2ca8eb348fa3\"/><name formatted=\"Samuel Pardoe\"/><birthTime value=\"2003\"/></relationshipHolder></relative></patientPerson></patient></subject></FamilyHistory>";
function getUrlParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}

var authToken = getUrlParameter('wctoken');
//alert(authToken);

$(document).ready(function(){
	$("#getDocument").click(function(){
		var jsonData = {"authToken" : authToken};
		
		$.ajax({
		    url        : "/FHH-REST/rest/hv/getFHHDocumentAjax",
		    contentType: 'application/json', 
		    data       : JSON.stringify(jsonData),
		    dataType   : 'xml',
		    type       : 'POST',
		    success: function (data) {
		    	globalXmlData = data;
		    	console.log(data);

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);


            }
		});
	});  
	
	$("#putDocument").click(function(){
		//var thingId = "1dddf8f7-cf32-4acc-b2e7-de85ef2d0ace";
		//var versionStamp = "f6182cc1-9ea1-45d1-8366-4f6bca3ab241";
		var xmlData = globalXmlData;
		
		//var jsonData = {"authToken" : authToken, "thingId" : thingId, "versionStamp" : versionStamp, "xmlData" : xmlData};
		var jsonData = {"authToken" : authToken, "xmlData" : xmlData};
		
		$.ajax({
		    url        : "/FHH-REST/rest/hv/putFHHDocumentAjax",
		    contentType: 'application/json', 
		    data       : JSON.stringify(jsonData),
		    dataType   : 'text',
		    type       : 'POST',
		    success: function (msg) {
                alert(msg);

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);


            }
		});
	}); 
	
	$("#getRecord").click(function(){
		var jsonData = {"authToken" : authToken};
		
		$.ajax({
		    url        : "/FHH-REST/rest/hv/getRecord",
		    contentType: 'application/json', 
		    data       : JSON.stringify(jsonData),
		    dataType   : 'text',
		    type       : 'POST',
		    success: function (data) {
		    	console.log("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                console.log(data);
                alert(data);

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);


            }
		});
	}); 	
});