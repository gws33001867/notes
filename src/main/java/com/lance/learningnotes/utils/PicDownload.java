package com.lance.learningnotes.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

public class PicDownload {
    private static final String path="/Users/lance/jsProject/纸牌游戏/images";

    public static void main(String[] args) {
        String url="https://www.y7x7.com/game/klondikeblast/cards/";
//        for(int i = 0;i<100;i++){
//            int finalI = i;
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName());
//                download(url+ finalI +".png");
//            }).start();
//
//        }
        download(url+ 12 +".png");

    }


    private static  String download(String urlList) {
        URL url = null;
        String filepath="";
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            String towpath =path;//+"\\"+urlList.substring(urlList.lastIndexOf("/")+1, urlList.length());//+".jpg";
            try{
                File file = new File(towpath);
                if(!file.exists()){
                    file.mkdirs();
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
            filepath=towpath+"//"+urlList.substring(urlList.lastIndexOf("/")+1, urlList.length());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filepath));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filepath;
    }
}
