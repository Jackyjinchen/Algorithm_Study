package leetcodeanswer;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;

public class _temp {

	static {
        i = 0;                // 给变量赋值可以正常编译通过
//        System.out.print(i);  // 这句编译器会提示“非法向前引用”
    }
	static int i = 1;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		float a=1.0f;
		Arrays.asList(a);
		System.out.println(a);
		System.out.println(Arrays.asList(a));
		String str= "1";
		str.getBytes();
//		InetAddress.getByAddress();
	    URL url = new URL("http://www.baidu.com");

	    /* 字节流 */
	    InputStream is = url.openStream();

	    /* 字符流 */
	    InputStreamReader isr = new InputStreamReader(is, "utf-8");

	    /* 提供缓存功能 */
	    BufferedReader br = new BufferedReader(isr);
	    
	    String line;
	    OutputStream os=new FileOutputStream("F:\\Desktop\\a.html"); 
	    OutputStreamWriter oos=new OutputStreamWriter(os);
	    
	    
	    
	    while ((line = br.readLine()) != null) {
	        System.out.println(line);
	        oos.write(line);
	    }

	    br.close();
	    oos.close();
	}

}
