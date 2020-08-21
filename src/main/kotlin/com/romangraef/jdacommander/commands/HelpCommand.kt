package com.romangraef.jdacommander.commands

import com.beust.jcommander.Parameter
import com.romangraef.jdacommander.Command
import com.romangraef.jdacommander.ICommand

@Command("help")
class HelpCommand : ICommand() {

	@Parameter(description = "Help Topic")
	var helpTopic: String? = null

	override fun run() = responseChannel.queue {
		it.sendMessage(
			if (helpTopic == null) {
				"Helping...."
			} else {
				"Helping on topic $helpTopic"
			}
		).queue()
	}

}
