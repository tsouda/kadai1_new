package phase1.server.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.text.*;
import java.util.StringTokenizer;

import phase1.server.bean.*;
import phase1.server.dao.*;
import phase1.server.logic.*;
import test.server.*;

public class HttpReceiveFlightplan {
	
	ReceiveList  rl;
	FlightPlanBean fpb;
	 public DatabaseService DS;
	
	
	public int FlightTest() throws Exception{
		
		// return用変数
		int num = 0;
		boolean ret = false;
		
		// フライトプランコード
		short DBC = 0;
		
		// 経度
		double dept_longitude = 0, 
			   one_longitude = 0, 
			   two_longitude = 0, 
			   three_longitude = 0, 
			   four_longitude = 0, 
			   arriv_longitude = 0;

		// 緯度
		double dept_latitude = 0,
		   	   one_latitude = 0,
		   	   two_latitude = 0,
		   	   three_latitude = 0,
		   	   four_latitude = 0,
		   	   arriv_latitude = 0;

		// 空港名
		String departure = null, 
				arrival = null;

		// 時間
		String start = null,
			   first = null,
			   second = null,
			   third = null,
			   fourth = null,
			   end = null;
		
		Time dept_time = null,
			   one_time = null,
			   two_time = null,
			   three_time = null,
			   four_time = null,
			   arriv_time = null;
		
		// リスト格納用変数
		String buf1 = null,
			   buf2 = null,
			   buf3 = null,
			   buf4 = null,
			   buf5 = null,
			   buf6 = null,
			   buf7 = null,
			   buf8 = null,
			   buf9 = null,
			   buf10 = null,
			   buf11 = null,
			   buf12 = null,
			   buf13 = null;
					   
		try {
			
			rl = new ReceiveList();
			buf1 = (String)rl.list.get(0);
            DBC = Short.parseShort(buf1);
            
            departure =  (String)rl.list.get(1);
            arrival = (String)rl.list.get(2);
            
			buf2 = (String)rl.list.get(3);
			dept_longitude = Double.parseDouble(buf2);
			
			buf3 = (String)rl.list.get(4);
			one_longitude = Double.parseDouble(buf3);
            
			buf4 = (String)rl.list.get(5);
			two_longitude = Double.parseDouble(buf4);
            
			buf5 = (String)rl.list.get(6);
			three_longitude = Double.parseDouble(buf5);
            
			buf6 = (String)rl.list.get(7);
			four_longitude = Double.parseDouble(buf6);
            
			buf7 = (String)rl.list.get(8);
			arriv_longitude = Double.parseDouble(buf7);
            
			buf8 = (String)rl.list.get(9);
			dept_latitude = Double.parseDouble(buf8);
            
			buf9 = (String)rl.list.get(10);
			one_latitude = Double.parseDouble(buf9);
            
			buf10 = (String)rl.list.get(11);
			two_latitude = Double.parseDouble(buf10);
            
			buf11 = (String)rl.list.get(12);
			three_latitude = Double.parseDouble(buf11);
            
			buf12 = (String)rl.list.get(13);
			four_latitude = Double.parseDouble(buf12);
            
			buf13 = (String)rl.list.get(14);
			arriv_latitude = Double.parseDouble(buf13);
            
            start = (String)rl.list.get(15);
            first = (String)rl.list.get(16);
            second = (String)rl.list.get(17);
            third = (String)rl.list.get(18);
            fourth = (String)rl.list.get(19);
            end = (String)rl.list.get(20);
            
        	try{          	
        		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        		java.util.Date dt = sdf.parse(start); 
        		dept_time = new java.sql.Time(dt.getTime());
        	
        		dt = sdf.parse(first);
        		one_time = new java.sql.Time(dt.getTime());

        		dt = sdf.parse(second);
        		two_time = new java.sql.Time(dt.getTime());
        	
        		dt = sdf.parse(third);
        		three_time = new java.sql.Time(dt.getTime());
        	
        		dt = sdf.parse(fourth);
        		four_time = new java.sql.Time(dt.getTime());
        	
        		dt = sdf.parse(end);
        		arriv_time = new java.sql.Time(dt.getTime());
        	}catch(Exception e){
        		e.printStackTrace();
        	}

            		
		
			fpb = new FlightPlanBean();

            fpb.setDbc(DBC);
            fpb.setDeparture(departure);
            fpb.setDept_longitude(dept_longitude);
            fpb.setDept_latitude(dept_latitude);
            fpb.setDept_time(dept_time);
            fpb.setArrival(arrival);
            fpb.setArriv_longitude(arriv_longitude);
            fpb.setArriv_latitude(arriv_latitude);
            fpb.setArriv_time(arriv_time);
            fpb.setOne_longitude(one_longitude);
            fpb.setOne_latitude(one_latitude);
            fpb.setOne_time(one_time);
            fpb.setTwo_longitude(two_longitude);
            fpb.setTwo_latitude(two_latitude);
            fpb.setTwo_time(two_time);
            fpb.setThree_longitude(three_longitude);
            fpb.setThree_latitude(three_latitude);
            fpb.setThree_time(three_time);
            fpb.setFour_longitude(four_longitude);
            fpb.setFour_latitude(four_latitude);
            fpb.setFour_time(four_time);

            System.out.println("\n"+fpb.getDbc());
			System.out.print(fpb.getDeparture());
			System.out.println("\t"+fpb.getArrival());
			System.out.println("*********************");
			System.out.print(fpb.getDept_longitude());
			System.out.print("\t"+fpb.getOne_longitude());
			System.out.print("\t"+fpb.getTwo_longitude());
			System.out.print("\t"+fpb.getThree_longitude());
			System.out.print("\t"+fpb.getFour_longitude());
			System.out.println("\t"+fpb.getArriv_longitude());
			System.out.println("*********************");
			System.out.print(fpb.getDept_latitude());
			System.out.print("\t"+fpb.getOne_latitude());
			System.out.print("\t"+fpb.getTwo_latitude());
			System.out.print("\t"+fpb.getThree_latitude());
			System.out.print("\t"+fpb.getFour_latitude());
			System.out.println("\t"+fpb.getArriv_latitude());
			System.out.println("*********************");
			System.out.print(fpb.getDept_time());
			System.out.print("\t"+fpb.getOne_time());
			System.out.print("\t"+fpb.getTwo_time());
			System.out.print("\t"+fpb.getThree_time());
			System.out.print("\t"+fpb.getFour_time());
			System.out.println("\t"+fpb.getArriv_time());
			
			if(	fpb.getDbc() != null 
			 && fpb.getDeparture() != null 
			 && fpb.getArrival() != null 
			 && fpb.getDept_longitude() != null 
			 && fpb.getOne_longitude() != null 
			 && fpb.getTwo_longitude() != null
			 && fpb.getThree_longitude() != null 
			 && fpb.getFour_longitude() != null 
			 && fpb.getArriv_longitude() != null 
			 && fpb.getDept_latitude() != null 
			 && fpb.getOne_latitude() != null 
			 && fpb.getTwo_latitude() != null 
			 && fpb.getThree_latitude() != null 
			 && fpb.getFour_latitude() != null 
			 && fpb.getArriv_latitude() != null 
			 && fpb.getDept_time() != null 
			 && fpb.getOne_time() != null 
			 && fpb.getTwo_time() != null 
			 && fpb.getThree_time() != null 
			 && fpb.getFour_time() != null 
			 && fpb.getArriv_time() != null 
			){
				
				DS = new DatabaseService();
				ret = DS.executeInsert(fpb);
				if (true == ret){
					num=1;
				}
				
			}
			return num;
  
        } catch (Exception ex) {
            //例外発生時処理
            ex.printStackTrace();
            return num;
        }

	}
/*
	public int FlightTest(String test) throws Exception{
		
		// return用変数
		int num = 0;
		
		// フライトプランコード
		short DBC = 0;
		
		// 経度
		double dept_longitude = 0, 
			   one_longitude = 0, 
			   two_longitude = 0, 
			   three_longitude = 0, 
			   four_longitude = 0, 
			   arriv_longitude = 0;

		// 緯度
		double dept_latitude = 0,
		   	   one_latitude = 0,
		   	   two_latitude = 0,
		   	   three_latitude = 0,
		   	   four_latitude = 0,
		   	   arriv_latitude = 0;

		// 空港名
		String departure = null, 
				arrival = null;

		// 時間
		String start = null,
			   first = null,
			   second = null,
			   third = null,
			   fourth = null,
			   end = null;
		
		Time dept_time = null,
			   one_time = null,
			   two_time = null,
			   three_time = null,
			   four_time = null,
			   arriv_time = null;
		
		// リスト格納用変数
		String buf1 = null,
			   buf2 = null,
			   buf3 = null,
			   buf4 = null,
			   buf5 = null,
			   buf6 = null,
			   buf7 = null,
			   buf8 = null,
			   buf9 = null,
			   buf10 = null,
			   buf11 = null,
			   buf12 = null,
			   buf13 = null;
					   
		try {
			
			TestService  ss = new TestService();
			ss.execute();
			buf1 = (String)ss.list.get(0);
            DBC = Short.parseShort(buf1);
            
            departure =  (String)ss.list.get(1);
            arrival = (String)ss.list.get(2);
            
			buf2 = (String)ss.list.get(3);
			dept_longitude = Double.parseDouble(buf2);
			
			buf3 = (String)ss.list.get(4);
			one_longitude = Double.parseDouble(buf3);
            
			buf4 = (String)ss.list.get(5);
			two_longitude = Double.parseDouble(buf4);
            
			buf5 = (String)ss.list.get(6);
			three_longitude = Double.parseDouble(buf5);
            
			buf6 = (String)ss.list.get(7);
			four_longitude = Double.parseDouble(buf6);
            
			buf7 = (String)ss.list.get(8);
			arriv_longitude = Double.parseDouble(buf7);
            
			buf8 = (String)ss.list.get(9);
			dept_latitude = Double.parseDouble(buf8);
            
			buf9 = (String)ss.list.get(10);
			one_latitude = Double.parseDouble(buf9);
            
			buf10 = (String)ss.list.get(11);
			two_latitude = Double.parseDouble(buf10);
            
			buf11 = (String)ss.list.get(12);
			three_latitude = Double.parseDouble(buf11);
            
			buf12 = (String)ss.list.get(13);
			four_latitude = Double.parseDouble(buf12);
            
			buf13 = (String)ss.list.get(14);
			arriv_latitude = Double.parseDouble(buf13);
            
            start = (String)ss.list.get(15);
            first = (String)ss.list.get(16);
            second = (String)ss.list.get(17);
            third = (String)ss.list.get(18);
            fourth = (String)ss.list.get(19);
            end = (String)ss.list.get(20);
            
        	try{          	
        		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        		java.util.Date dt = sdf.parse(start); 
        		dept_time = new java.sql.Time(dt.getTime());
        	
        		dt = sdf.parse(first);
        		one_time = new java.sql.Time(dt.getTime());

        		dt = sdf.parse(second);
        		two_time = new java.sql.Time(dt.getTime());
        	
        		dt = sdf.parse(third);
        		three_time = new java.sql.Time(dt.getTime());
        	
        		dt = sdf.parse(fourth);
        		four_time = new java.sql.Time(dt.getTime());
        	
        		dt = sdf.parse(end);
        		arriv_time = new java.sql.Time(dt.getTime());
        	}catch(Exception e){
        		e.printStackTrace();
        	}

            		
		
			FlightPlanBean fpb = new FlightPlanBean();

            fpb.setDbc(DBC);
            fpb.setDeparture(departure);
            fpb.setDept_longitude(dept_longitude);
            fpb.setDept_latitude(dept_latitude);
            fpb.setDept_time(dept_time);
            fpb.setArrival(arrival);
            fpb.setArriv_longitude(arriv_longitude);
            fpb.setArriv_latitude(arriv_latitude);
            fpb.setArriv_time(arriv_time);
            fpb.setOne_longitude(one_longitude);
            fpb.setOne_latitude(one_latitude);
            fpb.setOne_time(one_time);
            fpb.setTwo_longitude(two_longitude);
            fpb.setTwo_latitude(two_latitude);
            fpb.setTwo_time(two_time);
            fpb.setThree_longitude(three_longitude);
            fpb.setThree_latitude(three_latitude);
            fpb.setThree_time(three_time);
            fpb.setFour_longitude(four_longitude);
            fpb.setFour_latitude(four_latitude);
            fpb.setFour_time(four_time);

            System.out.println("\n"+fpb.getDbc());
			System.out.print(fpb.getDeparture());
			System.out.println("\t"+fpb.getArrival());
			System.out.println("*********************");
			System.out.print(fpb.getDept_longitude());
			System.out.print("\t"+fpb.getOne_longitude());
			System.out.print("\t"+fpb.getTwo_longitude());
			System.out.print("\t"+fpb.getThree_longitude());
			System.out.print("\t"+fpb.getFour_longitude());
			System.out.println("\t"+fpb.getArriv_longitude());
			System.out.println("*********************");
			System.out.print(fpb.getDept_latitude());
			System.out.print("\t"+fpb.getOne_latitude());
			System.out.print("\t"+fpb.getTwo_latitude());
			System.out.print("\t"+fpb.getThree_latitude());
			System.out.print("\t"+fpb.getFour_latitude());
			System.out.println("\t"+fpb.getArriv_latitude());
			System.out.println("*********************");
			System.out.print(fpb.getDept_time());
			System.out.print("\t"+fpb.getOne_time());
			System.out.print("\t"+fpb.getTwo_time());
			System.out.print("\t"+fpb.getThree_time());
			System.out.print("\t"+fpb.getFour_time());
			System.out.println("\t"+fpb.getArriv_time());
			
			if(	fpb.getDbc() != null 
			 && fpb.getDeparture() != null 
			 && fpb.getArrival() != null 
			 && fpb.getDept_longitude() != null 
			 && fpb.getOne_longitude() != null 
			 && fpb.getTwo_longitude() != null
			 && fpb.getThree_longitude() != null 
			 && fpb.getFour_longitude() != null 
			 && fpb.getArriv_longitude() != null 
			 && fpb.getDept_latitude() != null 
			 && fpb.getOne_latitude() != null 
			 && fpb.getTwo_latitude() != null 
			 && fpb.getThree_latitude() != null 
			 && fpb.getFour_latitude() != null 
			 && fpb.getArriv_latitude() != null 
			 && fpb.getDept_time() != null 
			 && fpb.getOne_time() != null 
			 && fpb.getTwo_time() != null 
			 && fpb.getThree_time() != null 
			 && fpb.getFour_time() != null 
			 && fpb.getArriv_time() != null 
			){
				
				num=1;
			}
			return num;
  
        } catch (Exception ex) {
            //例外発生時処理
            ex.printStackTrace();
            return num;
        }

	}
	 */
}
