import org.apache.tools.ant.*;

public class Tags extends Task {
// /    private String msg;
//    public void execute () throws BuildException {
//        System.out.println (msg);
//    }
//
//
//    public void setmessage (String msg) {
//        this.msg = msg;
//    }
String message;
    public void setMessage(String msg) {
        message = msg;
    }

    public void execute() {
        if (message == null) {
            throw new BuildException("No message set.");
        }
        log(message);
    }
}
