package 标准;

import java.util.Scanner;

public class 赛码网 {

	 public static void main(String args[])
	    {
	        Scanner cin = new Scanner(System.in);
	        int a, b;
	        while(cin.hasNextInt())
	        {
	            a = cin.nextInt();
	            b = cin.nextInt();
	            System.out.println(a + b);
	        }
	    }
}

//Queuing	QI	提交太多了， 您的提交正处于排队状态。
//Compiling	CP	您提交的代码正在被编译。
//Running	RN	您的程序正在运行。
//Judging	JG	我们正在检查您程序的输出是否正确。
//Accepted	AC	您的程序是正确的。
//Presentation Error	PE	您的程序输出有格式问题，请检查是否多了或者少了空格（'?'）、制表符（'\t'）或者换行符（'\n'）
//Wrong Answer	WA	您的程序输出结果错误。
//Runtime Error	RE	您的程序在运行时发生错误。
//Time Limit Exceeded	TLE	您的程序运行的时间已经超出了题目的时间限制。
//Memory Limit Exceeded	MLE	您的程序运行的内存已经超出了题目的内存限制。
//Output Limit Exceeded	OLE	您的程序还在运行，但是输出内容字符数已经超过正确答案的字符数，明显已经是错误的，不必再运行下去了。
//Compilation Error	CE	您的程序语法出现问题，编译器无法编译。
//System Error	SE	评判系统内部出现错误 ，我们会尽快处理。
//Out Of Contest Time	OCT	考试已经结束，不再评测提交。