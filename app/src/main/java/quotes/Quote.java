package quotes;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Quote {
    ArrayList<QuoteData> quotes;

    public Quote(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            QuoteData[] data = gson.fromJson(reader, QuoteData[].class);
            quotes = new ArrayList<>(Arrays.asList(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomQuote() {
        Random random = new Random();
        QuoteData quoteData = quotes.get(random.nextInt(quotes.size()));
        return "Quote : "+quoteData.getQuote() + "\n - Author: " + quoteData.getAuthor();
    }

    static class QuoteData {
        String text;
        private String author;

        public String getQuote() {
            return text;
        }

        public String getAuthor() {
            return author;
        }
    }
}