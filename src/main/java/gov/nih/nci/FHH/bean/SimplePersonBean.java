package gov.nih.nci.FHH.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;


public class SimplePersonBean {

	List<Map<String, Object>> relativeList = new ArrayList<Map<String,Object>>();
	int mc = 0; int pc = 0; int br = 0; int ss = 0; int nec = 0; int nep = 0; int sn = 0; int ma = 0; int pa =0;
	int mu = 0; int pu = 0; int dr = 0; int gs = 0; int gd = 0; int mhb = 0; int mhs = 0; int phb = 0; int phs = 0;
	
	public Map<String, Object> parseJson(JSONObject jsonObj) {
		
		Map<String, Object> person = new HashMap<String, Object>();
		JSONArray things = jsonObj.getJSONArray("thing");
		try{
		for(int i = 0;i< things.length();i++){
			JSONObject thing = things.getJSONObject(i);
			JSONObject dataXML = thing.getJSONObject("data-xml");
			System.out.println("keyset =="+dataXML.keySet());
			if(dataXML.has("basic")){
				JSONObject basic = dataXML.getJSONObject("basic");
				if(basic.get("gender").toString().contains("f")){
					person.put("gender", "FEMALE");
				}else{
					person.put("gender", "MALE");
				}
			}
			if(dataXML.has("personal")){
				JSONObject personal = dataXML.getJSONObject("personal");
				JSONObject name = personal.getJSONObject("name");
				person.put("name", name.get("full"));
				if(personal.has("birthdate")){
					JSONObject birthDate = personal.getJSONObject("birthdate");
					JSONObject date = birthDate.getJSONObject("date");
					person.put("date_of_birth", date.get("m")+"/"+date.get("d")+"/"+date.get("y"));
					
				}

			}
			List<Map<String, String>> healthHistoryList = new ArrayList<Map<String,String>>();

			if(dataXML.has("family-history")){
				parseFamilyHistory(dataXML, person);
			}
		}
			
	
		}catch(Exception e){
			e.printStackTrace();
		}

		return person;
	}

	private void parseFamilyHistory(JSONObject dataXML, Map<String, Object> person) {
		
		Map<String, Object> relMap = new HashMap<String, Object>();
		Map<String, Object> relativeMap = new HashMap<String, Object>();
		JSONObject fhhExtension = new JSONObject();
		JSONObject relation = new JSONObject();
		if(dataXML.has("family-history")){
			JSONObject familyHistory = dataXML.getJSONObject("family-history");
			List<Map<String, Object>> healthHistoryList = new ArrayList<Map<String,Object>>();
			if(familyHistory.has("condition")){
				healthHistoryList = new ArrayList<Map<String,Object>>();
				Map<String, Object> healthHistory = new HashMap<String, Object>();
				Object condition = familyHistory.get("condition");
				if(condition instanceof JSONArray){
					JSONArray conditions = (JSONArray) condition;
					for(int j=0;j<conditions.length();j++){
						if(conditions.getJSONObject(j).has("resolution")){
							if(conditions.getJSONObject(j).getString("resolution").equalsIgnoreCase("death")){
								relMap.put("is_alive", "dead");
							}
							if(conditions.getJSONObject(j).has("name")){
								JSONObject name = conditions.getJSONObject(j).getJSONObject("name");
								relMap.put("cause_of_death", name.get("text"));
								relMap.put("detailed_cause_of_death", name.get("text"));
								if(name.has("code")){
									JSONArray codes = name.getJSONArray("code");
									relMap.put("cause_of_death_code", codes.getJSONObject(0).get("type")+"-"+codes.getJSONObject(0).get("value"));
									relMap.put("cause_of_death_system", codes.getJSONObject(0).get("type"));
									if(codes.getJSONObject(1).getString("value").substring(9).equalsIgnoreCase("sixties")){
										relMap.put("Age At Diagnosis", "senior");
										relMap.put("estimated_death_age", "senior");
									}
									else{
										relMap.put("Age At Diagnosis", codes.getJSONObject(1).getString("value").substring(9));
										relMap.put("estimated_death_age", codes.getJSONObject(1).getString("value").substring(9));
									}
								}
							}
						}else{
							relMap.put("is_alive", "alive");
						}
						if(conditions.getJSONObject(j).has("name")){
							healthHistory = new HashMap<String, Object>();
							JSONObject name = conditions.getJSONObject(j).getJSONObject("name");
							healthHistory.put("Disease Name", name.get("text"));
							healthHistory.put("Detailed Disease Name", name.get("text"));
							if(name.has("code")){
								JSONArray codes = name.getJSONArray("code");
								healthHistory.put("Disease Code", codes.getJSONObject(0).get("type")+"-"+codes.getJSONObject(0).get("value"));
								System.out.println("age length for sixties=="+codes.getJSONObject(1).getString("value"));
								if(codes.getJSONObject(1).getString("value").substring(9).equalsIgnoreCase("sixties")){
									healthHistory.put("Age At Diagnosis", "senior");
								}
								else{
									healthHistory.put("Age At Diagnosis", codes.getJSONObject(1).getString("value").substring(9));
								}
							
							}
							
						}
						healthHistoryList.add(healthHistory);
						
					}
					
				}
				if(condition instanceof JSONObject){
					JSONObject cond = (JSONObject) condition;
					healthHistoryList = new ArrayList<Map<String,Object>>();
					healthHistory = new HashMap<String, Object>();
					if(cond.has("resolution")){
						if(cond.getString("resolution").equalsIgnoreCase("death")){
							relMap.put("is_alive", "dead");
						}
						if(cond.has("name")){
							JSONObject name = cond.getJSONObject("name");
							relMap.put("cause_of_death", name.get("text"));
							relMap.put("detailed_cause_of_death", name.get("text"));
							if(name.has("code")){
								JSONArray codes = name.getJSONArray("code");
								relMap.put("cause_of_death_code", codes.getJSONObject(0).get("type")+"-"+codes.getJSONObject(0).get("value"));
								relMap.put("cause_of_death_system", codes.getJSONObject(0).get("type"));
								if(codes.getJSONObject(1).getString("value").substring(9).equalsIgnoreCase("sixties")){
									relMap.put("Age At Diagnosis", "senior");
									relMap.put("estimated_death_age", "senior");
								}
								else{
									relMap.put("Age At Diagnosis", codes.getJSONObject(1).getString("value").substring(9));
									relMap.put("estimated_death_age", codes.getJSONObject(1).getString("value").substring(9));
								}
							}
						}
					}else{
						relMap.put("is_alive", "alive");
					}
					if(cond.has("name")){
						JSONObject name = cond.getJSONObject("name");
						healthHistory.put("Disease Name", name.get("text"));
						healthHistory.put("Detailed Disease Name", name.get("text"));
						if(name.has("code")){
							JSONArray codes = name.getJSONArray("code");
							healthHistory.put("Disease Code", codes.getJSONObject(0).get("type")+"-"+codes.getJSONObject(0).get("value"));
							if(codes.getJSONObject(1).getString("value")!=null){
								if(codes.getJSONObject(1).getString("value").substring(9).equalsIgnoreCase("sixties")){
									healthHistory.put("Age At Diagnosis", "senior");
								}
								else{
									healthHistory.put("Age At Diagnosis", codes.getJSONObject(1).getString("value").substring(9));
								}
							}
							healthHistoryList.add(healthHistory);
						}
					}
					
				}
				
			}else{
				relMap.put("is_alive", "alive");
			}
			relMap.put("Health History", healthHistoryList);
			if(familyHistory.has("relative")){
				JSONObject relative = familyHistory.getJSONObject("relative");
				if(relative.has("relationship")){
					relation = relative.getJSONObject("relationship");
						if(relative.has("relative-name")){
							JSONObject relativeName = relative.getJSONObject("relative-name");
							if(relativeName.has("name")){
								JSONObject name = relativeName.getJSONObject("name");
								relMap.put("name", name.get("full"));
							}
						}
						if(relative.has("date-of-birth")){
							JSONObject dateOfBirth = relative.getJSONObject("date-of-birth");
							if((dateOfBirth.length()>0)&&(dateOfBirth.has("m"))&&(dateOfBirth.has("d"))&&(dateOfBirth.has("y"))){
								relMap.put("date_of_birth", dateOfBirth.get("m")+"/"+dateOfBirth.get("d")+"/"+dateOfBirth.get("y"));
							}
						}
						
				}
			}
		}
		
		
		if(dataXML.has("common")){
			JSONObject common = dataXML.getJSONObject("common");
			if(common.has("client-thing-id")){
				relMap.put("id", common.get("client-thing-id"));
			}
			if(common.has("related-thing")){
				Object relatedThings = common.get("related-thing");
				if(relatedThings instanceof JSONArray){
					JSONArray relatedArray = (JSONArray) relatedThings;
					for(int t=0;t<relatedArray.length();t++){
						if(relatedArray.getJSONObject(t).getString("relationship-type").equalsIgnoreCase("PAR"))
							relMap.put("parent_id", relatedArray.getJSONObject(t).get("client-thing-id"));
					}
				}
				if(relatedThings instanceof JSONObject){
					JSONObject relObj = (JSONObject) relatedThings;
					if(relObj.getString("relationship-type").equalsIgnoreCase("PAR"))
						relMap.put("parent_id", relObj.get("client-thing-id"));
				}
				
			}
			if(common.has("extension")){
				JSONObject extension = common.getJSONObject("extension");
				if(extension.has("fhh-extensions")){
					fhhExtension = extension.getJSONObject("fhh-extensions");
					if(relation.getString("text").equalsIgnoreCase("self")){
						person.put("twin_status", fhhExtension.get("twin"));
						person.put("adopted", fhhExtension.get("adopted"));
						if(fhhExtension.has("ethnicities")){
							Object ethnicities = fhhExtension.get("ethnicities");
							if(ethnicities instanceof JSONArray){
								JSONArray ethnicityList = (JSONArray) ethnicities;
								Map<String, Object> ethnicity = new HashMap<String, Object>();
								for(int l=0;l<ethnicityList.length();l++){
									if(ethnicityList.getJSONObject(l).has("code")){
										JSONObject code = ethnicityList.getJSONObject(l).getJSONObject("code");
										ethnicity.put(code.get("name").toString(), true);
									}
								}
								person.put("ethnicity", ethnicity);
							}
							if(ethnicities instanceof JSONObject){
								JSONObject ethObj = (JSONObject) ethnicities;
								if(ethObj.has("code")){
									JSONObject code = ethObj.getJSONObject("code");
									Map<String, Object> ethnicity = new HashMap<String, Object>();
									ethnicity.put(code.get("name").toString(), true);
									person.put("ethnicity", ethnicity);
								}
							}
						}
						if(fhhExtension.has("gender")){
							JSONObject gender = fhhExtension.getJSONObject("gender");
							if(gender.has("code")){
								JSONObject code = gender.getJSONObject("code");
								person.put("gender", code.get("name").toString().toUpperCase());
							}
						}
						if(fhhExtension.has("races")){
							Object races = fhhExtension.get("races");
							if(races instanceof JSONArray){
								JSONArray raceList = (JSONArray) races;
								for(int k=0;k<raceList.length();k++){
									if(raceList.getJSONObject(k).has("code")){
										JSONObject code = raceList.getJSONObject(k).getJSONObject("code");
										Map<String, Object> race = new HashMap<String, Object>();
										race.put(code.getString("name"), true);
										relMap.put("race", race);
									}
								}
							}
							if(races instanceof JSONObject){
								JSONObject raceObj = (JSONObject) races;
								if(raceObj.has("code")){
									JSONObject code = raceObj.getJSONObject("code");
									Map<String, Object> race = new HashMap<String, Object>();
									race.put(code.getString("name"), true);
									relMap.put("race", race);
								}
							}
							
						}
						if(fhhExtension.has("weight")){
							JSONObject weight = fhhExtension.getJSONObject("weight");
							if(weight.get("pounds")!=""){
								person.put("weight_unit", "pound");
								person.put("weight", weight.get("pounds"));
							}
							if(weight.get("kilograms")!=""){
								person.put("weight_unit", "kilograms");
								person.put("weight", weight.get("kilograms"));
							}
						}if(fhhExtension.has("consanguinity")){
							person.put("consanguinity", fhhExtension.get("consanguinity"));
						}
						
						if(fhhExtension.has("height")){
							JSONObject height = fhhExtension.getJSONObject("height");
							if(height.get("centemiters")!=""){
								person.put("height_unit", "centemiters");
								person.put("height", height.get("centemiters"));
							}
							if(height.get("inches")!=""){
								person.put("height_unit", "inches");
								person.put("height", height.get("inches"));
							}
						}
					}
					relMap.put("twin_status", fhhExtension.get("twin"));
					relMap.put("adopted", fhhExtension.get("adopted"));
					if(fhhExtension.has("dateOfBirth")){
						JSONObject dateOfBirth = fhhExtension.getJSONObject("dateOfBirth");
						if(dateOfBirth.has("code")){
							JSONObject code = dateOfBirth.getJSONObject("code");
							if(code.get("value").toString().contains("/")){
								relMap.put("date_of_birth", code.get("value"));
							}else if(code.get("value").toString().contains("ageRange")){
								relMap.put("is_alive", "alive");
								if(code.get("value").toString().substring(9).equalsIgnoreCase("sixties")){
									relMap.put("estimated_age", "senior");
								}else{
									relMap.put("estimated_age",code.get("value").toString().substring(9));
								}
							}else if(code.get("value").toString().equalsIgnoreCase("Unknown")){
									relMap.put("is_alive", "Unknown");
							}else{
								Long year = (Long) code.get("value");
								int birthYear = year.intValue();
								int currentYear = Calendar.getInstance().get(Calendar.YEAR);
								relMap.put("age", currentYear-birthYear);
							}
						}
						
					}
					if(fhhExtension.has("ethnicities")){
						Object ethnicities = fhhExtension.get("ethnicities");
						if(ethnicities instanceof JSONArray){
							JSONArray ethnicityList = (JSONArray) ethnicities;
							Map<String, Object> ethnicity = new HashMap<String, Object>();
							for(int l=0;l<ethnicityList.length();l++){
								if(ethnicityList.getJSONObject(l).has("code")){
									JSONObject code = ethnicityList.getJSONObject(l).getJSONObject("code");
									
									ethnicity.put(code.get("name").toString(), true);
									relMap.put("ethnicity", ethnicity);
								}
							}
						}
						if(ethnicities instanceof JSONObject){
							JSONObject ethObj = (JSONObject) ethnicities;
							if(ethObj.has("code")){
								JSONObject code = ethObj.getJSONObject("code");
								Map<String, Object> ethnicity = new HashMap<String, Object>();
								ethnicity.put(code.get("name").toString(), true);
								relMap.put("ethnicity", ethnicity);
							}
						}
					}
					if(fhhExtension.has("gender")){
						JSONObject gender = fhhExtension.getJSONObject("gender");
						if(gender.has("code")){
							JSONObject code = gender.getJSONObject("code");
							relMap.put("gender", code.get("name").toString().toUpperCase());
						}
					}
					if(fhhExtension.has("races")){
						Object races = fhhExtension.get("races");
						if(races instanceof JSONArray){
							JSONArray raceList = (JSONArray) races;
							Map<String, Object> race = new HashMap<String, Object>();
							for(int k=0;k<raceList.length();k++){
								if(raceList.getJSONObject(k).has("code")){
									JSONObject code = raceList.getJSONObject(k).getJSONObject("code");
									
									race.put(code.getString("name"), true);
									relMap.put("race", race);
								}
							}
						}
						if(races instanceof JSONObject){
							JSONObject raceObj = (JSONObject) races;
							if(raceObj.has("code")){
								JSONObject code = raceObj.getJSONObject("code");
								Map<String, Object> race = new HashMap<String, Object>();
								race.put(code.getString("name"), true);
								relMap.put("race", race);
							}
						}
						
					}
					
					if(relation.get("text").toString().equalsIgnoreCase("Paternal Grandmother")){
						relMap.put("relationship", "paternal_grandmother");
						person.put("paternal_grandmother", relMap);
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Maternal Grandmother")){
						relMap.put("relationship", "maternal_grandmother");
						person.put("maternal_grandmother", relMap);
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Paternal Grandfather")){
						relMap.put("relationship", "paternal_grandfather");
						person.put("paternal_grandfather", relMap);
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Maternal Grandfather")){
						relMap.put("relationship", "maternal_grandfather");
						person.put("maternal_grandfather", relMap);
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Maternal Aunt")){
						relMap.put("relationship", "maternal_aunt");
						person.put("maternal_aunt_"+ma, relMap);
						ma++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Paternal Aunt")){
						relMap.put("relationship", "paternal_aunt");
						person.put("paternal_aunt_"+pa, relMap);
						pa++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Maternal Uncle")){
						relMap.put("relationship", "maternal_uncle");
						person.put("maternal_uncle_"+mu, relMap);
						mu++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Paternal Uncle")){
						relMap.put("relationship", "paternal_uncle");
						person.put("paternal_uncle_"+pu, relMap);
						pu++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Paternal Cousin")){
						relMap.put("relationship", "paternal_cousin");
						person.put("paternal_cousin_"+pc, relMap);
						pc++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Maternal Cousin")){
						relMap.put("relationship", "maternal_cousin");
						person.put("maternal_cousin_"+mc, relMap);
						mc++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Maternal Halfbrother")){
						relMap.put("relationship", "maternal_halfbrother");
						person.put("maternal_halfbrother_"+mhb, relMap);
						mhb++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Paternal Halfbrother")){
						relMap.put("relationship", "paternal_halfbrother");
						person.put("paternal_halfbrother_"+phb, relMap);
						phb++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Maternal Halfsister")){
						relMap.put("relationship", "maternal_halfsister");
						person.put("maternal_halfsister_"+mhs, relMap);
						mhs++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Paternal Halfsister")){
						relMap.put("relationship", "paternal_halfsister");
						person.put("paternal_halfsister_"+phs, relMap);
						phs++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Brother")){
						relMap.put("relationship", "brother");
						person.put("brother_"+br, relMap);
						br++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Sister")){
						relMap.put("relationship", "sister");
						person.put("sister_"+ss, relMap);
						ss++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Son")){
						relMap.put("relationship", "son");
						person.put("son_"+sn, relMap);
						sn++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Daughter")){
						relMap.put("relationship", "daughter");
						person.put("daughter_"+dr, relMap);
						dr++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Niece")){
						relMap.put("relationship", "niece");
						person.put("niece_"+nec, relMap);
						nec++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Nephew")){
						relMap.put("relationship", "nephew");
						person.put("nephew_"+nep, relMap);
						nep++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Grandson")){
						relMap.put("relationship", "grandson");
						person.put("grandson_"+gs, relMap);
						gs++;
					}
					else if(relation.get("text").toString().equalsIgnoreCase("Granddaughter")){
						relMap.put("relationship", "granddaughter");
						person.put("granddaughter_"+gd, relMap);
						gd++;
					}
					else{						
						relMap.put("relationship", relation.get("text").toString().toLowerCase());
						person.put(relation.get("text").toString().toLowerCase(), relMap);
					}
					if(relation.get("text").toString().equalsIgnoreCase("self")){
						Map<String, Object> self = (Map<String, Object>) person.get("self");
						person.put("id", self.get("id"));
						person.put("parent_id", self.get("parent_id"));
						
						Map<String, Object> race = (Map<String, Object>) self.get("race");
						person.put("race", race);
						Map<String, Object> ethnicity = (Map<String, Object>) self.get("ethnicity");
						person.put("ethnicity", ethnicity);
						System.out.println("health condition =="+self.get("Health History"));
						person.put("Health History", self.get("Health History"));
						System.out.println(self.get("race"));
						person.remove("self");
					}
										
				}
			}
		}

	}

}
