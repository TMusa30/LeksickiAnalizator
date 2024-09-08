import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.security.auth.x500.X500Principal;

class LeksickiAnalizator {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int i = 1;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			sb.append(line).append("\n");
			i = i + 1;
		}
		
		List<Analiza> Analize = poziv(sb.toString());
		
		for (Analiza analiza : Analize) {
		    System.out.println(analiza.toString());
		}
		scanner.close();
	}
	public static List<Analiza> poziv(String sb) {
		List<Analiza> result = new ArrayList<>();
		String[] lines = sb.split("\n");
		
		for(int i = 0; i < lines.length; i++) {
			String line = lines[i].trim();
			
			
			if(line.startsWith("//")) {
				continue;
			}
			int j = 0;
			
			while (j < line.length()) {
				char c = line.charAt(j);
				 //
				if(c == '/' && j < line.length() - 1 && line.charAt(j + 1) == '/') {
					break;
				}
				if(Character.isWhitespace(c)) {
					j++;
					continue;
				}
				
				StringBuilder lb = new StringBuilder();
				
				if(c == '*' || c == '/' || c == '+' || c == '-' || c == '=' || c == '(' || c == ')') {
					lb.append(c);
					result.add(new Analiza(resultType(lb.toString()), i + 1, lb.toString()));
					j++;
				}
				else {
					if (Character.isDigit(c)) {
                        while (j < line.length() && Character.isDigit(line.charAt(j))) {
                            lb.append(line.charAt(j));
                            j++;
                        }
                        result.add(new Analiza("BROJ", i + 1, lb.toString()));
                    } else if (Character.isLetter(c)) {
                        while (j < line.length() && (Character.isLetter(line.charAt(j)) || Character.isDigit(line.charAt(j)))) {
                            lb.append(line.charAt(j));
                            j++;
                        }
                        result.add(new Analiza(resultType(lb.toString()), i + 1, lb.toString()));
                    } else {
                        lb.append(c);
                        result.add(new Analiza(resultType(lb.toString()), i + 1, lb.toString()));
                        j++;
                    }
				}
				
			}
			
		}
		
		
		
		return result;
	}


private static String resultType(String lb) {
		if (lb.length() > 0 && Character.isLetter(lb.charAt(0)) && lb.chars().allMatch(c -> Character.isLetterOrDigit(c))) {
        if (lb.equals("za") || lb.equals("od") || lb.equals("do") || lb.equals("az")) {
            return "KR_" + lb.toUpperCase();
        }
        return "IDN";
		}
		else if (isNumeric(lb)) return "BROJ";
		else if (lb.equals("=")) return "OP_PRIDRUZI";
		else if (lb.equals("*")) return "OP_PUTA";
		else if (lb.equals("/")) return "OP_DIJELI";
		else if (lb.equals("+")) return "OP_PLUS";
		else if (lb.equals("-")) return "OP_MINUS";
		else if (lb.equals("(")) return "L_ZAGRADA";
		else  return "D_ZAGRADA";
	
    
}



public static boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
}
class Analiza {
	private int line;
	private String identifikator;
	private String type;
	
	public Analiza(String type, int line, String identifikator) {
		// TODO Auto-generated constructor stub
		this.line = line;
		this.type = type;
		this.identifikator = identifikator;
	}
	
	public String getType() {
		return type;
	}
	public int getLine() {
		return line;
	}
	public String getIdentifikator() {
		return identifikator;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getType() + " " + getLine() + " " + getIdentifikator();
	}
}
