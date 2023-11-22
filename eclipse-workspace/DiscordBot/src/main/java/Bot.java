import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.events.session.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot extends ListenerAdapter{

	public static void main(String[] args) throws LoginException, InterruptedException{
		JDA jda = JDABuilder.createDefault("MTE3NjU4OTUzOTgyMTc2NDY1OA.Gipa9E.QS1fjY1lJ2vfNuC8f02n4TMpUJuI8n8FddK3JE")
				.addEventListeners(new Bot()).enableIntents(GatewayIntent.MESSAGE_CONTENT).build();

	}
	
	public void onReady(ReadyEvent event) {
		System.out.println("The bot is ready!");
		System.out.println(event.getJDA().getToken());
	}
	
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) {
			return;
		}
		else {
			System.out.println("A user sent a message");
			if (event.getMessage().getContentDisplay().equalsIgnoreCase("?help")) {
				event.getChannel().sendMessage("Received");
			}
		}
	}

}
