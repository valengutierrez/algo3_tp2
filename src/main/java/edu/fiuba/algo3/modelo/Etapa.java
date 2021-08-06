package edu.fiuba.algo3.modelo;

public enum Etapa {
    COLOCACION_INICIAL,
    ATAQUE,
    REAGRUPACION,
    INCORPORACION_EJERCITOS;

    @Override
    public String toString() {
        switch (this){
            case COLOCACION_INICIAL: return "Colocar";
            case INCORPORACION_EJERCITOS: return "Colocar";
            case ATAQUE: return "Atacar!";
            case REAGRUPACION: return "Reagrupar";
        }
        return "";
    }
}
