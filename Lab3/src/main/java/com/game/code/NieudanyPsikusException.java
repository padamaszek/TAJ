package com.game.code;

/**
 * Created by Hunter on 2015-03-18.
 */
public class NieudanyPsikusException extends Exception{
        private static final long serialVersionUID = -4197380075619961717L;
        //Parameterless Constructor
        public NieudanyPsikusException() {}
        //Constructor that accepts a message
        public NieudanyPsikusException(String message)
        {
            super(message);
        }
    }
}
