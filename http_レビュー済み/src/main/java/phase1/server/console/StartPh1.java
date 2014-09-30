package phase1.server.console;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StartPh1 {
	
	public static void main(String[] args) throws IOException{
        
		ArrayList<Object> setup_list = new ArrayList<Object>();  // 新規フライトプラン生成用情報を格納するリスト
		ArrayList<Object> read_list = new ArrayList<Object>();   // 既存のフライトプランの情報を格納するリスト
		Scanner scanner = new Scanner(System.in); 
		SetupFlightplan spf = new SetupFlightplan();
		CsvFileWriter cfw = new CsvFileWriter();
		CsvFileReader cfr = new CsvFileReader();
		HttpSendFlightplan hcd = new HttpSendFlightplan();//外部サーバとAPサーバ間のオブジェクト
				
        // ユーザのテキスト入力を読むために、BufferedReaderを設定
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        SetupFlightplan sfp = new SetupFlightplan();
        
        // 無限ループ
        for(;;){
            // プロンプトを表示
        	System.out.println("**********************************************");
            System.out.print("1:新規フライトプラン設定\n");
            System.out.print("2:既存のフライトプラン読み出し\n");
            System.out.print("3:CSV出力(1で設定した値 or 2で読み出した値をファイルに書き込む)\n");
            System.out.print("4:DB登録(APサーバへ送信)\n");
            System.out.print("99:終了\n");
            System.out.print("処理を選択してください >");
            
            //入力した行を読み込む
            String line = in.readLine();
            
            try{
                int x = Integer.parseInt(line);
                
                switch(x){
                case 1:  // 新規フライトプラン設定
                	if(!(setup_list.isEmpty())){
                		System.out.println("クリアします");
                		setup_list.clear();
                	}
                	boolean ans = sfp.FlightPlanSetting(setup_list);  // listにフライトプラン生成に必要な情報を格納する  
                	if(ans!=true){
                		System.out.println("入力値に誤りがあります");
                		System.out.println();
                		setup_list.clear();
                	}                	                	
                	break;               	
                case 2:  // 既存ファイルの読み込み
                	if(!(read_list.isEmpty())){
                		System.out.println("クリアします");
                		read_list.clear();
                	}                	                
	        		System.out.println("読み込ませるファイルのパスを入力してください(ファイル名まで) >");
	        		System.out.println("例→ C:xxx\\yyy\\zzz.csv\n");
	        		String path = scanner.nextLine();
	           		String file_path = new File(path).getAbsolutePath(); // 不要かもしれないが
 
	                boolean ans2 = cfr.file_read(file_path,read_list);
	                if(ans2!=true){
	                	System.out.println("ファイルの読み込みに失敗しました");
	                	System.out.println();
	                	read_list.clear();
	                }
	                break;
                case 3:  // CSV出力
                	if((setup_list.isEmpty()) && (read_list.isEmpty()) ){
                		System.out.println("新規にフライトプランを生成するか、既存のファイルを読み込ませてください");
                		System.out.println();
                	}
                	else{
                		System.out.println("1:新規作成フライトプラン");
                		System.out.println("2:既存のフライトプラン");
                		System.out.println("さきほど作成したフライトプランか、既存のフライトプランから読み出した情報かのどちらをファイルに書き込むか選択してください>");
                		
                        String s = in.readLine();
                		int a = Integer.parseInt(s);
                		switch(a){
                		case 1:                		
                	        // ファイルの格納場所を指定
                			System.out.println("新規にｃｓｖファイルを作成します");
                			System.out.println("ファイルの作成場所(パス)を指定してください >");
                			String path2 = scanner.nextLine();
                			System.out.println("ファイル名を指定してください(csvファイルのみ許容  ~.csv)>");
                			String file_name = scanner.nextLine();
                			String file_path2 = path2+"\\"+file_name;
                	   		file_path2 = new File(file_path2).getAbsolutePath(); // 不要かもしれないが
                			
                    		boolean ans3 = cfw.write_csv(setup_list,file_path2);  // xmlファイルにリストの中身を書き込む     
        	                if(ans3!=true){
        	                	System.out.println("ファイルの書き込みに失敗しました");
        	                	System.out.println();
        	                }
                			break;
                		case 2:
                	        // ファイルの格納場所を指定
                			System.out.println("既存フライトプランを基にｃｓｖファイルを作成します");
                			System.out.println("ファイルの作成場所(パス)を指定してください >");
                			String path3 = scanner.nextLine();
                			System.out.println("ファイル名を指定してください(csvファイルのみ許容  ~.csv)>");
                			String file_name3 = scanner.nextLine();
                			String file_path3 = path3+"\\"+file_name3;
                	   		file_path3 = new File(file_path3).getAbsolutePath(); // 不要かもしれないが
                			
                    		boolean ans4 = cfw.write_csv(read_list,file_path3);  // xmlファイルにリストの中身を書き込む     
        	                if(ans4!=true){
        	                	System.out.println("ファイルの書き込みに失敗しました");
        	                	System.out.println();
        	                }
                    		break;
                		default :
                			System.out.println("入力値に誤りがあります");
                			break;
                		}
                	}
                	break;
                case 4:  // 送信                
                	if((setup_list.isEmpty()) && (read_list.isEmpty()) ){
                		System.out.println("新規にフライトプランを生成するか、既存のファイルを読み込ませてください");
                		System.out.println();
                	}
                	else{
                		
                		System.out.println("1:新規作成フライトプラン");
                		System.out.println("2:既存のフライトプラン");
                		System.out.println("さきほど作成したフライトプランか、既存のフライトプランから読み出した情報かのどちらをAPサーバへ送信するか選択してください>");
                		
                        String s = in.readLine();
                		int a = Integer.parseInt(s);
                		switch(a){
                		case 1:
                			System.out.println("フライトプラン(新規のフライトプラン)をAPサーバに送信します");
                			boolean send_result = hcd.file_send(setup_list);
                			if(send_result!=true){
                				System.out.println("DB登録に失敗しました");
                			}
                			else{
                				System.out.println("DB登録に成功しました");
                			}
                			setup_list.clear();
                			break;
                		case 2:                    		
                			System.out.println("フライトプラン(既存のフライトプラン)をAPサーバに送信します");
                			boolean send_result2 = hcd.file_send(read_list);
                			if(send_result2!=true){
                				System.out.println("DB登録に失敗しました");
                			}
                			else{
                				System.out.println("DB登録に成功しました");
                			}
                			read_list.clear();
                    		break;
                		default :
                			System.out.println("入力値に誤りがあります");
                			break;
                		}
                	}	                                
                	break;                
                case 99:  // 終了
	                System.out.println("終了します");
	                if(!(setup_list.isEmpty())){
	                	setup_list.clear();
	                }	                
	                if(!(read_list.isEmpty())){
	                	read_list.clear();
	                }
                	break;      	
               	default:  // その他
               		System.out.println("入力値が不正です");
               		System.out.println();
               		break;
                }
                if(x==99)break;
            }
            //何か問題が発生したら、エラーメッセージを表示
            catch(Exception e) {
            	System.out.println("Invalid Input"); 
            	System.out.println();
            	e.printStackTrace();
            }
        }
    }
}