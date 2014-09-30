package phase1.server.bean;

import java.io.Serializable;
import java.util.ArrayList;

import phase1.server.bean.FlightPlanBean;

public class DbResultBean implements Serializable{

		//パラメータ
		private boolean dbConnectionFlag;
		private boolean dbSearchFlag;
		private ArrayList<FlightPlanBean> list;
		
		/**
		 * setter
		 */
		//DB接続確認
		public void setDbconnectionflag(boolean dbConnectionFlag){
			this.dbConnectionFlag = dbConnectionFlag;
		}
		//検索結果
		public void setDbsearchflag(boolean dbSearchFlag){
			this.dbSearchFlag = dbSearchFlag;
		}
		//リスト
		public void setFlightplanlist(ArrayList<FlightPlanBean> list){
			this.list = list;
		}
		
		/**
		 * getter
		 */
		//DB接続確認
		public boolean getDbconnectionflag(){
			return dbConnectionFlag;
		}
		//検索結果
		public boolean getDbsearchflag(){
			return dbSearchFlag;
		}
		//リスト
		public ArrayList<FlightPlanBean> getFlightplanlist(){
			return list;
		}
}
