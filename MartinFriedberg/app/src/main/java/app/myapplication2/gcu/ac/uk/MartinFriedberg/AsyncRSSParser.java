package app.myapplication2.gcu.ac.uk.MartinFriedberg;

/**
 * Created by Martin on 14/12/2014.
 */
import android.content.Context;
 import android.os.AsyncTask;
import android.widget.Toast;

         import java.net.MalformedURLException;



         public class AsyncRSSParser extends AsyncTask<String, Integer, RSSDataItem>
 {

         private Context appContext;
         private String urlRSSToParse;

         public AsyncRSSParser(Context currentAppContext, String urlRSS)
         {
         appContext = currentAppContext;
         urlRSSToParse = urlRSS;
         }

         // A callback method executed on UI thread on starting the task
         @Override
 protected void onPreExecute() {
         // Message to indicate start of parsing
         Toast.makeText(appContext,"Parsing started!", Toast.LENGTH_SHORT).show();
         }

         @Override
 protected RSSDataItem doInBackground(String... params)
         {
         RSSDataItem parsedData;
         RSSParser rssParser = new RSSParser();
         try {
         rssParser.parseRSSData(urlRSSToParse);
         } catch (MalformedURLException e) {
         e.printStackTrace();
         }
         parsedData = rssParser.getRSSDataItem();

         return parsedData;
         }



         // A callback method executed on UI thread, invoked after the completion of the task
         // When doInbackground has completed, the return value from that method is passed into this event
         // handler.
         @Override
 protected void onPostExecute(RSSDataItem result) {
         // Message to indicate end of parsing
         Toast.makeText(appContext,"Parsing finished!", Toast.LENGTH_SHORT).show();
         }


         }
