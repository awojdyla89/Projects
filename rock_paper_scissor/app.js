
const choice = {
    player: null,
    computer: null
}

const choiceMenu = ["rock", "paper", "scissor"];

/*
function playerChooses(event) {

    choice.player = event.target.innerText

   computerChooses();
    compareChoices();
}
*/

// points to element in HTML and adds result message to the body of the tag
function showResults(results) {

    // const message = document.getElementById('prompt');
    // message.innerText = results;
    // document.body.appendChild(results);

    document.getElementById('prompt').innerText = results
    document.body.appendChild(results)
}

/*
// function makes a random element selection from array choiceMenu[0-2]
function computerChooses() {

    choice.computer = choiceMenu[Math.floor(Math.random() * choiceMenu.length)]
}
*/

// logical comparisons for game functionality
function compareChoices(buttonEvent) {

    choice.computer = choiceMenu[Math.floor(Math.random() * choiceMenu.length)]
    choice.player = buttonEvent.target.innerText

   if(choice.computer === choiceMenu[0] && choice.player === choiceMenu[1]){
       showResults("Player wins: " + choice.player + " vs " + choice.computer);
   }else if(choice.computer === choiceMenu[0] && choice.player === choiceMenu[2]){
       showResults("Computer wins: " + choice.computer + " vs " + choice.player);
   }else if(choice.computer === choiceMenu[1] && choice.player === choiceMenu[0]){
       showResults("Computer wins: " + choice.computer + " vs " + choice.player);
   }else if(choice.computer === choiceMenu[1] && choice.player === choiceMenu[2]){
       showResults("Player wins: " + choice.player + " vs " + choice.computer);
   }else if(choice.computer === choiceMenu[2] && choice.player === choiceMenu[0]){
       showResults("Player wins: " + choice.player + " vs " + choice.computer);
   }else if(choice.computer === choiceMenu[2] && choice.player === choiceMenu[1]){
       showResults("Computer wins: " + choice.computer + " vs " + choice.player);
   }else{
       showResults("It's a tie. Both chose " + choice.player);
   }

}


//query a button ID, add 'click' type event on said button and call function to harvest players choice.
document.querySelector('#rock').addEventListener('click', compareChoices);
document.querySelector('#paper').addEventListener('click', compareChoices);
document.querySelector('#scissor').addEventListener('click', compareChoices);
