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

public class TwitterStreamBuilderUtil {

                public static TwitterStream getStream(){
                                 ConfigurationBuilder cb = new ConfigurationBuilder();
                                 cb.setJSONStoreEnabled(true);


        cb.setDebugEnabled(true)
  .setOAuthConsumerKey("bYzmiaxOEvCeL4SijFd0wVmmh")
  .setOAuthConsumerSecret("CVpOpInPTq4gcDshPpRhzt1SvsiWpR2AebLNuYqYzUP0p4AnDF")
  .setOAuthAccessToken("17703783-X4gmP01WGJCwDawFf1a5zGQXYx4Fr4BjrMlPBoAUO")
  .setOAuthAccessTokenSecret("oetxgSRMgF92NHzblYT40UagYOAAIRWSyfQZrlmCG5DrU");

                                return new TwitterStreamFactory(cb.build()).getInstance();
                }
}
