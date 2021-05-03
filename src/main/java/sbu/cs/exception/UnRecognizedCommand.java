package sbu.cs.exception;

public class UnRecognizedCommand extends ApException
{
    public UnRecognizedCommand(String message)
    {
        super(message);
    }
}
