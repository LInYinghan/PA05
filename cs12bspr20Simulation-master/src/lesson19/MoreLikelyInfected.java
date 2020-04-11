package lesson19;
/*
MoreLikelyInfected is a population where everyone is more likely to get infected when exposed.
Also, they will stay at home when they are infected.
*/
public class MoreLikelyInfected extends StayAtHomeIfSick{
    public MoreLikelyInfected(){
        super();
        this.infectionProb = 0.8;
    }
}
