Connect4Game REST APIS
====================================================
1) PUT /Connect4 , create game  .no params or request body
2) GET /Connect4/{gameId}, get all slots in a given game of "gameId"
3) GET /Connect4/{gameId}/columns , gets all columns that player can play now
4) POST /Connect4/{gameId}, RequestBody Move object specifying colour and column of move. it returns outcome of a move:- win/draw/incomplete

/**/
Following not implemented ...
a) logic for finding the WIN veritically and diagonally
b) persistence/keep in memory of the games
c) failed unit tests are ignored, since the logic is not implemented yet
d) security - i.e. if a user send wrong id of game, is not handled in this. should be associated with user session or so.


