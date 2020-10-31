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
//		String content = "i like like like java do you like a java";// 40字符
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
//		// 测试生成了对应的赫夫曼编码
//		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRootNode);
//		System.out.println("生成的Huffman编码表" + huffmanCode);
//
//		//17个字符，相比原40个字符，压缩率约57.5%
//		byte[] huffmanCodeBytes = huffmanZip(contentBytes);
//		System.out.println(Arrays.toString(huffmanCodeBytes));

//		byte[] decoderSourse = decode(huffmanCode, huffmanCodeBytes);
//		System.out.println(new String(decoderSourse));

		// 测试压缩文件
		String srcFile = "D:\\test.zip";
		String zipFile = "D:\\shabi.zip";
		String dstFile = "D:\\tesxt.zip";
		zipFile(srcFile, zipFile);
		System.out.println("Zip OK");

		unzipFile(zipFile, dstFile);
		System.out.println("UNZip OK");

	}

	/**
	 * 文件解压
	 * 
	 * @param zipFile 解压文件
	 * @param dstFile 解压后文件路径
	 */
	public static void unzipFile(String zipFile, String dstFile) {

		// 文件输入流
		InputStream is = null;
		OutputStream os = null;
		ObjectInputStream ois = null;
		// 创建输入流
		try {
			is = new FileInputStream(zipFile);
			ois = new ObjectInputStream(is);
			byte[] huffmanBytes = (byte[]) ois.readObject();
			Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
			// 解码
			byte[] bytes = decode(codes, huffmanBytes);

			// 写入到目标文件
			os = new FileOutputStream(dstFile);
			os.write(bytes);

			// 以对象流方式写入赫夫曼编码，是为了恢复原文件时候使用

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
	 * 编写文件压缩
	 * 
	 * @param srcFile 原始文件路径
	 * @param dstFile 压缩后文件路径
	 */
	public static void zipFile(String srcFile, String dstFile) {

		FileInputStream is = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;
		// 创建输入流
		try {
			is = new FileInputStream(srcFile);
			byte[] b = new byte[is.available()];
			// 读取文件
			is.read(b);
			// 使用赫夫曼编码
			byte[] huffmanBytes = huffmanZip(b);
			// 创建文件输出流存放压缩文件
			os = new FileOutputStream(dstFile);
			// 创建一个和文件输出流关联的ObjectOutputStream
			oos = new ObjectOutputStream(os);

			// 先写入数据Bytes写入压缩文件
			oos.writeObject(huffmanBytes);

			// 需要把赫夫曼编码表也写入文件，才能恢复
			oos.writeObject(huffmanCode);

			// 以对象流方式写入赫夫曼编码，是为了恢复原文件时候使用

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

	// 1huffmanCodeBytes转换成对应二进制"1110101010010.。。"
	// 2对照赫夫曼编码表还原

	// 二进制解码
	/**
	 * 将二进制通过解码，还原原来的字符串对应的数组
	 * 
	 * @param huffmanCodes 赫夫曼编码表Map
	 * @param huffmanBytes 赫夫曼编码得到的字节数组
	 * @return
	 */
	private static byte[] decode(Map<Byte, String> huffmanCode, byte[] huffmanBytes) {
		// 先得到huffmanBytes对应的二进制字符串，"1110101010010.。。"
		StringBuilder stringBuilder = new StringBuilder();
		// 将byte数组转成二进制字符串
		for (int i = 0; i < huffmanBytes.length; i++) {
			boolean flag = (i == huffmanBytes.length - 1);
			stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
		}
//		System.out.println("赫夫曼转二进制字符串=" + stringBuilder.toString());

		// 按照对应的赫夫曼编码进行解码，反向查询例如100->a
		Map<String, Byte> map = new HashMap<String, Byte>();
		for (Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
			map.put(entry.getValue(), entry.getKey());

		}
//		System.out.println(map);

		// 创建一个集合存放byte
		List<Byte> list = new ArrayList<Byte>();
		// i索引扫描stringBuilder中的字符串
		for (int i = 0; i < stringBuilder.length();) {
			int count = 1;
			boolean flag = true;
			Byte b = null;

			while (flag) {
				// 去除一位，拼接
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

		// for循环结束后list中就存放了所有的字符，还原了字符串单个字符
		// 把list数据存入byte[]中
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
	}

	/**
	 * byte转成二进制字符串
	 * 
	 * @param flag 标志是否需要补高位，true需要补
	 * @param b    传入byte
	 * @return b对应的二进制字符串，(按照补码返回的)
	 */
	private static String byteToBitString(boolean flag, byte b) {
		// b转成int类型可以使用toBinaryString
		int temp = b;
		// 如果是正数需要补充高位
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
	 * 封装赫夫曼压缩方法
	 * 
	 * @param bytes 原始字符串对应的字节数组
	 * @return 经过Huffman编码的字节数组
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		// 得到节点信息
		List<Node> nodes = getNodes(bytes);
		// 创建赫夫曼树
		Node huffmanTreeRootNode = createHuffmanTree(nodes);
		// 生成对应的赫夫曼编码
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRootNode);
		// 生成压缩后的byte数据
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

		return huffmanCodeBytes;

	}

	/**
	 * 
	 * @param bytes       原始字符串对应的byte[]
	 * @param huffmanCode 赫夫曼编码表
	 * @return
	 */
	// 将字符串对应的byte[]数组，返回一个赫夫曼编码后的字节数组
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCode) {
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(huffmanCode.get(b));
		}
//		System.out.println(stringBuilder.toString());
		// 将133位字符串转化成byte[]

		// 统计返回byte[] huffmanCodeBytes 长度
		int len;
//		len=(stringBuilder.length()+7)/8;
		if (stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		} else {
			len = stringBuilder.length() / 8 + 1;
		}

//		 存储压缩后的byte数
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;
		for (int i = 0; i < stringBuilder.length(); i += 8) {// 每8位对应一个byte
			String strByte;
			if (i + 8 > stringBuilder.length()) {// 不够八位
				strByte = stringBuilder.substring(i);
			} else {
				strByte = stringBuilder.substring(i, i + 8);

			}

			// 将strByte转成byte存入huffmanCodeBytes
			huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
			index++;
		}
		return huffmanCodeBytes;

	}

	/**
	 * 
	 * @param bytes 接受字节数据
	 * @return 返回List形式的Node表
	 */
	private static List<Node> getNodes(byte[] bytes) {
		ArrayList<Node> nodes = new ArrayList<Node>();

		// 存储每一个byte出现的次数-> map[key,value]
		Map<Byte, Integer> counts = new HashMap<>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}

		// 键值对构建Node
		// 遍历Map
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

	// 生成赫夫曼数据对应的赫夫曼编码
	// 将赫夫曼编码表存放在Map<Byte,String>
	static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();
	// 拼接路径，定义一个StringBuilder 村塾叶子节点路径
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
	 * 将传入的node节点所有叶子节点霍夫曼编码得到，并放入到Map中
	 * 
	 * @param node          传入节点
	 * @param code          路径：左子节点是0 右子节点是1
	 * @param stringBuilder 拼接路径
	 */
	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			// 判断当前node 是叶子节点还是非叶子节点
			if (node.data == null) {
				// 向左右两边递归
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
	Byte data;// 存放数据
	int weight;// 权值，出现的次数
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

	// 前序遍历
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
