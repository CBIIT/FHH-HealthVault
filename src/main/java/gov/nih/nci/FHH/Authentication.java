/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package gov.nih.nci.FHH;

import gov.nih.nci.FHH.bean.PersonInfo;

import java.io.InputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.HVAccessor;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.Request;

public class Authentication 
{
	private static final String TOKEN_NAME = "wctoken";
	
    
    public PersonInfo getPersonInfo(String authToken) {
	    PersonInfo personInfo = new PersonInfo();
		personInfo.setUserAuthToken(authToken);
		personInfo.setRecordId(getSelectedRecordId(authToken));
		
		return personInfo;
    }
    
    private String getSelectedRecordId(String userAuthToken)
	throws HVException
	{
    	try
    	{
        	Request request = new Request();
        	request.setTtl(3600 * 8 + 300);  
        	request.setMethodName("GetPersonInfo");
        	request.setUserAuthToken(userAuthToken);
        	HVAccessor accessor = new HVAccessor();
        	accessor.send(request, ConnectionFactory.getConnection());
        	InputStream is = accessor.getResponse().getInputStream();
        	
            XPath xpath = XPathFactory.newInstance().newXPath();
            String exp = "//record/@id";
            return xpath.evaluate(exp,new InputSource(is));      		
    	}
    	catch(HVException he)
    	{
    		throw he;
    	}
    	catch(Exception e)
    	{
    		throw new HVException(e);
    	}
    }
}
