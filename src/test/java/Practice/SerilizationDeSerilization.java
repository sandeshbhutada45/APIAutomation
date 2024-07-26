package Practice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilizationDeSerilization {

	@Test
	void ConvertPojoToJson() throws JsonProcessingException
	{
		//created java object using pojo class
		Student StudentPojo=new Student();    //pojo
		
		StudentPojo.setName("Scott");
		StudentPojo.setLocation("France");
		StudentPojo.setPhone("123456");
		String CoursesArr[]= {"C","C++"};
		StudentPojo.setCourses(CoursesArr);
		
		//convert java objet ---> json object ( serilization)
		ObjectMapper ObjMapper=new ObjectMapper();
		
		String JsonData=ObjMapper.writerWithDefaultPrettyPrinter().writeValueAsString(StudentPojo);
		
		System.out.println(JsonData);
		
	}
	
	
	
	// Json -----> Pojo    ( De-Serilization)
		@Test
		void ConvertJsonToPojo() throws JsonProcessingException
		{
			
			String JsonData="{\r\n"
					+ "  \"name\" : \"Scott\",\r\n"
					+ "  \"location\" : \"France\",\r\n"
					+ "  \"phone\" : \"123456\",\r\n"
					+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
					+ "}";
			
			
			//convert json data---> Pojo object
			
			ObjectMapper ObjMapper=new ObjectMapper();
			Student StudentPojo=ObjMapper.readValue(JsonData,Student.class); //convert json to pojo
			
			System.out.println("Name:"+StudentPojo.getName());
			System.out.println("Location:"+StudentPojo.getLocation());
			System.out.println("Phone:"+StudentPojo.getPhone());
			System.out.println("Course 1:"+StudentPojo.getCourses()[0]);
			System.out.println("Course2:"+StudentPojo.getCourses()[1]);	
			
			
		}
		
	
	
}
