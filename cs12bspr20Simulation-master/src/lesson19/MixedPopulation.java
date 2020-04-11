package lesson19;

public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numSkeptic;
  int numFrequentFlier;
  int numMoreLikelyInfected;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numSkeptic, int numFrequentFlier, int numMoreLikelyInfected;){
    super(numShelterInPlace + numEssential + numSkeptic + numFrequentFlier + numMoreLikelyInfected);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numSkeptic = numSkeptic;
    this.numFrequentFlier = numFrequentFlier;
    this.numMoreLikelyInfected = numMoreLikelyInfected;
  }

  public void createPeople(){
    for(int i=0; i<this.numShelterInPlace; i++){
      this.addPerson(new StayAtHome());
    }
    for(int i=0; i<this.numEssential; i++){
      this.addPerson(new StayAtHomeIfSick());
    }
    for(int i=0; i<this.numSkeptic; i++){
      this.addPerson(new Skeptic());
    }
    for(int i=0; i<this.numFrequentFlier; i++){
      this.addPerson(new FrequentFlier());
    }
    for(int i=0; i<this.numMoreLikelyInfected; i++){
      this.addPerson(new MoreLikelyInfected());
    }
  }
}
