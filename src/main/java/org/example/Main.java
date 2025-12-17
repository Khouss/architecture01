package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Affichage de bienvenue
        logger.info("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            // Log du compteur i
            logger.info("i = {}", i);
        }
    }
}
