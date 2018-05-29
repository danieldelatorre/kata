package com.project.kata.kata;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BerlinClockTest {

    private BerlinClock berlinClock=new BerlinClock();

    @Test
    public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
        String time = "00:00:00";
        Assert.assertEquals("Y", berlinClock.getSeconds(time));
        time="23:59:59";
        Assert.assertEquals("O", berlinClock.getSeconds(time));

    }

    @Test
    public void given_DigitalTime_Then_Return_Single_Minutes_Row(){
        String time = "00:00:00";
        String singleMinutesRow = berlinClock.getSingleMinutesRow(time);

        Assert.assertEquals("OOOO",singleMinutesRow);

        time = "23:59:59";
        singleMinutesRow = berlinClock.getSingleMinutesRow(time);
        Assert.assertEquals("YYYY",singleMinutesRow);

        time = "12:32:00";
        singleMinutesRow = berlinClock.getSingleMinutesRow(time);
        Assert.assertEquals("YYOO",singleMinutesRow);

        time = "12:34:00";
        singleMinutesRow = berlinClock.getSingleMinutesRow(time);
        Assert.assertEquals("YYYY",singleMinutesRow);

        time = "12:35:00";
        singleMinutesRow = berlinClock.getSingleMinutesRow(time);
        Assert.assertEquals("OOOO",singleMinutesRow);
    }

    @Test
    public void given_DigitalTime_Then_Return_Five_Minutes_Row(){
        String time = "00:00:00";
        String fiveMinutesRow=berlinClock.getFiveMinutesRow(time);
        Assert.assertEquals("OOOOOOOOOOO",fiveMinutesRow);

        time="23:59:59";
        fiveMinutesRow = berlinClock.getFiveMinutesRow(time);
        Assert.assertEquals("YYRYYRYYRYY",fiveMinutesRow);

        time="12:04:00";
        fiveMinutesRow = berlinClock.getFiveMinutesRow(time);
        Assert.assertEquals("OOOOOOOOOOO",fiveMinutesRow);

        time="12:23:00";
        fiveMinutesRow = berlinClock.getFiveMinutesRow(time);
        Assert.assertEquals("YYRYOOOOOOO",fiveMinutesRow);

        time="12:35:00";
        fiveMinutesRow = berlinClock.getFiveMinutesRow(time);
        Assert.assertEquals("YYRYYRYOOOO",fiveMinutesRow);

    }

    @Test
    public void given_DigitalTime_Then_Return_Single_Hours_Row(){

        String time = "00:00:00";
        String hoursRow=berlinClock.getHoursRow(time);
        Assert.assertEquals("OOOO",hoursRow);

        time = "23:59:59";
        hoursRow=berlinClock.getHoursRow(time);
        Assert.assertEquals("RRRO",hoursRow);

        time = "02:59:59";
        hoursRow=berlinClock.getHoursRow(time);
        Assert.assertEquals("RROO",hoursRow);

        time = "08:23:00";
        hoursRow=berlinClock.getHoursRow(time);
        Assert.assertEquals("RRRO",hoursRow);


        time = "14:35:00";
        hoursRow=berlinClock.getHoursRow(time);
        Assert.assertEquals("RRRR",hoursRow);
    }

    @Test
    public void given_DigitalTime_Then_Return_Five_Hours_Row(){

        String time = "00:00:00";
        String fiveHoursRow=berlinClock.getFiveHoursRow(time);
        Assert.assertEquals("OOOO",fiveHoursRow);

        time="23:59:59";
        fiveHoursRow=berlinClock.getFiveHoursRow(time);
        Assert.assertEquals("RRRR",fiveHoursRow);

        time="02:04:00";
        fiveHoursRow=berlinClock.getFiveHoursRow(time);
        Assert.assertEquals("OOOO",fiveHoursRow);

        time="08:23:00";
        fiveHoursRow=berlinClock.getFiveHoursRow(time);
        Assert.assertEquals("ROOO",fiveHoursRow);

        time="16:35:00";
        fiveHoursRow=berlinClock.getFiveHoursRow(time);
        Assert.assertEquals("RRRO",fiveHoursRow);


    }

    @Test
    public void given_DigitalTime_then_ConvertToBerlinClock(){

        String time = "00:00:00";
        String result=berlinClock.getSeconds(time)+berlinClock.getFiveHoursRow(time)+berlinClock.getHoursRow(time)+berlinClock.getFiveMinutesRow(time)+berlinClock.getSingleMinutesRow(time);
        Assert.assertEquals("YOOOOOOOOOOOOOOOOOOOOOOO",result);

        time = "23:59:59";
        result = berlinClock.getSeconds(time)+berlinClock.getFiveHoursRow(time)+berlinClock.getHoursRow(time)+berlinClock.getFiveMinutesRow(time)+berlinClock.getSingleMinutesRow(time);
        Assert.assertEquals("ORRRRRRROYYRYYRYYRYYYYYY",result);

        time = "16:50:06";
        result = berlinClock.getSeconds(time)+berlinClock.getFiveHoursRow(time)+berlinClock.getHoursRow(time)+berlinClock.getFiveMinutesRow(time)+berlinClock.getSingleMinutesRow(time);
        Assert.assertEquals("YRRROROOOYYRYYRYYRYOOOOO",result);

        time = "11:37:01";
        result = berlinClock.getSeconds(time)+berlinClock.getFiveHoursRow(time)+berlinClock.getHoursRow(time)+berlinClock.getFiveMinutesRow(time)+berlinClock.getSingleMinutesRow(time);
        Assert.assertEquals("ORROOROOOYYRYYRYOOOOYYOO",result);
    }

    @Test
    public void given_BerlinClock_Then_Return_Digital(){
        String time="YOOOOOOOOOOOOOOOOOOOOOOO";
        String res=berlinClock.convertToDigital(time);
        Assert.assertEquals("00:00:00",res);

        time ="ORRRRRRROYYRYYRYYRYYYYYY";

        res=berlinClock.convertToDigital(time);
        Assert.assertEquals("23:59:59",res);

        //I dont know how to extract the 6 seconds for this particualr case
        //http://agilekatas.co.uk/katas/BerlinClock-Kata

        /*time ="YRRROROOOYYRYYRYYRYOOOOO";
        res=berlinClock.convertToDigital(time);
        Assert.assertEquals("16:50:06",res);*/
    }



}
