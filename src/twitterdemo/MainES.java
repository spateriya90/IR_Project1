/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package twitterdemo;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitterdemo.TwitterStreamBuilderUtil;
import twitter4j.StallWarning;
import twitter4j.StatusListener;
import twitter4j.TwitterObjectFactory;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;








/**
 *
 * @author Siddharth1
 */
public class MainES {



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException, IOException {
        // TODO code application logic here

       


         /*StatusListener listener = new StatusListener(){
        public void onStatus(Status status) {
            System.out.println(status.getUser().getName() + " : " + status.getText());
        }
        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
        public void onException(Exception ex) {
            ex.printStackTrace();
        }

            public void onScrubGeo(long l, long l1) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
    };*/
   // TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
    //twitterStream.addListener(listener);
    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
   // twitterStream.sample();




//Runtime.getRuntime().exec("clear");



int num = 0;
//TwitterFactory tf = new TwitterFactory(cb.build());
//final Twitter twitter = tf.getInstance();
 
/* Twitter twitter = tf.getInstance();
    Query query = new Query("source: #Trump");
    QueryResult result = twitter.search(query);
    for (Status status : result.getTweets()) {
        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
    }*/

         //DateFormat dateFormat = new SimpleDateFormat(d);
final int count = 0;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;


    		File file = new File("Spanish" + dateFormat.format(date) + ".json");
                if(!file.exists()){
    			file.createNewFile();
    		}
                final FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        final BufferedWriter bufferWritter = new BufferedWriter(fileWritter);



 // TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
                      TwitterStream twitterStream = TwitterStreamBuilderUtil.getStream();

    StatusListener listener = new StatusListener() {
        int num = 0;
        public void onStatus(Status status) {
          //  System.out.println("@" + status.getUser().getScreenName() + " - " + status.getLang()
            //        +status.getText());
//String stat = status.getUser() + status.getLang() + status.getText()
  //                  + status.isRetweet();
            String json = TwitterObjectFactory.getRawJSON(status);
            //String json1 = TwitterObjectFactory.getRawJSON(stat);
            boolean rt = status.isRetweet();
            if(rt == false)
            {
                try {
                    num = num + 1;
                     System.out.println(num);
                    bufferWritter.write(json);
                    bufferWritter.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(MainES.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    ;
        }

        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
            System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
        }

        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
            System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
        }

        public void onScrubGeo(long userId, long upToStatusId) {
            System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
        }

        public void onException(Exception ex) {
            ex.printStackTrace();
        }

            public void onStallWarning(StallWarning sw) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
    };

    FilterQuery fq = new FilterQuery();
    String[] keywords = {"#GOT","ASOIAF","#ASOIAF","Jon Snow","#GOT7","Game of Thrones Season 7",
    "WindsOfWinter","#Windsofwinter","GRRM","#GRRM","#Gameofthrones","Winter Is Coming","#WinterIsComing",
    "The Winds of Winter","R+L=J","got7","#gameofthrones","#windsofwinter","#winteriscoming",
    "game of thrones season 7", "Game of Thrones","game of thrones","asoiaf","#asoiaf","grrm","the winds of winter",
"iPhone7","iPhone","#iPhone7","#iPhone","#iPhone7Plus","#iphone7plus","#iphone",
             "#iphone7","apple","#apple","#iphone7launch","#applewatch","#AppleWatch","#appleevent",
             "Apple","#Apple","Apple Watch 2","Apple Watch",
"#elections2016","#trump2016","#hillary2016",
            "Hillary Clinton","Donald Trump","Trump",
            "#america","#election","#president","#trumpnation","#fl4trump","#trumpforpres","#pumpfortrump",
            "#2016election","#donaldtrump","#hillaryclinton","#democrat","#republican","#nobama","#nohillary",
            "#politics","usa","#potus","#liberal","#trump","hillary","#hillary",
"#USOpen","#usopen","Djokovic","#tennis", "#usopen2016","#atp","#grandslam","#wta"
,"#serenawilliams","#nike","#federer","#djokovic","#novakdjokovic","#rogerfederer",
"#usa","#nole","#champion","#nadal","#novak","#wawrinka","#niketennis","#flushingmeadows",
"#sports","#tennisplayer","nishikori",
"#syria","#freesyria","#assad","#prayforsyria","#freepalestine","#withsyria","fuckassad",
    "#pray4syria","#syrianwar","#syrian","#withpalestine","#freegaza","#freearabworld","#pray4gaza","#withgaza",
    "#syriawillbefree","#freesyrianarmy","#syrianrefugees","#assadwarcrimes","#basharalassad","damascus","#damascus"};
    String[] lang = {"es"};
    fq.track(keywords);
    fq.language(lang);

    twitterStream.addListener(listener);
    twitterStream.filter(fq);
}

    } 





