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

public class TwitterStreamBuilderUtil4 {

                public static TwitterStream getStream(){
                                 ConfigurationBuilder cb = new ConfigurationBuilder();
                                 cb.setJSONStoreEnabled(true);


        cb.setDebugEnabled(true)
  .setOAuthConsumerKey("0FFzRwMWxgwHmirXux4jHFDpq")
  .setOAuthConsumerSecret("Clxmt72XHaxySjF8nQVcU8dECSSSumbPRlKFhDlUwe8Ie6vxLp")
  .setOAuthAccessToken("17703783-18xVkfy1EW2nZwFVv6daigdVBgJH21EhnrJLHlDIY")
  .setOAuthAccessTokenSecret("daFuXrxe5T28PtsVksEHL0Ip5cXDjeF55dEH1IE0DqZ6u");

                                return new TwitterStreamFactory(cb.build()).getInstance();
                }
}
