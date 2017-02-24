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

public class TwitterStreamBuilderUtil2 {

                public static TwitterStream getStream(){
                                 ConfigurationBuilder cb = new ConfigurationBuilder();
                                 cb.setJSONStoreEnabled(true);



        cb.setDebugEnabled(true)
  .setOAuthConsumerKey("IjX6d4WQTrfvhLBLLFzCTvZS6")
  .setOAuthConsumerSecret("tBFC7yuly5dHft43wsLfAB0DKSCo631X9QyhNAPQto5ePQljRb")
  .setOAuthAccessToken("17703783-e2lSF7AoVm6iserk0Jw2Qs3zC7CUTNcPPfcP0ZaVn")
  .setOAuthAccessTokenSecret("a17JG9PzOFNR1qwAuXUUJdb6WWD64KWmjRrAAK1R9hSxA");

                                return new TwitterStreamFactory(cb.build()).getInstance();
                }
}
