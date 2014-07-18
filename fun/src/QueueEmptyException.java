
/**
 *
 * Exception for Priority Queue empty
 *
 * written by : R. G. Garside
 *
 * first written : 10/July/96
 * last rewritten : 11/July/96
 *
 */

public class QueueEmptyException extends Exception
    {
    public QueueEmptyException()
	{
    	
	} // end of constructor method  

    public QueueEmptyException(String message)
	{
	super(message) ;
	} // end of constructor method  
    } // end of class QueueEmptyException

