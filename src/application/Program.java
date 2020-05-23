package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		Map<String, Integer> map = new LinkedHashMap<>();
		
		try (BufferedReader bf = new BufferedReader(new FileReader(path))){		
			
			String line = bf.readLine();
			while (line != null) {
				String[] vet = line.split(",");
				String name = vet[0];
				int votes = Integer.parseInt(vet[1]);
				if (map.containsKey(name)) {
					votes+=map.get(name);
				}
				map.put(name, votes);
				line = bf.readLine();
			}
			
			for (String x : map.keySet()) {
				System.out.println(x + ": " + map.get(x));				
			}
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());			
		}
		
		sc.close();

	}

}
