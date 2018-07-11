package _08PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 21:28 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input;
        while (!"Tournament".equals(input = bufferedReader.readLine())) {

            String[] inputArgs = input.split("\\s+");

            String trainerName = inputArgs[0];
            String pokemonName = inputArgs[1];
            String pokemonElement = inputArgs[2];
            int pokemonHealth = Integer.parseInt(inputArgs[3]);

            Pokemon pokemon = new Pokemon(pokemonName,
                    pokemonElement, pokemonHealth);

            Trainer trainer = null;
            if (trainers.containsKey(trainerName)) {
                trainer = trainers.get(trainerName);
                trainer.getPokemons().add(pokemon);
            } else {
                trainer = new Trainer(trainerName, pokemon);
            }

            trainers.put(trainerName, trainer);
        }

        while (!"End".equals(input = bufferedReader.readLine())) {

            String pokemonElement = input;

            trainers.forEach((key, value) -> {
                boolean hasPokemonType = value
                        .getPokemons()
                        .stream()
                        .anyMatch(p -> p.getElement()
                                .equals(pokemonElement));

                if (hasPokemonType) {
                    value.addBadge();
                } else {
                    value.getPokemons()
                            .forEach(Pokemon::decreaseHealthBy10);
                }
            });

            trainers.forEach((key, value) ->
                    value.getPokemons()
                            .removeIf(p ->
                                    p.getHealth() <= 0)
            );
        }

        trainers.entrySet()
                .stream()
                .sorted((kv1, kv2) -> Integer.compare(
                        kv2.getValue()
                                .getBadgesCount(),
                        kv1.getValue()
                                .getBadgesCount()))
                .forEach(kv -> System.out
                        .println(kv.getValue()));
    }
}