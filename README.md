# GusKeepEye - Player Monitoring Plugin

Minecraft plugin for monitoring suspicious players. Tracks chat messages, commands, coordinates, and nearby players. Logs detailed reports to Discord via webhook.

## Key Features

- Real-time monitoring of specified players
- Discord webhook integration with rich message formatting
- Location tracking and nearby player detection
- Customizable datetime formatting
- LiteBans API integration for moderation context

## Technical Implementation

- **Event-Driven Architecture**  
  Uses Spigot's event system to capture player actions  
  [Spigot Event API Docs](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/package-summary.html)
- **Asynchronous Webhooks**  
  Non-blocking Discord messaging using Java's HttpURLConnection  
  [HttpURLConnection Docs](https://docs.oracle.com/javase/8/docs/api/java/net/HttpURLConnection.html)
- **Dynamic String Formatting**  
  Flexible message templates with replaceable parameters  
  [Java String Formatting](https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html)
- **YAML Configuration**  
  Simple user setup through config.yml files  
  [Spigot Configuration Guide](https://www.spigotmc.org/wiki/config-files/)

## Core Technologies

- **[Spigot API](https://www.spigotmc.org/wiki/spigot/)**  
  Minecraft server modification API
- **[LiteBans](https://github.com/ruany/LiteBans)**  
  Lightweight ban management system
- **[Discord Webhooks](https://discord.com/developers/docs/resources/webhook)**  
  Discord's message delivery system
- **[Java SimpleDateFormat](https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html)**  
  Custom datetime formatting

## Project Structure

```
guskeepeye/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/guskeep/
│       │       ├── listeners/        # Event handlers
│       │       ├── utils/            # Helper classes
│       │       ├── GusKeepEye.java   # Main plugin class
│       │       └── WebhookSender.java # Discord integration
│       └── resources/
│           ├── config.yml            # Plugin configuration
│           └── plugin.yml            # Plugin metadata
├── target/                           # Build output
└── pom.xml                           # Project dependencies
```

### Directory Details
- `listeners/`: Handles chat/command events and player tracking
- `utils/`: Contains formatting and location calculation helpers
- `resources/`: Stores user-editable configuration files

## Configuration Example

```yaml
discord:
  message: "**Игрок %s написал в чат:**\n%s\n**Координаты:** %s\n**Игроки рядом:** %s\n**Время:** %s"
  url: "https://discord.com/api/webhooks/..."

players-under-surveillance:
  - "Player1"
  - "Player2"

date-format: "dd.MM.yyyy HH:mm:ss"
```

## Disclaimer

> This project is intended for educational purposes only. Use responsibly in compliance with all applicable laws and server regulations.
