package gov.nih.nci.FHH.services;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.Marshaller;
import gov.nih.nci.FHH.RequestTemplate;
import gov.nih.nci.FHH.bean.BasicDemographicInfo;
import gov.nih.nci.FHH.bean.DataBean;
import gov.nih.nci.FHH.bean.FamilyHistory;
import gov.nih.nci.FHH.bean.PersonalDemographicInfo;
import gov.nih.nci.FHH.bean.FileInfo;
import gov.nih.nci.FHH.bean.HeightInfo;
import gov.nih.nci.FHH.bean.PersonInfo;
import gov.nih.nci.FHH.bean.RecordBean;
import gov.nih.nci.FHH.bean.SimplePersonBean;
import gov.nih.nci.FHH.bean.WeightInfo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.Request;


@Path("/hv")
public class HealthVaultServices {
	public static final String fileName = "PersonalHistory.xml";
	public static final String fileType = "bd0403c5-4ae2-4b0e-a8db-1888678e4528";
	public static final String PersonalDemographicType = "92ba621e-66b3-4a01-bd73-74844aed4f5b";

    private String demographicThingId = "";
    private String demographicVersionStamp = "";

	
	@POST
	//@Path("/{authToken}")
	//public Response getFHHDocument(@PathParam("authToken") String authToken) {
	@Path("/getFHHDocument")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/xml")
	public Response getFHHDocument(@FormParam("authToken") String encodedAuthToken) {		
 
		StringBuilder infoBuilder = new StringBuilder();
		List dataList = null;
		//String authToken = bean.getAuthToken();
		String authToken = encodedAuthToken;
		try {
			authToken = URLDecoder.decode(encodedAuthToken, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		infoBuilder.append("<info><group>");
		infoBuilder.append("<filter><type-id>bd0403c5-4ae2-4b0e-a8db-1888678e4528</type-id></filter>");
		infoBuilder.append("<format><section>core</section><section>otherdata</section><xml/></format>");
		infoBuilder.append("</group></info>");
		
		Request request = new Request();
		request.setMethodName("GetThings");
		request.setInfo(infoBuilder.toString());
		
		Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);
		
		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
		dataList = template.makeRequest(request, personInfo, new Marshaller<List>() {
			public List marshal(InputStream istream) throws Exception {
				InputSource isource = new InputSource(istream);
                XPath xpath = XPathFactory.newInstance().newXPath();
                String exp = "//thing";
                NodeList things = (NodeList)xpath.evaluate(exp,
                		isource,
                		XPathConstants.NODESET); 
                
                int count = Math.min(50, things.getLength());
                String id = "";
                String name = "";
                String xmlData = "";
                String versionStamp = "";
    	        for (int i=0; i<count; i++)
    	        {
    	            Node thing = things.item(i);
    	            name = xpath.evaluate("data-xml/file/name", thing);
    	            if(fileName.equals(name)) {
    	            	id = xpath.evaluate("thing-id", thing);
    	            	versionStamp = xpath.evaluate("thing-id/@version-stamp", thing);
    	            	xmlData = xpath.evaluate("data-other", thing);
        	            System.out.println(id);
        	            System.out.println(name);
        	            System.out.println(versionStamp);
        	            System.out.println(xmlData);
    	            	break;
    	            }
    	        }
    	        
    	        ArrayList data = new ArrayList();
    	        data.add(xmlData);
    	        
    	        return data;
			}
		});
		
        return Response.status(200).entity(dataList.get(0)).build();

	}
	
	@POST
	//@Path("/{authToken}")
	//public Response getFHHDocument(@PathParam("authToken") String authToken) {
	@Path("/putFHHDocument")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("text/plain")
	public Response putFHHDocument(@FormParam("authToken") String encodedAuthToken, @FormParam("xmlData") String xmlData, @FormParam("thingId") String thingId, @FormParam("versionStamp") String versionStamp) {		
		//String authToken = bean.getAuthToken();
		String authToken = encodedAuthToken;
		try {
			authToken = URLDecoder.decode(encodedAuthToken, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
        String fileSize = Integer.valueOf(xmlData.length()).toString();
        //String fileContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!--This file was produced by the Family Health Portrait tool at http://familyhistory.hhs.gov. You should not attempt to edit the file. Visit http://familyhistory.hhs.gov to upload the file for viewing and editing. The web site also can provide a viewable and printable chart and diagram of the family health history.--><FamilyHistory classCode=\"OBS\" moodCode=\"EVN\" xmlns=\"urn:hl7-org:v3\"><id extention=\"gov.hhs.fhh:718163810183\" /><effectiveTime value=\"2014/06/24\" /><methodCode displayName=\"Surgeon General's Family Health History Tool\" /><subject typeCode=\"SBJ\"><patient classCode=\"PAT\"><patientPerson><administrativeGenderCode code=\"248153007\" codeSystemName=\"SNOMED_CT\" displayName=\"male\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code displayName=\"Other Kidney Disease\" originalText=\"Other Kidney Disease\"/><subject><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"30\"/><high value=\"39\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code code=\"107647005\" codeSystemName=\"SNOMED_CT\" displayName=\"weight\"/><value value=\"205\" unit=\"pound\"/></clinicalObservation><clinicalObservation><code code=\"271603002\" codeSystemName=\"SNOMED_CT\" displayName=\"height\"/><value value=\"69\" unit=\"inches\"/></clinicalObservation></subjectOf2><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"1e92eff2-86fa-4ac9-9b98-93eae628b863\"/></relationshipHolder></relative><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"9657fdf7-aa1a-40a6-b844-8670bec72176\"/></relationshipHolder></relative><administrativeGenderCode code=\"248152002\" codeSystemName=\"SNOMED_CT\" displayName=\"female\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"44054006\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Type 2 Diabetes\" originalText=\"Type 2 Diabetes\"/><subject><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectOf2><id extention=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/><name formatted=\"Myrna Brem\"/><birthTime value=\"06/04/1938\"/></relationshipHolder></relative><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"087290fc-0caa-4172-9c4b-6381915cf468\"/></relationshipHolder></relative><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"8627167f-d594-4674-bdd4-7a5e4954dff9\"/></relationshipHolder></relative><administrativeGenderCode code=\"248153007\" codeSystemName=\"SNOMED_CT\" displayName=\"male\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code displayName=\"Other Cancer\" originalText=\"Other Cancer\"/><subject><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectOf2><id extention=\"19484bc3-6f74-4849-8193-8bc6badbf64f\"/><name formatted=\"Marshall Brem\"/><birthTime value=\"09/02/1936\"/></relationshipHolder></relative><relative><code code=\"MGRMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Maternal Grandmother\"/><relationshipHolder><administrativeGenderCode code=\"248152002\" codeSystemName=\"SNOMED_CT\" displayName=\"female\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code code=\"39016-1\" codeSystemName=\"LOINC\" displayName=\"Age at Death\"/><value unit=\"year\"><low value=\"60\"/></value></deceasedEstimatedAge></subjectOf1><subjectOf2><clinicalObservation><code code=\"363349007\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Gastric Cancer\" originalText=\"Gastric Cancer\"/><subject><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code code=\"363349007\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Gastric Cancer\" originalText=\"Gastric Cancer\"/><sourceOf><code code=\"419620001\" codeSystemName=\"SNOMED_CT\" displayName=\"death\"/></sourceOf></clinicalObservation></subjectOf2><id extention=\"1e92eff2-86fa-4ac9-9b98-93eae628b863\"/><name formatted=\"Jean Levetin\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code code=\"MGRFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Maternal Grandfather\"/><relationshipHolder><administrativeGenderCode code=\"248153007\" codeSystemName=\"SNOMED_CT\" displayName=\"male\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code code=\"39016-1\" codeSystemName=\"LOINC\" displayName=\"Age at Death\"/><value unit=\"year\"><low value=\"60\"/></value></deceasedEstimatedAge></subjectOf1><subjectOf2><clinicalObservation><code code=\"22298006\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Heart Attack\" originalText=\"Heart Attack\"/><subject><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code code=\"22298006\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Heart Attack\" originalText=\"Heart Attack\"/><sourceOf><code code=\"419620001\" codeSystemName=\"SNOMED_CT\" displayName=\"death\"/></sourceOf></clinicalObservation></subjectOf2><id extention=\"9657fdf7-aa1a-40a6-b844-8670bec72176\"/><name formatted=\"Samuel Levetin\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code code=\"PGRMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Paternal Grandmother\"/><relationshipHolder><administrativeGenderCode code=\"248152002\" codeSystemName=\"SNOMED_CT\" displayName=\"female\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code code=\"39016-1\" codeSystemName=\"LOINC\" displayName=\"Age at Death\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></deceasedEstimatedAge></subjectOf1><subjectOf2><clinicalObservation><code code=\"93143009\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Leukemia\" originalText=\"Leukemia\"/><subject><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code code=\"93143009\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Leukemia\" originalText=\"Leukemia\"/><sourceOf><code code=\"419620001\" codeSystemName=\"SNOMED_CT\" displayName=\"death\"/></sourceOf></clinicalObservation></subjectOf2><id extention=\"087290fc-0caa-4172-9c4b-6381915cf468\"/><name formatted=\"Sadie Brem\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code code=\"PGRFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Paternal Grandfather\"/><relationshipHolder><administrativeGenderCode code=\"248153007\" codeSystemName=\"SNOMED_CT\" displayName=\"male\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf1><deceasedEstimatedAge><code code=\"39016-1\" codeSystemName=\"LOINC\" displayName=\"Age at Death\"/><value unit=\"year\"><low value=\"60\"/></value></deceasedEstimatedAge></subjectOf1><subjectOf2><clinicalObservation><code code=\"422504002\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Stroke/Brain Attack\" originalText=\"Stroke/Brain Attack\"/><subject><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge></subject></clinicalObservation><clinicalObservation><code code=\"422504002\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Stroke/Brain Attack\" originalText=\"Stroke/Brain Attack\"/><sourceOf><code code=\"419620001\" codeSystemName=\"SNOMED_CT\" displayName=\"death\"/></sourceOf></clinicalObservation></subjectOf2><id extention=\"8627167f-d594-4674-bdd4-7a5e4954dff9\"/><name formatted=\"James Brem\"/><deceasedIndCode value=\"true\"/></relationshipHolder></relative><relative><code code=\"NBRO\" codeSystemName=\"HL7 Family History Model\" displayName=\"Brother\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/></relationshipHolder></relative><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"19484bc3-6f74-4849-8193-8bc6badbf64f\"/></relationshipHolder></relative><administrativeGenderCode code=\"248153007\" codeSystemName=\"SNOMED_CT\" displayName=\"male\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"bb977ba0-a00d-4cc3-9b4e-869ae2c05a69\"/><name formatted=\"Jeffrey Brem\"/><birthTime value=\"06/04/1960\"/></relationshipHolder></relative><relative><code code=\"NBRO\" codeSystemName=\"HL7 Family History Model\" displayName=\"Brother\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/></relationshipHolder></relative><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"19484bc3-6f74-4849-8193-8bc6badbf64f\"/></relationshipHolder></relative><administrativeGenderCode code=\"248153007\" codeSystemName=\"SNOMED_CT\" displayName=\"male\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"87433001 \" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Emphysema\" originalText=\"Emphysema\"/><subject><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"40\"/><high value=\"49\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectOf2><id extention=\"8ee135d5-442a-4a6e-9ce5-d8737b3815dd\"/><name formatted=\"Steven Brem\"/><birthTime value=\"02/19/1963\"/></relationshipHolder></relative><relative><code code=\"NSIS\" codeSystemName=\"HL7 Family History Model\" displayName=\"Sister\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"e4f65c30-3d8f-4990-b696-637285328d4f\"/></relationshipHolder></relative><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"19484bc3-6f74-4849-8193-8bc6badbf64f\"/></relationshipHolder></relative><administrativeGenderCode code=\"248152002\" codeSystemName=\"SNOMED_CT\" displayName=\"female\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"c33e7cf2-3710-480b-98e2-ce0de49b2330\"/><name formatted=\"Pamela Brem\"/><birthTime value=\"03/13/1970\"/></relationshipHolder></relative><relative><code code=\"DAU\" codeSystemName=\"HL7 Family History Model\" displayName=\"Daughter\"/><relationshipHolder><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2></relationshipHolder></relative><administrativeGenderCode code=\"248152002\" codeSystemName=\"SNOMED_CT\" displayName=\"female\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"a60fc415-5ed2-476e-b63f-079507ad903e\"/><name formatted=\"Samantha Brem\"/><birthTime value=\"04/03/2002\"/></relationshipHolder></relative><relative><code code=\"DAU\" codeSystemName=\"HL7 Family History Model\" displayName=\"Daughter\"/><relationshipHolder><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2></relationshipHolder></relative><administrativeGenderCode code=\"248152002\" codeSystemName=\"SNOMED_CT\" displayName=\"female\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"25fc620c-10f3-464b-8553-e1d8e83a003e\"/><name formatted=\"Miriam Brem\"/><birthTime value=\"10/14/2004\"/></relationshipHolder></relative><relative><code code=\"PAUNT\" codeSystemName=\"HL7 Family History Model\" displayName=\"Paternal Aunt\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"087290fc-0caa-4172-9c4b-6381915cf468\"/></relationshipHolder></relative><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"8627167f-d594-4674-bdd4-7a5e4954dff9\"/></relationshipHolder></relative><administrativeGenderCode code=\"248152002\" codeSystemName=\"SNOMED_CT\" displayName=\"female\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge><id extention=\"fc046b5f-0b61-4014-8310-77bea8a00cb1\"/><name formatted=\"Phyllis Shepard\"/></relationshipHolder></relative><relative><code code=\"MAUNT\" codeSystemName=\"HL7 Family History Model\" displayName=\"Maternal Aunt\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"1e92eff2-86fa-4ac9-9b98-93eae628b863\"/></relationshipHolder></relative><relative><code code=\"NFTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Father\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"9657fdf7-aa1a-40a6-b844-8670bec72176\"/></relationshipHolder></relative><administrativeGenderCode code=\"248152002\" codeSystemName=\"SNOMED_CT\" displayName=\"female\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"22298006\" codeSystemName=\"SNOMED COMPLETE\" displayName=\"Heart Attack\" originalText=\"Heart Attack\"/><subject><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"50\"/><high value=\"59\"/></value></dataEstimatedAge></subject></clinicalObservation></subjectOf2><dataEstimatedAge><code code=\"21611-9\" codeSystemName=\"LOINC\" displayName=\"Estimated Age\"/><value unit=\"year\"><low value=\"60\"/></value></dataEstimatedAge><id extention=\"8c51fbcc-9546-4bd6-ab25-819d7f2ef084\"/><name formatted=\"Judy Goldman\"/></relationshipHolder></relative><relative><code code=\"MCOUSN\" codeSystemName=\"HL7 Family History Model\" displayName=\"Maternal Cousin\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"8c51fbcc-9546-4bd6-ab25-819d7f2ef084\"/></relationshipHolder></relative><administrativeGenderCode code=\"248152002\" codeSystemName=\"SNOMED_CT\" displayName=\"female\"/><ethnicGroupCode code=\"2186-5\" codeSystemName=\"HL7-TBD\" displayName=\"Not Hispanic or Latino\" id=\"3\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"e3b3aa0a-1ff8-4da4-8f87-aa300d2798cc\"/><name formatted=\"Alysa Glazer\"/><birthTime value=\"09/26/1968\"/></relationshipHolder></relative><relative><code code=\"NEPHEW\" codeSystemName=\"HL7 Family History Model\" displayName=\"Nephew\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"c33e7cf2-3710-480b-98e2-ce0de49b2330\"/></relationshipHolder></relative><administrativeGenderCode code=\"248153007\" codeSystemName=\"SNOMED_CT\" displayName=\"male\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><ethnicGroupCode code=\"2186-5\" codeSystemName=\"HL7-TBD\" displayName=\"Not Hispanic or Latino\" id=\"3\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"1a670818-1c8f-40d2-813c-2ca8eb348fa3\"/><name formatted=\"Samuel Pardoe\"/><birthTime value=\"2003\"/></relationshipHolder></relative><relative><code code=\"NEPHEW\" codeSystemName=\"HL7 Family History Model\" displayName=\"Nephew\"/><relationshipHolder><relative><code code=\"NMTH\" codeSystemName=\"HL7 Family History Model\" displayName=\"Mother\"/><relationshipHolder><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"c33e7cf2-3710-480b-98e2-ce0de49b2330\"/></relationshipHolder></relative><administrativeGenderCode code=\"248153007\" codeSystemName=\"SNOMED_CT\" displayName=\"male\"/><ethnicGroupCode code=\"81706006\" codeSystemName=\"SNOMED_CT\" displayName=\"Ashkenazi Jewish\" id=\"2\"/><ethnicGroupCode code=\"2186-5\" codeSystemName=\"HL7-TBD\" displayName=\"Not Hispanic or Latino\" id=\"3\"/><raceCode code=\"2106-3\" codeSystemName=\"HL7\" displayName=\"White\" id=\"5\"/><subjectOf2><clinicalObservation><code code=\"160245001\" codeSystemName=\"SNOMED_CT\" displayName=\"No current problems or disability\"/></clinicalObservation></subjectOf2><id extention=\"717738ab-d56b-4ff1-9d97-95fc2ef9794f\"/><name formatted=\"Aiden Pardoe\"/><birthTime value=\"2006\"/></relationshipHolder></relative><id extention=\"c63f7ede-18e3-4627-9662-f6a9ac8b28fd\"/><name formatted=\"Thiagarajan Prakash\"/><birthTime value=\"05/28/1968\"/></patientPerson></patient></subject></FamilyHistory>";
        //String fileContent="TEST";
        //byte[] encodedContent =  Base64.encodeBase64(xmlData.getBytes());

        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append("<info><thing>");
        if(thingId != null && !thingId.equals("")) {
        	infoBuilder.append("<thing-id version-stamp=\"");
        	infoBuilder.append(versionStamp + "\">");
        	infoBuilder.append(thingId);
        	infoBuilder.append("</thing-id>");
        }
        infoBuilder.append("<type-id>");
        infoBuilder.append(fileType);
        infoBuilder.append("</type-id><thing-state>Active</thing-state><data-xml><file><name>");
        infoBuilder.append(fileName);
        infoBuilder.append("</name><size>");
        infoBuilder.append(fileSize);
        infoBuilder.append("</size></file></data-xml>");
        infoBuilder.append("<data-other content-type='xml'><![CDATA[");
        infoBuilder.append(xmlData);
        infoBuilder.append("]]></data-other></thing></info>");
        
        //System.out.println("***********************");
        System.out.println(infoBuilder.toString());
        //System.out.println("encodedBytes " + new String(encodedContent));
        
		Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);
        
        Request request = new Request();
		request.setMethodName("PutThings");
		request.setInfo(infoBuilder.toString());
		
		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
		Integer retValue = template.makeRequest(request, personInfo);
		
		System.out.println(retValue);

		return Response.status(200).entity("success").build();

	}	
	
	@POST
	//@Path("/{authToken}")
	//public Response getFHHDocument(@PathParam("authToken") String authToken) {
	@Path("/getFHHDocumentAjax")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Response getFHHDocumentAjax(DataBean dataBean) {		
 
		String authToken = "";
		try {
			authToken = URLDecoder.decode(dataBean.getAuthToken(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("**********");
		System.out.println(authToken);
		
		FileInfo fileInfo = new FileInfo();
		List dataList = fileInfo.pullData(authToken);
		
        return Response.status(200).entity(dataList.get(0)).build();

	}
	
	@POST
	@Path("/putFHHDocumentAjax")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public Response putFHHDocumentAjax(DataBean dataBean) {	
		//String authToken = bean.getAuthToken();
		String encodedAuthToken = dataBean.getAuthToken();
		String xmlData = dataBean.getXmlData();
		String thingId = dataBean.getThingId();
		String versionStamp = dataBean.getVersionStamp();
		String authToken = "";
		
		System.out.println(xmlData);
		
		try {
			authToken = URLDecoder.decode(encodedAuthToken, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		PersonalDemographicInfo personalDemographicInfo = new PersonalDemographicInfo();
		personalDemographicInfo.pushData(authToken, dataBean);
		
		BasicDemographicInfo basicDemographicInfo = new BasicDemographicInfo();
		basicDemographicInfo.pushData(authToken, dataBean);
		
		WeightInfo weightInfo = new WeightInfo();
		weightInfo.pushData(authToken, dataBean);
		
		HeightInfo heightInfo = new HeightInfo();
		heightInfo.pushData(authToken, dataBean);
		
		FamilyHistory familyHistory = new FamilyHistory();
		familyHistory.pushData(authToken, dataBean);
		
//		FileInfo fileInfo = new FileInfo();
//		fileInfo.pushData(authToken, dataBean);

		return Response.status(200).entity("success").build();

	}	
	
	@POST
	//@Path("/{authToken}")
	//public Response getFHHDocument(@PathParam("authToken") String authToken) {
	@Path("/getRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRecord(DataBean dataBean) {		
 
		String authToken = "";
		try {
			authToken = URLDecoder.decode(dataBean.getAuthToken(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		RecordBean recordBean = new RecordBean();
		String recordData = recordBean.pullData(authToken);
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
//        DocumentBuilder builder;  
//        try{
//        	builder = factory.newDocumentBuilder();
//        	Document doc = builder.parse(new InputSource(new StringReader(recordData)));
//        	SimplePersonBean pBean = new SimplePersonBean();
//    		pBean.parseXml(doc);
//        }catch(Exception e){
//        	e.printStackTrace();
//        }
		
		JSONObject xmlJsonObj = XML.toJSONObject(recordData);
		String jsonString = xmlJsonObj.toString(4);
		SimplePersonBean pBean = new SimplePersonBean();
		Map<String, Object> person = pBean.parseJson(xmlJsonObj);
//		HashMap<String, Object> result = null;
//		try {
//			result = new ObjectMapper().readValue(jsonString, HashMap.class);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		pBean.transferToSimpleBean(result);
		System.out.println("Json String "+jsonString);
		System.out.println(person);
        return Response.status(200).entity(person).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS").header("Access-Control-Allow-Headers", "Content-Type, Content-Range, Content-Disposition, Content-Description").build();

	}	
	
}
