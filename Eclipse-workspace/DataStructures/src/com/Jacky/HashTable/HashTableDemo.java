package com.Jacky.HashTable;

import java.util.Scanner;

public class HashTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTab hashTab = new HashTab(7);
		String key = "";
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("add");
			System.out.println("list");
			System.out.println("find");
			System.out.println("exit");

			key = scanner.next();

			switch (key) {
			case "add":
				System.out.println("id:");
				int id = scanner.nextInt();
				System.out.println("name");
				String name = scanner.next();
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("id:");
				int id1 =scanner.nextInt();
				hashTab.findEmpById(id1);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				break;
			}

		}

	}

}

class Emp {
	public int id;
	public String name;
	public Emp next; // 默认为空

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

class EmpLinkedList {
	// 头指针指向第一个Emp
	private Emp head;

	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}
		Emp curEmp = head;
		while (true) {
			if (curEmp.next == null) {
				break;
			}
		}
		curEmp.next = emp;
		return;
	}

	public void list(int no) {
		if (head == null) {
			System.out.println("第" + no + "链表为空");
			return;
		}
		System.out.print("第" + no + "链表信息");
		Emp curEmp = head;
		while (true) {
			System.out.printf("=> id =%d name=%s\t", curEmp.id, curEmp.name);
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		System.out.println();
	}

	public Emp findEmpById(int id) {
		if (head == null) {
			System.out.println("链表为空");
			return null;
		}

		Emp curEmp = head;
		while (true) {
			if (curEmp.id == id) {
				break;
			}
			if (curEmp.next == null) {
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;
		}
		return curEmp;
	}

}

class HashTab {
	private EmpLinkedList[] empLinkedListArray;
	private int size;

	public HashTab(int size) {
		this.size = size;
		empLinkedListArray = new EmpLinkedList[size];
		// 要分别初始化每个链表
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}

	}

	public void add(Emp emp) {
		// 根据id找到对应的链表
		int empLinkedListNO = hashFun(emp.id);
		empLinkedListArray[empLinkedListNO].add(emp);

	}

	public void list() {
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i].list(i);
		}
	}

	// 散列函数 取模法
	public int hashFun(int id) {
		return id % size;
	}

	public void findEmpById(int id) {
		int empLinkedListNO = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
		if (emp != null) {
			System.out.printf("在第%d条找到雇员 id= %d\n", (empLinkedListNO + 1), id);
		} else {
			System.out.println("没找到这个雇员");
		}
	}

}
