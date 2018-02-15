import java.util.*;
import java.util.regex.Pattern;

public class CatchingAnInsiderTrader {



	static String[] findPotentialInsiderTraders(String[] datafeed) {

		int n = datafeed.length;

		StringBuilder sb = new StringBuilder();

		String[] ar;
		int[] priceChange;
		int count = 0;
		ArrayList<Person> pList = new ArrayList<Person>();
		ArrayList<stockPrice> sList = new ArrayList<stockPrice>();

		int day = 0;
		int price = 0;
		int amount = 0;
		String name;
		String action;
		String[] result;
		ArrayList<String> str = new ArrayList<String>();


		for (int i = 0; i < n; i++) {

			ar = datafeed[i].split(Pattern.quote("|"));

			if (ar.length <= 2) {

				day = Integer.parseInt(ar[0]);
				price = Integer.parseInt(ar[1]);

				stockPrice sp = new stockPrice(day, price);

				sList.add(sp);
				count++;


			} else {

				day = Integer.parseInt(ar[0]);
				name = ar[1];
				action = ar[2];
				amount = Integer.parseInt(ar[3]);

				Person p = new Person(day, name, action, amount);

				pList.add(p);

			}

		}

		priceChange = new int[count];

		for(int i = 0; i < sList.size() - 1; i++) {

			priceChange[i] = sList.get(i + 1).price - sList.get(i).price;

		}

		Person test;
		int total = 0;
		int index = 0;
		int newCount = 0;
		
		System.out.println(pList.size());

		for (int i = 0; i < pList.size(); i++) {
			

			test = pList.get(i);

			amount = test.amount;
			day = test.day;

			if (test.action.equals("BUY")) {

				for (int j = 0; j < sList.size(); j++) {
					if (test.day < sList.get(j).day) {
						index = j;
					}
				}

				total = amount * priceChange[index - 1];
				
				System.out.println(total);



			} else if (test.action.equals("SELL")) {

				for (int j = 0; j < sList.size(); j++) {
					if (test.day < sList.get(j).day) {
						index = j;
					}
				}

				total = (amount * priceChange[index - 1]);
				
				System.out.println(total);

			}

			
			if (total >= 500000) {
				sb.append(test.day);
				sb.append("|");
				sb.append(test.name);
				str.add(sb.toString());
				sb = new StringBuilder();

				newCount++;
			}


		}

		result = new String[str.size()];

		for (int m = 0; m < str.size(); m++) {
			result[m] = str.get(m);
		}

		return result;


	}

	static class stockPrice {

		int day;
		int price;

		public stockPrice(int day, int price) {
			this.day = day;
			this.price = price;
		}
	}

	static class Person {

		int day;
		String name;
		String action;
		int amount;

		public Person(int day, String name, String action, int amount) {
			this.day = day;
			this.name = name;
			this.action = action;
			this.amount = amount;
		}

	}

}
