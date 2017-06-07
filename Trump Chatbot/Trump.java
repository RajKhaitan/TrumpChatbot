
public class Trump
{
    //public String getGreeting() implements 4aiv
    public String getGreeting()
    {
        return "Hello, how are you?";
    }
    //public String getResponse(String statement) implements requirement 2a and 4aii
    public String getResponse(String statement)
    {
        String response = "";
        // First 'if' statement fullfills 4ai
        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }
        else if (findKeyword(statement, "Hillary") >= 0)
        {
            response = "Nasty woman, no one likes her. She is a loser.";
        }
        else if (findKeyword(statement, "Emails") >= 0)
        {
            response = "Hillary For Prison 2016";
        }
        else if (findKeyword(statement, "Tax Returns") >= 0)
        {
            response = "I will prosecute whoever released some of them but remember, there is nothing fishy about them.";
        }
        else if (findKeyword(statement, "Locker room talk") >= 0)
        {
            response = "When you live in a world with ISIS, you can't worry about small things.";
        }
        else if (findKeyword(statement, "Obama") >= 0)
        {
            response = "That Muslim President";
        }
        else if (findKeyword(statement, "Women") >= 0)
        {
            response = "No one respects women more than I do.";
        }
        else if (findKeyword(statement, "Mexico") >= 0)
        {
            response = "Build a wall and stop the drugs";
        }
        else if (findKeyword(statement, "China") >= 0)
        {
            response = "I love China. But they are stealing our jobs.";
        }
        else if (findKeyword(statement, "Global Warming") >= 0)
        {
            response = "Hoax created by China";
        }
        else if (findKeyword(statement, "America") >= 0 || findKeyword(statement, "U.S.A") >= 0)
        {
            response = "Make America Great Again";
        }
        else if (findKeyword(statement, "Taxes") >= 0)
        {
            response = "I am saying that I will lower taxes but tbh I don't care.";
        }
        else if (findKeyword(statement, "Mexicans") >= 0)
        {
            response = "Illegal Immigrants";
        }
        else if (findKeyword(statement, "Vote") >= 0)
        {
            response = "Vote on November 28";
        }
        else if (findKeyword(statement, "9/11") >= 0 || findKeyword(statement, "September 11") >= 0 )
        {
            response = "7/11 was a tragic event.";
        }
        else if (findKeyword(statement, "Sources") >= 0)
        {
            response = "I know it, you know it, we all know it";
        }
        else if (findKeyword(statement, "Votes?") >= 0)
        {
            response = "Election is rigged";
        }
        else if (findKeyword(statement, "Ivanka") >= 0 || findKeyword(statement, "daughter") >= 0)
        {
            response = "If she wasn't my daughter, I would marry her.";
        }
        else if (findKeyword(statement, "guns") >= 0 || findKeyword(statement, "killings") >= 0 || findKeyword(statement, "shootings") >= 0)
        {
            response = "Report it when you see it";
        }
        else if (findKeyword(statement, "Drugs") >= 0)
        {
            response = "Only in Detroit";
        }
        else if (findKeyword(statement, "Corruption") >= 0)
        {
            response = "That's basically what I love and create.";
        }
        else if (findKeyword(statement, "Idiot") >= 0)
        {
            response = "OMG! How did you know what I really was?";
        }
        else if (findKeyword(statement, "1 million dollars") >= 0)
        {
            response = "A small loan that I recieved";
        }
        else if (findKeyword(statement, "clowns") >= 0)
        {
            response = "It's Hillary.";
        }
        else if (findKeyword(statement, "ISIS") >= 0)
        {
            response = "Created by Hillary. Funded by the Muslim President.";
        }
        else if (findKeyword(statement, "How will you fulfill your promises?") >= 0)
        {
            response = "Believe me. Believe me. Believe me.";
        }
        else
        {
            int psn = findKeyword(statement, "you", 0);
            if (psn >= 0
                    && findKeyword(statement, "me", psn) >= 0)
            {
                response = transformYouMeStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
        }
        return response;
    }
    //private String transformIWantStatement(String statement) changes I want to you had and makes it a question
	private String transformIWantStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 7).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	// private String transformYouMeStatement(String statement) implements requirement 4aiii
	private String transformYouMeStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psnOfI= findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you");
		String restOfStatement = statement.substring(psnOfI + 2, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	//private int findKeyword(String statement, String goal, int startPos) implements requirement 3
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        while (psn >= 0) 
        {
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0)) 
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
        }
        return -1;
    }
    // private int findKeyword(String statement, String goal) gives the Keyword an integer
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }
    //public String getRandomResponse() implements requirement 2b
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 11;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Politicians tried to rig the election and make me lose. But they failed because they are losers. I hate losers.";
        }
        else if (whichResponse == 1)
        {
            response = "I believe that I am extremely rich thanks to the extremely small loan of 1 million dollars that my dad gave me.";
        }
        else if (whichResponse == 2)
        {
            response = "Mexico is bringing in drugs and it is poisoning our cities.";
        }
        else if (whichResponse == 3)
        {
            response = "As President, I will build a wall to save our country and make Mexico pay.";
        }
        else if (whichResponse == 4)
        {
            response = "I believe that I have a great relationship with the African Americans.";
        }
        else if (whichResponse == 5)
        {
            response = "I will release my tax returns when Hillary releases her emails and Obama admits he is a Muslim.";
        }
        else if (whichResponse == 6)
        {
            response = "Putin is my dad and Kim Jong Un is my uncle.";
        }
        else if (whichResponse == 7)
        {
            response = "Wanna hear a joke. Why don't I go to the bathroom? Because all the shit comes out of my mouth!!!";
        }
        else if (whichResponse == 8)
        {
            response = "Thanks to the voters on November 28th, I and only I can make America great again.";
        }
        else if (whichResponse == 9)
        {
            response = "Illegal immigrants keep coming from Mexico and are destroying our cities.";
        }
        else if (whichResponse == 10)
        {
            response = "I don't think I have met Putin but he said nice things about me.";
        }
        return response;
    }
}
