package gov.nih.nci.FHH.bean;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.Marshaller;
import gov.nih.nci.FHH.RequestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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

public class BasicDemographicInfo implements thing {

public static final String BasicDemographicType = "3b3e6b16-eb69-483c-8d7e-dfe116ae6092";
	
	private String id = "";
	private String versionStamp = "";
	private String gender = "";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
				BasicDemographicType +
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
			
			String expr = "/FamilyHistory/subject/patient/patientPerson/administrativeGenderCode/@displayName";
			String gender = xPath.compile(expr).evaluate(doc);
			setGender(gender);

			
			System.out.println("aaaaaaaaaaaaaaaaaaaaa");
			System.out.println(gender);
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
        infoBuilder.append(BasicDemographicType);
        infoBuilder.append("</type-id><data-xml><basic><gender>");
        infoBuilder.append(getGender()).append("</gender>");
        infoBuilder.append("</basic><common/></data-xml></thing>");
        infoBuilder.append("</info>");
        
        System.out.println(infoBuilder.toString());
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        
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
