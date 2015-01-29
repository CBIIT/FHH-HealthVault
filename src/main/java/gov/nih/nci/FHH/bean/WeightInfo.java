package gov.nih.nci.FHH.bean;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.RequestTemplate;
import gov.nih.nci.FHH.util.XmlDocument;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import org.xml.sax.SAXException;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.Request;

public class WeightInfo implements thing {
	public static final String WeightType = "3d34d87e-7fc1-4153-800f-f56592cb0d17";
	
	private String id = "";
	private String versionStamp = "";
	public String value = "";
	public String unit = "";
	public static String weight = "";
	public static String weightUnit = "";
	
	public static String getWeight() {
		return weight;
	}

	public static void setWeight(String weight) {
		WeightInfo.weight = weight;
	}

	public static String getWeightUnit() {
		return weightUnit;
	}

	public static void setWeightUnit(String weightUnit) {
		WeightInfo.weightUnit = weightUnit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getKgValue() {
		System.out.println("Value is "+ value);
		if(unit.equals("kilogram"))
			return value;
		else
			return String.format("%.2f", Float.valueOf(value)/2.2046);
	}	
	
	public String getUnit() {
		if(unit.equals("kilogram"))
			return "kg";
		else
			return "lb";
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	private void setupWeightInfo(String xmlData) {
		/* DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
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
		*/
		Document doc = XmlDocument.parse(xmlData);
		XPath xPath =  XPathFactory.newInstance().newXPath();
		
		try {
			String expr = "/FamilyHistory/subject/patient/patientPerson/subjectOf2/clinicalObservation";
			this.setWeight(""); this.setWeightUnit("");
			NodeList nodeList = (NodeList) xPath.compile(expr).evaluate(doc, XPathConstants.NODESET);
			for (int i = 0;null!=nodeList && i < nodeList.getLength(); i++) {
		        Node node = nodeList.item(i);
		        if(node.getNodeType() == Node.ELEMENT_NODE) {
		        	Element eElement = (Element) node;
		        	boolean weightFound = false;
		        	if(eElement.getElementsByTagName("code").item(0)!=null){
		        	NamedNodeMap attributesList = eElement.getElementsByTagName("code").item(0).getAttributes();
		        	
		        	for (int j = 0; j < attributesList.getLength(); j++) {
		        		if( attributesList.item(j).getNodeValue().equals("weight"))
		        			weightFound = true;
		        		System.out.println("weight Found is : "+weightFound);
		                System.out.println("Attribute: "
		                        + attributesList.item(j).getNodeName() + " = "
		                        + attributesList.item(j).getNodeValue());
		            }
		        	}
		        	
		        	if(weightFound) {
		        		if(eElement.getElementsByTagName("value").item(0)!=null){
		        			
		        		NamedNodeMap vAttributesList = eElement.getElementsByTagName("value").item(0).getAttributes();
			        	for (int j = 0; j < vAttributesList.getLength(); j++) {
			        		if( vAttributesList.item(j).getNodeName().equals("value")) {
			        			System.out.println("Weight Value "+vAttributesList.item(j).getNodeValue());
			        			setValue(vAttributesList.item(j).getNodeValue());
			        			this.setWeight(this.getValue());
			        		}
			        		if( vAttributesList.item(j).getNodeName().equals("unit")) {
			        			setUnit(vAttributesList.item(j).getNodeValue());
			        			this.setWeightUnit(this.getUnit());
			        		}
			                System.out.println("Attribute: "
			                        + vAttributesList.item(j).getNodeName() + " = "
			                        + vAttributesList.item(j).getNodeValue());
			            }
			        	
			        	break;
		        	}
		        	}
		        }
		    }
			    
						
			System.out.println("aaaaaaaaaaaaaaaaaaaaa");
			System.out.println(value);
			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbb");
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeWeightInfo(String authToken, DataBean dataBean)
	{
		
		String xmlData = dataBean.getXmlData();
		setupWeightInfo(xmlData);
		if(this.getValue().equals("")){
			return;
		}
		
		Calendar calendar = Calendar.getInstance();
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
        infoBuilder.append(WeightInfo.WeightType);
        infoBuilder.append("</type-id><data-xml><weight><when><date><y>");
        infoBuilder.append(calendar.get(Calendar.YEAR));
        infoBuilder.append("</y><m>");
        infoBuilder.append(calendar.get(Calendar.MONTH) + 1);
        infoBuilder.append("</m><d>");
        infoBuilder.append(calendar.get(Calendar.DATE));
        infoBuilder.append("</d></date><time><h>");
        infoBuilder.append(calendar.get(Calendar.HOUR_OF_DAY));
        infoBuilder.append("</h><m>");
        infoBuilder.append(calendar.get(Calendar.MINUTE));
        infoBuilder.append("</m><s>");
        infoBuilder.append(calendar.get(Calendar.SECOND));
        infoBuilder.append("</s></time></when><value><kg>");
        infoBuilder.append(getKgValue());
        infoBuilder.append("</kg>");
        if( getUnit().equals("lb"))
        	infoBuilder.append("<display units=\"lb\" units-code=\"lb\">");
        else
        	infoBuilder.append("<display units=\"kg\" units-code=\"kg\">");
        infoBuilder.append(getValue());
        infoBuilder.append("</display></value></weight>");
        infoBuilder.append("<common/></data-xml></thing>");
        infoBuilder.append("</info>");
        
        System.out.println(infoBuilder.toString());
        
        Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);
        
        Request request = new Request();
		request.setMethodName("PutThings");
		request.setInfo(infoBuilder.toString());
		
		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
		template.makeRequest(request, personInfo);
	}

	public void pushData(String authToken, DataBean dataBean) {
		writeWeightInfo(authToken, dataBean);
	}

}
