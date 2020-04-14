package lesson19;

import java.util.*;
/**
 *
 * @author Irene Li, Wendy Mao
 *
 */
public class AnalyzeSimulation{
  RunSimulation[] simulation;
  public AnalyzeSimulation(int rep){
    simulation = new RunSimulation[rep];
  }
  
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter a simulation that's bigger than 100. ");
    int numofrep = scanner.nextInt();
    if(numofrep < 100){
      System.out.println("Please enter a simulation that's bigger than 100. ");
    }else{
      AnalyzeSimulation simulations = new AnalyzeSimulation(numofrep);
      int numofdays = 0;
      int numrecovered = 0;
      int oldinfected = 0;
      for(int i = 0;i<numofrep;i++){
        numofdays = numofdays + simulations[i].days;
        numrecovered = numrecovered + simulations[i].recovered;
        numinfected = simulations[i].infected;
        if (numinfected > oldinfected){
          oldinfected = numinfected;
        }
        System.out.printf("numOfDays:%d   numOfInfected:%d   peakInfectedLevel:%d%n",simulations[i].days,simulations[i].recovered,numinfected);
      }
      double avdays = numofdays/(double)numofrep;
      double avrec = numrecovered/(double)numofrep;
      int maxinfect = oldinfected;
      System.out.printf("numOfDays:%.1f   numOfInfected:%.1f   peakInfectedLevel:%d%n",avdays,avrec,maxinfect);
    }
  }
}

