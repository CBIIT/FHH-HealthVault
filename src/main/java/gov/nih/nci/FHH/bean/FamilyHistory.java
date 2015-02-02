package gov.nih.nci.FHH.bean;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.Marshaller;
import gov.nih.nci.FHH.RequestTemplate;
import gov.nih.nci.FHH.util.XmlDocument;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
//	private List<String> races;
//	private List<String> raceCodes;
	private String consanguinity;
	private String dobAgeLow = "";
	private String dobAgeHigh = "";
	List<Map<String, Object>> conditions = new ArrayList<Map<String,Object>>();
	List<Map<String, Object>> ethnicities = new ArrayList<Map<String,Object>>();
	List<Map<String, Object>> races = new ArrayList<Map<String,Object>>();
	
	public String getDobAgeLow() {
		return dobAgeLow;
	}
	public void setDobAgeLow(String dobAgeLow) {
		this.dobAgeLow = dobAgeLow;
	}
	public String getDobAgeHigh() {
		return dobAgeHigh;
	}
	public void setDobAgeHigh(String dobAgeHigh) {
		this.dobAgeHigh = dobAgeHigh;
	}
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
		for (int i = 0;null!=nodeList && i <= 100; i++) {
			if(id != null && !id.equals("")) {
			this.setId("");this.setVersionStamp("");
			getPersonalInfo(authToken);
			this.checkFamilyHistoryExists(authToken);
			}else{
				break;
			}
		}
		
		StringBuilder infoBuilder = new StringBuilder();

		infoBuilder.append("<info>");
       
		for (int i = 0;null!=nodeList && i < nodeList.getLength(); i++) {
			
	        
	        if(i==0){
	        	this.setConsanguinity("false");
	        	 conditions = new ArrayList<Map<String,Object>>();
	        	WeightInfo weight = new WeightInfo();
				HeightInfo height = new HeightInfo();
				this.setWeight(weight.weight);
				this.setWeightUnit(weight.weightUnit);
				this.setHeight(height.getHeight());
				this.setHeightUnit(height.getHeightUnit());
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
					NodeList nodeList2 = (NodeList) xPath.compile(expr).evaluate(doc, XPathConstants.NODESET);
					for (int m = 0;null!=nodeList2 && m < nodeList2.getLength(); m++) {
						Map<String, Object> conditionMap = new HashMap<String, Object>();
						Node clinicalObservation = nodeList2.item(m);
						Node condition = clinicalObservation.getFirstChild();
						if(condition.hasAttributes()){
							NamedNodeMap nodeMap = condition.getAttributes();
							for(int n = 0; n<nodeMap.getLength();n++){
								Node tempNode = nodeMap.item(n);
		    					System.out.println("Attribute Proband Name : "+tempNode.getNodeName()+"Attribute Proband Value : "+tempNode.getNodeValue());
		    					if((tempNode.getNodeValue().contains("Fraternal twin"))&&(tempNode.getNodeName().equalsIgnoreCase("displayName"))){
		        					this.setTwinStatus("FRATERNAL");
		        					conditionMap.put("displayName", "FRATERNAL");
		        				}else if((tempNode.getNodeValue().contains("Identical twin"))&&(tempNode.getNodeName().equalsIgnoreCase("displayName"))){
		        					this.setTwinStatus("IDENTICAL");
		        					conditionMap.put("displayName", "IDENTICAL");
		        				}else if((tempNode.getNodeValue().contains("adopted"))&&(tempNode.getNodeName().equalsIgnoreCase("displayName"))){
		        					this.setAdopted(true);
		        					conditionMap.put("displayName", "adopted");
		        				}else{
			    					if(tempNode.getNodeName().equalsIgnoreCase("displayName")){
			    						conditionMap.put("displayName", tempNode.getNodeValue());
			    					}
			    					if(tempNode.getNodeName().equalsIgnoreCase("codeSystemName")){
			    						conditionMap.put("conditionCodeSystemName", tempNode.getNodeValue());
			    					}
			    					if(tempNode.getNodeName().equalsIgnoreCase("code")){
			    						if(tempNode.getNodeValue().equalsIgnoreCase("other")){
			    							conditionMap.put("conditionCode", "EMPTY");
			    	    				}
			    						conditionMap.put("conditionCode", tempNode.getNodeValue());
			    					}
			    					if(tempNode.getNodeName().equalsIgnoreCase("originalText")){
			    						if(tempNode.getNodeValue().equalsIgnoreCase("Parental consanguinity indicated")){
				        					this.setConsanguinity("true");
				        				}else{
				        					conditionMap.put("condition", tempNode.getNodeValue());
				        				}
			    					}
		        				}
							}
						}
						
						if(condition.getNextSibling()!=null){
		        			if(condition.getNextSibling().getNodeName().contains("subject")){
			        			Node subject = condition.getNextSibling();
			        			Node dataEstimatedAge = subject.getFirstChild();
			        			Node estimateAge = dataEstimatedAge.getFirstChild();
			        			if(estimateAge.hasAttributes()){
			        				NamedNodeMap nodeMap = estimateAge.getAttributes();
			        				for(int a = 0; a<nodeMap.getLength();a++){
			        					Node tempNode = nodeMap.item(a);
				    					System.out.println("Attribute Name : "+tempNode.getNodeName()+"Attribute Value : "+tempNode.getNodeValue());
				    					if(tempNode.getNodeName().equalsIgnoreCase("originalText")){
				    						if(tempNode.getNodeValue().equalsIgnoreCase("pre-birth")){
				    							conditionMap.put("ageAtDiagnosis", "prebirth");
				    						}else if(tempNode.getNodeValue().equalsIgnoreCase("unknown")){
				    							conditionMap.put("ageAtDiagnosis", "Unknown");
				    						}
				    					}
			        				}
			        			}
			        			if(estimateAge.getNextSibling()!=null){
			        			if(estimateAge.getNextSibling().getNodeName().contains("value")){
			        				Node value = estimateAge.getNextSibling();
			        				if(value.getFirstChild()!=null){
			        					Node low = value.getFirstChild();
			        					if(low.hasAttributes()){
			        						NamedNodeMap nodeMap = low.getAttributes();
			        						for(int a = 0; a<nodeMap.getLength();a++){
					        					Node tempNode = nodeMap.item(a);
						    					System.out.println("Attribute low Name : "+tempNode.getNodeName()+"Attribute low Value : "+tempNode.getNodeValue());
						    					this.setAgeRangeLow(tempNode.getNodeValue());
			        						}
			        					}
			        				}
			        				if(value.getLastChild()!=null){
			        					Node high = value.getLastChild();
			        					if(high.hasAttributes()){
			        						NamedNodeMap nodeMap = high.getAttributes();
			        						for(int a = 0; a<nodeMap.getLength();a++){
					        					Node tempNode = nodeMap.item(a);
						    					System.out.println("Attribute high Name : "+tempNode.getNodeName()+"Attribute high Value : "+tempNode.getNodeValue());
						    					this.setAgeRangeHigh(tempNode.getNodeValue());
			        						}
			        					}
			        				}
			        				conditionMap.put("ageAtDiagnosis", calculateDiagnosisAge(this.getAgeRangeLow(),this.getAgeRangeHigh()));
			        			}
		        			}
			        		}
					}
						conditions.add(conditionMap);
					}
					Iterator<Map<String, Object>> itr = conditions.iterator();
					while(itr.hasNext()){
						Map<String, Object> condMap = itr.next();
						if((condMap.get("displayName")!=null)&&(condMap.get("condiiton")!=null)){
			        		if((condMap.get("displayName").equals("FRATERNAL"))||(condMap.get("displayName").equals("IDENTICAL"))||(condMap.get("displayName").equals("adopted"))||(condMap.get("displayName").equals("height"))||(condMap.get("displayName").equals("weight"))||(condMap.get("condition").equals("Parental consanguinity indicated"))||(condMap.get("displayName").equals("Physically Active"))){
			        			itr.remove();
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
				ethnicities = new ArrayList<Map<String,Object>>();
				
				for(int e=0; e<10;e++){
					Map<String, Object> ethnicityMap = new HashMap<String, Object>();
				expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode["+e+"]/@displayName";
					String ethnicity = xPath.compile(expr).evaluate(doc);
					ethnicityMap.put("ethnicity", ethnicity);
					expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode["+e+"]/@code";
					String ethCode = xPath.compile(expr).evaluate(doc);
					ethnicityMap.put("ethnicityCode", ethCode);
					expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode["+e+"]/@codeSystemName";
					String ethname = xPath.compile(expr).evaluate(doc);
					ethnicityMap.put("ethnicityCodeSystemName", ethname);
					ethnicities.add(ethnicityMap);
				}
				
				races = new ArrayList<Map<String,Object>>();
				for(int r = 0; r<18;r++){
					Map<String, Object> raceMap = new HashMap<String, Object>();
					expr = "/FamilyHistory/subject/patient/patientPerson/raceCode["+r+"]/@displayName";
					String race = xPath.compile(expr).evaluate(doc);
					raceMap.put("race", race);
					expr = "/FamilyHistory/subject/patient/patientPerson/raceCode["+r+"]/@code";
					String raceCode = xPath.compile(expr).evaluate(doc);
					raceMap.put("raceCode", raceCode);
					expr = "/FamilyHistory/subject/patient/patientPerson/raceCode["+r+"]/@codeSystemName";
					String racename = xPath.compile(expr).evaluate(doc);
					raceMap.put("raceCodeSystemName", racename);
					races.add(raceMap);
				}
				
				expr = "/FamilyHistory/subject/patient/patientPerson/id/@extension";
				String id = xPath.compile(expr).evaluate(doc);
				setSelfId(id);
			
	        	infoBuilder.append("<type-id>");
		        infoBuilder.append(FamilyHistory.familyHistoryType);
		        infoBuilder.append("</type-id>");
				infoBuilder.append("<data-xml><family-history>");
				for(int t=0;t<conditions.size();t++){
					Map<String, Object> condMap = conditions.get(t);
					if(condMap.get("condition")!=null){
						infoBuilder.append("<condition><name><text>").append(condMap.get("condition")).append("</text>");
						infoBuilder.append("<code>");
						infoBuilder.append("<value>").append(condMap.get("conditionCode")).append("</value>");
						infoBuilder.append("<family>urn:gov.familyhistory.hl7</family>");
						infoBuilder.append("<type>").append(condMap.get("conditionCodeSystemName")).append("</type>");
						infoBuilder.append("<version>3</version>");
						infoBuilder.append("</code>");
						infoBuilder.append("<code>");
						infoBuilder.append("<value>ageRange.").append(condMap.get("ageAtDiagnosis")).append("</value>");
						infoBuilder.append("<family>hhs</family>");
						infoBuilder.append("<type>hhs-onset-date-codes</type>");
						infoBuilder.append("<version>3</version>");
						infoBuilder.append("</code>");
						infoBuilder.append("</name></condition>");
					}
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
			        infoBuilder.append("<pounds>"+this.getWeight()+"</pounds>");
			        infoBuilder.append("<kilograms />");
		        }else{
		        	infoBuilder.append("<pounds />");
			        infoBuilder.append("<kilograms>"+this.getWeight()+"</kilograms>");
		        }
		        infoBuilder.append("</weight>");
		        for(int r =0; r<races.size();r++){
		        	Map<String, Object> race = races.get(r);
		        	if(race.get("race")!=""){
				        infoBuilder.append("<races version=\""+"1.0"+ "\">");
				        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+race.get("race") +"\" type=\""+race.get("raceCodeSystemName") +"\" value=\""+race.get("raceCode") +"\" version=\""+"3"+"\"/>");
				        infoBuilder.append("</races>");
		        	}
		        }
		        for(int e =0; e<ethnicities.size();e++){
		        	Map<String, Object> ethnicity = ethnicities.get(e);
		        	if(ethnicity.get("ethnicity")!=""){
				        infoBuilder.append("<ethnicities>");
				        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+ethnicity.get("ethnicity") +"\" type=\""+ethnicity.get("ethnicityCodeSystemName") +"\" value=\""+ethnicity.get("ethnicityCode") +"\" version=\""+"3"+"\"/>");
				        infoBuilder.append("</ethnicities>");
		        	}
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

	        }
			Node node = nodeList.item(i);
			
			conditions = new ArrayList<Map<String,Object>>();
    		
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
	        	ethnicities = new ArrayList<Map<String,Object>>();
	        	for(int e = 0; e< 10;e++){
		        	if(eElement.getElementsByTagName("ethnicGroupCode").item(e)!=null){
		        		Map<String, Object> ethnicity = new HashMap<String, Object>();
		        		Node ethnicGroupCode = eElement.getElementsByTagName("ethnicGroupCode").item(e);
		        		if(ethnicGroupCode.hasAttributes()){
		        			NamedNodeMap nodeMap = ethnicGroupCode.getAttributes();
		        			for(int k = 0;k<nodeMap.getLength();k++){
		        				Node tempNode = nodeMap.item(k);
		    					System.out.println("Attribute ethinicity Name : "+tempNode.getNodeName()+"Attribute ethnicity Value : "+tempNode.getNodeValue());
		    					if(tempNode.getNodeName().equalsIgnoreCase("code")){
		    						ethnicity.put("ethnicityCode", tempNode.getNodeValue());
		    					}
		    					if(tempNode.getNodeName().equalsIgnoreCase("codeSystemName")){
		    						ethnicity.put("ethnicityCodeSystemName", tempNode.getNodeValue());
		    					}
		    					if(tempNode.getNodeName().equalsIgnoreCase("displayName")){
		    						ethnicity.put("ethnicity", tempNode.getNodeValue());
		    					}
		        			}
		        		}
		        		ethnicities.add(ethnicity);
		        	}
		        	
	        	}
	        	this.setRace("");
	        	races = new ArrayList<Map<String,Object>>();
	        	for(int r = 0; r < 18;r++){
		        	if(eElement.getElementsByTagName("raceCode").item(r)!=null){
		        		Map<String, Object> race = new HashMap<String, Object>();
		        		Node raceCode = eElement.getElementsByTagName("raceCode").item(r);
		        		if(raceCode.hasAttributes()){
		        			NamedNodeMap nodeMap = raceCode.getAttributes();
		        			for(int k = 0;k<nodeMap.getLength();k++){
		        				Node tempNode = nodeMap.item(k);
		    					System.out.println("Attribute race Name : "+tempNode.getNodeName()+"Attribute race Value : "+tempNode.getNodeValue());
		    					if(tempNode.getNodeName().equalsIgnoreCase("code")){
		    						race.put("raceCode", tempNode.getNodeValue());
		    					}
		    					if(tempNode.getNodeName().equalsIgnoreCase("codeSystemName")){
		    						race.put("raceCodeSystemName", tempNode.getNodeValue());
		    					}
		    					if(tempNode.getNodeName().equalsIgnoreCase("displayName")){
		    						race.put("race", tempNode.getNodeValue());
		    					}
		        			}
		        		}
		        		races.add(race);
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
	        	}else if(eElement.getElementsByTagName("id").item(0)!=null){
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
	        	
	        	this.setBirthDate("");
	        	if(eElement.getElementsByTagName("deceasedIndCode").item(0)!=null){
		        	attributesList = eElement.getElementsByTagName("deceasedIndCode").item(0).getAttributes();
		        	for(int k=0;k<attributesList.getLength();k++){
		        		System.out.println("Attribute: "
		                        + attributesList.item(k).getNodeName() + " = "
		                        + attributesList.item(k).getNodeValue());
		        		if(attributesList.item(k).getNodeValue().contains("UNKNOWN")){
		        			this.setBirthDate("Unknown");
		        		}
		        	}
	        	}
	        	if(node.getLastChild().getLastChild().getNodeName().contains("dataEstimatedAge")){
	        		Node dobEstimated = node.getLastChild().getLastChild();
	        		System.out.println("DOB nodes "+dobEstimated.getFirstChild().getNodeName());
	        		
	        		if(dobEstimated.getFirstChild().getNodeName().equalsIgnoreCase("code")){
		        		attributesList = dobEstimated.getFirstChild().getAttributes();
		        		for(int k=0;k<attributesList.getLength();k++){
	        				System.out.println("DOB code attributes: "+ attributesList.item(k).getNodeName() + " = "
			                        + attributesList.item(k).getNodeValue());
	        				if(attributesList.item(k).getNodeName().equalsIgnoreCase("originalText")){
	        					this.setBirthDate("");
		        				if(attributesList.item(k).getNodeValue().equalsIgnoreCase("pre-birth")){
		        					this.setBirthDate("ageRange.prebirth");
		        				}
		        				if(attributesList.item(k).getNodeValue().equalsIgnoreCase("unknown")){
		        					this.setBirthDate("ageRange.Unknown");
		        				}
		        			}
	        			}
		        	}
	        		this.setDobAgeLow(""); this.setDobAgeHigh("");
	        		if((dobEstimated.getFirstChild().getNextSibling()!=null)&&(dobEstimated.getFirstChild().getNextSibling().getNodeName().contains("value"))){
		        		Node value = dobEstimated.getFirstChild().getNextSibling();
		        		if(value.getFirstChild()!=null){
		        			Node low = value.getFirstChild();
        					if(low.hasAttributes()){
        						NamedNodeMap nodeMap = low.getAttributes();
        						for(int a = 0; a<nodeMap.getLength();a++){
		        					Node tempNode = nodeMap.item(a);
			    					System.out.println("Attribute DOB low Name : "+tempNode.getNodeName()+"Attribute low Value : "+tempNode.getNodeValue());
			    					this.setDobAgeLow(tempNode.getNodeValue());
        						}
        					}
		        		}
		        		if(value.getLastChild()!=null){
        					Node high = value.getLastChild();
        					if(high.hasAttributes()){
        						NamedNodeMap nodeMap = high.getAttributes();
        						for(int a = 0; a<nodeMap.getLength();a++){
		        					Node tempNode = nodeMap.item(a);
			    					System.out.println("Attribute DOB high Name : "+tempNode.getNodeName()+"Attribute high Value : "+tempNode.getNodeValue());
			    					this.setDobAgeHigh(tempNode.getNodeValue());
        						}
        					}
        				}
		        	}
		        	if((this.getDobAgeLow().equals("0"))&&(this.getDobAgeHigh().equals("28"))){
						this.setBirthDate("ageRange.newborn");
					}else if((this.getDobAgeLow().equals("29"))&&(this.getDobAgeHigh().equals("729"))){
						this.setBirthDate("ageRange.infant");
					}else if((this.getDobAgeLow().equals("2"))&&(this.getDobAgeHigh().equals("10"))){
						this.setBirthDate("ageRange.child");
					}else if((this.getDobAgeLow().equals("11"))&&(this.getDobAgeHigh().equals("19"))){
						this.setBirthDate("ageRange.teen");
					}else if((this.getDobAgeLow().equals("20"))&&(this.getDobAgeHigh().equals("29"))){
						this.setBirthDate("ageRange.twenties");
					}else if((this.getDobAgeLow().equals("30"))&&(this.getDobAgeHigh().equals("39"))){
						this.setBirthDate("ageRange.thirties");
					}else if((this.getDobAgeLow().equals("40"))&&(this.getDobAgeHigh().equals("49"))){
						this.setBirthDate("ageRange.fourties");
					}else if((this.getDobAgeLow().equals("50"))&&(this.getDobAgeHigh().equals("59"))){
						this.setBirthDate("ageRange.fifties");
					}else if(this.getDobAgeLow().equals("60")){
						this.setBirthDate("ageRange.sixties");
					}else{
						this.setBirthDate("ageRange.Unknown");
					}
	        	}
	        	
	        	
	        	this.setCondition("");
        		twinStatus = ""; adopted = false;
        		for(int c = 0;c < 50; c++){
	        	if(eElement.getElementsByTagName("clinicalObservation").item(c)!=null){
	        		Map<String, Object> conditionMap = new HashMap<String, Object>();
	        		Node clinicalObservation = eElement.getElementsByTagName("clinicalObservation").item(c);
	        		Node condition = clinicalObservation.getFirstChild();
	        		if(condition.hasAttributes()){
	        			NamedNodeMap nodeMap = condition.getAttributes();
	        			for(int n = 0; n<nodeMap.getLength();n++){
	        				Node tempNode = nodeMap.item(n);
	    					System.out.println("Attribute Name : "+tempNode.getNodeName()+"Attribute Value : "+tempNode.getNodeValue());
	    					if((tempNode.getNodeValue().contains("Fraternal twin"))&&(tempNode.getNodeName().equalsIgnoreCase("displayName"))){
	        					this.setTwinStatus("FRATERNAL");
	        					conditionMap.put("condition", "FRATERNAL");
	        				}else if((tempNode.getNodeValue().contains("Identical twin"))&&(tempNode.getNodeName().equalsIgnoreCase("displayName"))){
	        					this.setTwinStatus("IDENTICAL");
	        					conditionMap.put("condition", "IDENTICAL");
	        				}else if((tempNode.getNodeValue().contains("adopted"))&&(tempNode.getNodeName().equalsIgnoreCase("displayName"))){
	        					this.setAdopted(true);
	        					conditionMap.put("condition", "adopted");
	        				}else{
	        					
	        					if(tempNode.getNodeName().contains("originalText")){
	        						this.setCondition(tempNode.getNodeValue());
				        			if(this.getCondition()!=""){
				        				conditionMap.put("condition",tempNode.getNodeValue());
				        			}
			        			}
	        					if(tempNode.getNodeName().equalsIgnoreCase("codeSystemName")){
			        				this.setConditionCodeSystemName(tempNode.getNodeValue());
			        				conditionMap.put("conditionCodeSystem", tempNode.getNodeValue());
			        			}
			        			if(tempNode.getNodeName().equalsIgnoreCase("code")){
			        					this.setConditionCode(tempNode.getNodeValue());
				        				if(this.getConditionCode().equalsIgnoreCase("OTHER")){
				        					conditionMap.put("conditionCode", "EMPTY");
				        				}else{
				        					conditionMap.put("conditionCode", tempNode.getNodeValue());
				        				}
				        			}
	        				  }
	        			}
	        			if(condition.getNextSibling()!=null){
		        			if(condition.getNextSibling().getNodeName().contains("subject")){
			        			Node subject = condition.getNextSibling();
			        			Node dataEstimatedAge = subject.getFirstChild();
			        			Node estimatedAge = dataEstimatedAge.getFirstChild();
			        			if(estimatedAge.hasAttributes()){
			        				nodeMap = estimatedAge.getAttributes();
			        				for(int a = 0; a<nodeMap.getLength();a++){
			        					Node tempNode = nodeMap.item(a);
				    					System.out.println("Attribute Name : "+tempNode.getNodeName()+"Attribute Value : "+tempNode.getNodeValue());
				    					if(tempNode.getNodeName().equalsIgnoreCase("originalText")){
				    						if(tempNode.getNodeValue().equalsIgnoreCase("pre-birth")){
				    							conditionMap.put("ageAtDiagnosis", "prebirth");
				    						}else if(tempNode.getNodeValue().equalsIgnoreCase("unknown")){
				    							conditionMap.put("ageAtDiagnosis", "Unknown");
				    						}
				    					}
			        				}
			        			}
			        			if(estimatedAge.getNextSibling()!=null){
			        			if(estimatedAge.getNextSibling().getNodeName().contains("value")){
			        				Node value = estimatedAge.getNextSibling();
			        				if(value.getFirstChild()!=null){
			        					Node low = value.getFirstChild();
			        					if(low.hasAttributes()){
			        						nodeMap = low.getAttributes();
			        						for(int a = 0; a<nodeMap.getLength();a++){
					        					Node tempNode = nodeMap.item(a);
						    					System.out.println("Attribute low Name : "+tempNode.getNodeName()+"Attribute low Value : "+tempNode.getNodeValue());
						    					this.setAgeRangeLow(tempNode.getNodeValue());
			        						}
			        					}
			        				}
			        				if(value.getLastChild()!=null){
			        					Node high = value.getLastChild();
			        					if(high.hasAttributes()){
			        						nodeMap = high.getAttributes();
			        						for(int a = 0; a<nodeMap.getLength();a++){
					        					Node tempNode = nodeMap.item(a);
						    					System.out.println("Attribute high Name : "+tempNode.getNodeName()+"Attribute high Value : "+tempNode.getNodeValue());
						    					this.setAgeRangeHigh(tempNode.getNodeValue());
			        						}
			        					}
			        				}
			        				conditionMap.put("ageAtDiagnosis", calculateDiagnosisAge(this.getAgeRangeLow(),this.getAgeRangeHigh()));
			        			}
		        			}
			        		}else if(condition.getNextSibling().getNodeName().contains("sourceOf")){
			        			//Remove the condition from the conditions list if the condition has a code
			        			String conditionCode = conditionMap.get("conditionCode").toString();
			        			String conditionName = conditionMap.get("condition").toString();
			        			if(conditionCode.matches("^[0-9]*$")){
			        				Iterator<Map<String, Object>> itr = conditions.iterator();
			    					while(itr.hasNext()){
			    						Map<String, Object> condMap = itr.next();
			        					if(conditionName.equals(condMap.get("condition"))){
			        						itr.remove();
			        					}
			        				}
//			        				conditions.remove(conditions.remove(conditions.size()-1));
			        			}
			        			Node sourceOf = condition.getNextSibling();
			        			Node death = sourceOf.getFirstChild();
			        			if(death.hasAttributes()){
			        				nodeMap = death.getAttributes();
			        				for(int a = 0; a<nodeMap.getLength();a++){
			        					Node tempNode = nodeMap.item(a);
				    					System.out.println("Attribute Name : "+tempNode.getNodeName()+"Attribute Value : "+tempNode.getNodeValue());
				    					if(tempNode.getNodeValue().equalsIgnoreCase("death")){
				    						this.setResolution("death");
				    						conditionMap.put("resolution", "death");
				    					}
			        				}
			        			}
			        			if(eElement.getElementsByTagName("deceasedEstimatedAge").item(0)!=null){
			        				Node deceasedEstimatedAge = eElement.getElementsByTagName("deceasedEstimatedAge").item(0);
			        				Node deathAge = deceasedEstimatedAge.getFirstChild();
			        				if(deathAge.hasAttributes()){
				        				nodeMap = deathAge.getAttributes();
				        				for(int a = 0; a<nodeMap.getLength();a++){
				        					Node tempNode = nodeMap.item(a);
					    					System.out.println("Attribute Name : "+tempNode.getNodeName()+"Attribute Value : "+tempNode.getNodeValue());
					    					if(tempNode.getNodeName().equalsIgnoreCase("originalText")){
					    						if(tempNode.getNodeValue().equalsIgnoreCase("pre-birth")){
					    							conditionMap.put("ageAtDiagnosis", "prebirth");
					    						}else if(tempNode.getNodeValue().equalsIgnoreCase("unknown")){
					    							conditionMap.put("ageAtDiagnosis", "Unknown");
					    						}
					    					}
				        				}
				        			}
			        				if(deathAge.getNextSibling()!=null){
				        				if(deathAge.getNextSibling().getNodeName().contains("value")){
					        				Node value = deathAge.getNextSibling();
					        				if(value.getFirstChild()!=null){
					        					Node low = value.getFirstChild();
					        					if(low.hasAttributes()){
					        						nodeMap = low.getAttributes();
					        						for(int a = 0; a<nodeMap.getLength();a++){
							        					Node tempNode = nodeMap.item(a);
								    					System.out.println("Attribute low Name : "+tempNode.getNodeName()+"Attribute low Value : "+tempNode.getNodeValue());
								    					this.setAgeRangeLow(tempNode.getNodeValue());
					        						}
					        					}
					        				}
					        				if(value.getLastChild()!=null){
					        					Node high = value.getLastChild();
					        					if(high.hasAttributes()){
					        						nodeMap = high.getAttributes();
					        						for(int a = 0; a<nodeMap.getLength();a++){
							        					Node tempNode = nodeMap.item(a);
								    					System.out.println("Attribute high Name : "+tempNode.getNodeName()+"Attribute high Value : "+tempNode.getNodeValue());
								    					this.setAgeRangeHigh(tempNode.getNodeValue());
					        						}
					        					}
					        				}
					        				conditionMap.put("ageAtDiagnosis", calculateDiagnosisAge(this.getAgeRangeLow(),this.getAgeRangeHigh()));
					        			}
			        				}
			        			}
			        		}
	        			}
	        		}
					conditions.add(conditionMap);
	        	}
    		}
	        	for(int d = 0; d< conditions.size();d++){
	        		Map<String, Object> condMap = conditions.get(d);
	        		if((condMap.get("condition").equals("FRATERNAL"))||(condMap.get("condition").equals("IDENTICAL"))||(condMap.get("condition").equals("adopted"))){
	        			conditions.remove(d);
	        		}
	        	}
	        	
	        	       	
	        	if(eElement.getElementsByTagName("birthTime").item(0)!=null){
	        		this.setBirthDate("");
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
			for(int d = 0;d < conditions.size();d++){
				Map<String, Object> condMap = conditions.get(d);
				infoBuilder.append("<condition><name><text>").append(condMap.get("condition")).append("</text>");
				infoBuilder.append("<code>");
				infoBuilder.append("<value>").append(condMap.get("conditionCode")).append("</value>");
				infoBuilder.append("<family>urn:gov.familyhistory.hl7</family>");
				infoBuilder.append("<type>").append(condMap.get("conditionCodeSystem")).append("</type>");
				infoBuilder.append("<version>3</version>");
				infoBuilder.append("</code>");
				infoBuilder.append("<code>");
				infoBuilder.append("<value>ageRange.").append(condMap.get("ageAtDiagnosis")).append("</value>");
				infoBuilder.append("<family>hhs</family>");
				infoBuilder.append("<type>hhs-onset-date-codes</type>");
				infoBuilder.append("<version>3</version>");
				infoBuilder.append("</code>");
				infoBuilder.append("</name>");
				if(condMap.containsKey("resolution")&&(condMap.get("resolution").equals("death"))){
					infoBuilder.append("<resolution>death</resolution>");
				}
				infoBuilder.append("</condition>");
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

	        infoBuilder.append("<region-of-origin><text /><code><value /><family /><type /><version /></code></region-of-origin >");
	        infoBuilder.append("</relative></family-history>");
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
	        	Map<String, Object> race = races.get(r);
		        infoBuilder.append("<races version=\""+"1.0"+ "\">");
		        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+race.get("race") +"\" type=\""+race.get("raceCodeSystemName") +"\" value=\""+race.get("raceCode") +"\" version=\""+"3"+"\"/>");
		        infoBuilder.append("</races>");
	        }
	        for(int e=0;e<ethnicities.size();e++){
	        	Map<String, Object> ethnicity = ethnicities.get(e);
		        infoBuilder.append("<ethnicities>");
		        infoBuilder.append("<code family=\""+"HL7"+ "\" name=\""+ethnicity.get("ethnicity") +"\" type=\""+ethnicity.get("ethnicityCodeSystemName") +"\" value=\""+ethnicity.get("ethnicityCode") +"\" version=\""+"3"+"\"/>");
		        infoBuilder.append("</ethnicities>");
	        }
	        if(this.getBirthDate()!=""){
	        	infoBuilder.append("<dateOfBirth version=\""+"1.0"+ "\">");
	        	infoBuilder.append("<code>");
	        	infoBuilder.append("<value>"+this.getBirthDate()+"</value>");
        		infoBuilder.append("<family>hhs</family>");
	        	if(this.getBirthDate().contains("/")){
	        		infoBuilder.append("<type>hhs-date-based-exact-age</type>");
	        	}else{
	        		infoBuilder.append("<type>hhs-year-based-age</type>");
	        	}
	        	infoBuilder.append("<version>3</version>");
	        	infoBuilder.append("</code>");
	        	infoBuilder.append("</dateOfBirth>");
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
	        if(this.getRelativeId()!=""){
	        	infoBuilder.append("<client-thing-id>"+this.getRelativeId()+"</client-thing-id>");
	        }
	        infoBuilder.append("</common></data-xml></thing>");

		}
        infoBuilder.append("</info>");
        
        System.out.println(infoBuilder.toString());
        Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);
        
        Request request = new Request();
		request.setMethodName("PutThings");
		request.setInfo(infoBuilder.toString());
		
		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
		template.makeRequest(request, personInfo);
	    
	   	} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		
	
			
	}
	
	private String calculateDiagnosisAge(String ageRangeLow2,
			String ageRangeHigh2) {
		this.setEstimatedAge("");
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
		return this.getEstimatedAge();
		
	}
	private void checkFamilyHistoryExists(String authToken) {
		
		StringBuilder infoBuilder = new StringBuilder();
		if(id != null && !id.equals("")) {
			infoBuilder.append("<info>");
	        System.out.println("There is family history");
	        infoBuilder.append("<thing-id version-stamp=\"");
	        infoBuilder.append(versionStamp + "\">");
	        infoBuilder.append(id);
	        infoBuilder.append("</thing-id>");
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
	

}
