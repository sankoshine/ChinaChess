
/**
 *
 * Class to implement priority queue with arrays
 *
 * written by : R. G. Garside
 *
 * first written : 10/July/96
 * last rewritten : 11/July/96
 *
 */

public class QueueElement
    {
    private int priority ;
    private String data ;

    public QueueElement()
        {
        priority = 0 ;
        data = "" ;
        } // end of constructor method

    public QueueElement(int p, String d)
        {
        priority = p ;
        data = d ;
        } // end of constructor method

    public void setPriority(int p)
        {
        priority = p ;
        } // end of method setPriority

    public void setData(String d)
        {
        data = d ;
        } // end of method setData

    public int getPriority()
        {
        return priority ;
        } // end of method getPriority

    public String getData()
        {
        return data ;
        } // end of method getData
    } // end of class QueueElement

