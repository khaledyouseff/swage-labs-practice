package PractiseProject.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsUtilities {
    private LogsUtilities(){
    }
    public static Logger logger(){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }
    // the benefit of the join and the 3 dots that i can pass more than one message "kjn" , "bv" ,"nbv"
    public static void trace(String... message){
        logger().trace(String.join("",message));
    }
    public static void debug(String... message){
        logger().debug(String.join("", message));
    }
    public static void info(String... message){
        logger().info(String.join("", message));
    }
    public static void warn(String... message){
        logger().warn(String.join("", message));
    }
    public static void error (String... message){
        logger().error(String.join("", message));
    }

}