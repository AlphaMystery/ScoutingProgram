//package falconrobotics.scoutingprogram;
//
//import android.util.Base64;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
//import org.apache.commons.codec.binary.Base64;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
///**
// * Created by 842 on 4/17/2016.
// */
//public class Util_GetTeamInfo {
//
//
//    /**
//     * Retrieve the team list for an event using the FRC Events API 2.0.
//     *
//     * It only pulls the registered team list for a single event and it only displays the info.  It does NOT save it to any database.
//     *
//     * This code does NOT create or use any SQLite databases.  It is purely a retrieve and display version!
//     */
//
//
//        public static void exec( String[] args )
//        {
//            try
//            {
//		/*
//		 * The FRC Events API 2.0 format for getting a team list for an event is:
//		 *
//		 * https://frc-api.firstinspires.org/v2.0/season/teams?teamNumber=842&eventCode=CMP&districtCode=PNW&state=state&page=2
//		 *
//		 * where:
//		 *
//		 * season -  Numeric year of the event from which the schedule is requested. Must be 4 digits and greater than or equal to 2015, and less than or equal to the current year. (e.g. 2016)
//		 * teamNumber - OPTIONAL Numeric teamNumber of the team about which information is requested.  Must be 1 to 4 digits (e.g. 842)
//		 * eventCode - Case insensitive alphanumeric eventCode of the event from which the schedule are requested. Must be at least 3 characters. (e.g. CMP)
//		 * districtCode - OPTIONAL Case insensitive districtCode code of the district from which team listings are requested. (e.g. PNW)
//		 * page - OPTIONAL Numeric page of results to return. If not included, page 1 will be returned. (e.g. 2)
//		 *
//		 *  Response results will look like:
//		 * {
//		 * "teams": [
//    	 * 		{
//    	 * 			"teamNumber": 60,
//    	 * 			"nameFull": "KUSD #20 Kingman High School/Kingman Academy of Learning High School/Chrysler Foundation/Laron Incorporated/Purvis Industries/Brackett Aircraft/Potters, Inc/Praxair/Grand Canyon University/Sutton Funeral Home/3-Systems and the Coca Cola Company/Mohave County Block Grant/I Corp/West Coast Netting/Kingman Regional Medical Center/True Value/Coast Aluminum  & Kingman High School & Kingman Academy of Learning - High School & Lee Williams High School",
//    	 * 			"nameShort": "Bionic Bulldogs",
//    	 * 			"city": "Kingman",
//    	 * 			"stateProv": "Arizona",
//    	 * 			"country": "USA",
//    	 * 			"website": "www.frcteam60.com",
//    	 * 			"rookieYear": 1997,
//    	 * 			"robotName": "Phat $tak$",
//    	 * 			"districtCode": null
//    	 * 		},
//    	 * 		{
//    	 * 			"teamNumber": 125,
//    	 * 			"nameFull": "Textron Systems/National Grid/Northeastern University & Boston Latin & Brookline High & Revere High",
//    	 * 			"nameShort": "NUTRONS",
//    	 * 			"city": "Boston",
//    	 * 			"stateProv": "Massachusetts",
//    	 * 			"country": "USA",
//    	 * 			"website": "http://www.nutrons.com",
//    	 * 			"rookieYear": 1998,
//    	 * 			"robotName": null,
//    	 * 			"districtCode": "NE"
//    	 * 		},
//    	 * 		...
//    	 * 	],
//    	 * 	"teamCountTotal": 53,
//    	 * 	"teamCountPage": 53,
//    	 * 	"pageCurrent": 1,
//    	 * 	"pageTotal": 1
//    	 * }
//    	 *
//		 */
//
//		/*
//		 * The URL to the PRODUCTION server (for live FIRST info)
//		 */
//                String webPageRoot = "https://frc-api.firstinspires.org/v2.0/";
//
//		/*
//		 * The URL to the STAGING server (for app demo/testing)
//		 */
//                // String webPageRoot = "https://frc-staging-api.firstinspires.org/v2.0/";
//
//                String season = "2016";
//                String eventCode = "WEEK0";
//
//		/*
//		 * FRC Events API 2.0 issued credentials
//		 *
//		 * DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE
//		 * DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE
//		 * DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE DO NOT SHARE
//		 */
//                String name = "BruceKahn";
//                String password = "27461226-AFF6-4A7B-8011-C44AA19DD1A5";
//
//		/* END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING
//		 * END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING
//		 * END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING END OF NOT SHARING
//		 */
//                String authString = name + ":" + password;
//                byte[] authEncBytes = Base64.encode(authString.getBytes(), 0);
//                String authStringEnc = new String( authEncBytes );
//
//                System.out.println( "Auth string: " + authString );
//                System.out.println( "Base64 encoded auth string: " + authStringEnc );
//
//                // Construct the URL to retrieve the desired regional list of participating teams
//
//                URL url = new URL( webPageRoot + "/" + season + "/teams?eventCode=" + eventCode );
//                HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
//
//                // Include the required authentication info and the fact we want data in JSON
//
//                httpConnection .setRequestProperty( "Authorization", "Basic " + authStringEnc );
//                httpConnection .setRequestProperty( "Accept", "application/json" );
//
//                InputStream is = httpConnection.getInputStream();
//                int status = httpConnection.getResponseCode();
//
//                System.out.println( "Request status: " + status );
//
//                InputStreamReader isr = new InputStreamReader( is );
//
//                int numCharsRead;
//                char[] charArray = new char[ 1024 ];		// Read 1K of data at a time
//                StringBuffer sb = new StringBuffer();
//
//                // Read all the data they want to send and save it away for processing when they are done
//
//                while ( ( numCharsRead = isr.read( charArray ) ) > 0 )
//                {
//                    sb.append( charArray, 0, numCharsRead );
//                }
//
//                // Another bad practice: the connection is NOT cleanly closed when we are done reading.  We should
//                // close the sessions down nicely even if the remote server may have already done it on their end.
//
//                String result = sb.toString();
//
//
//
//                // Lets do a little quick JSON data processing:
//
//                JSONObject json = new JSONObject( result );
//
//                System.out.println( "pageTotal:      " + json.getInt( "pageTotal" ) );
//                System.out.println( "pageCurrent:    " + json.getInt( "pageCurrent" ) );
//                System.out.println( "teamCountTotal: " + json.getInt( "teamCountTotal" ) );
//                System.out.println( "teamCountPage:  " + json.getInt( "teamCountPage" ) );
//
//                // Lets print out some details about the first team in the teams JSON array
//
//                JSONArray teamsArray = json.getJSONArray( "teams" );
//
//                for ( int i = 0; i < teamsArray.length(); i++ )
//                {
//                    JSONObject teamInfo = teamsArray.getJSONObject( i );
//
//                    System.out.println( "Registration " + ( i + 1 ) + ": " + teamInfo.getInt( "teamNumber" ) + " (" + teamInfo.getString( "nameShort" ) + ") from " +
//                            teamInfo.getString( "city" ) + ", " + teamInfo.getString( "stateProv" ) );
//                }
//            }
//            catch ( MalformedURLException e )
//            {
//                e.printStackTrace();
//            }
//            catch ( IOException e )
//            {
//                e.printStackTrace();
//            }
//        }
//
//
//}
