package com.springExercise.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	// 取得時間
	public static String getTime() {
		// 用Timestamp來記錄日期時間還是很方便的，但有時候顯示的時候是不需要小數位後面的毫秒的，這樣就需要在轉換為String時重新定義格式
		SimpleDateFormat time = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = time.format(date);
		return strDate;
	}
	
	
	//把圖片轉成Base61的字串
	public static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }
	
}
