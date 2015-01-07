package gov.nih.nci.FHH.bean;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.Marshaller;
import gov.nih.nci.FHH.RequestTemplate;
import gov.nih.nci.FHH.util.XmlDocument;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.Request;

public class FamilyHistory implements Serializable, thing{

	public static final String familyHistoryType = "4a04fcc8-19c1-4d59-a8c7-2031a03f21de";
	private String id = "";
	private String versionStamp = "";
	
	private String relation = "";	
	
	private String birthYear = "";
	private String birthMonth = "";
	private String birthDay = "";
	private String birthDate = "";
	private String fullName = "";
	private String firstName = "";
	private String lastName = "";
	private String gender ="";
	private String typeId = "";
	private String condition = "";
	private String genderCode = "";
	private String genderCodeSystemName = "";
	private String race = "";
	private String raceCode = "";
	private String raceCodeSystemName = "";
	private String ethnicity = "";
	private String ethnicityCode = "";
	private String ethnicitySystemName = "";
	private String genderValue = "";
	private String conditionCode = "";
	private String conditionCodeSystemName = "";
	private String resolution = "";
	private String deathCondition = "";
	private String deathConditionCode = "";
	private String deathConditionSystemName = "";
	private String selfGender = "";
	private String selfGenderValue = "";
	private String selfRace = "";
	private String selfEthnicity = "";
	private String selfCondition = "";
	private String selfConditionCode = "";
	private String selfConditionSystemName = "";
	private String selfRaceCode = "";
	private String selfRaceCodeSystemName = "";
	private String selfEthnicityCode = "";
	private String selfEthnicitySystemName = "";
	private String weight = "";
	private String weightUnit = "";
	private String height = "";
	private String heightUnit = "";
	private String selfGenderCode = "";
	private String selfGenderCodeSystemName = "";
	private String selfId = "";
	private String relativeId = "";
	private String estimatedAge = "";
	
	public String getEstimatedAge() {
		return estimatedAge;
	}
	public void setEstimatedAge(String estimatedAge) {
		this.estimatedAge = estimatedAge;
	}
	public String getRelativeId() {
		return relativeId;
	}
	public void setRelativeId(String relativeId) {
		this.relativeId = relativeId;
	}
	public String getSelfId() {
		return selfId;
	}
	public void setSelfId(String selfId) {
		this.selfId = selfId;
	}
	public String getSelfGenderValue() {
		return selfGenderValue;
	}
	public void setSelfGenderValue(String selfGenderValue) {
		this.selfGenderValue = selfGenderValue;
	}
	public String getSelfGenderCode() {
		return selfGenderCode;
	}
	public void setSelfGenderCode(String selfGenderCode) {
		this.selfGenderCode = selfGenderCode;
	}
	public String getSelfGenderCodeSystemName() {
		return selfGenderCodeSystemName;
	}
	public void setSelfGenderCodeSystemName(String selfGenderCodeSystemName) {
		this.selfGenderCodeSystemName = selfGenderCodeSystemName;
	}
	public String getSelfGender() {
		return selfGender;
	}
	public void setSelfGender(String selfGender) {
		this.selfGender = selfGender;
	}
	public String getSelfRace() {
		return selfRace;
	}
	public void setSelfRace(String selfRace) {
		this.selfRace = selfRace;
	}
	public String getSelfEthnicity() {
		return selfEthnicity;
	}
	public void setSelfEthnicity(String selfEthnicity) {
		this.selfEthnicity = selfEthnicity;
	}
	public String getSelfCondition() {
		return selfCondition;
	}
	public void setSelfCondition(String selfCondition) {
		this.selfCondition = selfCondition;
	}
	public String getSelfConditionCode() {
		return selfConditionCode;
	}
	public void setSelfConditionCode(String selfConditionCode) {
		this.selfConditionCode = selfConditionCode;
	}
	public String getSelfConditionSystemName() {
		return selfConditionSystemName;
	}
	public void setSelfConditionSystemName(String selfConditionSystemName) {
		this.selfConditionSystemName = selfConditionSystemName;
	}
	public String getSelfRaceCode() {
		return selfRaceCode;
	}
	public void setSelfRaceCode(String selfRaceCode) {
		this.selfRaceCode = selfRaceCode;
	}
	public String getSelfRaceCodeSystemName() {
		return selfRaceCodeSystemName;
	}
	public void setSelfRaceCodeSystemName(String selfRaceCodeSystemName) {
		this.selfRaceCodeSystemName = selfRaceCodeSystemName;
	}
	public String getSelfEthnicityCode() {
		return selfEthnicityCode;
	}
	public void setSelfEthnicityCode(String selfEthnicityCode) {
		this.selfEthnicityCode = selfEthnicityCode;
	}
	public String getSelfEthnicitySystemName() {
		return selfEthnicitySystemName;
	}
	public void setSelfEthnicitySystemName(String selfEthnicitySystemName) {
		this.selfEthnicitySystemName = selfEthnicitySystemName;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getHeightUnit() {
		return heightUnit;
	}
	public void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}
	public String getDeathCondition() {
		return deathCondition;
	}
	public void setDeathCondition(String deathCondition) {
		this.deathCondition = deathCondition;
	}
	public String getDeathConditionCode() {
		return deathConditionCode;
	}
	public void setDeathConditionCode(String deathConditionCode) {
		this.deathConditionCode = deathConditionCode;
	}
	public String getDeathConditionSystemName() {
		return deathConditionSystemName;
	}
	public void setDeathConditionSystemName(String deathConditionSystemName) {
		this.deathConditionSystemName = deathConditionSystemName;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getConditionCode() {
		return conditionCode;
	}
	public void setConditionCode(String conditionCode) {
		this.conditionCode = conditionCode;
	}
	public String getConditionCodeSystemName() {
		return conditionCodeSystemName;
	}
	public void setConditionCodeSystemName(String conditionCodeSystemName) {
		this.conditionCodeSystemName = conditionCodeSystemName;
	}
	public String getGenderValue() {
		return genderValue;
	}
	public void setGenderValue(String genderValue) {
		this.genderValue = genderValue;
	}
	public String getGenderCodeSystemName() {
		return genderCodeSystemName;
	}
	public void setGenderCodeSystemName(String genderCodeSystemName) {
		this.genderCodeSystemName = genderCodeSystemName;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getRaceCode() {
		return raceCode;
	}
	public void setRaceCode(String raceCode) {
		this.raceCode = raceCode;
	}
	public String getRaceCodeSystemName() {
		return raceCodeSystemName;
	}
	public void setRaceCodeSystemName(String raceCodeSystemName) {
		this.raceCodeSystemName = raceCodeSystemName;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getEthnicityCode() {
		return ethnicityCode;
	}
	public void setEthnicityCode(String ethnicityCode) {
		this.ethnicityCode = ethnicityCode;
	}
	public String getEthnicitySystemName() {
		return ethnicitySystemName;
	}
	public void setEthnicitySystemName(String ethnicitySystemName) {
		this.ethnicitySystemName = ethnicitySystemName;
	}
	public String getGenderCode() {
		return genderCode;
	}
	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDay() {
		if(getBirthDate().contains("/")){
			int slash = getBirthDate().indexOf("/");
			String temp = getBirthDate().substring(slash+1);
			slash = temp.indexOf("/");
			this.birthDay = temp.substring(0,slash);
		}else{
			this.setBirthDay("01");
		}
		
		return this.birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVersionStamp() {
		return versionStamp;
	}
	public void setVersionStamp(String versionStamp) {
		this.versionStamp = versionStamp;
	}
	public String getBirthYear() {
		int slash = getBirthDate().indexOf("/");
		String temp = getBirthDate().substring(slash+1);
		slash = temp.indexOf("/");
		this.birthYear = temp.substring(slash+1);
		return this.birthYear;
	}
	public String getBirthMonth() {
		if(this.getBirthDate().contains("/")){
			int slash = getBirthDate().indexOf("/");
			this.birthMonth = getBirthDate().substring(0,slash);
		}else{
			this.setBirthMonth("01");
		}
		return this.birthMonth;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	private void writeFamilyHistory(String authToken, DataBean dataBean) {
		String xmlData = dataBean.getXmlData();
		//setupFamilyHistory(xmlData);
		Calendar calendar = Calendar.getInstance();
	     
        Document doc = XmlDocument.parse(xmlData);
		try {
		XPath xPath =  XPathFactory.newInstance().newXPath();
		String expr = "/FamilyHistory/subject/patient/patientPerson/relative";
		NodeList nodeList = (NodeList) xPath.compile(expr).evaluate(doc, XPathConstants.NODESET);
		System.out.println("nodeList length =="+nodeList.getLength());
		getPersonalInfo(authToken);
		if(id != null && !id.equals("")) {
		for (int i = 0;null!=nodeList && i <= nodeList.getLength(); i++) {
			this.setId("");this.setVersionStamp("");
			getPersonalInfo(authToken);
			this.checkFamilyHistoryExists(authToken);
			}
		}
		StringBuilder infoBuilder = new StringBuilder();

		infoBuilder.append("<info>");
       
		for (int i = 0;null!=nodeList && i < nodeList.getLength(); i++) {
			WeightInfo weight = new WeightInfo();
			HeightInfo height = new HeightInfo();
			System.out.println("printing height and weight");
			this.setWeight(weight.weight);
			this.setWeightUnit(weight.weightUnit);
			this.setHeight(height.height);
			this.setHeightUnit(height.heightUnit);
	        
	        if(i==0){
	        	this.setId("");this.setVersionStamp("");
				getPersonalInfo(authToken);
//				infoBuilder.append("<info>");
		        infoBuilder.append("<thing>");
		        if(id != null && !id.equals("")) {
		        	infoBuilder.append("<thing-id version-stamp=\"");
		        	infoBuilder.append(versionStamp + "\">");
		        	infoBuilder.append(id);
		        	infoBuilder.append("</thing-id>");
		        }
	        	expr = "/FamilyHistory/subject/patient/patientPerson/administrativeGenderCode/@displayName";
				String gender = xPath.compile(expr).evaluate(doc);
				this.setSelfGender(gender);
				if(this.getSelfGender().equalsIgnoreCase("male")){
        			this.setGenderValue("Mr");
        		}
        		else{
        			this.setGenderValue("Mrs");
        		}
				
				try {
					expr = "/FamilyHistory/subject/patient/patientPerson/subjectOf2/clinicalObservation";
					NodeList nodeList1 = (NodeList) xPath.compile(expr).evaluate(doc, XPathConstants.NODESET);
					for (int m = 0;null!=nodeList1 && m < nodeList1.getLength(); m++) {
					Node node = nodeList1.item(m);
			        if(node.getNodeType() == Node.ELEMENT_NODE) {
			        	Element eElement = (Element) node;
					if(eElement.getElementsByTagName("code").item(0)!=null){
						NamedNodeMap attributesList = eElement.getElementsByTagName("code").item(0).getAttributes();
	        			for(int k=0;k<attributesList.getLength();k++){

		        		System.out.println("condition Attribute: " + k + ":" 
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("originalText")){
		        				this.setSelfCondition(attributesList.item(k).getNodeValue());
		        			}
		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName")){
		        				this.setSelfConditionSystemName(attributesList.item(k).getNodeValue());
		        			}
		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("code")){
		        				this.setSelfConditionCode(attributesList.item(k).getNodeValue());
		        			}
		        		
	        			}
	        		}
					if(eElement.getElementsByTagName("low").item(0)!=null){
						NamedNodeMap attributesList = eElement.getElementsByTagName("low").item(0).getAttributes();
	        			for(int k=0;k<attributesList.getLength();k++){

		        		System.out.println("low Attribute : " + k + ":" 
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("value")){
		        				this.setEstimatedAge(attributesList.item(k).getNodeValue());
		        			}
//		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName")){
//		        				this.setSelfConditionSystemName(attributesList.item(k).getNodeValue());
//		        			}
//		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("code")){
//		        				this.setSelfConditionCode(attributesList.item(k).getNodeValue());
//		        			}
		        		
	        			}
	        		}
			        }
					}
				}catch(Exception e){
					e.printStackTrace();
				}
								
				expr = "/FamilyHistory/subject/patient/patientPerson/name/@formatted";
				String fullName = xPath.compile(expr).evaluate(doc);
				setFullName(fullName);
				
				expr = "/FamilyHistory/subject/patient/patientPerson/birthTime/@value";
				String birthDate = xPath.compile(expr).evaluate(doc);
				setBirthDate(birthDate);
									
				expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode/@displayName";
				String ethnicity = xPath.compile(expr).evaluate(doc);
				setSelfEthnicity(ethnicity);
				expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode/@code";
				String ethCode = xPath.compile(expr).evaluate(doc);
				setSelfEthnicityCode(ethCode);
				expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode/@codeSystemName";
				String ethname = xPath.compile(expr).evaluate(doc);
				setSelfEthnicitySystemName(ethname);
				
				expr = "/FamilyHistory/subject/patient/patientPerson/raceCode/@displayName";
				String race = xPath.compile(expr).evaluate(doc);
				setSelfRace(race);
				expr = "/FamilyHistory/subject/patient/patientPerson/raceCode/@code";
				String raceCode = xPath.compile(expr).evaluate(doc);
				setSelfRaceCode(raceCode);
				expr = "/FamilyHistory/subject/patient/patientPerson/raceCode/@codeSystemName";
				String racename = xPath.compile(expr).evaluate(doc);
				setSelfRaceCodeSystemName(racename);
				
				expr = "/FamilyHistory/subject/patient/patientPerson/id/@extension";
				String id = xPath.compile(expr).evaluate(doc);
				setSelfId(id);
				
			//	this.setSelfCondition("Other Kidney Disease");
			//	this.setSelfConditionCode("OTKIDDIS");
			//	this.setSelfConditionSystemName("SNOMED_CT");
				
	        	infoBuilder.append("<type-id>");
		        infoBuilder.append(FamilyHistory.familyHistoryType);
		        infoBuilder.append("</type-id>");
				infoBuilder.append("<data-xml><family-history>");
				if(this.getSelfCondition()!=""){
					infoBuilder.append("<condition><name><text>").append(getSelfCondition()).append("</text>");
					infoBuilder.append("<code>");
					infoBuilder.append("<value>").append(this.getSelfConditionCode()).append("</value>");
					infoBuilder.append("<family>urn:gov.familyhistory.hl7</family>");
					infoBuilder.append("<type>").append(this.getSelfConditionSystemName()).append("</type>");
					infoBuilder.append("<version>3</version>");
					infoBuilder.append("</code>");
					infoBuilder.append("<code>");
					if(this.getEstimatedAge().equals("30"))
						infoBuilder.append("<value>ageRange.thirties</value>");
					if(this.getEstimatedAge().equals("40"))
						infoBuilder.append("<value>ageRange.forties</value>");
					if(this.getEstimatedAge().equals("50"))
						infoBuilder.append("<value>ageRange.fifties</value>");
					if(this.getEstimatedAge().equals("60"))
						infoBuilder.append("<value>ageRange.sixties</value>");
					infoBuilder.append("<family>hhs</family>");
					infoBuilder.append("<type>hhs-onset-date-codes</type>");
					infoBuilder.append("<version>3</version>");
					infoBuilder.append("</code>");
					infoBuilder.append("</name></condition>");
				}
				infoBuilder.append("<relative><relationship><text>");
				infoBuilder.append("self");
		        infoBuilder.append("</text><code>");
		        infoBuilder.append("<value>self</value>");
		        infoBuilder.append("<family>wc</family><type>personal-relationship</type><version>1</version></code></relationship>");
		        infoBuilder.append("<relative-name><name>");
		        infoBuilder.append("<full>"+this.getFullName()+"</full>");
		        infoBuilder.append("<title><text>");
		        infoBuilder.append(this.getSelfGenderValue()+"</text>");
		        infoBuilder.append("<code><value>"+this.getSelfGenderValue()+"</value>");
		        infoBuilder.append("<family>wc</family><type>name-prefixes</type><version /></code></title>");
		        infoBuilder.append("<first /><middle /><last /></name>");
		        infoBuilder.append("<id>"+this.getSelfId()+"</id>");
		        infoBuilder.append("<contact><address><description /><is-primary>false</is-primary><street /><city /><state /><postcode /><country /></address>");
		        infoBuilder.append("<phone><description /><is-primary>false</is-primary><number /></phone>");
		        infoBuilder.append("<email><description /><is-primary>false</is-primary><address /></email></contact>");
		        infoBuilder.append("<type><text /><code><value /><family /><type /><version /></code></type></relative-name>");
		        if(this.getBirthDate()!=""){
			        infoBuilder.append("<date-of-birth>");
			        infoBuilder.append("<y>").append(getBirthYear()).append("</y>");
			        infoBuilder.append("<m>").append(getBirthMonth()).append("</m>");
			        infoBuilder.append("<d>").append(getBirthDay()).append("</d>");
			        infoBuilder.append("</date-of-birth>");
		        }

		        infoBuilder.append("<region-of-origin><text /><code><value /><family /><type /><version /></code></region-of-origin >");
		        infoBuilder.append("</relative></family-history>");
		 //       infoBuilder.append("<common /></data-xml></thing>");
		        infoBuilder.append("<common>");
		        infoBuilder.append("<source>urn:gov.hhs.familyhistory.mfhp</source>");
		        infoBuilder.append("<extension source=\""+"urn:gov.hhs.familyhistory.mfhp"+ "\">");
		        infoBuilder.append("<fhh-extensions version=\""+"1.0"+ "\">");
		        infoBuilder.append("<gender version=\""+"1.0"+ "\">");
		        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+this.getSelfGender() +"\" type=\""+this.getSelfGenderCodeSystemName() +"\" value=\""+this.getSelfGenderCode() +"\" version=\""+"3"+"\"/>");
		        infoBuilder.append("</gender>");
		        infoBuilder.append("<twin>NO</twin>");
		        infoBuilder.append("<adopted>false</adopted>");
		        infoBuilder.append("<height version=\""+"1.0"+ "\">");
		        if(this.getHeightUnit().equalsIgnoreCase("centimeters")){
		        	infoBuilder.append("<centemiters>"+this.getHeight()+"</centemiters>");
		        	infoBuilder.append("<inches />");
		        }else{
			        infoBuilder.append("<inches>"+this.getHeight()+"</inches>");
			        infoBuilder.append("<centemiters />");
		        }
		        infoBuilder.append("</height>");
		        infoBuilder.append("<weight version=\""+"1.0"+ "\">");
		        if(this.getWeightUnit().equalsIgnoreCase("lb")){
			        infoBuilder.append("<pounds>205</pounds>");
			        infoBuilder.append("<kilograms />");
		        }else{
		        	infoBuilder.append("<pounds />");
			        infoBuilder.append("<kilograms>"+this.getWeight()+"</kilograms>");
		        }
		        infoBuilder.append("</weight>");
		        if(this.getSelfRace()!=""){
			        infoBuilder.append("<races version=\""+"1.0"+ "\">");
			        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+this.getSelfRace() +"\" type=\""+this.getSelfRaceCodeSystemName() +"\" value=\""+this.getSelfRaceCode() +"\" version=\""+"3"+"\"/>");
			        infoBuilder.append("</races>");
		        }
		        if(this.getSelfEthnicity()!=""){
			        infoBuilder.append("<ethnicities>");
			        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+this.getSelfEthnicity() +"\" type=\""+this.getSelfEthnicitySystemName() +"\" value=\""+this.getSelfEthnicityCode() +"\" version=\""+"3"+"\"/>");
			        infoBuilder.append("</ethnicities>");
		        }
		        infoBuilder.append("<consanguinity>true</consanguinity>");
		        infoBuilder.append("</fhh-extensions>");
		        infoBuilder.append("</extension>");
		        infoBuilder.append("<client-thing-id>"+this.getSelfId()+"</client-thing-id>");
		        infoBuilder.append("</common></data-xml></thing>");
//		        break;

	        }
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
	        	Element eElement = (Element) node;
	        	
	        	NamedNodeMap attributesList = eElement.getElementsByTagName("code").item(0).getAttributes();
	        	for(int j=0;j<attributesList.getLength();j++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(j).getNodeName() + " = "
	                        + attributesList.item(j).getNodeValue());
	        		this.setRelation(attributesList.item(j).getNodeValue());
	        	}
	        	
	        	attributesList = eElement.getElementsByTagName("administrativeGenderCode").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        		this.setGender(attributesList.item(k).getNodeValue());
	        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("code"))
	        			this.setGenderCode(attributesList.item(k).getNodeValue());
	        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName"))
	        			this.setGenderCodeSystemName(attributesList.item(k).getNodeValue());
	        		if(attributesList.item(k).getNodeValue().equalsIgnoreCase("male")){
	        			this.setGenderValue("Mr");
	        		}
	        		else{
	        			this.setGenderValue("Mrs");
	        		}
	        	}
	        	this.setEthnicity("");
	        	if(eElement.getElementsByTagName("ethnicGroupCode").item(0)!=null){
		        	attributesList = eElement.getElementsByTagName("ethnicGroupCode").item(0).getAttributes();
		        	for(int k=0;k<attributesList.getLength();k++){
		        		System.out.println("Attribute: "
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("code"))
		        			this.setEthnicityCode(attributesList.item(k).getNodeValue());
		        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName"))
		        			this.setEthnicitySystemName(attributesList.item(k).getNodeValue());
		        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("displayName"))
		        			this.setEthnicity(attributesList.item(k).getNodeValue());
		        	}
	        	}
	        	this.setRace("");
	        	if(eElement.getElementsByTagName("raceCode").item(0)!=null){
		        	attributesList = eElement.getElementsByTagName("raceCode").item(0).getAttributes();
		        	for(int k=0;k<attributesList.getLength();k++){
		        		System.out.println("Attribute: "
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("code"))
		        			this.setRaceCode(attributesList.item(k).getNodeValue());
		        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName"))
		        			this.setRaceCodeSystemName(attributesList.item(k).getNodeValue());
		        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("displayName"))
		        			this.setRace(attributesList.item(k).getNodeValue());
		        	}
	        	}
	        	attributesList = eElement.getElementsByTagName("id").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        		this.setRelativeId(attributesList.item(k).getNodeValue());
	        	}
	        	attributesList = eElement.getElementsByTagName("name").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        		this.setFullName(attributesList.item(k).getNodeValue());
	        	}
	        	this.setCondition("");
	        	this.setResolution("");
	        	if(eElement.hasAttribute("Age at Death")){
	        		System.out.println("testing attribute age at death");
	        	}
	        	if(eElement.getElementsByTagName("clinicalObservation").item(0)!=null){
	        		this.setCondition("");
	        		if(eElement.getElementsByTagName("low").item(0)!=null){
	        			attributesList = eElement.getElementsByTagName("low").item(0).getAttributes();
	        			for(int k=0;k<attributesList.getLength();k++){
	        				this.setEstimatedAge("");
	        				System.out.println("Age attributes: "+ attributesList.item(k).getNodeName() + " = "
			                        + attributesList.item(k).getNodeValue());
	        				if(attributesList.item(k).getNodeName().equalsIgnoreCase("value")){
		        				this.setEstimatedAge(attributesList.item(k).getNodeValue());
		        			}
	        			}
	        		}
			        		if(eElement.getElementsByTagName("code").item(2)!=null){
			        			for(int k=0;k<attributesList.getLength();k++){
				        		attributesList = eElement.getElementsByTagName("code").item(2).getAttributes();
				        		System.out.println("condition Attribute: " + k + ":" 
				                        + attributesList.item(k).getNodeName() + " = "
				                        + attributesList.item(k).getNodeValue());
				        		if(!(attributesList.item(k).getNodeValue().equalsIgnoreCase("Age at Death"))){
				        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("displayName")){
				        				this.setCondition(attributesList.item(k).getNodeValue());
				        			}
				        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName")){
				        				this.setConditionCodeSystemName(attributesList.item(k).getNodeValue());
				        				this.setConditionCodeSystemName(attributesList.item(k).getNodeValue());
				        			}
				        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("code")){
				        				this.setConditionCode(attributesList.item(k).getNodeValue());
				        				this.setDeathConditionCode(attributesList.item(k).getNodeValue());
				        			}
				        		}
				        		else{
				        			this.setResolution("death");
				        			}
			        			}
			        		}
			        		if(eElement.getElementsByTagName("code").item(3)!=null){
			        			for(int k=0;k<attributesList.getLength();k++){
				        		attributesList = eElement.getElementsByTagName("code").item(3).getAttributes();
				        		System.out.println("condition Attribute: "
				                        + attributesList.item(k).getNodeName() + " = "
				                        + attributesList.item(k).getNodeValue());
				        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("displayName")){
				        			if(!(attributesList.item(k).getNodeValue().equalsIgnoreCase("Estimated Age"))){
				        				this.setDeathCondition(attributesList.item(k).getNodeValue());
				        				this.setCondition(attributesList.item(k).getNodeValue());
				        			}
				        		}
				        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName")){
			        				this.setDeathConditionSystemName(attributesList.item(k).getNodeValue());
			        				this.setConditionCodeSystemName(attributesList.item(k).getNodeValue());
			        			}
			        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("code")){
			        				this.setDeathConditionCode(attributesList.item(k).getNodeValue());
			        				this.setConditionCode(attributesList.item(k).getNodeValue());
			        			}
				        		
			        		}
		        		}
			        		if(eElement.getElementsByTagName("low").item(0)!=null){
			        			for(int k=0;k<attributesList.getLength();k++){
			        				System.out.println("Age attributes: "+ attributesList.item(k).getNodeName() + " = "
					                        + attributesList.item(k).getNodeValue());
			        			}
			        		}
	        	}
	        	this.setBirthDate("");
	        	if(eElement.getElementsByTagName("birthTime").item(0)!=null){
	        		
	        	attributesList = eElement.getElementsByTagName("birthTime").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        		this.setBirthDate(attributesList.item(k).getNodeValue());
	        	}
	        	}
			}
			 infoBuilder.append("<thing>");
			 this.setId("");this.setVersionStamp("");
			 this.getPersonalInfo(authToken);
		        if(id != null && !id.equals("")) {
		        	infoBuilder.append("<thing-id version-stamp=\"");
		        	infoBuilder.append(versionStamp + "\">");
		        	infoBuilder.append(id);
		        	infoBuilder.append("</thing-id>");
		        }
	        infoBuilder.append("<type-id>");
	        infoBuilder.append(FamilyHistory.familyHistoryType);
	        infoBuilder.append("</type-id>");
			infoBuilder.append("<data-xml><family-history>");
			if(this.getCondition()!=""){
				infoBuilder.append("<condition><name><text>").append(getCondition()).append("</text>");
				infoBuilder.append("<code>");
				infoBuilder.append("<value>").append(this.getConditionCode()).append("</value>");
				infoBuilder.append("<family>urn:gov.familyhistory.hl7</family>");
				infoBuilder.append("<type>").append(this.getConditionCodeSystemName()).append("</type>");
				infoBuilder.append("<version>3</version>");
				infoBuilder.append("</code>");
				infoBuilder.append("<code>");
//				if(this.getEstimatedAge().equals("30"))
//					infoBuilder.append("<value>ageRange.thirties</value>");
//				if(this.getEstimatedAge().equals("40"))
//					infoBuilder.append("<value>ageRange.forties</value>");
//				if(this.getEstimatedAge().equals("50"))
					infoBuilder.append("<value>ageRange.fifties</value>");
//				if(this.getEstimatedAge().equals("60"))
//					infoBuilder.append("<value>ageRange.sixties</value>");
				infoBuilder.append("<family>hhs</family>");
				infoBuilder.append("<type>hhs-onset-date-codes</type>");
				infoBuilder.append("<version>3</version>");
				infoBuilder.append("</code>");
				infoBuilder.append("</name></condition>");
			}
			if(this.getResolution()!=""){
				infoBuilder.append("<condition><name><text>").append(getDeathCondition()).append("</text>");
				infoBuilder.append("<code>");
				infoBuilder.append("<value>").append(this.getDeathConditionCode()).append("</value>");
				infoBuilder.append("<family>urn:gov.familyhistory.hl7</family>");
				infoBuilder.append("<type>").append(this.getDeathConditionSystemName()).append("</type>");
				infoBuilder.append("<version>3</version>");
				infoBuilder.append("</code>");
				infoBuilder.append("<code>");
//				if(this.getEstimatedAge().equals("30"))
//					infoBuilder.append("<value>ageRange.thirties</value>");
//				if(this.getEstimatedAge().equals("40"))
//					infoBuilder.append("<value>ageRange.forties</value>");
//				if(this.getEstimatedAge().equals("50"))
//					infoBuilder.append("<value>ageRange.fifties</value>");
//				if(this.getEstimatedAge().equals("60"))
					infoBuilder.append("<value>ageRange.sixties</value>");
				infoBuilder.append("<family>hhs</family>");
				infoBuilder.append("<type>hhs-onset-date-codes</type>");
				infoBuilder.append("<version>3</version>");
				infoBuilder.append("</code>");
				infoBuilder.append("</name><resolution>death</resolution></condition>");
				
			}
			infoBuilder.append("<relative><relationship><text>");
			infoBuilder.append(this.getRelation());
	        infoBuilder.append("</text><code>");
	        infoBuilder.append("<value>"+ this.getRelation() +"</value>");
	        infoBuilder.append("<family>wc</family><type>personal-relationship</type><version>1</version></code></relationship>");
	        infoBuilder.append("<relative-name><name>");
	        infoBuilder.append("<full>"+this.getFullName()+"</full>");
	        infoBuilder.append("<title><text>");
	        infoBuilder.append(this.getGenderValue()+"</text>");
	        infoBuilder.append("<code><value>"+this.getGenderValue()+"</value>");
	        infoBuilder.append("<family>wc</family><type>name-prefixes</type><version /></code></title>");
	        infoBuilder.append("<first /><middle /><last /></name>");
	        infoBuilder.append("<id>"+this.getRelativeId()+"</id>");
	        infoBuilder.append("<contact><address><description /><is-primary>false</is-primary><street /><city /><state /><postcode /><country /></address>");
	        infoBuilder.append("<phone><description /><is-primary>false</is-primary><number /></phone>");
	        infoBuilder.append("<email><description /><is-primary>false</is-primary><address /></email></contact>");
	        infoBuilder.append("<type><text /><code><value /><family /><type /><version /></code></type></relative-name>");
	        if(this.getBirthDate()!=""){
		        infoBuilder.append("<date-of-birth>");
		        infoBuilder.append("<y>").append(getBirthYear()).append("</y>");
		        infoBuilder.append("<m>").append(getBirthMonth()).append("</m>");
		        infoBuilder.append("<d>").append(getBirthDay()).append("</d>");
		        infoBuilder.append("</date-of-birth>");
	        }

	        infoBuilder.append("<region-of-origin><text /><code><value /><family /><type /><version /></code></region-of-origin >");
	        infoBuilder.append("</relative></family-history>");
	 //       infoBuilder.append("<common /></data-xml></thing>");
	        infoBuilder.append("<common>");
	        infoBuilder.append("<source>urn:gov.hhs.familyhistory.mfhp</source>");
	        infoBuilder.append("<extension source=\""+"urn:gov.hhs.familyhistory.mfhp"+ "\">");
	        infoBuilder.append("<fhh-extensions version=\""+"1.0"+ "\">");
	        infoBuilder.append("<gender version=\""+"1.0"+ "\">");
	        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+this.getGender() +"\" type=\""+this.getGenderCodeSystemName() +"\" value=\""+this.getGenderCode() +"\" version=\""+"3"+"\"/>");
	        infoBuilder.append("</gender>");
	        infoBuilder.append("<twin>NO</twin>");
	        infoBuilder.append("<adopted>false</adopted>");
	        if(this.getRace()!=""){
		        infoBuilder.append("<races version=\""+"1.0"+ "\">");
		        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+this.getRace() +"\" type=\""+this.getRaceCodeSystemName() +"\" value=\""+this.getRaceCode() +"\" version=\""+"3"+"\"/>");
		        infoBuilder.append("</races>");
	        }
	        if(this.getEthnicity()!=""){
		        infoBuilder.append("<ethnicities>");
		        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+this.getEthnicity() +"\" type=\""+this.getEthnicitySystemName() +"\" value=\""+this.getEthnicityCode() +"\" version=\""+"3"+"\"/>");
		        infoBuilder.append("</ethnicities>");
	        }
	        infoBuilder.append("<consanguinity>false</consanguinity>");
	        infoBuilder.append("</fhh-extensions>");
	        infoBuilder.append("</extension>");
	        infoBuilder.append("<client-thing-id>"+this.getRelativeId()+"</client-thing-id>");
	        infoBuilder.append("</common></data-xml></thing>");

		}
//		infoBuilder.append("</itemtype></itemtypes>");
        infoBuilder.append("</info>");
 //       infoBuilder.append("</itemtype></itemtypes>");
        
        System.out.println(infoBuilder.toString());
        Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);
        
        Request request = new Request();
		request.setMethodName("PutThings");
		request.setInfo(infoBuilder.toString());
		
		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
		template.makeRequest(request, personInfo);
	    
	   	} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
			
	}
	private void checkFamilyHistoryExists(String authToken) {
		// TODO Auto-generated method stub
		System.out.println("Checking if family history exists");
		StringBuilder infoBuilder = new StringBuilder();
		if(id != null && !id.equals("")) {
			infoBuilder.append("<info>");
	        if(id != null && !id.equals("")) {
	        	System.out.println("There is family history");
	        	infoBuilder.append("<thing-id version-stamp=\"");
	        	infoBuilder.append(versionStamp + "\">");
	        	infoBuilder.append(id);
	        	infoBuilder.append("</thing-id>");
	        }
	        
	        infoBuilder.append("</info>");
	        System.out.println(infoBuilder.toString());
	        Authentication auth = new Authentication();
			PersonInfo personInfo = auth.getPersonInfo(authToken);
	        System.out.println("Deleting family history");
	        Request request = new Request();
			request.setMethodName("RemoveThings");
			request.setInfo(infoBuilder.toString());
			
			RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
			template.makeRequest(request, personInfo);
		}
		System.out.println("FamilyHistory removed successfully");
		
	}
	private void setupFamilyHistory(String xmlData) {
		Document doc = XmlDocument.parse(xmlData);
		try {
		XPath xPath =  XPathFactory.newInstance().newXPath();
		String expr = "/FamilyHistory/subject/patient/patientPerson/relative";
		NodeList nodeList = (NodeList) xPath.compile(expr).evaluate(doc, XPathConstants.NODESET);
		System.out.println("nodeList length =="+nodeList.getLength());
		for (int i = 0;null!=nodeList && i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
	        	Element eElement = (Element) node;
	        	
	        	NamedNodeMap attributesList = eElement.getElementsByTagName("code").item(0).getAttributes();
	        	for(int j=0;j<attributesList.getLength();j++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(j).getNodeName() + " = "
	                        + attributesList.item(j).getNodeValue());
	        		this.setRelation(attributesList.item(j).getNodeValue());
	        	}
	        	
	        	attributesList = eElement.getElementsByTagName("administrativeGenderCode").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        		if(attributesList.item(k).getNodeValue().equalsIgnoreCase("male")){
	        			this.setGender("Mr");
	        		}else{
	        			this.setGender("Mrs");
	        		}
	        	}
	        	attributesList = eElement.getElementsByTagName("ethnicGroupCode").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        	}
	        	attributesList = eElement.getElementsByTagName("raceCode").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        	}
	        	attributesList = eElement.getElementsByTagName("id").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        	}
	        	attributesList = eElement.getElementsByTagName("name").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        	}
	        	if(eElement.getElementsByTagName("birthTime").item(0)!=null){
	        	attributesList = eElement.getElementsByTagName("birthTime").item(0).getAttributes();
	        	for(int k=0;k<attributesList.getLength();k++){
	        		System.out.println("Attribute: "
	                        + attributesList.item(k).getNodeName() + " = "
	                        + attributesList.item(k).getNodeValue());
	        	}
	        	}
			}
	        
			
		
        
//        Authentication auth = new Authentication();
//		PersonInfo personInfo = auth.getPersonInfo(authToken);
//        
//        Request request = new Request();
//		request.setMethodName("PutThings");
//		request.setInfo(infoBuilder.toString());
//		
//		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
//		template.makeRequest(request, personInfo);
		
	     }
	
		
		setRelation(relation);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void getPersonalInfo(String authToken)
	{
		Request request = new Request();
		request.setMethodName("GetThings");
		request.setInfo("<info><group max=\"30\"><filter><type-id>" +
				familyHistoryType +
				"</type-id></filter><format><section>core</section><xml/></format></group></info>");
		
		Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);		
		
		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
		template.makeRequest(request, personInfo, new Marshaller<String>() {
			public String marshal(InputStream istream) throws Exception {
				InputSource isource = new InputSource(istream);
                XPath xpath = XPathFactory.newInstance().newXPath();
                String exp = "//thing";
                NodeList things = (NodeList)xpath.evaluate(exp,
                		isource,
                		XPathConstants.NODESET); 
                
                int count = Math.min(50, things.getLength());
    	        for (int i=0; i<count; i++)
    	        {
    	            Node thing = things.item(i);
    	            setId(xpath.evaluate("thing-id", thing));
    	            setVersionStamp(xpath.evaluate("thing-id/@version-stamp", thing));
    	            System.out.println(id);
    	            System.out.println(versionStamp);
    	            System.out.println("(((()))))))))))))))))");
	            	break;
    	        }
				return id;
			}
		});       
	}
	@Override
	public void pushData(String authToken, DataBean dataBean) {
		getPersonalInfo(authToken);
		writeFamilyHistory(authToken, dataBean);
		
	}
	public void conditionSetup(String xmlData){
		Document doc = XmlDocument.parse(xmlData);
		try {
		XPath xPath =  XPathFactory.newInstance().newXPath();
		String expr = "/FamilyHistory/subject/patient/patientPerson/relative/relationshipHolder/subjectof2/clinicalObservation/code/@displayName";
    	String condition = xPath.compile(expr).evaluate(doc);
    	System.out.println("conditio +"+condition);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
