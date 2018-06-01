package util;


import com.google.gson.Gson;
import entity.RunDate;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class RunDateUtil {

    public String returnAllDate(String id, String password, String sportsType,
                                    long startTime, long endTime, double totalDistance,
                                    double mCurrentLat, double mCurrentLon) {
        double CaloriesPerM = 0.072;
        double MetersPerStep = 0.45;
        String RunDateJson = null;
        RunDate runDate = new RunDate();
        DecimalFormat df = new java.text.DecimalFormat("#.00");
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String sTime = sdf.format(startTime);

        double totalTime = (endTime-startTime) / 1000;

        runDate.setId(id);
        runDate.setPassword(password);
        runDate.setSportsType(sportsType);
        runDate.setStartTime(sTime);
        runDate.setTotalTime(toTimeMMHH(totalTime));//单位秒
        runDate.setTotalDistance(Double.parseDouble(df.format(totalDistance)));//单位米
        runDate.setCalories(Double.parseDouble(df.format(CaloriesPerM * totalDistance)));
        runDate.setTimePerKM(totalTime / totalDistance);
        runDate.setStepCount((int)(totalDistance / MetersPerStep));
        runDate.setmCurrentLat(mCurrentLat);
        runDate.setmCurrentLon(mCurrentLon);

        //封装JSON格式数据
        Gson gson = new Gson();
        RunDateJson = gson.toJson(runDate);

        return RunDateJson;
    }

    public String toTimeMMHH(double totalTime){
        String timeHHMM = null;
        int h = (int)(totalTime / 3600);
        int m = (int)((totalTime % 3600) / 60);
        timeHHMM = h + ":" + m;
        return timeHHMM;
    }

    @Test
    public void Test() {
        System.out.println(returnAllDate("1000", "11","跑步",
                System.currentTimeMillis() + 3600 * 1000, System.currentTimeMillis() + 2*3600*1000,
                200.0, 12.1, 121.1));
    }
}