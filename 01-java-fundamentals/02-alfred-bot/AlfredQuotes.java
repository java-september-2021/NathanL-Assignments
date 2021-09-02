import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name, String dayPeriod) {
        String greeting=String.format("Good %s, %s. Lovely to see you.",dayPeriod,name);return greeting;
    }

    public String dateAnnouncement() {
        Date date = new Date();
        String currentdate=String.format("Current date is: %s",date);
        return currentdate;
    }

    public String respondBeforeAlexis(String conversation) {
        String alexis = "Alexis";
        String alfred = "Alfred";
        if (conversation.contains(alexis)){
            String respond = "Right away, sir. She certainly isn't sophisticated enough for that.";
            return respond;
        } else if (conversation.contains(alfred)){
            String respond = "At your service. As you wish, naturally.";
            return respond;
        } else{
            String respond = "Right. And with that I shall retire.";
            return respond;
        }
    }
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String brucey (String conversation) {
    String nickname = conversation.replace("Batman", "Brucey");
    return nickname;
    }
}

