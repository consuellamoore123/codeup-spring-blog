package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showRollDicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess) {
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;

        String redirectUrl = "redirect:/roll-dice-result?guess=" + guess + "&diceRoll=" + diceRoll;
        return redirectUrl;
    }


    @GetMapping("/roll-dice-result")
    public String showRollDiceResultPage(@RequestParam int guess, @RequestParam int diceRoll, Model model) {
        model.addAttribute("guess", guess);
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("message", guess == diceRoll ? "Congratulations! You guessed correctly." : "Sorry, wrong guess!");

        return "roll-dice-result";

    }
}



