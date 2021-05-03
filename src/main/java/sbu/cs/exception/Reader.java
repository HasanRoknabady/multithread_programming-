package sbu.cs.exception;

import java.util.List;

public class Reader {

    /**
     * declare 2 Exception class. 1 for UnrecognizedCommand and 1 for NotImplementedCommand
     * iterate on function inputs and check for commands and throw exception when needed.
     *
     * @param args
     */
    public void readTwitterCommands(List<String> args) throws ApException
    {
        List<String> forNotImplementedCommand = Util.getNotImplementedCommands();
        List<String> forUnrecognizedCommand  = Util.getImplementedCommands();

        for (String a : args)
        {
            if(forNotImplementedCommand.contains(a)){
                throw new
                        NotImplementedCommand("Sorry reseon : not implemented commands");
            }else if(!forUnrecognizedCommand.contains(a)){
                throw new
                        UnRecognizedCommand("MISSING " + a + " command");
            }

        }
    }

    /**
     * function inputs are String but odd positions must be integer parsable
     * a valid input is like -> "ap", "2", "beheshti", "3992", "20"
     * throw BadInput exception when the string is not parsable.
     *
     * @param args
     */
    public void read(String...args) throws BadInputException
    {
        boolean flag = false;
        for (String arg: args)
        {
            if(flag)
            {
                //for match integer we use regex and in regex \\d use for num
                if (!arg.matches("\\d+?"))
                {
                    throw new BadInputException("the even inputs must be an integer");
                }
                flag = false;
            }else {
                flag = true;
            }
        }
    }
}
