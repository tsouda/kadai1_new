package phase1.server.console;

import java.util.ArrayList;
import java.util.Scanner;

public class SetupFlightplan {
	
	// フライトプラン生成に必要な情報を設定するメソッド
	public boolean FlightPlanSetting (ArrayList<Object> setup_list){
		
		Scanner scanner = new Scanner(System.in); 
		
		// DBCを設定
        System.out.print("1:DBC(整数のみ許容) ＞");
        String s = scanner.nextLine();  // 入力した値を一旦保持
        if(s.equals("")){ // 空文字だったら
        	System.out.println("空文字検出");
        	return false;
        }
        else{
        	try{
        		Object obj  = Integer.parseInt(s);  // 入力した値がint型以外の場合、ここで例外が発生するのでガード処理として使用する
        		setup_list.add(obj);  // int型の場合、例外が発生しないため、リストに追加する。
        	}
        	catch(Exception e){
        		System.out.println("異常値検出");
        		return false;
        	}
        }
        
        // 発空港を設定
        System.out.print("2:発空港(特殊文字、数字は非許容)　＞");
        String s2 = scanner.nextLine();  // 入力した値を一旦保持
        if(s2.equals("")){ // 空文字だったら
        	System.out.println("空文字検出");
        	return false;
        }
        else{
        	// 特殊文字、数字は除外
            if ((s2.matches(".*[@＠｢「｣」\\d:：!#$%&'\"()-=^~|?_.*\\[\\]\\{\\}\\<\\>/]+.*") )) {
            	System.out.println("異常値検出");
            	return false;
            }
            else{
            	// 正常値のため、リストに追加
            	setup_list.add(s2);
            }
        }
        
        // 着空港を設定
        System.out.print("3:着空港(特殊文字、数字は非許容) ＞");
        String s3 = scanner.nextLine();  // 入力した値を一旦保持
        if(s3.equals("")){ // 空文字だったら
        	System.out.println("空文字検出");
        	return false;
        }
        else{
        	// 特殊文字、数字は除外
            if ((s3.matches(".*[@＠｢「｣」\\d:：!#$%&'\"()-=^~|?_.*\\[\\]\\{\\}\\<\\>/]+.*") )) {
            	System.out.println("異常値検出");
            	return false;
            }
            else{
            	// 正常値のため、リストに追加
            	setup_list.add(s3);
            }
        }

        // 経度を設定
        System.out.println("4:経度(6つ設定してください_数値(小数点付きも含む)のみ許容");
        for(int i=1;i<=6;i++){
        	System.out.print(i+"つ目＞");
            String s4 = scanner.nextLine();  // 入力した値を一旦保持
            if(s4.equals("")){ // 空文字だったら
            	System.out.println("空文字検出");
            	return false;
            }
            else{
            	try{
            		Object obj  = Double.parseDouble(s4);  // 入力した値がdouble型以外の場合、ここで例外が発生するのでガード処理として使用する
            		setup_list.add(obj);  // double型の場合、例外が発生しないため、リストに追加する。
            	}
            	catch(Exception e){
            		System.out.println("異常値検出");
            		return false;
            	}
            }
        }
        
        // 緯度を設定
        System.out.println("5:緯度(6つ設定してください_数値(小数点付きも含む)のみ許容");
        for(int i=1;i<=6;i++){
        	System.out.print(i+"つ目＞");
            String s5 = scanner.nextLine();  // 入力した値を一旦保持
            if(s5.equals("")){ // 空文字だったら
            	System.out.println("空文字検出");
            	return false;
            }
            else{
            	try{
            		Object obj  = Double.parseDouble(s5);  // 入力した値がdouble型以外の場合、ここで例外が発生するのでガード処理として使用する
            		setup_list.add(obj);  // double型の場合、例外が発生しないため、リストに追加する。
            	}
            	catch(Exception e){
            		System.out.println("異常値検出");
            		return false;
            	}
            }
        }
        
        // 時間を設定
        System.out.println("6:時間(6つ設定してください_HH:MM形式のみ許容)");
        for(int i=1;i<=6;i++){
        	System.out.print(i+"つ目＞");
        	String s6 = scanner.nextLine();  // 入力した値を一旦保持
            if (s6.equals("")) { // 空文字、長さ異常時
            	System.out.println("空文字検出");
                return false;
            }
            
            // 時刻異常かどうかを判定
            if(!s6.matches("([0-1][0-9]|[2][0-3])[:][0-5][0-9].*")){ // HH:MM かどうかを判定
            	if(s6.matches("([0-9])[:][0-5][0-9].*")){ // H:MM については許容
            		if(s6.length()!=4){  // H:MM の後ろに余計な文字がついていないか
            		    System.out.println("レングス異常_H:MM");
            		    return false;
            		}
            		else{
            			// H:MM の正常値の場合
            			setup_list.add(s6);
            		}
            	}
            	else{ // HH:MM以外の場合
            		System.out.println("時刻異常検出時");
            		return false;
            	}
            }
            else{ // HH:MMの場合
            	if(s6.length()!=5){ // HH:MM の後ろに余計な文字がついていないか判定
            		System.out.println("レングス異常_HH:MM");
            		return false;
            	}
            	else{
            		// HH:MM の正常値の場合
            		setup_list.add(s6);
            	}
            }
        }
        
        System.out.print("リストには以下の要素が挿入されました。");
        System.out.println(setup_list.toString());
        System.out.println();
        
        return true;
	}
}