package bobsrocket

import bobsrocket.navigation

class Ship:
    val nav = new navigation.Navigator
    def start = print(nav.info)