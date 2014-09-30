package phase1.client.AP;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.Header;
import org.springframework.integration.annotation.Payload;
//自作関数
import phase1.server.bean.DbResultBean;

/**
 * クライアント-APサーバ間のデータ送信形式の指定
 * @author machida
 *
 */


public interface ClientAPComand {

	@Gateway
	/**
	 * @param dataName
	 * @param request=dbcの値
	 * return=DbResultBeanオブジェクト
	 */
	
	DbResultBean echo(
			@Header("dataName") Object dataName,
			@Payload String request);

}
