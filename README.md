

# Wordle

## Aim

To create a java program that would allow the user to play the game wordle through the console.

## Live Site

**Deployed Site** : https://github.com/gerden/wordle.git



## MVP:
    [x] Recreate a simplified version of the game Wordle to be played in a Java console application
    [x] The game should be able to randomly select a 5-letter word from the provided word list
    [x] The user will be able to enter a guess word that is also 5 characters long
    [x] For each letter, the application will tell the user if that letter is correct, right letter in the wrong position, or wrong letter
    [x] After the user guesses 6 times incorrectly, the game is over and the user loses
    [x] If the user guesses the word correctly, the game is over and the user wins
    [x] In addition you must implement one of the following extensions, or an extension of your own design as approved by a coach

### Extensions

    [x] Read the word list directly from the file when the application starts
        Create a history file that keeps track of user wins/losses and how many letters they guessed it in
        When the game finishes and the secret word is shown, also display the dictionary definition for that word
           Hint: Use a free API (https://dictionaryapi.dev/)
        Generate an output of the word/guesses and copy it to the user's clipboard so they can share it on socials
           Bonus: Use emojis


## Implementation Process

1. Create a function that can read to the given words list.
2. Allow the use to guess up to 6 time with each guess having each letter looked at to see if they are wrong, correct or in the wrong spot.
3. Allow the player to win if they guess the right word or fail if they run out of guesses.
4. Tidy everything up.

## Future Implementations

- Implement the other extensions.
- Add instructions to explain the game.

## Resources Used

none
