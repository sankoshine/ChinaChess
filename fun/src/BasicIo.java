


import java.io.* ;

/**
 * simple methods for basic input/output (Java 1.1)
 * @author Roger Garside
 * @version Last Rewritten: 16/Sept/97
 */

public class BasicIo
    {
 
    /**
     * output a prompt message to the screen
     * @param prompt message
     */
    public static void prompt(String s)
	{
	System.err.print(s) ;
	System.err.flush() ;
	} // end of method prompt

    /**
     * read the next line from the keyboard as a String
     * @return the line as a String
     */
    public static String readString() throws IOException
        {
	BufferedReader in = new BufferedReader(new
					InputStreamReader(System.in)) ;

        return in.readLine() ;
        } // end of method readString

    /**
     * read a character, the first on the line
     * @return the first character on the line
     */
    public static char readCharacter() throws IOException
        {
	BufferedReader in = new BufferedReader(new
					InputStreamReader(System.in)) ;

        String s = in.readLine() ;
	if (s.length() == 0)
            return ' ' ;
        else
	    return s.charAt(0) ;
        } // end of method readCharacter

    /**
     * read the next line from the keyboard as an integer
     * @return the line as an integer
     */
    public static int readInteger() throws IOException
        {
        String line ;

	BufferedReader in = new BufferedReader(new
					InputStreamReader(System.in)) ;

        try
            {
            line = in.readLine() ;
            int i = Integer.parseInt(line.trim()) ;
            return i ;
            }
        catch (Exception e)
            {
            throw new IOException("invalid integer") ;
            }
        } // end of method readInteger

    /**
     * read the next line from the keyboard as a float
     * @return the line as a float
     */
    public static float readFloat() throws IOException
        {
        String line ;

	BufferedReader in = new BufferedReader(new
					InputStreamReader(System.in)) ;

        try
            {
            line = in.readLine() ;
            return Float.valueOf(line.trim()).floatValue() ;
            }
        catch (Exception e)
            {
            throw new IOException("invalid float") ;
            }
        } // end of method readFloat

    /**
     * read the next line from the keyboard as a double
     * @return the line as a double
     */
    public static double readDouble() throws IOException
        {
        String line ;

	BufferedReader in = new BufferedReader(new
					InputStreamReader(System.in)) ;

        try
            {
            line = in.readLine() ;
            return Double.valueOf(line.trim()).doubleValue() ;
            }
        catch (Exception e)
            {
            throw new IOException("invalid double") ;
            }
        } // end of method readDouble

    /**
     * output an integer in a field of a specified width
     * @param n the integer to be output
     * @param w the width of the field
     */
    public static void writeInteger(int n, int w)
        {
        Integer n1 = new Integer(n) ;
        String t = n1.toString() ;

        if (t.length() > w)
            System.out.print(t) ;
        else
            {
            for (int i = 0 ; i < w - t.length() ; i++)
                System.out.print(' ') ;
            System.out.print(t) ;
            }
        } // end of method writeInteger

    /**
     * output a float in a field of a specified width
     * @param n the float to be output
     * @param w the width of the field
     * @param d the number of decimal places
     */
    public static void writeFloat(float n, int w, int d) throws IOException
	{
	Float n1 = new Float(n) ;
	String t = n1.toString() ;
	//System.err.println("string is **" + t + "**") ;

	if (t.indexOf('e') != -1)
	    throw new IOException("out of range") ;
        if (d < 1)
	    throw new IOException("invalid 3rd argument") ;
	boolean negative = false ;
	if (t.charAt(0) == '-')
	    {
	    negative = true ;
	    t = t.substring(1) ;
	    }
	int index = t.indexOf('.') ;
	int decimals ;
	if (index == -1)
	    decimals = 0 ;
	else
	    {
	    decimals = t.length() - index - 1 ;
            if (decimals <= 0)
		throw new IOException("funny format") ;
	    }
	if (decimals < d)
	    {
	    if (decimals == 0)
		t += '.' ;
	    for (int i = 0 ; i < d - decimals ; i++)
		t += '0' ;
	    }
	else if (decimals > d)
	    {
	    int offset = t.length() - decimals + d ;
	    if (t.charAt(offset) < '5')
		t = t.substring(0, t.length() - decimals + d) ;
	    else
		{
		StringBuffer sb = new StringBuffer(t) ;
		offset-- ;
		while ((offset >= 0) &&
		       ((sb.charAt(offset) == '9') ||
		        (sb.charAt(offset) == '.')))
		    {
		    if (sb.charAt(offset) == '9')
		        sb.setCharAt(offset, '0') ;
		    offset-- ;
		    }
		if (offset >= 0)
		    {
		    sb.setCharAt(offset,
	Character.forDigit(Character.digit(sb.charAt(offset), 10) + 1, 10)) ;
	t = sb.toString().substring(0, t.length() - decimals + d) ;
		    }
		else
	t = '1' + sb.toString().substring(0, t.length() - decimals + d) ;
		}
	    }
	if (negative)
	    t = '-' + t ;

	if (t.length() > w)
	    System.out.print(t) ;
	else
	    {
	    for (int i = 0 ; i < w - t.length() ; i++)
		System.out.print(' ') ;
	    System.out.print(t) ;
	    }
	} // end of method writeFloat

    /**
     * output a double in a field of a specified width
     * @param n the double to be output
     * @param w the width of the field
     * @param d the number of decimal places
     */
    public static void writeDouble(double n, int w, int d) throws IOException
	{
	Double n1 = new Double(n) ;
	String t = n1.toString() ;
	//System.err.println("string is **" + t + "**") ;

	if (t.indexOf('e') != -1)
	    throw new IOException("out of range") ;
        if (d < 1)
	    throw new IOException("invalid 3rd argument") ;
	boolean negative = false ;
	if (t.charAt(0) == '-')
	    {
	    negative = true ;
	    t = t.substring(1) ;
	    }
	int index = t.indexOf('.') ;
	int decimals ;
	if (index == -1)
	    decimals = 0 ;
	else
	    {
	    decimals = t.length() - index - 1 ;
            if (decimals <= 0)
		throw new IOException("funny format") ;
	    }
	if (decimals < d)
	    {
	    if (decimals == 0)
		t += '.' ;
	    for (int i = 0 ; i < d - decimals ; i++)
		t += '0' ;
	    }
	else if (decimals > d)
	    {
	    int offset = t.length() - decimals + d ;
	    if (t.charAt(offset) < '5')
		t = t.substring(0, t.length() - decimals + d) ;
	    else
		{
		StringBuffer sb = new StringBuffer(t) ;
		offset-- ;
		while ((offset >= 0) &&
		       ((sb.charAt(offset) == '9') ||
		        (sb.charAt(offset) == '.')))
		    {
		    if (sb.charAt(offset) == '9')
		        sb.setCharAt(offset, '0') ;
		    offset-- ;
		    }
		if (offset >= 0)
		    {
		    sb.setCharAt(offset,
	Character.forDigit(Character.digit(sb.charAt(offset), 10) + 1, 10)) ;
	t = sb.toString().substring(0, t.length() - decimals + d) ;
		    }
		else
	t = '1' + sb.toString().substring(0, t.length() - decimals + d) ;
		}
	    }
	if (negative)
	    t = '-' + t ;

	if (t.length() > w)
	    System.out.print(t) ;
	else
	    {
	    for (int i = 0 ; i < w - t.length() ; i++)
		System.out.print(' ') ;
	    System.out.print(t) ;
	    }
	} // end of method writeDouble

    } // end of class BasicIo  
