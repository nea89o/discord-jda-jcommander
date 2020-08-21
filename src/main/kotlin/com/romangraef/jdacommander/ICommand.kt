package com.romangraef.jdacommander

import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.MessageChannel
import net.dv8tion.jda.api.requests.RestAction

abstract class ICommand {
	lateinit var base: BaseInformation
	lateinit var message: Message
	abstract fun run()
	val channel get() = message.channel
	val jda get() = message.jda
	val responseChannel: RestAction<out MessageChannel> get() = if (base.sendToDM) message.author.openPrivateChannel() else SyncRestAction(jda, channel)
}
