# Scrabble

##Scrabble

  Main class. Used to drive the Scrabble game.
  Responsible for: 
      - Creating Racks
      - Getting maximum value of Racks
      
##Rack
  
  Rack class. Contains list of Tiles.
  Handles the internal implementation of `getMaxValue()` for a rack
  
##Tile
  
  Granular level implementation of Tile along with value of that Tile.
  
##AnagramUtil
  
  Responsible for reading from `sowpods.txt` and creating a `HashMap` of all sorted keys.
  
  
###Implementation:

    - Sort the 7 letters
    - Take permutations and check for score
    - Select word with maximum score
