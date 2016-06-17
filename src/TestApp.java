import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.snpData.dao.*;
import com.snpData.model.*;
import com.snpData.service.*;

public class TestApp {

	public static void main(String[] args) {
		
		SnpDataService service = new SnpDataService();
		
		long profileID = 20001L; 
		
		SnpData sdata = service.getSleepDataByProfileID(profileID);
		
		System.out.println(sdata);
		
		System.out.println(service.getS3Address(sdata));
		
		String path = "";
		
		service.getS3File(sdata, path);

		
	}
	

}
