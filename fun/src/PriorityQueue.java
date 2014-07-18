
/**
 *
 * Class to implement priority queue with arrays - exception-throwing version
 *
 * written by : R. G. Garside
 *
 * first written : 10/July/96
 * last rewritten : 30/July/97
 *
 */

import java.io.* ;

public class PriorityQueue
    {
    private static final int MAX_BUFFER_SIZE = 100 ;

    private int queueLength ;
    private QueueElement[] buffer = new QueueElement[MAX_BUFFER_SIZE] ;

    /**
     * constructor
     */

    public PriorityQueue()
        {
        queueLength = 0 ;
        // System.out.println("array implementation") ;
        } // end of constructor method

    /**
     * initialize - initializes a PriorityQueue to empty
     */

    public void initialize()
        {
        queueLength = 0 ;
        } // end of method initialize

    /**
     * insert - insert in the priority queue a QueueElement "d". The
     *	program halts if there is no room
     */

    public void insert(QueueElement d) throws QueueFullException
        {
        // check that the queue is not full
        if (isFull())
	    throw new QueueFullException("'insert' in full queue") ;	

        // search for the correct insertion position "i"
        int i = 0 ;
        while ((i < queueLength) &&
               (buffer[i].getPriority() <= d.getPriority()))
            i++ ;

        // shuffle the data up (if necessary)
        for (int j = queueLength ; j > i ; j--)
            buffer[j] = buffer[j - 1] ;

        // insert the item
        buffer[i] = new QueueElement(d.getPriority(), d.getData()) ;

        // adjust queue length
        queueLength++ ;
        } // end of method insert

    /**
     * first - return the QueueElement which is the first item in the
     *     priority queue, without removing it; the program halts if
     *     the queue is empty
     */

    public QueueElement first() throws QueueEmptyException
        {
        if (isEmpty())
	    throw new QueueEmptyException("'first' on empty queue") ;

        return new QueueElement(buffer[0].getPriority(), buffer[0].getData()) ;
        } // end of method first

    /**
     * remove - remove the first item from the priority queue "q",
     *     returning the priority "p" and data "d"; the program halts
     *     if there are no items in the queue
     */

    public QueueElement remove() throws QueueEmptyException
        {
        // check for empty queue
        if (isEmpty())
	    throw new QueueEmptyException("'remove' from empty queue") ;

        // remember the first item
        QueueElement temp = buffer[0] ;

        // shuffle everything else up
        for (int i = 0 ; i < queueLength - 1 ; i++)
            buffer[i] = buffer[i + 1] ;

        // adjust the length
        queueLength-- ;

        // return the first item
        return temp ;
        } // end of method remove

    /**
     * length - returns the number of items in the priority queue "q" 
     */

    public int length()
        {
        return queueLength ;
        } // end of method length

    /**
     * isFull - returns TRUE if the PriorityQueue "q" is full, otherwise
     *     returns FALSE.
     */

    public boolean isFull()
        {
        return queueLength == MAX_BUFFER_SIZE ;
        } // end of method isFull

    /**
     * isEmpty - returns TRUE if the PriorityQueue "q" is empty, 
     *     otherwise returns FALSE. 
     */

    public boolean isEmpty()
        {
        return queueLength == 0 ;
        } // end of method isEmpty

    /**
     * main
     */

    public static void main(String[] args) throws IOException
        {
        int priority ;
        String data ;
        String response ;
        boolean continueLoop = true ;
        PriorityQueue q = new PriorityQueue() ;
        QueueElement temp = new QueueElement() ;

        while (continueLoop)
            {
            displayMenu() ;

	    try {
                response = BasicIo.readString().toLowerCase() ;
                if (response.length() == 0)
	            response = "x" ;

                switch (response.charAt(0))
                    {
                    case '1' :
                        q.initialize() ;
                        System.out.println("queue initialized") ;
                        break ;

                    case '2' :
                        BasicIo.prompt("priority? ") ;
                        priority = BasicIo.readInteger() ;
                        BasicIo.prompt("string to insert? ") ;
                        data = BasicIo.readString() ;
                        temp.setPriority(priority) ;
                        temp.setData(data) ;
                        q.insert(temp) ;
                        System.out.print("'" + data) ;
                        System.out.print("' inserted in queue with priority ") ;
	                System.out.println(priority) ;
                        break ;

                    case '3' :
                        temp = q.first() ;
                        System.out.print("'" + temp.getData()) ;
                        System.out.print("' at head of queue with priority ") ;
	                System.out.println(temp.getPriority()) ;
                        break ;

                    case '4' :
                        temp = q.remove() ;
                        System.out.print("'" + temp.getData()) ;
                        System.out.print("' removed from queue with priority ");
	                System.out.println(temp.getPriority()) ;
                        break ;

                    case '5' :
                        System.out.print("there are " + q.length()) ;
		        System.out.println(" items in the queue") ;
                        break ;

                    case '6' :
                        System.out.print("the queue is ") ;
                        if (!q.isFull())
                            System.out.print("not ") ;
                        System.out.println("full") ;
                        break ;

                    case '7' :
                        System.out.print("the queue is ") ;
                        if (!q.isEmpty())
                            System.out.print("not ") ;
                        System.out.println("empty") ;
                        break ;

                    case '8' :
                        while (true)
                            {
                            BasicIo.prompt("priority (0 to terminate)? ") ;
                            priority = BasicIo.readInteger() ;
                            if (priority == 0)
                                break ;
            
                            BasicIo.prompt("string to insert? ") ;
                            data = BasicIo.readString() ;

                            temp.setPriority(priority) ;
                            temp.setData(data) ;
                            q.insert(temp) ;
                            }
                         break ;

                    case '9' :
                        while (!q.isEmpty())
                            {
                            temp = q.remove() ;
                            System.out.print("'" + temp.getData()) ;
                            System.out.print("' with priority ") ;
                            System.out.println(temp.getPriority()) ;
                            }
                        System.out.println("**end of queue**") ;
                        break ;

                    case 'a' :
	                q.print() ;
	                break ;

                    case 'q' :
                        continueLoop = false ;
                        break ;

                    default :
                        System.out.println("invalid response") ;
	                break ;
                    } // end of switch
		} // end of try block
	    catch (QueueFullException e)
		{
		System.out.println("no more room in the queue") ;
		}	
	    catch (QueueEmptyException e)
		{
		System.out.println("no elements in the queue") ;
		}	

            if (continueLoop)
	        {
      	        BasicIo.prompt("press RETURN to continue ") ;
                response = BasicIo.readString() ;
                }
            } // end of loop

        System.out.println("program terminating") ;
        } // end of method main

    /**
     * displayMenu
     */

    private static void displayMenu()
        {
        System.out.println() ;
        System.out.println("Options to Exercise the Priority Queue") ;
        System.out.println() ;
        System.out.println("1 : initialise") ;
        System.out.println("2 : insert") ;
        System.out.println("3 : first") ;
        System.out.println("4 : remove") ;
        System.out.println("5 : length") ;
        System.out.println("6 : is full") ;
        System.out.println("7 : is empty") ;
        System.out.println() ;
        System.out.println("8 : multiple item insert") ;
        System.out.println("9 : scan and empty queue") ;
        System.out.println("a : print queue contents") ;
        System.out.println() ;
        System.out.println("q : quit") ;
        } // end of method displayMenu

    /**
     * print
     */

    private void print()
        {
        System.out.println("the queue is (highest priority first)") ;
        for (int i = 0 ; i < queueLength ; i++)
            {
            System.out.print(i) ;
            System.out.print(": priority = " + buffer[i].getPriority()) ;
            System.out.print(": data = '" + buffer[i].getData()) ;
            System.out.println("'") ;
            }
        } // end of method print
    } // end of class PriorityQueue



