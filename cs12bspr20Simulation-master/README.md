# cs12bspr20Simulation

This is a simple simulator of the geographical spread of an infection disease. 
The primary purpose of this code is to help learn about inheritance in Java.

The simulation is performed on a 2d grid (Country.places) where the people are distributed (Country.population)
with at most one person per grid point.  In each tick of the simulation, the people try to move to another
grid point and after everyone has moved the infected people spread the virus to some of their neighbors.

This is clearly a very simple model, but it does allow one to see what happens when shelter-in-place orders are given
and some percentage of the populations follows those orders. It also allows you to see the effect of population density
on disease spread.  

None of this can be applied directly to the covid-19 pandemic because this model is too simple, 
but it can help give some insights into the factors impacting the geographical spread of infectious diseases in general.
