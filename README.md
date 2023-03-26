# butlerpantry
Pantry Management Java Backend

This is the first draft of a first iteration of an iterative project to learn how to build Java microservices with Spring Boot. First, though, I need to learn how to build a Java backend at all: the first iteration is to be created to the following specifications:
  * Data persistance only through files (.csv)
  * No build tools (Ant/Maven/Gradle)

This app should eventually do the following:

1) Accept inputs to a "Pantry" (inventory catalogue) which contains "Ingredients" and amounts.
2) Accept addition and subtraction of amounts and of items ("Ingredients") with some automatic unit conversion for common unit names.
3) Check if a recipe can be completed with the current inventory.
4) If a recipe cannot be completed, output a persisting shopping list which would permit said recipe to be created.
5) If a recipe can be created, facilitate the subtraction of said recipe from inventory as a unit.

The next iteration should add a database for persistance. 
