package xz.sean.mr_all_wise;

import static java.lang.Math.random;

/**
 * Created by SeanC on 2017/7/29.
 */

public class MyUtility {
    public static int mRandomNumber (int min , int max){
        return (int)((max-min)*random());
    }
}
