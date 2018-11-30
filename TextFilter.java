package myprojects.grep.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class TextFilter {
	public static void filter(String... pattern) {

		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));) {
			List<String> list = new LinkedList<>();
			System.out.println("Put your text here. Put 'the end' to end input.");
			String str = in.readLine();
			while (!str.equalsIgnoreCase("the end")) {
				list.add(str);
				str = in.readLine();
			}
			List<String> res = analize(list, pattern);
			res.stream().forEach(s -> out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static List<String> analize(List<String> list, String... pattern) {
		List<String> res = new LinkedList<>();
		for (String str : list) {
			for (String strPattern : pattern) {
				if (str.toLowerCase().contains(strPattern.toLowerCase())) {
					res.add(str);
				}
			}
		}
		return res;
	}

}
