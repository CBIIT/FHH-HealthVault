package gov.nih.nci.FHH.bean;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.Marshaller;
import gov.nih.nci.FHH.RequestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.Request;

public class PersonalDemographicInfo implements Serializable, thing
{
	public static final String PersonalDemographicType = "92ba621e-66b3-4a01-bd73-74844aed4f5b";
	
	private String id = "";
	private String versionStamp = "";
	private String fullName = "";
	private String firstName = "";
	private String lastName = "";
	private String ethnicity = "";
	private String birthDate = "";
	private String gender = "";
	private String ethnicityCode = "";
	private String birthYear = "";
	private String birthMonth = "";
	private String birthDay = "";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFirstName() {
		if( firstName == null || firstName.equals("")) {
			int space = getFullName().indexOf(" ");
			System.out.println("space =="+space);
			if(space>-1){
				this.firstName = getFullName().substring(0,space);
			}
		}
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		if( lastName == null || lastName.equals("")) {
			int space = getFullName().indexOf(" ");
			if(space>-1){
				this.lastName = getFullName().substring(space+1);
			}
		}
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
		
		setEthnicityCode(ethnicity);
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if( gender.equals("male"))
			this.gender = "m";
		else
			this.gender = "f";
	}
	
	public String getEthnicityCode() {
		return ethnicityCode;
	}
	public void setEthnicityCode(String ethnicity) {
		if( ethnicity.equals("American Indian or Alaska Native") )
			this.ethnicityCode = "1";
		else if( ethnicity.equals("Asian") )
			this.ethnicityCode = "2";
		else if( ethnicity.equals("Black or African American") )
			this.ethnicityCode = "3";
		else if( ethnicity.equals("Hispanic or Latino") )
			this.ethnicityCode = "4";
		else if( ethnicity.equals("Native Hawaiian or Other Pacific Islander") )
			this.ethnicityCode = "5";
		else if( ethnicity.equals("White") )
			this.ethnicityCode = "6";
		else if( ethnicity.equals("Mixed Race") )
			this.ethnicityCode = "7";
		else
			this.ethnicityCode = "8";
		
	}
	public String getBirthYear() {
		int slash = getBirthDate().indexOf("/");
		String temp = getBirthDate().substring(slash+1);
		slash = temp.indexOf("/");
		this.birthYear = temp.substring(slash+1);
		return this.birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthMonth() {
		int slash = getBirthDate().indexOf("/");
		this.birthMonth = getBirthDate().substring(0,slash);
		return this.birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDay() {
		int slash = getBirthDate().indexOf("/");
		String temp = getBirthDate().substring(slash+1);
		slash = temp.indexOf("/");
		this.birthDay = temp.substring(0,slash);
		return this.birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getVersionStamp() {
		return versionStamp;
	}
	public void setVersionStamp(String versionStamp) {
		this.versionStamp = versionStamp;
	}
	private void getPersonalInfo(String authToken)
	{
		Request request = new Request();
		request.setMethodName("GetThings");
		request.setInfo("<info><group max=\"30\"><filter><type-id>" +
				PersonalDemographicType +
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
    	            System.out.println("TTTTTTTTTTTTTTTT");
	            	break;
    	        }
				return id;
			}
		});       
	}
	
	private void setupDemographicInfo(String xmlData) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		XPath xPath =  XPathFactory.newInstance().newXPath();
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(xmlData.getBytes("utf-8"))));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//String expr = "/FamilyHistory/subject/patient/patientPerson/id/@extension";
		try {
			//String id = xPath.compile(idExpr).evaluate(doc);
			
			String expr = "/FamilyHistory/subject/patient/patientPerson/name/@formatted";
			String fullName = xPath.compile(expr).evaluate(doc);
			setFullName(fullName);
			
			expr = "/FamilyHistory/subject/patient/patientPerson/birthTime/@value";
			String birthDate = xPath.compile(expr).evaluate(doc);
			setBirthDate(birthDate);
			
			expr = "/FamilyHistory/subject/patient/patientPerson/administrativeGenderCode/@displayName";
			String gender = xPath.compile(expr).evaluate(doc);
			setGender(gender);
			
			expr = "/FamilyHistory/subject/patient/patientPerson/ethnicGroupCode/@displayName";
			String ethnicity = xPath.compile(expr).evaluate(doc);
			setEthnicity(ethnicity);
			
			System.out.println("aaaaaaaaaaaaaaaaaaaaa");
			System.out.println(fullName);
			System.out.println(birthDate);
			System.out.println(gender);
			System.out.println(ethnicity);
			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbb");
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeDemographicData(String authToken, DataBean dataBean)
	{
		String xmlData = dataBean.getXmlData();
		setupDemographicInfo(xmlData);
		
		StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append("<info>");
        infoBuilder.append("<thing>");
        if(id != null && !id.equals("")) {
        	infoBuilder.append("<thing-id version-stamp=\"");
        	infoBuilder.append(versionStamp + "\">");
        	infoBuilder.append(id);
        	infoBuilder.append("</thing-id>");
        }
        infoBuilder.append("<type-id>");
        infoBuilder.append(PersonalDemographicType);
        //infoBuilder.append("</type-id>    <data-xml>        <personal>            <name>                <full>Thiagarajan Prakash</full>                <first>Thiagarajan</first>                <last>Prakash</last>            </name>            <birthdate>                <date>                    <y>1989</y>                    <m>5</m>                    <d>30</d>                </date>            </birthdate>            <blood-type>                <text>O+</text>            </blood-type>            <ethnicity><text>Asian</text><code><value>2</value><type>ethnicity-types</type></code></ethnicity>            <marital-status>                <text>Mar</text>            </marital-status>        </personal>        <common/>    </data-xml></thing>");
        infoBuilder.append("</type-id><data-xml><personal><name>");
        infoBuilder.append("<full>").append(getFullName()).append("</full>");
        infoBuilder.append("<first>").append(getFirstName()).append("</first>");
        infoBuilder.append("<last>").append(getLastName()).append("</last>");
        infoBuilder.append("</name>");
        infoBuilder.append("<birthdate><date>");
        infoBuilder.append("<y>").append(getBirthYear()).append("</y>");
        infoBuilder.append("<m>").append(getBirthMonth()).append("</m>");
        infoBuilder.append("<d>").append(getBirthDay()).append("</d></date></birthdate>");
        infoBuilder.append("<ethnicity><text>").append(getEthnicity()).append("</text><code><value>").append(getEthnicityCode()).append("</value><type>ethnicity-types</type></code></ethnicity>");
        infoBuilder.append("</personal><common/></data-xml></thing>");
        infoBuilder.append("</info>");
        
        System.out.println(infoBuilder.toString());
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        
        Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);
        
        Request request = new Request();
		request.setMethodName("PutThings");
		request.setInfo(infoBuilder.toString());
		
		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
		template.makeRequest(request, personInfo);
	}
	
	public void pushData(String authToken, DataBean dataBean) {
		getPersonalInfo(authToken);
		
		writeDemographicData(authToken, dataBean);
	}
	
	
}