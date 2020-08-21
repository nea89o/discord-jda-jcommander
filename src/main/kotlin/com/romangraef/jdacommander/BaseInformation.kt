package com.romangraef.jdacommander

import com.beust.jcommander.Parameter

class BaseInformation {
	@Parameter(names = ["-p", "--private", "--direct", "--dm"])
	var sendToDM: Boolean = false
}
