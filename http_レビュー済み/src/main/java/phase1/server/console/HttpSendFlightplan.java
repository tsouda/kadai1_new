package phase1.server.console;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpSendFlightplan {
	
	private static Logger logger = Logger.getLogger(HttpSendFlightplan.class);
	
	public boolean file_send(ArrayList<Object> list){

		if(list.isEmpty()){ // 読み出し元でガードしているが、念のため
			System.out.println("リストが空です");
			return false;
		}
		
		if(list.size()!=21){
			System.out.println("リストに設定されているパラメータに不足があります");
			return false;
		}

		System.out.println("フライトプランの情報をAPサーバへ送信します");
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/http-outbound-config.xml");
		RequestGateway requestGateway_console = context.getBean("requestGateway_console", RequestGateway.class);
		try{
			for(int i =0;i<list.size();i++){
				String ans = requestGateway_console.File_send(list.get(i));
				if(ans.equals("true")){
					logger.info("Replied with: " + ans);
					System.out.println("reply:" + ans);
				}
				else{
					System.out.println("サーバからエラーを受信しました");
					return false;
				}
			}
		}
		catch(Exception e){
			System.out.println("異常終了");
			return false;
		}
		// 正常終了
		return true;
	}
}