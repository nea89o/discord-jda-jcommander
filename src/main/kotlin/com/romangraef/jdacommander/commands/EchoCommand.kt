package com.romangraef.jdacommander.commands

import com.beust.jcommander.Parameter
import com.romangraef.jdacommander.Command
import com.romangraef.jdacommander.ICommand

@Command("echo")
class EchoCommand : ICommand() {
	@Parameter(names = ["-c", "--caps", "--capitalize"], description = "Convert the text to upper case")
	var caps: Boolean = false

	@Parameter(description = "Text to echo back")
	lateinit var texts: List<String>
	val text get() = texts.joinToString(" ")

	override fun run() = responseChannel.queue {
		it.sendMessage(if (caps) text.toUpperCase() else text).queue()
	}

}
