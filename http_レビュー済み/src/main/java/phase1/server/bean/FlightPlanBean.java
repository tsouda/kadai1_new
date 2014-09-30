package phase1.server.bean;

import java.io.Serializable;
import java.sql.Time;

public class FlightPlanBean implements Serializable{
    private static long serialVersionUID;
    private Short dbc;
    private String departure;
    private Double dept_longitude;
    private Double dept_latitude;
    private Time dept_time;
    private String arrival;
    private Double arriv_longitude;
    private Double arriv_latitude;
    private Time arriv_time;
    private Double one_longitude;
    private Double one_latitude;
    private Time one_time;
    private Double two_longitude;
    private Double two_latitude;
    private Time two_time;
    private Double three_longitude;
    private Double three_latitude;
    private Time three_time;
    private Double four_longitude;
    private Double four_latitude;
    private Time four_time;
    
    public FlightPlanBean(){
    
    }

    public void setDbc(Short dbc){
    	this.dbc=dbc;
    }

    public Short getDbc(){
        return dbc;
    }

    public void setDeparture(String departure){
    	this.departure = departure;
    }

    public String getDeparture(){
        return departure;
    }

    public void setDept_longitude(Double dept_longitude){
    		this.dept_longitude = dept_longitude;
    }

    public Double getDept_longitude(){
        return dept_longitude;
    }

    public void setDept_latitude(Double dept_latitude){
    		this.dept_latitude=dept_latitude;
    }

    public Double getDept_latitude(){
        return dept_latitude;
    }

    public void setDept_time(Time dept_time){
    		this.dept_time =dept_time;
    }

    public Time getDept_time(){
        return dept_time;
    }

    public void setArrival(String arrival){
    		this.arrival =arrival;
    }

    public String getArrival(){
        return arrival;
    }

    public void setArriv_longitude(Double arriv_longitude){
    	this.arriv_longitude =arriv_longitude;
    }

    public Double getArriv_longitude(){
        return arriv_longitude;
    }

    public void setArriv_latitude(Double arriv_latitude){
    		this.arriv_latitude = arriv_latitude;
    }

    public Double getArriv_latitude(){
        return arriv_latitude;
    }

    public void setArriv_time(Time arriv_time){
    	this.arriv_time = arriv_time;
    }

    public Time getArriv_time(){
        return arriv_time;
    }

    public void setOne_longitude(Double one_longitude){
    	this.one_longitude =one_longitude;
    }

    public Double getOne_longitude(){
        return one_longitude;
    }

    public void setOne_latitude(Double one_latitude){
    	this.one_latitude =one_latitude;
    }

    public Double getOne_latitude(){
        return one_latitude;
    }

    public void setOne_time(Time one_time){
    	this.one_time =one_time;
    }

    public Time getOne_time(){
        return one_time;
    }

    public void setTwo_longitude(Double two_longitude){
    	this.two_longitude =two_longitude;
    }

    public Double getTwo_longitude(){
        return two_longitude;
    }

    public void setTwo_latitude(Double two_latitude){
    	this.two_latitude=two_latitude;
    }

    public Double getTwo_latitude(){
        return two_latitude;
    }

    public void setTwo_time(Time two_time){
    	this.two_time =two_time;
    }

    public Time getTwo_time(){
        return two_time;
    }

    public void setThree_longitude(Double three_longitude){
    	this.three_longitude =three_longitude;
    }

    public Double getThree_longitude(){
        return three_longitude;
    }

    public void setThree_latitude(Double three_latitude){
    	this.three_latitude =three_latitude;
    }

    public Double getThree_latitude(){
        return three_latitude;
    }

    public void setThree_time(Time three_time){
    	this.three_time = three_time;
    }

    public Time getThree_time(){
        return three_time;
    }

    public void setFour_longitude(Double four_longitude){
    	this.four_longitude = four_longitude;
    }

    public Double getFour_longitude(){
        return four_longitude;
    }

    public void setFour_latitude(Double four_latitude){
    	this.four_latitude = four_latitude;
    }

    public Double getFour_latitude(){
        return four_latitude;
    }

    public void setFour_time(Time four_time){
    	this.four_time =four_time;
    }

    public Time getFour_time(){
        return four_time;
    }

    public int hashCode(){
        return 0;
    }

    public boolean equals(Object obj){
        return false;
    }

}