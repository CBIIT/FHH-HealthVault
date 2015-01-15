package gov.nih.nci.FHH.bean;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.Marshaller;
import gov.nih.nci.FHH.RequestTemplate;
import gov.nih.nci.FHH.util.XmlDocument;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
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
	private String ageRangeLow = "";
	private String ageRangeHigh = "";
	private String parentId = "";
	private String twinStatus = "";
	boolean adopted = false;
	private List<String> ethnicities;
	private List<String> ethnicityCodes;
	private List<String> races;
	private List<String> raceCodes;
	private String consanguinity;
	
	public String getConsanguinity() {
		return consanguinity;
	}
	public void setConsanguinity(String consanguinity) {
		this.consanguinity = consanguinity;
	}
	public boolean isAdopted() {
		return adopted;
	}
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	public String getTwinStatus() {
		return twinStatus;
	}
	public void setTwinStatus(String twinStatus) {
		this.twinStatus = twinStatus;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getAgeRangeLow() {
		return ageRangeLow;
	}
	public void setAgeRangeLow(String ageRangeLow) {
		this.ageRangeLow = ageRangeLow;
	}
	public String getAgeRangeHigh() {
		return ageRangeHigh;
	}
	public void setAgeRangeHigh(String ageRangeHigh) {
		this.ageRangeHigh = ageRangeHigh;
	}
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
		for (int i = 0;null!=nodeList && i <= 100; i++) {
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
			boolean heightFound = false; boolean weightFound = false;
			System.out.println("printing height and weight");
			this.setWeight(weight.weight);
			this.setWeightUnit(weight.weightUnit);
			this.setHeight(height.height);
			this.setHeightUnit(height.heightUnit);
	        
	        if(i==0){
	        	this.setId("");this.setVersionStamp("");
	        	List<String> conCodeList = new ArrayList<String>();
	        	List<String> conList = new ArrayList<String>();
	        	List<String> estimatedAge = new ArrayList<String>();
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
					this.setConsanguinity("false");
					expr = "/FamilyHistory/subject/patient/patientPerson/subjectOf2/clinicalObservation";
					NodeList nodeList1 = (NodeList) xPath.compile(expr).evaluate(doc, XPathConstants.NODESET);
					for (int m = 0;null!=nodeList1 && m < nodeList1.getLength(); m++) {
					Node node = nodeList1.item(m);
			        if(node.getNodeType() == Node.ELEMENT_NODE) {
			        	Element eElement = (Element) node;
					if(eElement.getElementsByTagName("code").item(0)!=null){
						NamedNodeMap attributesList = eElement.getElementsByTagName("code").item(0).getAttributes();
	        			for(int k=0;k<attributesList.getLength();k++){
	        				
	        				this.setSelfCondition("");
	        				
		        		System.out.println("condition Attribute: " + k + ":" 
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        	if(attributesList.item(k).getNodeValue().equalsIgnoreCase("weight")){
		        		 weightFound = true;
		        	}
		        	if(attributesList.item(k).getNodeValue().equalsIgnoreCase("height")){
		        		 heightFound = true;
		        	}
		        	if(attributesList.item(k).getNodeValue().contains("Fraternal twin")){
    					this.setTwinStatus("FRATERNAL");
    				}else if(attributesList.item(k).getNodeValue().contains("Identical twin")){
    					this.setTwinStatus("IDENTICAL");
    				}else if(attributesList.item(k).getNodeValue().contains("adopted")){
    					this.setAdopted(true);
    				}else{
    					this.setEstimatedAge("");
		        		if((!(attributesList.item(k).getNodeValue().equalsIgnoreCase("weight")))&&(!(attributesList.item(k).getNodeValue().equalsIgnoreCase("height")))){
		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("originalText")){
		        				if(attributesList.item(k).getNodeValue().equalsIgnoreCase("Parental consanguinity indicated")){
		        					this.setConsanguinity("true");
		        				}else if(attributesList.item(k).getNodeValue().equalsIgnoreCase("pre-birth")){
		        					this.setEstimatedAge("prebirth");
		        					estimatedAge.add(this.getEstimatedAge());
		        					System.out.println("prebirth=="+this.getEstimatedAge());
		        				}
		        				else{
			        				this.setSelfCondition(attributesList.item(k).getNodeValue());
			        				conList.add(this.getSelfCondition());
		        				}
		        			}
		        			
		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName")){
		        				this.setSelfConditionSystemName(attributesList.item(k).getNodeValue());
		        			}
		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("code")){
		        				this.setSelfConditionCode(attributesList.item(k).getNodeValue());
		        				conCodeList.add(this.getSelfConditionCode());
		        				System.out.println("code "+this.getSelfConditionCode());
		        			}
		        			
		        			            	
		            	}
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
		        				this.setAgeRangeLow(attributesList.item(k).getNodeValue());
		        			}
   		
	        			}
	        		}
					if(eElement.getElementsByTagName("high").item(0)!=null){
						NamedNodeMap attributesList = eElement.getElementsByTagName("high").item(0).getAttributes();
	        			for(int k=0;k<attributesList.getLength();k++){

		        		System.out.println("high Attribute : " + k + ":" 
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("value")){
		        				this.setAgeRangeHigh(attributesList.item(k).getNodeValue());
		        			}
   		
	        			}
	        		}
			        }
			        
			        if((this.getAgeRangeLow().equals("0"))&&(this.getAgeRangeHigh().equals("28"))){
						this.setEstimatedAge("newborn");
					}else if((this.getAgeRangeLow().equals("29"))&&(this.getAgeRangeHigh().equals("729"))){
						this.setEstimatedAge("infant");
					}else if((this.getAgeRangeLow().equals("2"))&&(this.getAgeRangeHigh().equals("10"))){
						this.setEstimatedAge("child");
					}else if((this.getAgeRangeLow().equals("11"))&&(this.getAgeRangeHigh().equals("19"))){
						this.setEstimatedAge("teen");
					}else if((this.getAgeRangeLow().equals("20"))&&(this.getAgeRangeHigh().equals("29"))){
						this.setEstimatedAge("twenties");
					}else if((this.getAgeRangeLow().equals("30"))&&(this.getAgeRangeHigh().equals("39"))){
						this.setEstimatedAge("thirties");
					}else if((this.getAgeRangeLow().equals("40"))&&(this.getAgeRangeHigh().equals("49"))){
						this.setEstimatedAge("fourties");
					}else if((this.getAgeRangeLow().equals("50"))&&(this.getAgeRangeHigh().equals("59"))){
						this.setEstimatedAge("fifties");
					}else if(this.getAgeRangeLow().equals("60")){
						this.setEstimatedAge("sixties");
					}else{
						this.setEstimatedAge("unknown");
					}
					if(this.getEstimatedAge()!=""){
						estimatedAge.add(this.getEstimatedAge());
					}
					for(int e = 0; e< estimatedAge.size();e++){
						System.out.println("estimated age length =="+estimatedAge.get(e));
					}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				for(int l=0;l<conList.size();l++){
    				if(conCodeList.get(l).equalsIgnoreCase("other")){
    					conCodeList.add(l, "EMPTY");
    				}
    			}
				for(int l=0;l<conList.size();l++){
					System.out.println("condition codes list = "+conCodeList.get(l));
				}
    		
				if((weightFound)&&(conCodeList.size()>0)){
    				conCodeList.remove(0);
    			}
    			if((heightFound)&&(conCodeList.size()>0)){
    				conCodeList.remove(0);
    			}
								
				expr = "/FamilyHistory/subject/patient/patientPerson/name/@formatted";
				String fullName = xPath.compile(expr).evaluate(doc);
				setFullName(fullName);
				
				expr = "/FamilyHistory/subject/patient/patientPerson/birthTime/@value";
				String birthDate = xPath.compile(expr).evaluate(doc);
				setBirthDate(birthDate);
				ethnicities = new ArrayList<String>();
				ethnicityCodes = new ArrayList<String>();
				for(int e=0; e<10;e++){
				expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode["+e+"]/@displayName";
					String ethnicity = xPath.compile(expr).evaluate(doc);
					setSelfEthnicity(ethnicity);
					if(this.getSelfEthnicity()!=""){
						ethnicities.add(this.getSelfEthnicity());
					}
					expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode["+e+"]/@code";
					String ethCode = xPath.compile(expr).evaluate(doc);
					if(this.getSelfEthnicityCode()!=""){
						setSelfEthnicityCode(ethCode);
					}
					ethnicityCodes.add(this.getSelfEthnicityCode());
					expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode["+e+"]/@codeSystemName";
					String ethname = xPath.compile(expr).evaluate(doc);
					setSelfEthnicitySystemName(ethname);
				}
				races = new ArrayList<String>();
				raceCodes = new ArrayList<String>();
				for(int r = 0; r<18;r++){
					expr = "/FamilyHistory/subject/patient/patientPerson/raceCode["+r+"]/@displayName";
					String race = xPath.compile(expr).evaluate(doc);
					setSelfRace(race);
					if(this.getSelfRace()!=""){
						races.add(this.getSelfRace());
					}
					expr = "/FamilyHistory/subject/patient/patientPerson/raceCode["+r+"]/@code";
					String raceCode = xPath.compile(expr).evaluate(doc);
					setSelfRaceCode(raceCode);
					if(this.getSelfRaceCode()!=""){
						raceCodes.add(this.getSelfRaceCode());
					}
					expr = "/FamilyHistory/subject/patient/patientPerson/raceCode["+r+"]/@codeSystemName";
					String racename = xPath.compile(expr).evaluate(doc);
					setSelfRaceCodeSystemName(racename);
				}
				
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
				for(int t=0;t<conList.size();t++){
					infoBuilder.append("<condition><name><text>").append(conList.get(t)).append("</text>");
					infoBuilder.append("<code>");
					infoBuilder.append("<value>").append(conCodeList.get(t)).append("</value>");
					infoBuilder.append("<family>urn:gov.familyhistory.hl7</family>");
					infoBuilder.append("<type>").append(this.getSelfConditionSystemName()).append("</type>");
					infoBuilder.append("<version>3</version>");
					infoBuilder.append("</code>");
					infoBuilder.append("<code>");
					infoBuilder.append("<value>ageRange.").append(estimatedAge.get(t)).append("</value>");
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
		        if(this.getTwinStatus().equalsIgnoreCase("IDENTICAL")){
		        	infoBuilder.append("<twin>IDENTICAL</twin>");
		        }else if(this.getTwinStatus().equalsIgnoreCase("FRATERNAL")){
		        	infoBuilder.append("<twin>FRATERNAL</twin>");
		        }else{
		        	infoBuilder.append("<twin>NO</twin>");
		        }
		        if(adopted){
		        	infoBuilder.append("<adopted>true</adopted>");
		        }else{
		        	infoBuilder.append("<adopted>false</adopted>");
		        }
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
		        for(int r =0; r<races.size();r++){
			        infoBuilder.append("<races version=\""+"1.0"+ "\">");
			        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+races.get(r) +"\" type=\""+this.getSelfRaceCodeSystemName() +"\" value=\""+raceCodes.get(r) +"\" version=\""+"3"+"\"/>");
			        infoBuilder.append("</races>");
		        }
		        for(int e =0; e<ethnicities.size();e++){
			        infoBuilder.append("<ethnicities>");
			        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+ethnicities.get(e) +"\" type=\""+this.getSelfEthnicitySystemName() +"\" value=\""+ethnicityCodes.get(e) +"\" version=\""+"3"+"\"/>");
			        infoBuilder.append("</ethnicities>");
		        }
		        if(this.getConsanguinity().equalsIgnoreCase("true")){
		        	infoBuilder.append("<consanguinity>true</consanguinity>");
		        }else{
		        	infoBuilder.append("<consanguinity>false</consanguinity>");
		        }
		        infoBuilder.append("</fhh-extensions>");
		        infoBuilder.append("</extension>");
		        infoBuilder.append("<client-thing-id>"+this.getSelfId()+"</client-thing-id>");
		        infoBuilder.append("</common></data-xml></thing>");
//		        break;

	        }
			Node node = nodeList.item(i);
			List<String> estimatedAgeList = new ArrayList<String>();
			List<String> conList = new ArrayList<String>();
    		List<String> conCodeList = new ArrayList<String>();
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
	        	ethnicities = new ArrayList<String>();
	        	ethnicityCodes = new ArrayList<String>();
	        	for(int e = 0; e< 10;e++){
		        	if(eElement.getElementsByTagName("ethnicGroupCode").item(e)!=null){
			        	attributesList = eElement.getElementsByTagName("ethnicGroupCode").item(e).getAttributes();
			        	for(int k=0;k<attributesList.getLength();k++){
			        		System.out.println("Attribute: "
			                        + attributesList.item(k).getNodeName() + " = "
			                        + attributesList.item(k).getNodeValue());
			        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("code"))
			        			this.setEthnicityCode(attributesList.item(k).getNodeValue());
			        		if(this.getEthnicityCode()!=""){
			        			ethnicityCodes.add(this.getEthnicityCode());
			        		}
			        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName"))
			        			this.setEthnicitySystemName(attributesList.item(k).getNodeValue());
			        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("displayName"))
			        			this.setEthnicity(attributesList.item(k).getNodeValue());
			        		if(this.getEthnicity()!=""){
			        			ethnicities.add(this.getEthnicity());
			        		}
			        	}
		        	}
	        	}
	        	this.setRace("");
	        	races = new ArrayList<String>();
	        	raceCodes = new ArrayList<String>();
	        	for(int r = 0; r < 18;r++){
		        	if(eElement.getElementsByTagName("raceCode").item(r)!=null){
			        	attributesList = eElement.getElementsByTagName("raceCode").item(r).getAttributes();
			        	for(int k=0;k<attributesList.getLength();k++){
			        		System.out.println("Attribute: "
			                        + attributesList.item(k).getNodeName() + " = "
			                        + attributesList.item(k).getNodeValue());
			        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("code"))
			        			this.setRaceCode(attributesList.item(k).getNodeValue());
			        		if(this.getRaceCode()!=""){
			        			raceCodes.add(this.getRaceCode());
			        		}
			        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName"))
			        			this.setRaceCodeSystemName(attributesList.item(k).getNodeValue());
			        		if(attributesList.item(k).getNodeName().equalsIgnoreCase("displayName"))
			        			this.setRace(attributesList.item(k).getNodeValue());
			        		if(this.getRace()!=""){
			        			races.add(this.getRace());
			        		}
			        	}
		        	}
	        	}
	        	this.setParentId(""); this.setRelativeId("");
	        	if((eElement.getElementsByTagName("id").item(0)!=null)&&(eElement.getElementsByTagName("id").item(1)!=null)){
		        	attributesList = eElement.getElementsByTagName("id").item(0).getAttributes();
		        	for(int k=0;k<attributesList.getLength();k++){
		        		System.out.println("Attribute: "
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        		this.setParentId(attributesList.item(k).getNodeValue());
		        	}
		        	if(eElement.getElementsByTagName("id").item(1)!=null){
		        	attributesList = eElement.getElementsByTagName("id").item(1).getAttributes();
		        	for(int k=0;k<attributesList.getLength();k++){
		        		System.out.println("Attribute: "
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        		this.setRelativeId(attributesList.item(k).getNodeValue());
		        	}
		        	}
	        	}else{
	        		attributesList = eElement.getElementsByTagName("id").item(0).getAttributes();
		        	for(int k=0;k<attributesList.getLength();k++){
		        		System.out.println("Attribute: "
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        		this.setRelativeId(attributesList.item(k).getNodeValue());
		        	}
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
//	        		List<String> conList = new ArrayList<String>();
//	        		List<String> conCodeList = new ArrayList<String>();
	        		twinStatus = ""; adopted = false;
	        		if(eElement.getElementsByTagName("code").item(0)!=null){
	        			attributesList = eElement.getElementsByTagName("code").item(0).getAttributes();
	        			for(int k=0;k<attributesList.getLength();k++){
	        				System.out.println(" twin condition Attribute: " + k + ":" 
			                        + attributesList.item(k).getNodeName() + " = "
			                        + attributesList.item(k).getNodeValue());
	        				if(attributesList.item(k).getNodeValue().contains("Fraternal twin")){
	        					this.setTwinStatus("FRATERNAL");
	        				}
	        				if(attributesList.item(k).getNodeValue().contains("Identical twin")){
	        					this.setTwinStatus("IDENTICAL");
	        				}
	        				if(attributesList.item(k).getNodeValue().contains("adopted")){
	        					this.setAdopted(true);
	        				}
	        			}
	        		}
	        		
	        		for(int d = 0;d<25;d++){
	        			this.setEstimatedAge("");
			        		if(eElement.getElementsByTagName("code").item(d)!=null){
			        			for(int k=0;k<attributesList.getLength();k++){
				        		attributesList = eElement.getElementsByTagName("code").item(d).getAttributes();
				        		System.out.println("condition Attribute: " + k + ":" 
				                        + attributesList.item(k).getNodeName() + " = "
				                        + attributesList.item(k).getNodeValue());
				        		if(attributesList.item(k).getNodeValue().contains("Fraternal twin")){
		        					this.setTwinStatus("FRATERNAL");
		        				}else if(attributesList.item(k).getNodeValue().contains("Identical twin")){
		        					this.setTwinStatus("IDENTICAL");
		        				}else if(attributesList.item(k).getNodeValue().contains("adopted")){
		        					this.setAdopted(true);
		        				}else{
		        					if(attributesList.item(k).getNodeValue().equalsIgnoreCase("death")){
			        					this.setResolution("death");
			        				}
//				        		if(!(attributesList.item(k).getNodeValue().equalsIgnoreCase("Age at Death"))){
				        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("originalText")){
				        				if(attributesList.item(k).getNodeValue().equalsIgnoreCase("pre-birth")){
				        					this.setEstimatedAge("prebirth");
				        					System.out.println("prebirth=="+this.getEstimatedAge());
				        					estimatedAgeList.add(this.getEstimatedAge());
				        				}else{
					        				this.setCondition(attributesList.item(k).getNodeValue());
					        				if(this.getCondition()!=""){
					        					conList.add(this.getCondition());
					        				}
				        				}
				        			}
				        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("codeSystemName")){
				        				this.setConditionCodeSystemName(attributesList.item(k).getNodeValue());
				        				this.setConditionCodeSystemName(attributesList.item(k).getNodeValue());
				        			}
				        			if(attributesList.item(k).getNodeName().equalsIgnoreCase("code")){
				        				
					        				this.setConditionCode(attributesList.item(k).getNodeValue());
					        				this.setDeathConditionCode(attributesList.item(k).getNodeValue());
					        				if(this.getConditionCode()!=""){
					        					conCodeList.add(this.getConditionCode());
					        				
				        				}
				        			}
			        			}
			        			}
			        		}
	        		}
	        		if(eElement.getElementsByTagName("low").item(0)!=null){
	        			attributesList = eElement.getElementsByTagName("low").item(0).getAttributes();
	        			for(int k=0;k<attributesList.getLength();k++){
	        				System.out.println("low relative attributes: "+ attributesList.item(k).getNodeName() + " = "
			                        + attributesList.item(k).getNodeValue());
	        				this.setAgeRangeLow(attributesList.item(k).getNodeValue());
	        			}
	        		}
	        		if(eElement.getElementsByTagName("high").item(0)!=null){
	        			attributesList = eElement.getElementsByTagName("high").item(0).getAttributes();
	        			for(int k=0;k<attributesList.getLength();k++){
	        				System.out.println("high relative attributes: "+ attributesList.item(k).getNodeName() + " = "
			                        + attributesList.item(k).getNodeValue());
	        				this.setAgeRangeHigh(attributesList.item(k).getNodeValue());
	        			}
	        		}
	        		
	        		 if((this.getAgeRangeLow().equals("0"))&&(this.getAgeRangeHigh().equals("28"))){
							this.setEstimatedAge("newborn");
						}else if((this.getAgeRangeLow().equals("29"))&&(this.getAgeRangeHigh().equals("729"))){
							this.setEstimatedAge("infant");
						}else if((this.getAgeRangeLow().equals("2"))&&(this.getAgeRangeHigh().equals("10"))){
							this.setEstimatedAge("child");
						}else if((this.getAgeRangeLow().equals("11"))&&(this.getAgeRangeHigh().equals("19"))){
							this.setEstimatedAge("teen");
						}else if((this.getAgeRangeLow().equals("20"))&&(this.getAgeRangeHigh().equals("29"))){
							this.setEstimatedAge("twenties");
						}else if((this.getAgeRangeLow().equals("30"))&&(this.getAgeRangeHigh().equals("39"))){
							this.setEstimatedAge("thirties");
						}else if((this.getAgeRangeLow().equals("40"))&&(this.getAgeRangeHigh().equals("49"))){
							this.setEstimatedAge("fourties");
						}else if((this.getAgeRangeLow().equals("50"))&&(this.getAgeRangeHigh().equals("59"))){
							this.setEstimatedAge("fifties");
						}else if(this.getAgeRangeLow().equals("60")){
							this.setEstimatedAge("sixties");
						}else{
							this.setEstimatedAge("unknown");
						}
					if(this.getEstimatedAge()!=""){
						estimatedAgeList.add(this.getEstimatedAge());
					}
							
	        	}
	        	for(int e = 0; e< estimatedAgeList.size();e++){
					System.out.println("estimated ages =="+estimatedAgeList.get(e));
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
			for(int d = 0;d < conList.size();d++){
				infoBuilder.append("<condition><name><text>").append(conList.get(d)).append("</text>");
				infoBuilder.append("<code>");
				infoBuilder.append("<value>").append(conCodeList.get(d)).append("</value>");
				infoBuilder.append("<family>urn:gov.familyhistory.hl7</family>");
				infoBuilder.append("<type>").append(this.getConditionCodeSystemName()).append("</type>");
				infoBuilder.append("<version>3</version>");
				infoBuilder.append("</code>");
				infoBuilder.append("<code>");
				if(estimatedAgeList.size()>0){
					infoBuilder.append("<value>ageRange.").append(estimatedAgeList.get(0)).append("</value>");
				}else{
					infoBuilder.append("<value>ageRange.unknown</value>");
				}
				infoBuilder.append("<family>hhs</family>");
				infoBuilder.append("<type>hhs-onset-date-codes</type>");
				infoBuilder.append("<version>3</version>");
				infoBuilder.append("</code>");
				infoBuilder.append("</name>");
				if(this.getResolution()!=""){
					infoBuilder.append("<resolution>death</resolution>");
				}
				infoBuilder.append("</condition>");
			}
//			if(this.getResolution()!=""){
//				infoBuilder.append("<condition><name><text>").append(getDeathCondition()).append("</text>");
//				infoBuilder.append("<code>");
//				infoBuilder.append("<value>").append(this.getDeathConditionCode()).append("</value>");
//				infoBuilder.append("<family>urn:gov.familyhistory.hl7</family>");
//				infoBuilder.append("<type>").append(this.getDeathConditionSystemName()).append("</type>");
//				infoBuilder.append("<version>3</version>");
//				infoBuilder.append("</code>");
//				infoBuilder.append("<code>");
//				if(estimatedAgeList.size()>0){
//					infoBuilder.append("<value>ageRange.").append(estimatedAgeList.get(0)).append("</value>");
//				}else{
//					infoBuilder.append("<value>ageRange.unknown</value>");
//				}
//				infoBuilder.append("<family>hhs</family>");
//				infoBuilder.append("<type>hhs-onset-date-codes</type>");
//				infoBuilder.append("<version>3</version>");
//				infoBuilder.append("</code>");
//				infoBuilder.append("</name><resolution>death</resolution></condition>");
//				
//			}
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
	        if(this.getTwinStatus().equalsIgnoreCase("IDENTICAL")){
	        	infoBuilder.append("<twin>IDENTICAL</twin>");
	        }else if(this.getTwinStatus().equalsIgnoreCase("FRATERNAL")){
	        	infoBuilder.append("<twin>FRATERNAL</twin>");
	        }else{
	        	infoBuilder.append("<twin>NO</twin>");
	        }
	        if(adopted){
	        	infoBuilder.append("<adopted>true</adopted>");
	        }else{
	        	infoBuilder.append("<adopted>false</adopted>");
	        }
	        for(int r=0;r<races.size();r++){
		        infoBuilder.append("<races version=\""+"1.0"+ "\">");
		        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+races.get(r) +"\" type=\""+this.getRaceCodeSystemName() +"\" value=\""+raceCodes.get(r) +"\" version=\""+"3"+"\"/>");
		        infoBuilder.append("</races>");
	        }
	        for(int e=0;e<ethnicities.size();e++){
		        infoBuilder.append("<ethnicities>");
		        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+ethnicities.get(e) +"\" type=\""+this.getEthnicitySystemName() +"\" value=\""+ethnicityCodes.get(e) +"\" version=\""+"3"+"\"/>");
		        infoBuilder.append("</ethnicities>");
	        }
	        infoBuilder.append("<consanguinity>false</consanguinity>");
	        infoBuilder.append("</fhh-extensions>");
	        infoBuilder.append("</extension>");
	        if(this.getParentId()!=""){
		        infoBuilder.append("<related-thing>");
		        infoBuilder.append("<client-thing-id>"+this.getParentId()+"</client-thing-id>");
		        infoBuilder.append("<relationship-type>PAR</relationship-type>");
		        infoBuilder.append("</related-thing>");
	        }
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
//		System.out.println("Checking if family history exists");
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
//		System.out.println("FamilyHistory removed successfully");
		
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
