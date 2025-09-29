package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class RegexProcessor {


        public static String searchMatches(String pattern, String input) {
            StringBuilder matches = new StringBuilder();
            try {
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(input);
                while (m.find()) {
                    matches.append(m.group()).append(" ");
                }
            } catch (Exception e) {
                return "Invalid regex pattern!";
            }
            return matches.toString().isEmpty() ? "No matches found" : matches.toString();
        }


        public static String replaceText(String pattern, String replacement, String input) {
            try {
                return input.replaceAll(pattern, replacement);
            } catch (Exception e) {
                return "Invalid regex pattern!";
            }
        }
    }


