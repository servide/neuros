package co.insou.neuros.plugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import co.insou.neuros.plugin.NeurosPlugin;

public class NeurosCommand implements CommandExecutor {

	private final NeurosPlugin neurosPlugin;

	public NeurosCommand(NeurosPlugin neurosPlugin) {
		this.neurosPlugin = neurosPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		sender.sendMessage("Hi");

		return false;
	}
}
