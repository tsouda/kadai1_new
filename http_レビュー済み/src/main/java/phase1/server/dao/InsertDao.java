package phase1.server.dao;



import org.apache.ibatis.session.SqlSession;





import phase1.server.bean.FlightPlanBean;

public class InsertDao {
	
	private SqlSession sqlSession;
	//このメソッドはApplication-context.xmlを読み込んだ時にSpringが勝手に実行する
	public void setSqlSession(SqlSession sqlSession) {
		    this.sqlSession = sqlSession;
		  }
	  
		  public int insertOne(FlightPlanBean bean) {
			  
			  int result = 0;//更新結果。更新が成功すると１が入る

			  short dbc = bean.getDbc();
			  
			  try{
				  Integer number = sqlSession.selectOne("phase1.server.mapper.FlightPlanMapper.selectBeforeInsert",dbc);
			  if(0 == number){
				  	result =  sqlSession.update("phase1.server.mapper.FlightPlanMapper.insertOne",bean);
			  }else{//インサートするDBCと重複するフライトプランがあった場合は削除してからインサートする
				 //重複の削除
				sqlSession.update("phase1.server.mapper.FlightPlanMapper.deleteBeforeInsert",dbc);
				//新規レコードの挿入
				result =  sqlSession.update("phase1.server.mapper.FlightPlanMapper.insertOne",bean);
				  
			  }
			  }catch(Exception e){
				  e.printStackTrace();
				  System.out.println("データベースとの接続において何らかのエラーが発生しました");
			  }
		    return  result;

		  }
		  

}
