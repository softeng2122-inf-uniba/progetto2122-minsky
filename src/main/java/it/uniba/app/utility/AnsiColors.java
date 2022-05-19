package it.uniba.app.utility;

public class AnsiColors {

    public static final String ANSI_BRIGHT_GREEN = "\u001b[32;1m";
    public static final String ANSI_BRIGHT_RED = "\u001b[31;1m";

    public static final String ANSI_BACKGROUDN_BRIGHT_GREEN = "\u001b[42;1m"; 
    public static final String ANSI_BACKGROUDN_BRIGHT_YELLOW = "\u001b[43;1m";
    public static final String ANSI_BACKGROUDN_BRIGHT_GRAY = "\u001b[47;1m";
    
    public static final String ANSI_RESET = "\u001B[0m";

    public static String getBrightRed(){return ANSI_BRIGHT_RED;}
    public static String getBrightGreen(){return ANSI_BRIGHT_GREEN;}
    public static String getReset(){return ANSI_RESET;}

    public static String getBackgroundGreen(){return ANSI_BACKGROUDN_BRIGHT_GREEN;}
    public static String getBackgroundYellow(){return ANSI_BACKGROUDN_BRIGHT_YELLOW;}
    public static String getBackgroundGray(){return ANSI_BACKGROUDN_BRIGHT_GRAY;}




}
