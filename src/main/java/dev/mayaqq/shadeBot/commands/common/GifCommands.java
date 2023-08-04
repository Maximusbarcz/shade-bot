package dev.mayaqq.shadeBot.commands.common;

public class GifCommands {
    public enum GifType {
        HUG("You can't hug yourself!", "Cute!", "Awww, how cute! %sender% is hugging %target%!", "anime_girl_hug"),
        KISS("You can't kiss yourself!", "Cute!", "Awww, how cute! %sender% is kissing %target%!", "anime_girl_kiss"),
        PAT("You can't pat yourself!", "Cute!", "Awww, how cute! %sender% is patting %target%!", "anime_girl_pat"),
        CUDDLE("You can't cuddle yourself!", "Cute!", "Awww, how cute! %sender% is cuddling %target%!", "anime_girl_cuddle"),
        HIGHFIVE("You can't highfive yourself!", "Cute!", "Awww, how cute! %sender% is highfiving %target%!", "anime_girl_highfive"),
        KILL("You can't kill yourself! (please don't ILY)", "Awful!", "Awww, how awful! %sender% is killing %target%!", "anime_girl_kill");

        private final String failedMessage;
        private final String title;
        private final String message;
        private final String tenorSearch;

        GifType(String failedMessage, String title, String message, String tenorSearch) {
            this.failedMessage = failedMessage;
            this.title = title;
            this.message = message;
            this.tenorSearch = tenorSearch;
        }

        public String getFailedMessage() {
            return this.failedMessage;
        }

        public String getTitle() {
            return this.title;
        }

        public String getMessage() {
            return this.message;
        }

        public String getTenorSearch() {
            return this.tenorSearch;
        }
    }
}
