package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class IST2UST {

//    public static void main(String[] args) {
//        System.out.println(ist2ust("2021-11-08 03:22:00"));
//    }

//    public static void main(String[] args) throws ParseException {
//        String[] istDates = new String[]{
//                "2022-03-02 23:24:03",
//                "2022-03-02 14:53:12",
//                "2022-03-01 16:00:31",
//                "2022-03-01 15:58:22",
//                "2022-03-01 11:41:04",
//                "2022-03-01 11:15:10",
//                "2022-03-01 11:13:08",
//                "2022-03-01 11:10:33",
//                "2022-02-28 01:36:34",
//                "2022-02-28 01:28:59",
//                "2022-02-28 01:28:32",
//                "2022-02-28 00:51:57",
//                "2022-02-08 00:47:36",
//                "2022-02-07 21:48:08",
//                "2022-02-05 22:23:25",
//                "2022-02-05 21:38:10",
//                "2022-02-05 20:30:32",
//                "2022-02-05 20:15:30",
//                "2022-02-05 19:59:44",
//                "2022-02-05 19:43:09",
//                "2022-02-05 19:40:18",
//                "2022-02-05 19:33:39",
//                "2022-02-05 19:30:31",
//                "2022-02-05 01:16:30",
//                "2022-01-22 01:44:07",
//                "2022-01-21 09:04:59",
//                "2021-11-08 03:09:56",
//                "2021-11-08 01:32:46",
//                "2021-10-04 22:22:23"
//        };
//
//        Arrays.stream(istDates).forEach(istDate -> System.out.println(ist2ust(istDate)));
//    }

    //    public static void main(String[] args) throws ParseException {
//        String[] istDates = new String[]{"2022-03-31 15:36:39",
//                "2022-02-27 21:21:36",
//                "2022-02-03 19:16:20",
//                "2022-02-03 19:14:02",
//                "2022-02-03 16:34:54"};
//
//        Arrays.stream(istDates).forEach(istDate -> System.out.println(ist2ust(istDate)));
//    }

    public static void main(String[] args) throws ParseException {
        String[] istDates = new String[]{
                "2021-11-29 03:12:23",
                "2021-11-09 23:23:19",
                "2021-11-08 02:41:27",
                "2021-11-05 18:05:26"
        };

        Arrays.stream(istDates).forEach(istDate -> System.out.println(ist2ust(istDate)));
    }

    //
    public static String ist2ust(String istDate) {
        // istDate 2022-03-31 04:36:39

        DateFormat formatterIST = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatterIST.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        Date date = null;
        try {
            date = formatterIST.parse(istDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat formatterUTC = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        formatterUTC.setTimeZone(TimeZone.getTimeZone("UTC"));

        return formatterUTC.format(date);
    }
}
