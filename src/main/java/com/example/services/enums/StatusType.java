package com.example.services.enums;

public enum StatusType {
        OPEN("OPEN","Open"),
        CLOSE("CLOSE", "Close");

        private final String value;
        private final String reasonPhrase;

        private StatusType(String value, String reasonPhrase) {
                this.value = value;
                this.reasonPhrase = reasonPhrase;
        }


        public String value() {
                return value;
        }

        public String reasonPhrase() {
                return reasonPhrase;
        }
}
