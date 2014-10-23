package gov.nih.nci.FHH.bean;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.RequestTemplate;
import gov.nih.nci.FHH.util.XmlDocument;

import java.util.Calendar;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.Request;

public class HeightInfo implements thing {
public static final String heightType = "40750a6a-89b2-455c-bd8d-b420a4cb500b";
	
	private String id = "";
	private String versionStamp = "";
	private String value = "";
	private String unit = "";
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getMeterValue() {
		if(unit.equals("centimeters"))
			return String.format("%.2f", Float.valueOf(value)/100);
		else if(unit.equals("inches"))
			return String.format("%.2f", Float.valueOf(value)* 0.0254);
		else
			return String.format("%.2f", Float.valueOf(value)* 0.3048);
	}	
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	private void setupHeightInfo(String xmlData) {
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
			String expr = "/FamilyHistory/subject/patient/patientPerson/subjectof2/clinicalObservation";
			NodeList nodeList = (NodeList) xPath.compile(expr).evaluate(doc, XPathConstants.NODESET);
			for (int i = 0;null!=nodeList && i < nodeList.getLength(); i++) {
		        Node node = nodeList.item(i);
		        if(node.getNodeType() == Node.ELEMENT_NODE) {
		        	Element eElement = (Element) node;
		        	
		        	NamedNodeMap attributesList = eElement.getElementsByTagName("code").item(0).getAttributes();
		        	boolean heightFound = false;
		        	for (int j = 0; j < attributesList.getLength(); j++) {
		        		if( attributesList.item(j).getNodeValue().equals("height"))
		        			heightFound = true;
		                System.out.println("Attribute: "
		                        + attributesList.item(j).getNodeName() + " = "
		                        + attributesList.item(j).getNodeValue());
		            }
		        	
		        	if(heightFound) {
		        		NamedNodeMap vAttributesList = eElement.getElementsByTagName("value").item(0).getAttributes();
			        	for (int j = 0; j < vAttributesList.getLength(); j++) {
			        		if( vAttributesList.item(j).getNodeName().equals("value")) {
			        			setValue(vAttributesList.item(j).getNodeValue());
			        		}
			        		if( vAttributesList.item(j).getNodeName().equals("unit")) {
			        			setUnit(vAttributesList.item(j).getNodeValue());
			        		}
			                System.out.println("Attribute: "
			                        + vAttributesList.item(j).getNodeName() + " = "
			                        + vAttributesList.item(j).getNodeValue());
			            }
			        	
			        	break;
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
	
	private void writeHeightInfo(String authToken, DataBean dataBean)
	{
		String xmlData = dataBean.getXmlData();
		setupHeightInfo(xmlData);
		
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
        infoBuilder.append(HeightInfo.heightType);
        infoBuilder.append("</type-id><data-xml><height><when><date><y>");
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
        infoBuilder.append("</s></time></when><value><m>");
        infoBuilder.append(getMeterValue());
        infoBuilder.append("</m>");
        if( getUnit().equals("centimeters"))
        	infoBuilder.append("<display units=\"cms\" units-code=\"cms\">");
        else if( getUnit().equals("inches"))
        	infoBuilder.append("<display units=\"inches\" units-code=\"inches\">");
        else
        	infoBuilder.append("<display units=\"feet\" units-code=\"feet\">");
        infoBuilder.append(getValue());
        infoBuilder.append("</display></value></height>");
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
		writeHeightInfo(authToken, dataBean);
	}
}
