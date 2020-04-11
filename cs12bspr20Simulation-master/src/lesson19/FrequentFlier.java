package lesson19;
/*
Frequentflier is a population where everyone jump to a random, unoccupied space on the board when they move.
*/
public class FrequentFlier extends Person{
    public FrequentFlier(){
        super();
    }

    public void tryToMove(){
        // find an open random space for the person
        int i = random.nextInt(this.country.places.length);
        int j = random.nextInt(this.country.places[i].length);
        while (this.country.places[i][j] != null) {
            // loop to make sure it is an open space ...
            i = random.nextInt(this.country.places.length);
            j = random.nextInt(this.country.places[i].length);
        }
        moveTo(i,j);
    }
}
