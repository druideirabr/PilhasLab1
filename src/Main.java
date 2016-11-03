import java.util.Stack;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Stack<String> pilha = new Stack<>();
		String expressao = JOptionPane.showInputDialog("Expressão aqui");
		String[] termos = expressao.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
		for (int i = 0; i < termos.length; i++) {
			if (termos[i].equals("(") || termos[i].equals("[") || termos[i].equals("{"))
				pilha.push(termos[i]);
			else if (matcher(termos[i].charAt(0), pilha))
				pilha.pop();
		}
		if (!pilha.isEmpty()) System.out.println("inválido");
		else System.out.println("Válido");

	}

	private static boolean matcher(char a, Stack<String> pilha) {
		if (a == ')' && pilha.peek().charAt(0) == '(' || a == ']' && pilha.peek().charAt(0) == '['
				|| a == '}' && pilha.peek().charAt(0) == '{')
			return true;
		return false;

	}

}
