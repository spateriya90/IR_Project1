/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package twitterdemo;

/**
 *
 * @author Siddharth1
 */
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamBuilderUtil3 {

                public static TwitterStream getStream(){
                                 ConfigurationBuilder cb = new ConfigurationBuilder();
                                 cb.setJSONStoreEnabled(true);


        cb.setDebugEnabled(true)
  .setOAuthConsumerKey("Dwz2RiwBtH9EwbWTJOceo5YAh")
  .setOAuthConsumerSecret("rPbAimbbLSZAzJRYgjztMZBWaXadUHGbteNB96sZx5HwY4RJtN")
  .setOAuthAccessToken("17703783-3gdhbyMRQTJG30Vr7VFcYCAPS0ecjmwqFVtOIRQHz")
  .setOAuthAccessTokenSecret("GEI11YV0OUN4S2m716F22428MFWzdPzuJwrlM4srglAAE");

                                return new TwitterStreamFactory(cb.build()).getInstance();
                }
}
