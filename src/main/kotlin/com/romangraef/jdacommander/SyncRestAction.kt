package com.romangraef.jdacommander

import java.util.concurrent.CompletableFuture
import java.util.function.BooleanSupplier
import java.util.function.Consumer
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.requests.RestAction

class SyncRestAction<I>(private val jda: JDA, private val value: I) : RestAction<I> {
	override fun getJDA(): JDA = jda

	override fun setCheck(checks: BooleanSupplier?): RestAction<I> {
		// No need for last Second checks.
		// We don't execute HTTP requests anyways.
		return this
	}

	override fun queue(success: Consumer<in I>?, failure: Consumer<in Throwable>?) {
		success?.accept(value)
	}

	override fun complete(shouldQueue: Boolean): I = value

	override fun submit(shouldQueue: Boolean): CompletableFuture<I> =
		CompletableFuture.supplyAsync { value }


}