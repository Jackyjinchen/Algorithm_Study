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
        i = 0;                // ��������ֵ������������ͨ��
//        System.out.print(i);  // ������������ʾ���Ƿ���ǰ���á�
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

	    /* �ֽ��� */
	    InputStream is = url.openStream();

	    /* �ַ��� */
	    InputStreamReader isr = new InputStreamReader(is, "utf-8");

	    /* �ṩ���湦�� */
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
