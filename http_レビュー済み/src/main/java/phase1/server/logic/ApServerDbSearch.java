package phase1.server.logic;

import java.util.ArrayList;
//アノテーション
import org.springframework.integration.annotation.Payload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
//bean
import phase1.server.bean.DbResultBean;
import phase1.server.bean.FlightPlanBean;
import phase1.server.bean.FlightPlanBeanListBean;

@Component
public class ApServerDbSearch {

	@ServiceActivator
	/**
	 * 
	 * @param dbc
	 * @return DbResultBean
	 * dbcに対応したリストを返却する
	 */
	
	public DbResultBean DbSearch(String dbc){
		//オブジェクトの生成
		DatabaseService odatabaseservice = new DatabaseService();
		FlightPlanBeanListBean oflightplanbeanlistbean = new FlightPlanBeanListBean();
		DbResultBean odbresultbean = new DbResultBean();
		ArrayList<FlightPlanBean> list = new ArrayList<FlightPlanBean>();
				
		/**
		 * dbcを判定し、検索処理へ飛ばす
		 */
		//dbcにnull又は、空文字列が入力されている場合
		if((dbc == null)||(dbc.length() == 0)||(dbc.equals("　"))){
			oflightplanbeanlistbean = odatabaseservice.executeSelect();
		}
		//dbcに数値が入力されている場合
		else{
			//データ型変換
			short hdbc = (short)Integer.parseInt(dbc);

			//1～32767ならば関数に飛ばす
			if((1 <= hdbc) && (hdbc <= 32767)){
				oflightplanbeanlistbean = odatabaseservice.executeSelect(hdbc);
			}
			//1～32767以外ならばエラーを返す
			else{
				odbresultbean = null;
				return odbresultbean;
			}
		}
		
		/**
		 * データベース接続結果
		 */
		odbresultbean.setDbconnectionflag(oflightplanbeanlistbean.getsuccessFlg());
		
		/**
		 * 検索結果判定
		 */
		list = oflightplanbeanlistbean.getFlightListBeanList();
		
		//リストの中身がなければ、dbSearchFlagをFaluseにする
		if(list == null){
			odbresultbean.setDbsearchflag(false);
		}
		else{
			odbresultbean.setDbsearchflag(true);
		}
		
		/**
		 * DB判定
		 * 検索結果
		 * リスト
		 */
		odbresultbean.setFlightplanlist(list);
		
		return odbresultbean;
	}
	
}