package phase1.server.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
//テスト用インポート文
// import org.springframework.integration.samples.http.ClientAPDemo;






import phase1.server.bean.FlightPlanBean;
import phase1.server.logic.DatabaseService;

public class SelectDao {

	
	private short error = -1;//エラー値
	
	private SqlSession sqlSession;
	
	  public void setSqlSession(SqlSession sqlSession) {
		    this.sqlSession = sqlSession;
		  }
	  //全件検索
		  public List<FlightPlanBean> selectAll()  {

			  List<FlightPlanBean> list =null;
			  try{
				 list = sqlSession.selectList("phase1.server.mapper.FlightPlanMapper.selectAll");
			  }catch(Exception e  ){
				  //データベース接続エラーの際は、リストの最初のオブジェクトのDBCにマイナスの値を入れて返却する
				  FlightPlanBean bean = DatabaseService.CONTEXT.getBean("ｂean",FlightPlanBean.class);
				  bean.setDbc(error);
				  list = new ArrayList<FlightPlanBean>();
				  list.add(bean);
				  e.printStackTrace();
				  System.out.println("データベースとの接続において何らかのエラーが発生しました");
			  }
			  //リストのサイズが０の場合は、検索結果ﾅｼなのでnullを詰める
			  if(list.size() ==0){
				  list = null;
			  }
			return  list;

		  }
		  
		//1件検索
		  public FlightPlanBean selectOne(short dbc) {
			  FlightPlanBean bean = DatabaseService.CONTEXT.getBean("ｂean",FlightPlanBean.class);
			  try{
				  bean = sqlSession.selectOne("phase1.server.mapper.FlightPlanMapper.selectOne",dbc);
			  }catch(Exception e){
				  //データベース接続エラーの際は、オブジェクトのDBCにマイナスの値を入れて返却する
				  bean.setDbc(error);	
				  e.printStackTrace();
				  System.out.println("データベースとの接続において何らかのエラーが発生しました");
			  }
			  return  bean;
		  }
}
