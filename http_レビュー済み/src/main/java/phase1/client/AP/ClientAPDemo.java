package phase1.client.AP;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import phase1.server.bean.DbResultBean;
import phase1.server.bean.FlightPlanBean;
/**
 * @author Oleg Zhurakousky
 *
 */
public class ClientAPDemo {
	
	private static Logger logger = Logger.getLogger(ClientAPDemo.class);

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * モックです（本番は使いません）
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/client-apsarver-outbound-config.xml");
		ClientAPComand requestGateway = context.getBean("requestGateway", ClientAPComand.class);
		//戻り値を決める　String byte[]
		DbResultBean reply = requestGateway.echo("TestData", "99");
		//logger.info("Replied with: " + replyo);
		
		//byte[]配列からString変換する
		//String reply = new String(replyo, "UTF-8");
		//logger.info("Replied with: " + reply);
		//DbResultBeanオブジェクトからString変換する

		logger.info("Replied with: " + reply);
		
		ArrayList<FlightPlanBean> list = reply.getFlightplanlist();
		System.out.println(reply.getDbconnectionflag());
		System.out.println(reply.getDbsearchflag());
		
		if(list == null){
			System.out.println(list);
		}
		else{
			for(FlightPlanBean fpb: list){
				System.out.println(fpb.getArrival());
			}
		}
	}

}
