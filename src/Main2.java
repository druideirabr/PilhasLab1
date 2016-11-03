import java.util.Stack;

import javax.swing.JOptionPane;

public class Main2 {
	public static void main(String[] args) {
		Stack<String> pilha = new Stack<>();
		String expressao = JOptionPane.showInputDialog("Expressão aqui");
		long t1 = System.currentTimeMillis();
		String[] termos = expressao.split(" ");
		for (int i = 0; i < termos.length; i++) {
			if (!matcherFecha(termos[i])) {
				pilha.push(termos[i]);
			} else {
				Double valor2 = Double.valueOf(pilha.pop());
				String operador = pilha.pop();
				Double valor1 = Double.valueOf(pilha.pop());
				switch (operador) {
				case "+":
					pilha.pop();
					pilha.push(String.valueOf(valor1 + valor2));
					break;
				case "-":
					pilha.pop();
					pilha.push(String.valueOf(valor1 - valor2));
					break;
				case "*":
					pilha.pop();
					pilha.push(String.valueOf(valor1 * valor2));
					break;
				case "/":
					pilha.pop();
					if (valor2 != 0)
						pilha.push(String.valueOf(valor1 / valor2));
					else
						pilha.push("0");
					break;
				}

			}
		}
		System.out.println(pilha.peek());
		System.out.println(System.currentTimeMillis() - t1);
	}
	private static boolean matcherFecha(String c) {
		return c.equals(")") || c.equals("}") || c.equals("]");
	}
}
 //  ( 4 * ( ( 3 + 30 ) / ( 10 - 7 ) ) )
