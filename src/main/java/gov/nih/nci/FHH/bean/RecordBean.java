package gov.nih.nci.FHH.bean;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.Marshaller;
import gov.nih.nci.FHH.RequestTemplate;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.Request;

public class RecordBean implements thing {

public static final String personalDemographicInfo = "92ba621e-66b3-4a01-bd73-74844aed4f5b";
public static final String basicDemographicInfo = "3b3e6b16-eb69-483c-8d7e-dfe116ae6092";
public static final String condition = "7ea7a1f9-880b-4bd4-b593-f5660f20eda8";
public static final String familyHistory = "4a04fcc8-19c1-4d59-a8c7-2031a03f21de";
public static final String familyHistoryCondition = "6705549b-0e3d-474e-bfa7-8197ddd6786a";
public static final String familyHistoryPerson = "cc23422c-4fba-4a23-b52a-c01d6cd53fdf";
	
	public void pushData(String authToken, DataBean dataBean) {
		
	}
	
	public String pullData(String authToken) {
		return readRecordData(authToken);
	}	
	
	public String readRecordData(String authToken) {
		StringBuilder infoBuilder = new StringBuilder();
		String data = null;
		
		infoBuilder.append("<info>");
		infoBuilder.append("<group name=\"BasicDemographicInfo\">");
		infoBuilder.append("<filter>");
		infoBuilder.append("<type-id>");
		infoBuilder.append(basicDemographicInfo);
		infoBuilder.append("</type-id>");
		infoBuilder.append("<thing-state>Active</thing-state>");
		infoBuilder.append("</filter>");
		infoBuilder.append("<format><section>core</section><xml/></format>");
		infoBuilder.append("</group>");
		
		infoBuilder.append("<group name=\"PersonalDemographicInfo\">");
		infoBuilder.append("<filter>");
		infoBuilder.append("<type-id>");
		infoBuilder.append(personalDemographicInfo);
		infoBuilder.append("</type-id>");
		infoBuilder.append("<thing-state>Active</thing-state>");
		infoBuilder.append("</filter>");
		infoBuilder.append("<format><section>core</section><xml/></format>");
		infoBuilder.append("</group>");
		
		infoBuilder.append("<group name=\"condition\">");
		infoBuilder.append("<filter>");
		infoBuilder.append("<type-id>");
		infoBuilder.append(condition);
		infoBuilder.append("</type-id>");
		infoBuilder.append("<thing-state>Active</thing-state>");
		infoBuilder.append("</filter>");
		infoBuilder.append("<format><section>core</section><xml/></format>");
		infoBuilder.append("</group>");		
		
		infoBuilder.append("<group name=\"familyHistory\">");
		infoBuilder.append("<filter>");
		infoBuilder.append("<type-id>");
		infoBuilder.append(familyHistory);
		infoBuilder.append("</type-id>");
		infoBuilder.append("<thing-state>Active</thing-state>");
		infoBuilder.append("</filter>");
		infoBuilder.append("<format><section>core</section><xml/></format>");
		infoBuilder.append("</group>");	
		
		infoBuilder.append("<group name=\"familyHistoryCondition\">");
		infoBuilder.append("<filter>");
		infoBuilder.append("<type-id>");
		infoBuilder.append(familyHistoryCondition);
		infoBuilder.append("</type-id>");
		infoBuilder.append("<thing-state>Active</thing-state>");
		infoBuilder.append("</filter>");
		infoBuilder.append("<format><section>core</section><xml/></format>");
		infoBuilder.append("</group>");		
		
		infoBuilder.append("<group name=\"familyHistoryPerson\">");
		infoBuilder.append("<filter>");
		infoBuilder.append("<type-id>");
		infoBuilder.append(familyHistoryPerson);
		infoBuilder.append("</type-id>");
		infoBuilder.append("<thing-state>Active</thing-state>");
		infoBuilder.append("</filter>");
		infoBuilder.append("<format><section>core</section><xml/></format>");
		infoBuilder.append("</group>");			
		
		infoBuilder.append("</info>");
		
		Request request = new Request();
		request.setMethodName("GetThings");
		request.setInfo(infoBuilder.toString());
		
		Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);
		
		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
		data = template.makeRequest(request, personInfo, new Marshaller<String>() {
			public String marshal(InputStream istream) throws Exception {
				InputSource isource = new InputSource(istream);
                XPath xpath = XPathFactory.newInstance().newXPath();
                String exp = "//thing";
                NodeList things = (NodeList)xpath.evaluate(exp,
                		isource,
                		XPathConstants.NODESET);  
                
                System.out.println(things.getLength());
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");  
                
                /* DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document d = db.parse(istream); */
				
                String xml = "";
                StringBuilder hvXml = new StringBuilder("");
                int count = Math.min(50, things.getLength());
                for (int i=0; i<count; i++)
    	        {
    	            Node thing = things.item(i);
    	            
    	            StringWriter writer = new StringWriter();
    				Transformer transformer = TransformerFactory.newInstance().newTransformer();
    				transformer.transform(new DOMSource(thing), new StreamResult(writer));
    				xml = writer.toString();
    				
    				//System.out.println("(((((((((((((((((");
    				//System.out.println(xml);
    				
    				hvXml.append(xml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", ""));
    	         }

                hvXml.insert(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><HealthVault>");
                hvXml.append("</HealthVault>");
                
                
                System.out.println(hvXml);
    	            
    	        return hvXml.toString();
			}
		});
		
		return data;
	}


}
