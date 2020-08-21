package com.romangraef.jdacommander

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Command
	(
	val value: String
)