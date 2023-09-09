package org.example.repositories;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.example.entities.Account;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DataRepository {

    private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(
            LocalDate.class,
            (JsonDeserializer<LocalDate>) (json, typeOfT, context) -> LocalDate.parse(
                json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("dd.MM.yyyy")
            )
        )
        .registerTypeAdapter(
            Optional.class,
            (JsonDeserializer<Optional<String>>) (json, typeOfT, context) -> Optional.ofNullable(json.getAsJsonPrimitive().getAsString())
        )
        .create();

    public Account findData() {

        try(
            final FileReader fileReader = new FileReader(
                this.getClass().getResource("/data.json").getPath(), StandardCharsets.UTF_8
            )
        ) {

            final JsonReader jsonReader = new JsonReader(fileReader);

            return gson.fromJson(jsonReader, Account.class);

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
