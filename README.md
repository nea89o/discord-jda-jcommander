## JDA Commander

This is a proof of concept project to demonstrate using [jcommander] with [JDA]

### Building
This project uses [Gradle] for building and dependency management.

 - You can either directly run the project using `./gradlew run`.
 - You can create a zip/tar using `./gradlew distZip` or `./gradlew distTar` respectively.
     - Those can be found in `build/distributions`
     - Those have Windows / Linux scripts to launch the project in the bin folder

#### Versioning / Dependencies

This project uses [Refresh Versions] to manage dependencies.


Run `./gradlew refreshVersions` to check for updates. Then open `versions.properties` and bump versions where appropriate. After that reload your project and run `./gradlew refreshVersions` again to make sure there won't be any git conflicts.

When introducing new dependencies make sure you use the `"_"` version identifier, so it will be managed by the plugin.

### Token
Set the environment variable `DISCORD_TOKEN` to a bot token obtained from Discord's [Developer Panel][discord].


[discord]: https://discord.com/developers/applications/me
[refresh versions]: https://google.com
[gradle]: https://gradle.org
[jda]: https://github.com/DV8FromTheWorld/JDA
[jcommander]: https://jcommander.org/
