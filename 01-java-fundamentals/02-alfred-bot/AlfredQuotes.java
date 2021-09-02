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
        String respond;
        String alexis = "Alexis";
        String alfred = "Alfred";
        if (conversation.contains(alexis)){
            respond ="Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.contains(alfred)){
            respond = "At your service. As you wish, naturally.";
        } else{
            respond = "Right. And with that I shall retire.";
        }
            return respond;
    }

    public String brucey (String conversation) {
    String nickname = conversation.replace("Batman", "Brucey");
    return nickname;
    }
}

