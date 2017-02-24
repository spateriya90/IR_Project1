/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package twitterdemo;

/**
 *
 * @author Siddharth1
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import org.json.simple.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.regex.*;



public class Parser {

    public static void main(String[] args) throws IOException {

  JSONParser parser = new JSONParser();
  String nu = null;

  String[] politics = {"#elections2016","#trump2016","#hillary2016",
            "Hillary Clinton","Donald Trump","Trump",
            "#america","#election","#president","#trumpnation","#fl4trump","#trumpforpres","#pumpfortrump",
            "#2016election","#donaldtrump","#hillaryclinton","#democrat","#republican","#nobama","#nohillary",
            "#politics","#potus","#liberal","#trump","hillary","#hillary",
  "#의 elections2016", "#의 trump2016", "#의 hillary2016",
            "힐러리 클린턴", "부동산 재벌 도널드 트럼프", "트럼프","#의 2016election", "#의 도널드 트럼프", "#의 hillaryclinton", "# 민주주의", "# 공화당", "#의 nobama", "#의 nohillary",
            "#politics", "USA", "#의 POTUS", "#의 자유", "# 트럼프", "힐러리", "# 힐러리","# Elections2016", "# trump2016", "# hillary2016",
            "Hillary Clinton,", "Donald Trump", "Trump",
            "#america", "# Seçim", "# başkan", "# trumpnation", "# fl4trump", "# trumpforpres", "# pumpfortrump",
            "# 2016election", "# Donald Trump", "# hillaryclinton", "# demokrat", "# cumhuriyetçi", "# nobama", "# nohillary",
            "#politics", "Abd", "# POTUS", "# liberal", "# koz", "hillary", "# hillary",};

  String[] entert = {"#GOT","ASOIAF","#ASOIAF","Jon Snow","#GOT7","Game of Thrones Season 7",
    "WindsOfWinter","#windsofwinter","GRRM","#GRRM","#Gameofthrones","Winter Is Coming","#WinterIsComing",
    "The Winds of Winter","R+L=J","got7","gotseason7","#gameofthrones","#windsofwinter","#winteriscoming",
    "game of thrones season 7", "Game of Thrones","game of thrones","asoiaf","#asoiaf","grrm","the winds of winter",
  "#의 ASOIAF", "존 소", "#의 갓 세븐 ','계절 스론 7 게임","gameofthrones","thewindsofwinter","windsofwinter","game of thrones season 7",
    "WindsOfWinter", "# Windsofwinter", "GRRM", "#의 GRRM", "#의 Gameofthrones", "겨울이오고있다", "#의 WinterIsComing",
    "겨울의 바람", "R + L = J", "갓 세븐", "#의 gameofthrones", "#의 windsofwinter", "#의 winteriscoming",
    "보좌 시즌 7의 게임", "왕좌의 게임", "왕좌의 게임", "asoiaf", "#의 asoiaf", "grrm", "겨울 바람",
   "#GOT", "ASOIAF", "# ASOIAF", "Jon Snow", "# Got7", "Thrones Sezon 7 Oyun",
    "WindsOfWinter", "# Windsofwinter", "GRRM", "# GRRM", "# Gameofthrones", "Kış Geliyor", "# WinterIsComing","Kış Rüzgarları", "R + L = J", "Got7", "# gameofthrones", "# windsofwinter", "# winteriscoming",
    "Thrones sezon 7 oyun", "Game of Thrones", "taht oyunu", "asoiaf", "# asoiaf", "grrm", "kış rüzgarları",};

  String[] world = {"#syria","#freesyria","#assad","#prayforsyria","#freepalestine","#withsyria","fuckassad",
    "#pray4syria","#syrianwar","#syrian","#withpalestine","#freegaza","#freearabworld","#pray4gaza","#withgaza",
    "#syriawillbefree","#freesyrianarmy","#syrianrefugees","#assadwarcrimes","#basharalassad","damascus","#damascus",
  "#syria", "#의 freesyria", "#의 아사", "#의 prayforsyria", "#의 freepalestine", "#의 withsyria", "fuckassad",
    "#의 pray4syria", "#의 syrianwar", "# 시리아", "#의 withpalestine", "#의 freegaza", "#의 freearabworld", "#의 pray4gaza", "#의 withgaza",
    "#syriawillbefree", "#의 freesyrianarmy", "#의 syrianrefugees", "#의 assadwarcrimes", "#의 basharalassad", "다마스쿠스", "#의 다마스쿠스",
  "#syria", "# Freesyria", "# assad", "# prayforsyria", "# freepalestine", "# withsyria", "fuckassad",
    "# Pray4syria", "# syrianwar", "# Suriye", "# withpalestine", "# freegaza", "# freearabworld", "# pray4gaza", "# withgaza",
    "#syriawillbefree", "# Freesyrianarmy", "# syrianrefugees", "# assadwarcrimes", "# basharalassad", "Şam", "# Şam"};

  String[] tech = { "iPhone7","iPhone","#iPhone7","#iPhone","#iPhone7Plus","#iphone7plus","#iphone",
             "#iphone7","apple","#apple","#iphone7launch","#applewatch","#AppleWatch","#appleevent",
             "Apple","#Apple","Apple Watch 2","Apple Watch","iPhone7", "아이폰", "# iPhone7", "# 아이폰", "# iPhone7Plus", "#의 iphone7plus", "# 아이폰",
             "#의 iphone7", "애플", "# 애플", "#의 iphone7launch", "#의 애플 워치", "#의 애플 워치", "#의 appleevent",
             "애플", "# 애플", "애플 시계 2", "애플 시계","IPhone7", "iPhone", "# iPhone7", "# iPhone", "# iPhone7Plus", "# iphone7plus", "# iphone",
"# Iphone7", "elma", "# elma", "# iphone7launch", "# Apple Watch", "# Apple Watch", "# appleevent","Apple", "# Elma", "Apple Ürünü 2", "Apple Ürünü"};

  String[] sports = {"#USOpen","#usopen","Djokovic","#tennis", "#usopen2016","#atp","#grandslam","#wta"
,"#serenawilliams","#nike","#federer","#djokovic","#novakdjokovic","#rogerfederer",
"#usa","#nole","#champion","#nadal","#novak","#wawrinka","#niketennis","#flushingmeadows",
"#sports","#tennisplayer","nishikori",
  "#USOpen", "#의 usopen", "조코비치", "# 테니스", "#의 usopen2016", "#의 ATP", "#의 grandslam", "#의 WTA",
"# 세리나 윌리엄스의", "# 나이키", "#의 페더", "#의 조 코 비치", "#의 노바 크 조코비치", "#의 로저 페더러",
"#usa", "#의 nole", "# 전사", "# 나 달에", "#의 노박", "#의 wawrinka", "#의 niketennis", "#의 flushingmeadows",
"#sports", "#의 tennisplayer」, 「니시","#USOpen", "# Usopen", "Cokoviç", "#, tenis", "# usopen2016", "# ATP", "# Grandslam", "# WTA",
"# Serena Williams", "# nike", "# federer", "# Djokovic", "# Novak Đoković", "# Roger Federer",
"#usa", "# Nole", "# şampiyon", "# nadal", "# Novak", "# Wawrinka", "# niketennis", "# flushingmeadows",
"#sports", "# Tennisplayer", "Nishikori"};

  boolean pol = false,ent = false,news = false,tec = false,spo = false, top = false;
  String topic = null;
  String emot = "[:;xX]-?[DP()]";
  String htag = "#[A-Za-z0-9]+";
  String ment = "@[A-Za-z0-9]+";
  String url = "https?://\\S+\\s?";
 // String emoj = "[\\u20a0-\\u32ff\\ud83c\\udc00-\\ud83d\\udeff\\udbb9\\udce5-\\udbb9\\udcee]";
  String emoj = "u'('u'\ud83c[\udf00-\udfff]|'u'\ud83d[\udc00-\ude4f\ude80-\udeff]|'u'[\u2600-\u26FF\u2700-\u27BF]+')";
  int i = 1;
  for (i=1;i<=42;i++)
     try{
         String oldjson = i + ".json";
             Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;


    		File file2 = new File("NewJSON" + oldjson + ".json");
                if(!file2.exists()){
    			file2.createNewFile();
    		}
                final FileWriter fileWritter2 = new FileWriter(file2.getName(),true);
    	        final BufferedWriter bufferWritter2 = new BufferedWriter(fileWritter2);
    BufferedReader br = new BufferedReader(new FileReader(oldjson));
    String strLine = null;
    String co1 = null;
    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   {


boolean hasco = false;
      // Print the content on the console
        JSONObject jsonObject = (JSONObject) parser.parse(strLine);
        JSONObject coord = null;
    //  System.out.println (strLine);
//JSONObject jsonObject = (JSONObject) strLine;
    String text = (String)jsonObject.get("text");
   String lang = (String)jsonObject.get("lang");
   String time = (String)jsonObject.get("timestamp_ms");
   if (jsonObject.containsKey("coordinates")){
   coord = (JSONObject)jsonObject.get("coordinates");
   hasco = (coord == null);
  // hasco = coord.containsKey("coordinates");
   if (hasco == false){
   JSONArray cord = (JSONArray) coord.get("coordinates");
   co1 = cord.toString();
    }}
top = false;
topic = null;
////Check for Topic and match them to hashtags,keywords
     for (String d: politics)
        {

        if (text.contains(d))
        {
            //System.out.println("Topic Apple");
           top = true;
          topic = "Politics";
            break;
        }
        }
        if (!top == true)
        {
            for (String d: entert)
        {
        if (text.toLowerCase().contains(d.toLowerCase()))
        {
            top = true;
            topic = "Entertainment";
            break;
        }
        }
        }
        if (!top == true)
            {
            for (String d: world)
        {
        if (text.toLowerCase().contains(d.toLowerCase()))
        {
            top = true;
            topic = "World News";
            break;
        }
        }
        }

      if (!top == true)
            {
            for (String d: tech)
        {
        if (text.toLowerCase().contains(d.toLowerCase()))
        {
            top = true;
            topic = "Tech";
            break;
        }
        }
        }
      if (!top == true)
            {
            for (String d: sports)
        {
        if (text.toLowerCase().contains(d.toLowerCase()))
        {
            top = true;
            topic = "Sports";
            break;
        }
        }
        }
///End Topic Identify

//Remove hashtags, keywords, urls and emoticons from tweet text

 String tweet_text = text;

//Store Emoticons and remove from text
 boolean emo1 = false;
 Pattern reg = Pattern.compile(emot);
Matcher rm = reg.matcher(text);
List <String> emoticons = new ArrayList<String>();
while (rm.find()){
       emoticons.add(rm.group());
       emo1 = true;
        }
        //System.out.println(emo.size());
        //for (int i = 0; i< emo.size(); i++)
         //   System.out.println(emo.get(i) + "\b");
 text = text.replaceAll(emot, "");              // replace all emoticons with space


 //Store Emojis and remove from text
 boolean emo2 = false;
 Pattern regem = Pattern.compile(emoj);
Matcher rmem = regem.matcher(text);
List <String> emojis = new ArrayList<String>();
while (rmem.find()){
       emojis.add(rmem.group());
       emo2 = true;
        }
        //System.out.println(emo.size());
        //for (int i = 0; i< emo.size(); i++)
         //   System.out.println(emo.get(i) + "\b");
 text = text.replaceAll(emoj, "");              // replace all emojis with space






 //Store hashtags and remove them from text
  boolean hash = false;
 Pattern reg1 = Pattern.compile(htag);
Matcher rm1 = reg1.matcher(text);
List <String> hashtags = new ArrayList<String>();

while (rm1.find()){
       hashtags.add(rm1.group());
       hash = true;
        }
        //System.out.println(emo.size());
        //for (int i = 0; i< emo.size(); i++)
         //   System.out.println(emo.get(i) + "\b");
 text = text.replaceAll(htag, "");              // replace all hashtags with space

  //Store mentions and remove them from text
  boolean men1 = false;
 Pattern reg2 = Pattern.compile(ment);
Matcher rm2 = reg2.matcher(text);
List <String> mentions = new ArrayList<String>();

while (rm2.find()){
       mentions.add(rm2.group());
       men1 = true;
        }
        //System.out.println(emo.size());
        //for (int i = 0; i< emo.size(); i++)
         //   System.out.println(emo.get(i) + "\b");
 text = text.replaceAll(ment, "");              // replace all mentions with space


   //Store URLs and remove them from text
  boolean url1 = false;
 Pattern reg3 = Pattern.compile(url);
Matcher rm3 = reg3.matcher(text);
List <String> urls = new ArrayList<String>();

while (rm3.find()){
       urls.add(rm3.group());
        url1 = true;
        }
        //System.out.println(emo.size());
        //for (int i = 0; i< emo.size(); i++)
         //   System.out.println(emo.get(i) + "\b");
 text = text.replaceAll(url, " ");              // replace all URLs with space

text = text.trim().replaceAll(" +", " ");      //replace 2 or more space characters with just one space
text = text.trim().replaceAll(",", "");        // remove comma

String text_en = null, text_es = null, text_tr = null, text_ko = null, text_xx = null;
Boolean en = false, es = false, tr = false, ko = false, xx = false, is = false, tl = false;

if (!lang.isEmpty() == true)
{
    if (lang.equals("en")) {
text_en = text;
en = true;
        }
    else if(lang.equals("es")) {
text_es = text;
es = true;
        }
    else if(lang.equals("tr")) {
text_tr = text;
tr = true;
        }
    else if(lang.equals("ko")) {
text_ko = text;
ko = true;
        }
    else{
        text_xx = text;
        xx = true;
    }

if (lang.equals("is")){
            is = true;}
if (lang.equals("tl")){
tl = true;
}

}

// Get timestamp and convert to nearest hour in GMT

        long t = Long.parseLong(time);
        Date d = new Date(t);

        SimpleDateFormat sdf = new SimpleDateFormat("EEE yyyy-MM-dd HH:mm:ss z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        //Date d = sdf.parse(time);
        String formattedDate = sdf.format(d);
       // System.out.println(formattedDate);

        Calendar c = new GregorianCalendar();
        c.setTime(d);
        if (c.get(Calendar.MINUTE) >= 30)
        c.add(Calendar.HOUR, 1);

    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);

String out = sdf.format(c.getTime());   //date in required format

//Write JSON

JSONObject file = new JSONObject();
file.put("topic", topic);
file.put("tweet_text", tweet_text);
file.put("tweet_lang", lang);


if (en == true)
file.put("text_en", text);

if (es == true)
file.put("text_es", text);

if (tr == true)
file.put("text_tr", text);

if (ko == true)
file.put("text_ko", text);

if (xx == true)
file.put("text_"+lang, text);

if (emo1 == true)
    if (emo2 == true){
    emoticons.addAll(emojis);}
file.put("tweet_emoticons", emoticons);
if (emo1 == false){
    if (emo2 == true)
    //emoticons.addAll(emojis);
   file.put("tweet_emoticons", emojis);}

if (men1 == true)
file.put("mentions", mentions);
if (men1 == false)
    file.put("mentions", nu);

if (url1 == true)
file.put("tweet_urls", urls);
if (url1 == false)
    file.put("tweet_urls", nu);

if (hash == true)
file.put("hashtags", hashtags);
if (hash == false)
    file.put("hashtags", nu);


file.put("tweet_date", out);

if (hasco == false)
file.put("tweet_loc", co1 );
if (hasco == true)
    file.put("tweet_loc", null);
try {

		//FileWriter file1 = new FileWriter("c:\\test1.json");
    if (is == false && tl == false)
    {
        bufferWritter2.write(file.toJSONString());
                bufferWritter2.newLine();
                bufferWritter2.flush();}

	} catch (IOException e) {
		e.printStackTrace();
	}



}
    bufferWritter2.close();
    
    //Close the input stream
    //in.close();
    }catch (Exception e){//Catch exception if any
     System.err.println("Error: " + e.getMessage());
  }finally{
    // in.close();
        }}}
    

  









