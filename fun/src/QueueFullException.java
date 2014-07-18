
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

public class QueueFullException extends Exception
    {
    public QueueFullException()
	{
	} // end of constructor method  

    public QueueFullException(String message)
	{
	super(message) ;
	} // end of constructor method  
    } // end of class QueueEmptyException

