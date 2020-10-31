package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

	private static class Callabletest implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			int sum = 0;
			for (int i = 0; i <= 100; i++) {
				sum += i;
			}

			return sum;
		}

	}

	public static void main(String[] args) {
		Callabletest c = new Callabletest();
		FutureTask<Integer> result = new FutureTask<Integer>(c);
		new Thread(result).start();

		try {
			Integer sum = result.get();
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
