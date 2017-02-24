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
public class MainKO {



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


    		File file = new File("Korean" + dateFormat.format(date) + ".json");
                if(!file.exists()){
    			file.createNewFile();
    		}
                final FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        final BufferedWriter bufferWritter = new BufferedWriter(fileWritter);



 // TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
                      TwitterStream twitterStream = TwitterStreamBuilderUtil4.getStream();

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
                    Logger.getLogger(MainKO.class.getName()).log(Level.SEVERE, null, ex);
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
    "#syriawillbefree","#freesyrianarmy","#syrianrefugees","#assadwarcrimes","#basharalassad","damascus","#damascus",
    "#GOT", "ASOIAF", "#의 ASOIAF", "존 소", "#의 갓 세븐 ','계절 스론 7 게임",
    "WindsOfWinter", "# Windsofwinter", "GRRM", "#의 GRRM", "#의 Gameofthrones", "겨울이오고있다", "#의 WinterIsComing",
    "겨울의 바람", "R + L = J", "갓 세븐", "#의 gameofthrones", "#의 windsofwinter", "#의 winteriscoming",
    "보좌 시즌 7의 게임", "왕좌의 게임", "왕좌의 게임", "asoiaf", "#의 asoiaf", "grrm", "겨울 바람",
"iPhone7", "아이폰", "# iPhone7", "# 아이폰", "# iPhone7Plus", "#의 iphone7plus", "# 아이폰",
             "#의 iphone7", "애플", "# 애플", "#의 iphone7launch", "#의 애플 워치", "#의 애플 워치", "#의 appleevent",
             "애플", "# 애플", "애플 시계 2", "애플 시계",
"#의 elections2016", "#의 trump2016", "#의 hillary2016",
            "힐러리 클린턴", "부동산 재벌 도널드 트럼프", "트럼프",

            "#의 2016election", "#의 도널드 트럼프", "#의 hillaryclinton", "# 민주주의", "# 공화당", "#의 nobama", "#의 nohillary",
            "#politics", "USA", "#의 POTUS", "#의 자유", "# 트럼프", "힐러리", "# 힐러리",
"#USOpen", "#의 usopen", "조코비치", "# 테니스", "#의 usopen2016", "#의 ATP", "#의 grandslam", "#의 WTA",
"# 세리나 윌리엄스의", "# 나이키", "#의 페더", "#의 조 코 비치", "#의 노바 크 조코비치", "#의 로저 페더러",
"#usa", "#의 nole", "# 전사", "# 나 달에", "#의 노박", "#의 wawrinka", "#의 niketennis", "#의 flushingmeadows",
"#sports", "#의 tennisplayer」, 「니시",
"#syria", "#의 freesyria", "#의 아사", "#의 prayforsyria", "#의 freepalestine", "#의 withsyria", "fuckassad",
    "#의 pray4syria", "#의 syrianwar", "# 시리아", "#의 withpalestine", "#의 freegaza", "#의 freearabworld", "#의 pray4gaza", "#의 withgaza",
    "#syriawillbefree", "#의 freesyrianarmy", "#의 syrianrefugees", "#의 assadwarcrimes", "#의 basharalassad", "다마스쿠스", "#의 다마스쿠스"};
  
  //  String[] keywords = {"#"};
    String[] lang = {"ko"};
    fq.track(keywords);
    fq.language(lang);

    twitterStream.addListener(listener);
    twitterStream.filter(fq);
}

    } 





