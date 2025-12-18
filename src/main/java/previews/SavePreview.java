package main.java.previews;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SavePreview {
    public final String playerName;

    public SavePreview(String playerName) {
        this.playerName = playerName;
    }

    public static SavePreview readSavePreview(Path savePath) {
        String playerName = null;

        try (BufferedReader br = Files.newBufferedReader(savePath)) {
            String line;

            while ((line = br.readLine()) != null) {

                if (line.startsWith("name:")) {
                    playerName = line.split(": ")[1];
                }

                if (playerName != null) {
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new SavePreview(playerName);
    }
}
