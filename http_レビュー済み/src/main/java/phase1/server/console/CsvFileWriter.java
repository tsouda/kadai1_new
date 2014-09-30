package phase1.server.console;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CsvFileWriter {
	
	boolean write_csv(ArrayList<Object> list,String file_path){
	
        try {
            //出力先のCSVファイルを指定する
        	FileWriter fw = new FileWriter(file_path, false); // 指定したパス、ファイル名でファイルを作成
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

            // リストの中身を表示。 単体試験時は無駄に出力されてしまうため、コメントアウト
//            Iterator<Object> it = list.iterator();
//            while (it.hasNext()) {
//            	System.out.println("List:");
//                System.out.println(it.next());
//            }
                       
            // ファイルにリストの中身を書いていく
            pw.print(list.get(0));  // DBC
            pw.println();
            
            pw.print(list.get(1));  // 発着空港名
            pw.print(",");
            pw.print(list.get(2));
            pw.println();
            
            pw.print(list.get(3));  // 経度
            pw.print(",");
            pw.print(list.get(4));
            pw.print(",");
            pw.print(list.get(5));            
            pw.print(",");
            pw.print(list.get(6));
            pw.print(",");
            pw.print(list.get(7));  
            pw.print(",");
            pw.print(list.get(8));
            pw.println();
            
            pw.print(list.get(9));  // 緯度
            pw.print(",");
            pw.print(list.get(10));
            pw.print(",");
            pw.print(list.get(11));            
            pw.print(",");
            pw.print(list.get(12));
            pw.print(",");          
            pw.print(list.get(13));
            pw.print(",");
            pw.print(list.get(14));
            pw.println();
            
            pw.print(list.get(15));  // 時間
            pw.print(",");
            pw.print(list.get(16));
            pw.print(",");
            pw.print(list.get(17));            
            pw.print(",");
            pw.print(list.get(18));
            pw.print(",");
            pw.print(list.get(19));
            pw.print(",");
            pw.print(list.get(20));
            pw.println();

            //ファイルに書き出す
            pw.close();

            //終了メッセージを画面に出力する
            System.out.println("出力が完了しました。");
            System.out.println();
            return true;
        }
        catch(FileNotFoundException e){
        	System.out.println("ファイルが存在しません");
        	System.out.println("ファイルのパスを確認してください");
        	return false;
        }
        catch (IOException ex) {
            //例外時処理
        	System.out.println("異常終了");
            return false;
        }
        catch(Exception e){
            //例外時処理
        	System.out.println("異常終了");
            return false;
        }
    }
}