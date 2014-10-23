package gov.nih.nci.FHH.bean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import gov.nih.nci.FHH.Authentication;
import gov.nih.nci.FHH.Marshaller;
import gov.nih.nci.FHH.RequestTemplate;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.Request;

public class FileInfo implements thing {
	public static final String fileName = "PersonalHistory.xml";
	public static final String fileType = "bd0403c5-4ae2-4b0e-a8db-1888678e4528";
	
	private String thingId = "";
	private String versionStamp = "";

	private void writeFileData(String authToken, DataBean dataBean)
	{
		readFileData(authToken);
		dataBean.setThingId(thingId);
		dataBean.setVersionStamp(versionStamp);
		
		String xmlData = dataBean.getXmlData();
		String thingId = dataBean.getThingId();
		String versionStamp = dataBean.getVersionStamp();
		String fileSize = Integer.valueOf(xmlData.length()).toString();
		
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
        
        System.out.println(infoBuilder.toString());
        
		Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);
        
        Request request = new Request();
		request.setMethodName("PutThings");
		request.setInfo(infoBuilder.toString());
		
		RequestTemplate template = new RequestTemplate(ConnectionFactory.getConnection());
		Integer retValue = template.makeRequest(request, personInfo);
		
		System.out.println(retValue);
	}
	
	public void pushData(String authToken, DataBean dataBean) {
		writeFileData(authToken, dataBean);
	}
	
	public List pullData(String authToken) {
		return readFileData(authToken);
	}	
	
	public List readFileData(String authToken) {
		StringBuilder infoBuilder = new StringBuilder();
		List dataList = null;
		
		infoBuilder.append("<info><group>");
		infoBuilder.append("<filter><type-id>bd0403c5-4ae2-4b0e-a8db-1888678e4528</type-id></filter>");
		infoBuilder.append("<format><section>core</section><section>otherdata</section><xml/></format>");
		infoBuilder.append("</group></info>");
		
		Request request = new Request();
		request.setMethodName("GetThings");
		request.setInfo(infoBuilder.toString());
		
		Authentication auth = new Authentication();
		PersonInfo personInfo = auth.getPersonInfo(authToken);
		
		thingId = "";
		versionStamp = "";
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
                String versionStampInner = "";
    	        for (int i=0; i<count; i++)
    	        {
    	            Node thing = things.item(i);
    	            name = xpath.evaluate("data-xml/file/name", thing);
    	            if(fileName.equals(name)) {
    	            	id = xpath.evaluate("thing-id", thing);
    	            	versionStampInner = xpath.evaluate("thing-id/@version-stamp", thing);
    	            	xmlData = xpath.evaluate("data-other", thing);
        	            System.out.println(id);
        	            System.out.println(name);
        	            System.out.println(versionStampInner);
        	            System.out.println(xmlData);
        	            
            	        thingId = id;
            	        versionStamp = versionStampInner;
            	        
    	            	break;
    	            }
    	        }
    	        

    	        ArrayList data = new ArrayList();
    	        data.add(xmlData);
    	        
    	        return data;
			}
		});
		
		return dataList;
	}
}
