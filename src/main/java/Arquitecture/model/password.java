package Arquitecture.model;

import Arquitecture.controler.passwordEvaluator;


public class password {

    private final String password;
    private final Toughness toughness;

    public password(String password) {
        this.password = password;
        passwordEvaluator evaluator = new passwordEvaluator();
        this.toughness = evaluator.evaluate_password(this.password);
    }

    public String getPassword() {
        return password;
    }

    public Toughness getToughness() {
        return toughness;
    }
}
