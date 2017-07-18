/*
	Trivial application that displays a string
*/

public class SentenceBuilder {

	public static void main(String args[]) {
		Noun n = new Noun("elephant", "singular");
		Verb v = new Verb("run");
		System.out.println("The " + n + v);
		//The elephant is running
		Noun n1 = new Noun("tiger", "plural");
		Verb v1 = new Verb("hop");
		System.out.println("The " + n1 + v1);
		//The tigers are hopping.
		Noun n2 = new Noun("cat", "plural");
		Verb v2 = new Verb("clap");
		Adjective a = new Adjective("large");
		System.out.println("The " + a + n2 + v2);
		//The large cats are clapping
		Noun n3 = new Noun("dog", "singular");
		Verb v3 = new Verb("swim");
		System.out.println("The " + v2 + n3 + v3);
		//The  clapping dog is swimming


	}
}
