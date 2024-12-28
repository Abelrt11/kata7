package Arquitecture.controler;

import Arquitecture.model.Toughness;

public class passwordEvaluator {

    public Toughness evaluate_password(String password) {
        int points = 0;

        points = isLongerThan8CharLessThan16(password, points);
        points = HasUpperCaseAndLowerCase(password, points);
        points = Hasdigits(password, points);
        points = HasSpecialCharacters(password, points);
        points = HasConsecutiveCharacters(password, points);


        return level_of_toughness(points);
    }

    private static int HasConsecutiveCharacters(String password, int points) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                points = points - 20;
                break;
            }
        }
        return points;
    }

    private static int HasSpecialCharacters(String password, int points) {
        String specialCharacters = "!@#$%^&*()-+";

        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return points + 20;
            }
        }
        return points;
    }

    private static int Hasdigits(String password, int points) {
        for (char c : password.toCharArray()) {
            if(Character.isDigit(c)) {
                return points + 20;
            }

        }
        return points;
    }

    private int isLongerThan8CharLessThan16(String password, int points) {
        if (password.length() >= 8 && password.length() <= 16) {
            return points + 20;
        }
        return points;
    }

    private int HasUpperCaseAndLowerCase(String password, int points) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
            if (hasUpperCase && hasLowerCase) {
                return points + 20;
            }
        }

        return points;
    }

    private Toughness level_of_toughness(int points_acquired) {
        if (points_acquired < 20) { return Toughness.Very_bad;}
        else if (points_acquired < 40 ) { return Toughness.Bad;}
        else if (points_acquired < 60 ) { return Toughness.Acceptable;}
        else if (points_acquired < 80 ) { return Toughness.Good;}
        else { return Toughness.Very_good;}

    }
}
