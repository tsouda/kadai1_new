package phase1.client.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * クラス名:FlightplanSearchValidator
 * 機能:入力DBC値の正常性判定
 * メソッド:private String sanitizing(String str)
 * 	     public boolean checkDBC(String chkDBC)
 * 		 public boolean validate(String strDBC)
 * 
 * 		OK:1～32767の半角数値
 * 		NG:その他の数値、文字、記号
 * 		入力段階で半角数値5ケタ以外が許容されていないため、
 * 		半角空白の処理やsanitaizingは実装不要だけど残す
 * 
 */

public class FlightplanSearchValidator {
	public static final short MIN_DBC = 1;		// 最小DBC
	public static final short MAX_DBC = 32767;	// 最大DBC

	public static final int NG = -1;	// 入力異常
	public static final int OK_ONE = 1;	// 単一検索
	public static final int OK_ALL = 2;	// 全件検索

	
	// 入力文字の無害化
	public String sanitizing(String str){
System.out.println("FlightplanSearchValidator sanitizing ### START ###");
		// 文字なしの場合は、そのまま戻る
		if (null == str || "".equals(str)) {
System.out.println("入力値なし");
System.out.println("FlightplanSearchValidator sanitizing ### END ###");
			return str;
		}
		
		// 空白文字のみの判定
		if( "\b".equals(str) ||
			"\b\b".equals(str) ||
			"\b\b\b".equals(str) ||
			"\b\b\b\b".equals(str) ||
			"\b\b\b\b\b".equals(str) ||
			" ".equals(str) ||
			"  ".equals(str) ||
			"   ".equals(str) ||
			"    ".equals(str) ||
			"     ".equals(str)
	){
System.out.println("空白文字のみ");
System.out.println("FlightplanSearchValidator sanitizing ### END ###");
			return str;
		}
		
		// 無害文字化
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("'", "&#39;");

System.out.println("入力値あり");
System.out.println("FlightplanSearchValidator sanitizing ### END ###");

		return str;
	}

	
	// 数値かつ1～32767の範囲か判定
	public int checkDBC(String chkDBC){
System.out.println("FlightplanSearchValidator checkDBC ### START ###");

		// 入力値なし(空白)の場合は全件検索のためtrue返却
		if(0 == chkDBC.length() || null == chkDBC){
System.out.println("全件検索");
System.out.println("FlightplanSearchValidator checkDBC ### END ###");
			return OK_ALL;

		}
		
		// 空白文字のみの判定
		if( "\b".equals(chkDBC) ||
			"\b\b".equals(chkDBC) ||
			"\b\b\b".equals(chkDBC) ||
			"\b\b\b\b".equals(chkDBC) ||
			"\b\b\b\b\b".equals(chkDBC) ||
			" ".equals(chkDBC) ||
			"  ".equals(chkDBC) ||
			"   ".equals(chkDBC) ||
			"    ".equals(chkDBC) ||
			"     ".equals(chkDBC)
		){
System.err.println("空白文字のみ");
System.out.println("FlightplanSearchValidator sanitizing ### END ###");
			return OK_ALL;
		}

		
		// 文字か数値か判定
		// 数値チェック
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(chkDBC);
		if(true == m.find()){
			// 数値のみであれば範囲判定
			// キャスト(Stringからint)
			int intDBC=Integer.parseInt(chkDBC);
			if(MIN_DBC <= intDBC && MAX_DBC >=intDBC){
				// 範囲内
System.out.println("単一検索");
System.out.println("FlightplanSearchValidator checkDBC ### END ###");

				return OK_ONE;
			}else{
				// 範囲外
System.out.println("入力値範囲外");
System.out.println("FlightplanSearchValidator checkDBC ### END ###");
				return NG;
			}
		}else{

System.out.println("入力値が数値でない");
System.out.println("FlightplanSearchValidator checkDBC ### END ###");
			// 数値のみでない、もしくは範囲外指定の場合
			return NG;
		}
	}
	
	// 外部からの呼び出し用メソッド
//	public boolean validate(String strDBC){
	public int validate(String strDBC){
		
System.out.println("FlightplanSearchValidator validate ### START ###");
		// 内部変数定義
		int ret = NG;	// 結果格納用

		// 入力値取得
		String chkDBC = sanitizing(strDBC);
		
		// 入力値判定
		ret = checkDBC(chkDBC);

System.out.println("判定結果ret:"+ret);
System.out.println("入力値DBC:"+strDBC);
System.out.println("判定用DBC:"+chkDBC);

System.out.println("FlightplanSearchValidator validate ### END ###");

		return ret;
	}
}
