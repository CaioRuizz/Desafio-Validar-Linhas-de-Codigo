/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.edu.cefsa.pacote;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;

public class Principal {

    public static boolean Balanceado(String s) {

        Stack<Character> charAbertura = new Stack<>();       

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '<') {
                charAbertura.push(s.charAt(i));
            }
            else {
                if (charAbertura.isEmpty()) {
                    return false;
                }
            }

            if (s.charAt(i) == ')' && charAbertura.peek() != '('
                    || s.charAt(i) == ']' && charAbertura.peek() != '['
                    || s.charAt(i) == '}' && charAbertura.peek() != '{'
                    || s.charAt(i) == '>' && charAbertura.peek() != '<') {
                return false;
            }
            else if (s.charAt(i) == ')' && charAbertura.peek() == '('
                    || s.charAt(i) == ']' && charAbertura.peek() == '['
                    || s.charAt(i) == '}' && charAbertura.peek() == '{'
                    || s.charAt(i) == '>' && charAbertura.peek() == '<') {
                charAbertura.pop();
            }

            
        }   

        if (charAbertura.size() == 0) return true;
        else return false;
    }

    public static void main(String[] args) throws Exception {
        
        File file = new File(args[0] + "-check.txt");
        FileWriter fileWriter = new FileWriter(file);
        
        FileReader fileReader = new FileReader(args[0] + ".txt");
        String auxiliar = null;
        BufferedReader linha = new BufferedReader(fileReader);
        while ((auxiliar = linha.readLine()) != null) {
            if (Balanceado(auxiliar) == true) {
                fileWriter.write(auxiliar + " - Ok" + "\n");
            } else {
                fileWriter.write(auxiliar +  " - Inválido" + "\n");
            }
        }
        fileReader.close();
        
    }
}
