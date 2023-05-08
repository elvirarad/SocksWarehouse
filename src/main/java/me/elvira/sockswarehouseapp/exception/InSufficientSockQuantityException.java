package me.elvira.sockswarehouseapp.exception;

public class InSufficientSockQuantityException extends RuntimeException{
    public InSufficientSockQuantityException(String massage){
        super(massage);
    }

}
