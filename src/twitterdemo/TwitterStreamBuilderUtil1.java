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

public class TwitterStreamBuilderUtil1 {

                public static TwitterStream getStream(){
                                 ConfigurationBuilder cb = new ConfigurationBuilder();
                                 cb.setJSONStoreEnabled(true);


        cb.setDebugEnabled(true)
  .setOAuthConsumerKey("o0Eq3FfextKnODi6WhoaJGu2L")
  .setOAuthConsumerSecret("Kr9OC3sj5cNwr93x2YEDkq9HiBioY77r79nHLejwps79rnNM2L")
  .setOAuthAccessToken("17703783-DcUyhAZNcELMmZeNzQH3GWWCy6431r7MP49IKVMiS")
  .setOAuthAccessTokenSecret("AsR0qRARWkvcIZYaqRyGuEaskwTOnHtK8KajYsOgqdrWz");

                                return new TwitterStreamFactory(cb.build()).getInstance();
                }
}
