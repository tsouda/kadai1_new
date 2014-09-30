package phase1.server.bean;

import java.util.ArrayList;


import phase1.server.bean.FlightPlanBean;
import java.io.Serializable;
public class FlightPlanBeanListBean implements Serializable{

	//パラメータ
	private boolean successFlg;
	private ArrayList<FlightPlanBean> list;
	
	/**
	 * setter
	 */
	//DB接続確認
	public void setSuccessflg(boolean successFlg){
		this.successFlg = successFlg;
	}
	//リスト
	public void setFlightListBeanList(ArrayList<FlightPlanBean> list){
		this.list = list;
	}
	
	/**
	 * getter
	 */
	//DB接続確認
	public boolean getsuccessFlg(){
		return successFlg;
	}
	//リスト
	public ArrayList<FlightPlanBean> getFlightListBeanList(){
		return list;
	}
	
}
