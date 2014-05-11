TheHelper
=========

<<<<<<< HEAD
<i>In-game player helper</i><br/>
<br/>
Author(s): DonoA, q220
<br/>

Tracks for new players, and sends valuable information to them, such as the location of the forums, where to find the texturepacks, TeamSpeak and how to use it, ...
Also is used to supply developers with various statistics and debug information.

As of now, the Plugin does the following:

- Checks if the player is a new player or not by verifying if theres a valid profile within the world folder.
- If no profile was found, it broadcasts a message server wide informing everyone that the player is new.
- The new player will receive various information on his first join, such as a link to the forum, and pointing out that Rangers are there to help/assist new players.


The following commands are available:

/helper forums | Returns a description and clickable url to the forums.
/helper textures | Returns a clickable url to the resources system.
/helper map | Returns clickable url for the dynmap
/helper servers | Returns a clickable url to the Server List resource page
/helper converse <player> | Returns a url that will prompt to create a conversation with <player> on the forums
=======
TheHelper implements the use of the /helper commands, and the /devinfo commands. It is also used to help new players when they first join the server. It gives basic help about the forums, texture packs, and TeamSpeak. The /helper command accepts one too two arguments and is meant to help improve the speed of finding valuable information. 
The syntax for /helper is as follows:
*forums
*textures
*map
*servers
*pm “player”

Most of the commands are straightforward, forums sends you a link to the forums, and server sends you a list of the server ips. pm is a command that allows you to start conversations through minecraft. The pm command will return a link to create a new conversation with the player specified. Example: ‘/helper pm SugarKoala’ would return the following link, http://mcmiddleearth.com/conversations/add?to=SugarKoala 

The devinfo is basicly just to allow us devs to view important information. 

Your welcome Lizzy =)
>>>>>>> readme and commands
