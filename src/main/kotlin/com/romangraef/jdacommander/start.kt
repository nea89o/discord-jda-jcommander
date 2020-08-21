package com.romangraef.jdacommander

import com.beust.jcommander.JCommander
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.reflections.Reflections

fun loadCommands(packageName: String): Map<String, Class<out ICommand>> {
	val reflections = Reflections(packageName)
	return reflections.getTypesAnnotatedWith(Command::class.java)
		.map {
			println(it)
			it
		}
		.filter { ICommand::class.java.isAssignableFrom(it) }
		.map {
			it.getAnnotation(Command::class.java).value to (it as Class<out ICommand>)
		}.toMap()
}

fun main() {
	val allCommands = loadCommands("com.romangraef.jdacommander.commands")
	JDABuilder.createDefault(System.getenv("DISCORD_TOKEN"))
		.addEventListeners(object : ListenerAdapter() {
			override fun onMessageReceived(event: MessageReceivedEvent) {
				val text = event.message.contentRaw
				if (!text.startsWith("!")) return
				val jCommander = JCommander()
				val bi = BaseInformation()
				allCommands.forEach { (name, `class`) ->
					jCommander.addCommand(name, `class`.newInstance())
				}
				jCommander.addObject(bi)
				jCommander.parse(*text.substring(1).split("\\s+".toRegex()).toTypedArray())
				val parsedCommand = jCommander.parsedCommand
				jCommander.findCommandByAlias(parsedCommand).objects.filterIsInstance<ICommand>().forEach {
					it.base = bi
					it.message = event.message
					it.run()
				}
			}
		})
		.build()
}