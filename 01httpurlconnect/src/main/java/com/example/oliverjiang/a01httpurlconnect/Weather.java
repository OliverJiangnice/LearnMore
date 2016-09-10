package com.example.oliverjiang.a01httpurlconnect;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/10.
 */
public class Weather {
    public int status;
    public ArrayList<small> detail;

    @Override
    public String toString() {
        return "Weather{" +
                "detail=" + detail +
                '}';
    }

    public class small {
        public String city;
        public String date;
        public String day_condition;
        public String day_wind;
        public String day_temperature;
        public String night_condition;
        public String night_wind;
        public String night_temperature;

        @Override
        public String toString() {
            return "small{" +
                    "city='" + city + '\'' +
                    ", date='" + date + '\'' +
                    ", day_condition='" + day_condition + '\'' +
                    ", night_condition='" + night_condition + '\'' +
                    '}';
        }
    }

}
