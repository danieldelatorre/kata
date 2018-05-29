package com.project.kata.kata;

public class BerlinClock {

    public String getSeconds(String time){

        String[] timeSplitted = time.split(":");
        String seconds= timeSplitted[0];
        String secondsRow="";

        if(Integer.parseInt(seconds) % 2 == 0){
            return "Y";
        }
        else{
            return "O";
        }
    }

    public String getSingleMinutesRow(String time){

        String[] timeSplitted = time.split(":");
        String minutes= timeSplitted[1];
        String singleRow="";
        //11 * 5
        // 4 * 1
        int resultSingleMinutesRow = Integer.parseInt(minutes) % 5;


        for(int i=0;i<resultSingleMinutesRow;i++) {

            singleRow = singleRow.concat("Y");

        }

        for(int i=singleRow.length();i<4;i++){
            singleRow = singleRow.concat("O");
        }

        return singleRow;
    }

    public String getFiveMinutesRow(String time){

        String fiveMinutesRow="";
        String[] timeSplitted = time.split(":");
        String minutes= timeSplitted[1];
        int resultFiveMinutesRow =Integer.parseInt(minutes) / 5;

        for(int i=1;i<=resultFiveMinutesRow;i++){
            if(i % 3 == 0){
                fiveMinutesRow = fiveMinutesRow.concat("R");
            }else {
                fiveMinutesRow = fiveMinutesRow.concat("Y");
            }

        }

        for(int i=fiveMinutesRow.length();i<11;i++){
            fiveMinutesRow = fiveMinutesRow.concat("O");
        }

        return fiveMinutesRow;
    }

    public String getHoursRow(String time){

        String[] timeSplitted = time.split(":");
        String hours= timeSplitted[0];
        String hoursRow="";

        int resultHours = (int) Integer.parseInt(hours) % 5;
        for(int i=0;i<resultHours;i++){
            hoursRow=hoursRow.concat("R");
        }

        for(int i=hoursRow.length();i<4;i++){
            hoursRow=hoursRow.concat("O");
        }
        return hoursRow;
    }

    public String getFiveHoursRow(String time){

        String[] timeSplitted = time.split(":");
        String minutes= timeSplitted[1];
        String hours= timeSplitted[0];
        String fiveHoursRow="";
        int resultHours = (int) Integer.parseInt(hours) / 5;

        for(int i=0;i<resultHours;i++){
            fiveHoursRow = fiveHoursRow.concat("R");
        }

        for(int i=fiveHoursRow.length();i<4;i++){
            fiveHoursRow = fiveHoursRow.concat("O");
        }

        return fiveHoursRow;
    }

    public String convertToDigital(String time){
        String seconds=time.substring(0,1);
        String fiveHours=time.substring(1,5);
        String hours = time.substring(5,9);
        String fiveMinutes = time.substring(9,20);
        String minutes=time.substring(20,24);

        String digital_seconds=getDigitalSecondsFromBerlinClock(seconds);

        String digital_minutes=getDigitalMinutesFromBerlinClock(fiveMinutes,minutes);

        String digital_hours = getDigitalHoursFromBerlingClock(fiveHours,hours);

        String res = digital_hours+":"+digital_minutes+":"+digital_seconds;

        return res;
    }

    public String getDigitalSecondsFromBerlinClock(String seconds){

        if(seconds.equals("Y"))
            return "00";
        else{
            return "59";
        }
    }

    public String getDigitalMinutesFromBerlinClock(String fiveminutes,String minutes){

        Integer digital_minutes=0;

        for(int i=0;i<fiveminutes.length();i++){
            if(fiveminutes.charAt(i)=='Y' || fiveminutes.charAt(i)=='R') {
                digital_minutes += 5;
            }

        }

        for(int i=0;i<minutes.length();i++){
            if(minutes.charAt(i)=='Y') {
                digital_minutes++;
            }
        }

        String res=digital_minutes.toString();

        if(res.length()==1){
            res="0"+res;
        }
        return res;
    }

    public String getDigitalHoursFromBerlingClock(String fiveHours,String hours){

        Integer digital_hours=0;

        for(int i=0;i<fiveHours.length();i++){
            if(fiveHours.charAt(i)=='R') {
                digital_hours += 5;
            }
        }

        for(int i=0;i<hours.length();i++){
            if(hours.charAt(i)=='R') {
                digital_hours++;
            }
        }

        String res=digital_hours.toString();

        if(res.length()==1){
            res="0"+res;
        }
        return res;

    }

}
