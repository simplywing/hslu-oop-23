package ch.hslu.oop.sw10;

public enum ComponentState {

    ON("turned on"), OFF("turned off"), FAILURE("failure");
    private final String description;

    private ComponentState(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return this.description;
    }
}
