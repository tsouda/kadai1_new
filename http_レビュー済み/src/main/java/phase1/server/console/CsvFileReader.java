package phase1.server.console;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.*;

public class CsvFileReader {

		public boolean check_file(String ss,int count){ // 既存のフライトプランを読み込ませた際の要素の確認用
		// ↓値の確認用のプリント文。単体試験の際に無駄に出力されてしまうため、コメントアウト。
//		System.out.println("ss="+ss+":count="+count);

		switch(count){
	    case 0: // DBC
           	try{
           		Object obj  = Integer.parseInt(ss);  // 入力した値がint型以外の場合、ここで例外が発生するのでガード処理として使用する
           	}
           	catch(Exception e){
           		System.out.println("DBC_異常値検出 :"+count);
           		return false;
           	}
	    		break;
	    case 1: // 発着空港
	    case 2:
            if ((ss.matches(".*[@＠｢「｣」\\d:：!#$%&'\"()-=^~|?_.*\\[\\]\\{\\}\\<\\>/]+.*") )) {
            	System.out.println("空港名_異常値検出:"+count);
            	return false;
            }
	    	break;
	    case 3: // 経度、緯度
	    case 4:
	    case 5:
	    case 6:
	    case 7:
	    case 8:
	    case 9:
	    case 10:
	    case 11:
	    case 12:
	    case 13:
	    case 14:
        	try{
        		Object obj  = Double.parseDouble(ss);  // 入力した値がdouble型以外の場合、ここで例外が発生するのでガード処理として使用する
        	}
        	catch(Exception e){
        		System.out.println("経度、緯度_異常値検出:"+count);
        		return false;
        	}
	    	break;
	    case 15: // 時間
	    case 16:
	    case 17:
	    case 18:
	    case 19:
	    case 20:
            if(!ss.matches("([0-1][0-9]|[2][0-3])[:][0-5][0-9].*")){ // HH:MM の表記になっているか 10:00～23:59
            	if(ss.matches("([0-9])[:][0-5][0-9].*")){ // 0:00 ～ 09:59まではOK
            		if(ss.length()!=4){ // 0:00 ～ 09:59 の後ろに余計な文字がついている場合はNG
            			System.out.println("時刻異常検出_レングス異常_1:"+count);
            			return false;
            		}
            		break;
            	}
                System.out.println("時刻異常検出:"+count);
            	return false;
            }
        	if(ss.length()!=5){ // HH:MMの後ろに余計な文字がついていないか
    			System.out.println("時刻異常検出_レングス異常_2:"+count);
    			return false;	
        	}
	    	break;
       	
	    default :
	    	break; 
	    }    	
		return true;
	} 

	public boolean file_read(String file_path,ArrayList<Object> read_list){ // 既存のフライトプランの読み込み時に使用
		
        try{                       
	        //ファイルを読み込む
	        FileReader fr = new FileReader(file_path);
	        BufferedReader br = new BufferedReader(fr);
        	
	        //読み込んだファイルを１行ずつ処理する
	        String line;
	        int count = 0;
	        while ((line = br.readLine()) != null) {

	           	// 区切り文字","で分割する
	            String [] ss = line.split(","); 
	           
	            // 読み込んだファイルの中身を解析
	            for(int i=0;i<ss.length;i++){
	            	
	            	// ↓値の確認用のプリント文。単体試験の際に無駄に出力されてしまうため、コメントアウト。
//	            	System.out.println("SS[i]= "+ss[i]+" ss_length="+ss.length);
//	            	System.out.println("i="+i+" count="+count);
	            	
	            	// リストの要素のチェック
	            	boolean ans = check_file(ss[i],count);
	            	if(ans!=true){	            	
	            		br.close();
	            		read_list.clear(); // check_fileでfalseが返ってきたら、リストを空にする
	            		return false;
	            	}
	            	// 問題なければリストにファイルから読み込んだ値を追加
	            	read_list.add(ss[i]);
	            	count++;
	            }
	            
     	         // ↓値の確認用のプリント文。単体試験の際に無駄に出力されてしまうため、コメントアウト。
//	            System.out.println("#####");
	        }  	       
	        
    	     // ↓値の確認用のプリント文。単体試験の際に無駄に出力されてしまうため、コメントアウト。
//	        for(int j=0;j<read_list.size();j++){
//	        	System.out.println("SS[i] ="+read_list.get(j));
//	        }	        
	        
	        //終了処理
	        br.close();
	        System.out.println("既存ファイルの読み込みが完了しました");
	        return true;
	    }
        catch(FileNotFoundException e){
        	System.out.println("ファイルが見つかりません");
        	return false;
        }
	    catch (IOException ex) {
	        //例外発生時処理
	        ex.printStackTrace();
	        return false;
	    }
	} 
}