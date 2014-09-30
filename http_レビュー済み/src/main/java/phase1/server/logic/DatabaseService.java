package phase1.server.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import phase1.server.bean.FlightPlanBean;
import phase1.server.bean.FlightPlanBeanListBean;
import phase1.server.dao.InsertDao;
import phase1.server.dao.SelectDao;

public class DatabaseService {
	//アプリケーションコンテクスストをスタティックで宣言　こいつはDB接続クラスみんなで仲良く使う
	//ところで、DB接続クラス以外もアプリケーションコンテキストを使用すると思うが、競合したりはしないのだろうか？
	public static  ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		
	private boolean success = true;
	private boolean failed = false;
	public String arrival = null;
	boolean successFlg = failed;// DB接続判別フラグ

	/**
	 * 引数で区別 全件検索
	 * 
	 * @return
	 */
	
	public FlightPlanBeanListBean executeSelect() {
		FlightPlanBeanListBean listBean = CONTEXT.getBean(
				"listBean", FlightPlanBeanListBean.class);
		SelectDao selectDao = CONTEXT.getBean("selectDao",
				SelectDao.class);
		// 検索実行
		List<FlightPlanBean> list = selectDao.selectAll();

		// リストをArrayListに変換する
		ArrayList<FlightPlanBean> arrayList = (ArrayList<FlightPlanBean>) list;

		// 一個目のリスト要素を取り出してDBの接続結果を調べる
		if (arrayList != null) {

			FlightPlanBean bean = arrayList.get(0);

			// DB接続に失敗した場合は一番最初のリストのDBCにー１が入っている
			if (bean.getDbc() != -1) {
				successFlg = success;

			} else {// DB接続失敗のパターンはリストをnullにする
				arrayList = null;
			}
			// nullが返ってきた場合は、検索対象がなかったことを示す

		} else {
			successFlg = success;
		}
		listBean.setSuccessflg(successFlg);
		listBean.setFlightListBeanList(arrayList);
		return listBean;
	}

	/**
	 * 一件検索
	 * 
	 * @param dbc
	 * @return
	 */
	public FlightPlanBeanListBean executeSelect(short dbc) {

		SelectDao selectDao = CONTEXT.getBean("selectDao",
				SelectDao.class);
		FlightPlanBeanListBean listBean = CONTEXT.getBean(
				"listBean", FlightPlanBeanListBean.class);

		FlightPlanBean bean = selectDao.selectOne(dbc);

		// リストビーンはリストを格納することになっているので、リストを生成して検索結果ビーンを格納する
		ArrayList<FlightPlanBean> arrayList = new ArrayList<FlightPlanBean>();
		arrayList.add(bean);
		// 検索結果の有無チェック
		if (bean != null) {
			// DB接続に失敗した場合はDBCにー１が入っている
			if (bean.getDbc() != -1) {
				successFlg = success;
			} else {
				// DN接続失敗の場合はリストをnullにする
				arrayList = null;
			}
		} else {//検索件数０のケース
			successFlg = success;
			arrayList = null;
		}
		// リストビーンにフラグとリストを突っ込む
		listBean.setFlightListBeanList(arrayList);

		listBean.setSuccessflg(successFlg);
		return listBean;
	}

	/**
	 * 
	 * @param bean
	 * @return
	 */
	public boolean executeInsert(FlightPlanBean bean) {
		boolean successFlg = failed;

			InsertDao insertDao = CONTEXT.getBean("insertDao",
					InsertDao.class);
			int result = insertDao.insertOne(bean);
			if (result == 1) {
				successFlg = success;
			}

		return successFlg;
	}
}
