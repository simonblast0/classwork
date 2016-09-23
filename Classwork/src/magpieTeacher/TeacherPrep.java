package magpieTeacher;

import java.util.Scanner;

public class TeacherPrep {

	static Scanner input;
	static boolean inLoop;
	static String response;
	static Topic school;

	public static void main(String[] args) {
		createFields();
		print("Here is a practice sentence. It is easy to read. You can add more words if you want. It will always cut it to 25 characters a line.");
		runMagpie();
	}

	private static void runMagpie() {
		inLoop = true;
		while(inLoop){
			print("What would you like to talk about?");
			response = input.nextLine();
			if(response.indexOf("school") >= 0){
				inLoop = false;
				school.talk(input);
			}else{
				print("Sorry, I didn't understand you.");
			}
		}
	}

	public static void resume(Topic c){
		print("Do you want to change the topic?");
		response = input.nextLine();
		if(response.indexOf("yes") >= 0){

			runMagpie();
		}else{
			print("Okay, let's continue talking.");	
			c.talk(input);
		}
	}

	private static void createFields() {
		input = new Scanner(System.in);
		school = new School();
	}

	public static void print(String s){
		String printString = "";
		int cutoff = 25;
		//this while loop last as long as there are letters left
		while(s.length() > 0){

			String currentCut = "";
			String nextWord = "";

			//while the current cut is still less than the line length 
			//AND there are still words left to add
			while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

				//add the next word
				currentCut += nextWord;

				//remove the word that was added from the original String
				s = s.substring(nextWord.length());

				//identify the following word, exclude the space
				int endOfWord = s.indexOf(" ");

				//if there are no more spaces, this is the last word, so add the whole thing
				if(endOfWord == -1) {
					endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
				}

				//the next word should include the space
				nextWord = s.substring(0,endOfWord+1);
			}

			printString +=currentCut+"\n";

		}
		System.out.print(printString);
	}



}


