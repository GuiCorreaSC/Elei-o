package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import entities.Candidatos;

public class Program {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		// System.out.print("Enter file full path: ");

		// File link = new File("C:\\temp\\Eleicao.txt");

		Map<String, Integer> candidatos = new HashMap<>();

	//	Candidatos cand = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\Eleicao.txt"));

			String line = br.readLine();

			while (line != null) {

				String[] vect = line.split(",");
				String name = vect[0];
				Integer votos = Integer.parseInt(vect[1]);

				if (candidatos.containsKey(name)) {
					int votosfar = candidatos.get(name);
					candidatos.put(name, votos + votosfar);
				}
				else {
					candidatos.put(name, votos);
				}

				line = br.readLine();

			}
			for (String key : candidatos.keySet()) {
			 System.out.println(key +": " +candidatos.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}

	}
}
