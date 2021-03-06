package lesson19;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Yinghan Lin, Ruoxuan Cao, Irene Li, Wendy Mao
 *
 */

public class RunSimulation {
	// the maximum number of days the simulation will run
	private static int MAX_TICKS=1000;

	private Random random = new Random();
	int days;
	int infected;
	int recovered;
	public RunSimulation(int days, int infected, int recovered) {
		this.days=days;
		this.quantity=infected;
		this.pricePerUnit=recovered;
	}
	public static void main(String[] args) {
		// first we get the simulation parameters
		// from the command line
		/***
		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int numStayHome = Integer.parseInt(args[2]);
		int numEssential = Integer.parseInt(args[3]);
		int numSkeptic = Integer.parseInt(args[4]);
		int numFrequentFlier = Integer.parseInt(args[5]);
		int numMoreLikelyInfected = Integer.parseInt(args[6]);
		***/
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter width:");
		int width=Integer.parseInt(sc.nextLine());
		System.out.println("Please enter height:");
		int height=Integer.parseInt(sc.nextLine());
		System.out.println("Please enter the number of StayHome population:");
		int numStayHome=Integer.parseInt(sc.nextLine());
		System.out.println("Please enter the number of Essential population:");
		int numEssential=Integer.parseInt(sc.nextLine());
		System.out.println("Please enter the number of Skeptic population:");
		int numSkeptic=Integer.parseInt(sc.nextLine());
		System.out.println("Please enter the number of FrequentFlier population:");
		int numFrequentFlier=Integer.parseInt(sc.nextLine());
		System.out.println("Please enter the number of MoreLikelyInfected population:");
		int numMoreLikelyInfected=Integer.parseInt(sc.nextLine());
		// next we create the population and the country
		Population population;

		//population = new Population(numPeople);
		//population = new AllStayAtHome(numPeople);
		//int numEssential = numPeople/10;
		//int numOther = numPeople/20;
		//int numStayHome = numPeople - numEssential - numSkeptic-numMoreLikelyInfected-numFrequentFlier;
		population = new MixedPopulation(numStayHome, numEssential, numSkeptic, numFrequentFlier, numMoreLikelyInfected);
		population.createPeople();

		Country country = new Country(width,height);
		// and add a link to the population in the country
		country.population = population;
		// next we place the people into the country randomly
		population.placePeople(country);

		System.out.println("Initial State of the Country");
		country.printCountry();

		System.out.println("\nTracking the Infection");
		int oldnum;
		int days = 0;
		int recovered;
		for(int k=0;k<MAX_TICKS; k++) {
			country.simulateOneStep();
			country.printState(k);
			if (((country.numInfected+country.numRecovered)-oldnum)!=0){
				days = days+k;
				
			}
			int infected = country.numInfected + country.numRecovered;
			
			recovered = country.numRecovered;
			
			oldnum = infected;
			if (country.numInfected==0) {
				break;

			}
		}
		RunSimulation simulation = new RunSimulation(days,oldnum,recovered);
		System.out.println("\nFinal State of the Country");
		country.printCountry();

	}



}
