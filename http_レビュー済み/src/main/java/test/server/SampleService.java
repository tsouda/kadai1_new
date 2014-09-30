package test.server;

import java.io.Serializable;

import org.springframework.integration.annotation.Payload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import phase1.server.bean.DbResultBean;

@Component
public class SampleService implements Serializable{
	
	@ServiceActivator
	/**public String execute(
			@Payload String param){
	
		//初期の文字列
		String ret = param + " test string";
		
		System.out.println("Server String:" + ret);
		
		return ret;

	}*/
	
	//DbResultBeanのオブジェクト　戻り値
	public DbResultBean obzi(
			@Payload String param){
		//DbResultBeanオブジェクトの生成
		DbResultBean brb = new DbResultBean();
		
		//初期の文字列
		//String ret = param + " test string";
		
		System.out.println("Server String:" + brb);
		//nullはあまりよくないみたいなので格納しましたー
		brb.setDbconnectionflag(true);
		brb.setDbsearchflag(true);
		brb.setFlightplanlist(null);
		
		System.out.println("Server String:" + brb);
		return brb;

	}
}
