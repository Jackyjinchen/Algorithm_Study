package com.Jacky.HuffmanCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Jacky.Sort.Sort_method;

public class HuffmanCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String content = "i like like like java do you like a java";// 40�ַ�
//		byte[] contentBytes = content.getBytes();
//		System.out.println(contentBytes.length);
//
//		List<Node> nodes = getNodes(contentBytes);
//		System.out.println(nodes);
//
//		// Print tree
//		System.out.println("HuffmanTree");
//		Node huffmanTreeRootNode = createHuffmanTree(nodes);
//		System.out.println("preOrder");
//		huffmanTreeRootNode.preOrder();
//
//		// ���������˶�Ӧ�ĺշ�������
//		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRootNode);
//		System.out.println("���ɵ�Huffman�����" + huffmanCode);
//
//		//17���ַ������ԭ40���ַ���ѹ����Լ57.5%
//		byte[] huffmanCodeBytes = huffmanZip(contentBytes);
//		System.out.println(Arrays.toString(huffmanCodeBytes));

//		byte[] decoderSourse = decode(huffmanCode, huffmanCodeBytes);
//		System.out.println(new String(decoderSourse));

		// ����ѹ���ļ�
		String srcFile = "D:\\test.zip";
		String zipFile = "D:\\shabi.zip";
		String dstFile = "D:\\tesxt.zip";
		zipFile(srcFile, zipFile);
		System.out.println("Zip OK");

		unzipFile(zipFile, dstFile);
		System.out.println("UNZip OK");

	}

	/**
	 * �ļ���ѹ
	 * 
	 * @param zipFile ��ѹ�ļ�
	 * @param dstFile ��ѹ���ļ�·��
	 */
	public static void unzipFile(String zipFile, String dstFile) {

		// �ļ�������
		InputStream is = null;
		OutputStream os = null;
		ObjectInputStream ois = null;
		// ����������
		try {
			is = new FileInputStream(zipFile);
			ois = new ObjectInputStream(is);
			byte[] huffmanBytes = (byte[]) ois.readObject();
			Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
			// ����
			byte[] bytes = decode(codes, huffmanBytes);

			// д�뵽Ŀ���ļ�
			os = new FileOutputStream(dstFile);
			os.write(bytes);

			// �Զ�������ʽд��շ������룬��Ϊ�˻ָ�ԭ�ļ�ʱ��ʹ��

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				is.close();
				os.close();
				ois.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	/**
	 * ��д�ļ�ѹ��
	 * 
	 * @param srcFile ԭʼ�ļ�·��
	 * @param dstFile ѹ�����ļ�·��
	 */
	public static void zipFile(String srcFile, String dstFile) {

		FileInputStream is = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;
		// ����������
		try {
			is = new FileInputStream(srcFile);
			byte[] b = new byte[is.available()];
			// ��ȡ�ļ�
			is.read(b);
			// ʹ�úշ�������
			byte[] huffmanBytes = huffmanZip(b);
			// �����ļ���������ѹ���ļ�
			os = new FileOutputStream(dstFile);
			// ����һ�����ļ������������ObjectOutputStream
			oos = new ObjectOutputStream(os);

			// ��д������Bytesд��ѹ���ļ�
			oos.writeObject(huffmanBytes);

			// ��Ҫ�Ѻշ��������Ҳд���ļ������ָܻ�
			oos.writeObject(huffmanCode);

			// �Զ�������ʽд��շ������룬��Ϊ�˻ָ�ԭ�ļ�ʱ��ʹ��

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				is.close();
				oos.close();
				os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	// 1huffmanCodeBytesת���ɶ�Ӧ������"1110101010010.����"
	// 2���պշ��������ԭ

	// �����ƽ���
	/**
	 * ��������ͨ�����룬��ԭԭ�����ַ�����Ӧ������
	 * 
	 * @param huffmanCodes �շ��������Map
	 * @param huffmanBytes �շ�������õ����ֽ�����
	 * @return
	 */
	private static byte[] decode(Map<Byte, String> huffmanCode, byte[] huffmanBytes) {
		// �ȵõ�huffmanBytes��Ӧ�Ķ������ַ�����"1110101010010.����"
		StringBuilder stringBuilder = new StringBuilder();
		// ��byte����ת�ɶ������ַ���
		for (int i = 0; i < huffmanBytes.length; i++) {
			boolean flag = (i == huffmanBytes.length - 1);
			stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
		}
//		System.out.println("�շ���ת�������ַ���=" + stringBuilder.toString());

		// ���ն�Ӧ�ĺշ���������н��룬�����ѯ����100->a
		Map<String, Byte> map = new HashMap<String, Byte>();
		for (Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
			map.put(entry.getValue(), entry.getKey());

		}
//		System.out.println(map);

		// ����һ�����ϴ��byte
		List<Byte> list = new ArrayList<Byte>();
		// i����ɨ��stringBuilder�е��ַ���
		for (int i = 0; i < stringBuilder.length();) {
			int count = 1;
			boolean flag = true;
			Byte b = null;

			while (flag) {
				// ȥ��һλ��ƴ��
				String key = stringBuilder.substring(i, i + count);
				b = map.get(key);
				if (b == null) {
					count++;
				} else {
					flag = false;
				}
			}
			list.add(b);
			i += count;
		}

		// forѭ��������list�оʹ�������е��ַ�����ԭ���ַ��������ַ�
		// ��list���ݴ���byte[]��
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
	}

	/**
	 * byteת�ɶ������ַ���
	 * 
	 * @param flag ��־�Ƿ���Ҫ����λ��true��Ҫ��
	 * @param b    ����byte
	 * @return b��Ӧ�Ķ������ַ�����(���ղ��뷵�ص�)
	 */
	private static String byteToBitString(boolean flag, byte b) {
		// bת��int���Ϳ���ʹ��toBinaryString
		int temp = b;
		// �����������Ҫ�����λ
		if (flag) {
			temp |= 256;
		}
		String str = Integer.toBinaryString(temp);
		if (flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}
	}

	/**
	 * ��װ�շ���ѹ������
	 * 
	 * @param bytes ԭʼ�ַ�����Ӧ���ֽ�����
	 * @return ����Huffman������ֽ�����
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		// �õ��ڵ���Ϣ
		List<Node> nodes = getNodes(bytes);
		// �����շ�����
		Node huffmanTreeRootNode = createHuffmanTree(nodes);
		// ���ɶ�Ӧ�ĺշ�������
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRootNode);
		// ����ѹ�����byte����
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

		return huffmanCodeBytes;

	}

	/**
	 * 
	 * @param bytes       ԭʼ�ַ�����Ӧ��byte[]
	 * @param huffmanCode �շ��������
	 * @return
	 */
	// ���ַ�����Ӧ��byte[]���飬����һ���շ����������ֽ�����
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCode) {
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(huffmanCode.get(b));
		}
//		System.out.println(stringBuilder.toString());
		// ��133λ�ַ���ת����byte[]

		// ͳ�Ʒ���byte[] huffmanCodeBytes ����
		int len;
//		len=(stringBuilder.length()+7)/8;
		if (stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		} else {
			len = stringBuilder.length() / 8 + 1;
		}

//		 �洢ѹ�����byte��
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;
		for (int i = 0; i < stringBuilder.length(); i += 8) {// ÿ8λ��Ӧһ��byte
			String strByte;
			if (i + 8 > stringBuilder.length()) {// ������λ
				strByte = stringBuilder.substring(i);
			} else {
				strByte = stringBuilder.substring(i, i + 8);

			}

			// ��strByteת��byte����huffmanCodeBytes
			huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
			index++;
		}
		return huffmanCodeBytes;

	}

	/**
	 * 
	 * @param bytes �����ֽ�����
	 * @return ����List��ʽ��Node��
	 */
	private static List<Node> getNodes(byte[] bytes) {
		ArrayList<Node> nodes = new ArrayList<Node>();

		// �洢ÿһ��byte���ֵĴ���-> map[key,value]
		Map<Byte, Integer> counts = new HashMap<>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}

		// ��ֵ�Թ���Node
		// ����Map
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

	// ���ɺշ������ݶ�Ӧ�ĺշ�������
	// ���շ������������Map<Byte,String>
	static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();
	// ƴ��·��������һ��StringBuilder ����Ҷ�ӽڵ�·��
	static StringBuilder stringBuilder = new StringBuilder();

	private static Map<Byte, String> getCodes(Node root) {
		if (root == null) {
			return null;
		}
		getCodes(root.left, "0", stringBuilder);
		getCodes(root.right, "1", stringBuilder);
		return huffmanCode;
	}

	/**
	 * �������node�ڵ�����Ҷ�ӽڵ����������õ��������뵽Map��
	 * 
	 * @param node          ����ڵ�
	 * @param code          ·�������ӽڵ���0 ���ӽڵ���1
	 * @param stringBuilder ƴ��·��
	 */
	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			// �жϵ�ǰnode ��Ҷ�ӽڵ㻹�Ƿ�Ҷ�ӽڵ�
			if (node.data == null) {
				// ���������ߵݹ�
				getCodes(node.left, "0", stringBuilder2);
				getCodes(node.right, "1", stringBuilder2);
			} else {
				huffmanCode.put(node.data, stringBuilder2.toString());
			}
		}
	}

	private static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("Empty");
		}
	}

	private static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			Collections.sort(nodes);

			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
			parentNode.left = leftNode;
			parentNode.right = rightNode;

			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);

		}

		return nodes.get(0);

	}

}

class Node implements Comparable<Node> {
	Byte data;// �������
	int weight;// Ȩֵ�����ֵĴ���
	Node left;
	Node right;

	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	// ǰ�����
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

}
